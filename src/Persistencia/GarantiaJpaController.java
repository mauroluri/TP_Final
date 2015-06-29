/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.Garantia;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Ale
 */
public class GarantiaJpaController implements Serializable {

    public GarantiaJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public GarantiaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Garantia garantia) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(garantia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGarantia(garantia.getDetalle()) != null) {
                throw new PreexistingEntityException("Garantia " + garantia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Garantia garantia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            garantia = em.merge(garantia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = garantia.getDetalle();
                if (findGarantia(id) == null) {
                    throw new NonexistentEntityException("The garantia with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Garantia garantia;
            try {
                garantia = em.getReference(Garantia.class, id);
                garantia.getDetalle();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The garantia with id " + id + " no longer exists.", enfe);
            }
            em.remove(garantia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Garantia> findGarantiaEntities() {
        return findGarantiaEntities(true, -1, -1);
    }

    public List<Garantia> findGarantiaEntities(int maxResults, int firstResult) {
        return findGarantiaEntities(false, maxResults, firstResult);
    }

    private List<Garantia> findGarantiaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Garantia.class));
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

    public Garantia findGarantia(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Garantia.class, id);
        } finally {
            em.close();
        }
    }

    public int getGarantiaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Garantia> rt = cq.from(Garantia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
