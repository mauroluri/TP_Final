/*
 *  ERROR EN LINEA 53.. 
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.OrdenTrabajo;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import LogicaDeNegocios.Turno;
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
public class OrdenTrabajoJpaController implements Serializable {

    public OrdenTrabajoJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public OrdenTrabajoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OrdenTrabajo ordenTrabajo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno unTurno = ordenTrabajo.getUnTurno();
            if (unTurno != null) {
                unTurno = em.getReference(unTurno.getClass(), unTurno.getCodigo());
                ordenTrabajo.setUnTurno(unTurno);
            }
            em.persist(ordenTrabajo);
            if (unTurno != null) {
                unTurno.getVsOrdenTrabajo().add(ordenTrabajo);
                unTurno = em.merge(unTurno);//asdfasd
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrdenTrabajo(ordenTrabajo.getCodOrden()) != null) {
                throw new PreexistingEntityException("OrdenTrabajo " + ordenTrabajo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OrdenTrabajo ordenTrabajo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OrdenTrabajo persistentOrdenTrabajo = em.find(OrdenTrabajo.class, ordenTrabajo.getCodOrden());
            Turno unTurnoOld = persistentOrdenTrabajo.getUnTurno();
            Turno unTurnoNew = ordenTrabajo.getUnTurno();
            if (unTurnoNew != null) {
                unTurnoNew = em.getReference(unTurnoNew.getClass(), unTurnoNew.getCodigo());
                ordenTrabajo.setUnTurno(unTurnoNew);
            }
            ordenTrabajo = em.merge(ordenTrabajo);
            if (unTurnoOld != null && !unTurnoOld.equals(unTurnoNew)) {
                unTurnoOld.getVsOrdenTrabajo().remove(ordenTrabajo);
                unTurnoOld = em.merge(unTurnoOld);
            }
            if (unTurnoNew != null && !unTurnoNew.equals(unTurnoOld)) {
                unTurnoNew.getVsOrdenTrabajo().add(ordenTrabajo);
                unTurnoNew = em.merge(unTurnoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = ordenTrabajo.getCodOrden();
                if (findOrdenTrabajo(id) == null) {
                    throw new NonexistentEntityException("The ordenTrabajo with id " + id + " no longer exists.");
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
            OrdenTrabajo ordenTrabajo;
            try {
                ordenTrabajo = em.getReference(OrdenTrabajo.class, id);
                ordenTrabajo.getCodOrden();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordenTrabajo with id " + id + " no longer exists.", enfe);
            }
            Turno unTurno = ordenTrabajo.getUnTurno();
            if (unTurno != null) {
                unTurno.getVsOrdenTrabajo().remove(ordenTrabajo);
                unTurno = em.merge(unTurno);
            }
            em.remove(ordenTrabajo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OrdenTrabajo> findOrdenTrabajoEntities() {
        return findOrdenTrabajoEntities(true, -1, -1);
    }

    public List<OrdenTrabajo> findOrdenTrabajoEntities(int maxResults, int firstResult) {
        return findOrdenTrabajoEntities(false, maxResults, firstResult);
    }

    private List<OrdenTrabajo> findOrdenTrabajoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OrdenTrabajo.class));
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

    public OrdenTrabajo findOrdenTrabajo(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OrdenTrabajo.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdenTrabajoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OrdenTrabajo> rt = cq.from(OrdenTrabajo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
