/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.NivelImportancia;
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
public class NivelImportanciaJpaController implements Serializable {

    public NivelImportanciaJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public NivelImportanciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(NivelImportancia nivelImportancia) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nivelImportancia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNivelImportancia(nivelImportancia.getEstado()) != null) {
                throw new PreexistingEntityException("NivelImportancia " + nivelImportancia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NivelImportancia nivelImportancia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nivelImportancia = em.merge(nivelImportancia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = nivelImportancia.getEstado();
                if (findNivelImportancia(id) == null) {
                    throw new NonexistentEntityException("The nivelImportancia with id " + id + " no longer exists.");
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
            NivelImportancia nivelImportancia;
            try {
                nivelImportancia = em.getReference(NivelImportancia.class, id);
                nivelImportancia.getEstado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nivelImportancia with id " + id + " no longer exists.", enfe);
            }
            em.remove(nivelImportancia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NivelImportancia> findNivelImportanciaEntities() {
        return findNivelImportanciaEntities(true, -1, -1);
    }

    public List<NivelImportancia> findNivelImportanciaEntities(int maxResults, int firstResult) {
        return findNivelImportanciaEntities(false, maxResults, firstResult);
    }

    private List<NivelImportancia> findNivelImportanciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NivelImportancia.class));
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

    public NivelImportancia findNivelImportancia(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NivelImportancia.class, id);
        } finally {
            em.close();
        }
    }

    public int getNivelImportanciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NivelImportancia> rt = cq.from(NivelImportancia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
