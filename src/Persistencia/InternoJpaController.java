/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.Interno;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import LogicaDeNegocios.Mecanico;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alee
 */
public class InternoJpaController implements Serializable {

    public InternoJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public InternoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Interno interno) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mecanico unMecanico = interno.getUnMecanico();
            if (unMecanico != null) {
                unMecanico = em.getReference(unMecanico.getClass(), unMecanico.getDni());
                interno.setUnMecanico(unMecanico);
            }
            em.persist(interno);
            if (unMecanico != null) {
                unMecanico.getVsInterno().add(interno);
                unMecanico = em.merge(unMecanico);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findInterno(interno.getCodPedido()) != null) {
                throw new PreexistingEntityException("Interno " + interno + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Interno interno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Interno persistentInterno = em.find(Interno.class, interno.getCodPedido());
            Mecanico unMecanicoOld = persistentInterno.getUnMecanico();
            Mecanico unMecanicoNew = interno.getUnMecanico();
            if (unMecanicoNew != null) {
                unMecanicoNew = em.getReference(unMecanicoNew.getClass(), unMecanicoNew.getDni());
                interno.setUnMecanico(unMecanicoNew);
            }
            interno = em.merge(interno);
            if (unMecanicoOld != null && !unMecanicoOld.equals(unMecanicoNew)) {
                unMecanicoOld.getVsInterno().remove(interno);
                unMecanicoOld = em.merge(unMecanicoOld);
            }
            if (unMecanicoNew != null && !unMecanicoNew.equals(unMecanicoOld)) {
                unMecanicoNew.getVsInterno().add(interno);
                unMecanicoNew = em.merge(unMecanicoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = interno.getCodPedido();
                if (findInterno(id) == null) {
                    throw new NonexistentEntityException("The interno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Interno interno;
            try {
                interno = em.getReference(Interno.class, id);
                interno.getCodPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The interno with id " + id + " no longer exists.", enfe);
            }
            Mecanico unMecanico = interno.getUnMecanico();
            if (unMecanico != null) {
                unMecanico.getVsInterno().remove(interno);
                unMecanico = em.merge(unMecanico);
            }
            em.remove(interno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Interno> findInternoEntities() {
        return findInternoEntities(true, -1, -1);
    }

    public List<Interno> findInternoEntities(int maxResults, int firstResult) {
        return findInternoEntities(false, maxResults, firstResult);
    }

    private List<Interno> findInternoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Interno.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Interno findInterno(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Interno.class, id);
        } finally {
            em.close();
        }
    }

    public int getInternoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Interno> rt = cq.from(Interno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
