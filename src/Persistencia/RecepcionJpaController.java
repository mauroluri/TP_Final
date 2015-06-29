/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.Recepcion;
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
public class RecepcionJpaController implements Serializable {

    public RecepcionJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public RecepcionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Recepcion recepcion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(recepcion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRecepcion(recepcion.getCod()) != null) {
                throw new PreexistingEntityException("Recepcion " + recepcion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Recepcion recepcion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            recepcion = em.merge(recepcion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = recepcion.getCod();
                if (findRecepcion(id) == null) {
                    throw new NonexistentEntityException("The recepcion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Recepcion recepcion;
            try {
                recepcion = em.getReference(Recepcion.class, id);
                recepcion.getCod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recepcion with id " + id + " no longer exists.", enfe);
            }
            em.remove(recepcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Recepcion> findRecepcionEntities() {
        return findRecepcionEntities(true, -1, -1);
    }

    public List<Recepcion> findRecepcionEntities(int maxResults, int firstResult) {
        return findRecepcionEntities(false, maxResults, firstResult);
    }

    private List<Recepcion> findRecepcionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Recepcion.class));
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

    public Recepcion findRecepcion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Recepcion.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecepcionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Recepcion> rt = cq.from(Recepcion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
