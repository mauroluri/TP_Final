/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import LogicaDeNegocios.AtencionPublico;
import LogicaDeNegocios.Externo;
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
public class ExternoJpaController implements Serializable {

    public ExternoJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public ExternoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Externo externo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AtencionPublico remitente = externo.getRemitente();
            if (remitente != null) {
                remitente = em.getReference(remitente.getClass(), remitente.getDni());
                externo.setRemitente(remitente);
            }
            em.persist(externo);
            if (remitente != null) {
                remitente.getVsExterno().add(externo);
                remitente = em.merge(remitente);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findExterno(externo.getCodPedido()) != null) {
                throw new PreexistingEntityException("Externo " + externo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Externo externo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Externo persistentExterno = em.find(Externo.class, externo.getCodPedido());
            AtencionPublico remitenteOld = persistentExterno.getRemitente();
            AtencionPublico remitenteNew = externo.getRemitente();
            if (remitenteNew != null) {
                remitenteNew = em.getReference(remitenteNew.getClass(), remitenteNew.getDni());
                externo.setRemitente(remitenteNew);
            }
            externo = em.merge(externo);
            if (remitenteOld != null && !remitenteOld.equals(remitenteNew)) {
                remitenteOld.getVsExterno().remove(externo);
                remitenteOld = em.merge(remitenteOld);
            }
            if (remitenteNew != null && !remitenteNew.equals(remitenteOld)) {
                remitenteNew.getVsExterno().add(externo);
                remitenteNew = em.merge(remitenteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = externo.getCodPedido();
                if (findExterno(id) == null) {
                    throw new NonexistentEntityException("The externo with id " + id + " no longer exists.");
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
            Externo externo;
            try {
                externo = em.getReference(Externo.class, id);
                externo.getCodPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The externo with id " + id + " no longer exists.", enfe);
            }
            AtencionPublico remitente = externo.getRemitente();
            if (remitente != null) {
                remitente.getVsExterno().remove(externo);
                remitente = em.merge(remitente);
            }
            em.remove(externo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Externo> findExternoEntities() {
        return findExternoEntities(true, -1, -1);
    }

    public List<Externo> findExternoEntities(int maxResults, int firstResult) {
        return findExternoEntities(false, maxResults, firstResult);
    }

    private List<Externo> findExternoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Externo.class));
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

    public Externo findExterno(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Externo.class, id);
        } finally {
            em.close();
        }
    }

    public int getExternoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Externo> rt = cq.from(Externo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
