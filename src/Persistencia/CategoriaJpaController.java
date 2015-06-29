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
import LogicaDeNegocios.Actividad;
import LogicaDeNegocios.Categoria;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ale
 */
public class CategoriaJpaController implements Serializable {

    public CategoriaJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public CategoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Categoria categoria) throws PreexistingEntityException, Exception {
        if (categoria.getVsEspecialidadActividad() == null) {
            categoria.setVsEspecialidadActividad(new ArrayList<Actividad>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Actividad> attachedVsEspecialidadActividad = new ArrayList<Actividad>();
            for (Actividad vsEspecialidadActividadActividadToAttach : categoria.getVsEspecialidadActividad()) {
                vsEspecialidadActividadActividadToAttach = em.getReference(vsEspecialidadActividadActividadToAttach.getClass(), vsEspecialidadActividadActividadToAttach.getNombre());
                attachedVsEspecialidadActividad.add(vsEspecialidadActividadActividadToAttach);
            }
            categoria.setVsEspecialidadActividad(attachedVsEspecialidadActividad);
            em.persist(categoria);
            for (Actividad vsEspecialidadActividadActividad : categoria.getVsEspecialidadActividad()) {
                Categoria oldUnaCategoriaOfVsEspecialidadActividadActividad = vsEspecialidadActividadActividad.getUnaCategoria();
                vsEspecialidadActividadActividad.setUnaCategoria(categoria);
                vsEspecialidadActividadActividad = em.merge(vsEspecialidadActividadActividad);
                if (oldUnaCategoriaOfVsEspecialidadActividadActividad != null) {
                    oldUnaCategoriaOfVsEspecialidadActividadActividad.getVsEspecialidadActividad().remove(vsEspecialidadActividadActividad);
                    oldUnaCategoriaOfVsEspecialidadActividadActividad = em.merge(oldUnaCategoriaOfVsEspecialidadActividadActividad);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCategoria(categoria.getNombre()) != null) {
                throw new PreexistingEntityException("Categoria " + categoria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Categoria categoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria persistentCategoria = em.find(Categoria.class, categoria.getNombre());
            List<Actividad> vsEspecialidadActividadOld = persistentCategoria.getVsEspecialidadActividad();
            List<Actividad> vsEspecialidadActividadNew = categoria.getVsEspecialidadActividad();
            List<Actividad> attachedVsEspecialidadActividadNew = new ArrayList<Actividad>();
            for (Actividad vsEspecialidadActividadNewActividadToAttach : vsEspecialidadActividadNew) {
                vsEspecialidadActividadNewActividadToAttach = em.getReference(vsEspecialidadActividadNewActividadToAttach.getClass(), vsEspecialidadActividadNewActividadToAttach.getNombre());
                attachedVsEspecialidadActividadNew.add(vsEspecialidadActividadNewActividadToAttach);
            }
            vsEspecialidadActividadNew = attachedVsEspecialidadActividadNew;
            categoria.setVsEspecialidadActividad(vsEspecialidadActividadNew);
            categoria = em.merge(categoria);
            for (Actividad vsEspecialidadActividadOldActividad : vsEspecialidadActividadOld) {
                if (!vsEspecialidadActividadNew.contains(vsEspecialidadActividadOldActividad)) {
                    vsEspecialidadActividadOldActividad.setUnaCategoria(null);
                    vsEspecialidadActividadOldActividad = em.merge(vsEspecialidadActividadOldActividad);
                }
            }
            for (Actividad vsEspecialidadActividadNewActividad : vsEspecialidadActividadNew) {
                if (!vsEspecialidadActividadOld.contains(vsEspecialidadActividadNewActividad)) {
                    Categoria oldUnaCategoriaOfVsEspecialidadActividadNewActividad = vsEspecialidadActividadNewActividad.getUnaCategoria();
                    vsEspecialidadActividadNewActividad.setUnaCategoria(categoria);
                    vsEspecialidadActividadNewActividad = em.merge(vsEspecialidadActividadNewActividad);
                    if (oldUnaCategoriaOfVsEspecialidadActividadNewActividad != null && !oldUnaCategoriaOfVsEspecialidadActividadNewActividad.equals(categoria)) {
                        oldUnaCategoriaOfVsEspecialidadActividadNewActividad.getVsEspecialidadActividad().remove(vsEspecialidadActividadNewActividad);
                        oldUnaCategoriaOfVsEspecialidadActividadNewActividad = em.merge(oldUnaCategoriaOfVsEspecialidadActividadNewActividad);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = categoria.getNombre();
                if (findCategoria(id) == null) {
                    throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.");
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
            Categoria categoria;
            try {
                categoria = em.getReference(Categoria.class, id);
                categoria.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.", enfe);
            }
            List<Actividad> vsEspecialidadActividad = categoria.getVsEspecialidadActividad();
            for (Actividad vsEspecialidadActividadActividad : vsEspecialidadActividad) {
                vsEspecialidadActividadActividad.setUnaCategoria(null);
                vsEspecialidadActividadActividad = em.merge(vsEspecialidadActividadActividad);
            }
            em.remove(categoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Categoria> findCategoriaEntities() {
        return findCategoriaEntities(true, -1, -1);
    }

    public List<Categoria> findCategoriaEntities(int maxResults, int firstResult) {
        return findCategoriaEntities(false, maxResults, firstResult);
    }

    private List<Categoria> findCategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Categoria.class));
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

    public Categoria findCategoria(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categoria> rt = cq.from(Categoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
