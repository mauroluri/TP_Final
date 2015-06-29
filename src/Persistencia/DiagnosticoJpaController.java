/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.Diagnostico;
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
public class DiagnosticoJpaController implements Serializable {

    public DiagnosticoJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public DiagnosticoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Diagnostico diagnostico) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno unTurno = diagnostico.getUnTurno();
            if (unTurno != null) {
                unTurno = em.getReference(unTurno.getClass(), unTurno.getCodigo());
                diagnostico.setUnTurno(unTurno);
            }
            em.persist(diagnostico);
            if (unTurno != null) {
                unTurno.getVsOrdenTrabajo().add(diagnostico);
                unTurno = em.merge(unTurno);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDiagnostico(diagnostico.getCodOrden()) != null) {
                throw new PreexistingEntityException("Diagnostico " + diagnostico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Diagnostico diagnostico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Diagnostico persistentDiagnostico = em.find(Diagnostico.class, diagnostico.getCodOrden());
            Turno unTurnoOld = persistentDiagnostico.getUnTurno();
            Turno unTurnoNew = diagnostico.getUnTurno();
            if (unTurnoNew != null) {
                unTurnoNew = em.getReference(unTurnoNew.getClass(), unTurnoNew.getCodigo());
                diagnostico.setUnTurno(unTurnoNew);
            }
            diagnostico = em.merge(diagnostico);
            if (unTurnoOld != null && !unTurnoOld.equals(unTurnoNew)) {
                unTurnoOld.getVsOrdenTrabajo().remove(diagnostico);
                unTurnoOld = em.merge(unTurnoOld);
            }
            if (unTurnoNew != null && !unTurnoNew.equals(unTurnoOld)) {
                unTurnoNew.getVsOrdenTrabajo().add(diagnostico);
                unTurnoNew = em.merge(unTurnoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = diagnostico.getCodOrden();
                if (findDiagnostico(id) == null) {
                    throw new NonexistentEntityException("The diagnostico with id " + id + " no longer exists.");
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
            Diagnostico diagnostico;
            try {
                diagnostico = em.getReference(Diagnostico.class, id);
                diagnostico.getCodOrden();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The diagnostico with id " + id + " no longer exists.", enfe);
            }
            Turno unTurno = diagnostico.getUnTurno();
            if (unTurno != null) {
                unTurno.getVsOrdenTrabajo().remove(diagnostico);
                unTurno = em.merge(unTurno);
            }
            em.remove(diagnostico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Diagnostico> findDiagnosticoEntities() {
        return findDiagnosticoEntities(true, -1, -1);
    }

    public List<Diagnostico> findDiagnosticoEntities(int maxResults, int firstResult) {
        return findDiagnosticoEntities(false, maxResults, firstResult);
    }

    private List<Diagnostico> findDiagnosticoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Diagnostico.class));
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

    public Diagnostico findDiagnostico(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Diagnostico.class, id);
        } finally {
            em.close();
        }
    }

    public int getDiagnosticoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Diagnostico> rt = cq.from(Diagnostico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
