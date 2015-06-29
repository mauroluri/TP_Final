/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.Actividad;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import LogicaDeNegocios.Categoria;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ale
 */
public class ActividadJpaController implements Serializable {

    public ActividadJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public ActividadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Actividad actividad) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria unaCategoria = actividad.getUnaCategoria();
            if (unaCategoria != null) {
                unaCategoria = em.getReference(unaCategoria.getClass(), unaCategoria.getNombre());
                actividad.setUnaCategoria(unaCategoria);
            }
            em.persist(actividad);
            if (unaCategoria != null) {
                unaCategoria.getVsEspecialidadActividad().add(actividad);
                unaCategoria = em.merge(unaCategoria);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findActividad(actividad.getNombre()) != null) {
                throw new PreexistingEntityException("Actividad " + actividad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Actividad actividad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Actividad persistentActividad = em.find(Actividad.class, actividad.getNombre());
            Categoria unaCategoriaOld = persistentActividad.getUnaCategoria();
            Categoria unaCategoriaNew = actividad.getUnaCategoria();
            if (unaCategoriaNew != null) {
                unaCategoriaNew = em.getReference(unaCategoriaNew.getClass(), unaCategoriaNew.getNombre());
                actividad.setUnaCategoria(unaCategoriaNew);
            }
            actividad = em.merge(actividad);
            if (unaCategoriaOld != null && !unaCategoriaOld.equals(unaCategoriaNew)) {
                unaCategoriaOld.getVsEspecialidadActividad().remove(actividad);
                unaCategoriaOld = em.merge(unaCategoriaOld);
            }
            if (unaCategoriaNew != null && !unaCategoriaNew.equals(unaCategoriaOld)) {
                unaCategoriaNew.getVsEspecialidadActividad().add(actividad);
                unaCategoriaNew = em.merge(unaCategoriaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = actividad.getNombre();
                if (findActividad(id) == null) {
                    throw new NonexistentEntityException("The actividad with id " + id + " no longer exists.");
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
            Actividad actividad;
            try {
                actividad = em.getReference(Actividad.class, id);
                actividad.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The actividad with id " + id + " no longer exists.", enfe);
            }
            Categoria unaCategoria = actividad.getUnaCategoria();
            if (unaCategoria != null) {
                unaCategoria.getVsEspecialidadActividad().remove(actividad);
                unaCategoria = em.merge(unaCategoria);
            }
            em.remove(actividad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Actividad> findActividadEntities() {
        return findActividadEntities(true, -1, -1);
    }

    public List<Actividad> findActividadEntities(int maxResults, int firstResult) {
        return findActividadEntities(false, maxResults, firstResult);
    }

    private List<Actividad> findActividadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Actividad.class));
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

    public Actividad findActividad(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Actividad.class, id);
        } finally {
            em.close();
        }
    }

    public int getActividadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Actividad> rt = cq.from(Actividad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
