/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.NivelSeveridad;
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
public class NivelSeveridadJpaController implements Serializable {

    public NivelSeveridadJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public NivelSeveridadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(NivelSeveridad nivelSeveridad) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nivelSeveridad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNivelSeveridad(nivelSeveridad.getNivel()) != null) {
                throw new PreexistingEntityException("NivelSeveridad " + nivelSeveridad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NivelSeveridad nivelSeveridad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nivelSeveridad = em.merge(nivelSeveridad);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = nivelSeveridad.getNivel();
                if (findNivelSeveridad(id) == null) {
                    throw new NonexistentEntityException("The nivelSeveridad with id " + id + " no longer exists.");
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
            NivelSeveridad nivelSeveridad;
            try {
                nivelSeveridad = em.getReference(NivelSeveridad.class, id);
                nivelSeveridad.getNivel();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nivelSeveridad with id " + id + " no longer exists.", enfe);
            }
            em.remove(nivelSeveridad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NivelSeveridad> findNivelSeveridadEntities() {
        return findNivelSeveridadEntities(true, -1, -1);
    }

    public List<NivelSeveridad> findNivelSeveridadEntities(int maxResults, int firstResult) {
        return findNivelSeveridadEntities(false, maxResults, firstResult);
    }

    private List<NivelSeveridad> findNivelSeveridadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NivelSeveridad.class));
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

    public NivelSeveridad findNivelSeveridad(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NivelSeveridad.class, id);
        } finally {
            em.close();
        }
    }

    public int getNivelSeveridadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NivelSeveridad> rt = cq.from(NivelSeveridad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
