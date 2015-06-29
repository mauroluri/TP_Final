/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.DetalleActividad;
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
public class DetalleActividadJpaController implements Serializable {

    public DetalleActividadJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public DetalleActividadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleActividad detalleActividad) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detalleActividad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetalleActividad(detalleActividad.getCod()) != null) {
                throw new PreexistingEntityException("DetalleActividad " + detalleActividad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleActividad detalleActividad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detalleActividad = em.merge(detalleActividad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = detalleActividad.getCod();
                if (findDetalleActividad(id) == null) {
                    throw new NonexistentEntityException("The detalleActividad with id " + id + " no longer exists.");
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
            DetalleActividad detalleActividad;
            try {
                detalleActividad = em.getReference(DetalleActividad.class, id);
                detalleActividad.getCod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleActividad with id " + id + " no longer exists.", enfe);
            }
            em.remove(detalleActividad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleActividad> findDetalleActividadEntities() {
        return findDetalleActividadEntities(true, -1, -1);
    }

    public List<DetalleActividad> findDetalleActividadEntities(int maxResults, int firstResult) {
        return findDetalleActividadEntities(false, maxResults, firstResult);
    }

    private List<DetalleActividad> findDetalleActividadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleActividad.class));
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

    public DetalleActividad findDetalleActividad(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleActividad.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleActividadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleActividad> rt = cq.from(DetalleActividad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
