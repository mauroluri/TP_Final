/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.Ajuste;
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
 * @author Ale
 */
public class AjusteJpaController implements Serializable {

    public AjusteJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public AjusteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ajuste ajuste) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno unTurno = ajuste.getUnTurno();
            if (unTurno != null) {
                unTurno = em.getReference(unTurno.getClass(), unTurno.getCodigo());
                ajuste.setUnTurno(unTurno);
            }
            em.persist(ajuste);
            if (unTurno != null) {
                LogicaDeNegocios.OrdenTrabajo oldUnaOrdenTrabajoOfUnTurno = unTurno.getUnaOrdenTrabajo();
                if (oldUnaOrdenTrabajoOfUnTurno != null) {
                    oldUnaOrdenTrabajoOfUnTurno.setUnTurno(null);
                    oldUnaOrdenTrabajoOfUnTurno = em.merge(oldUnaOrdenTrabajoOfUnTurno);
                }
                unTurno.setUnaOrdenTrabajo(ajuste);
                unTurno = em.merge(unTurno);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAjuste(ajuste.getCodOrden()) != null) {
                throw new PreexistingEntityException("Ajuste " + ajuste + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ajuste ajuste) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ajuste persistentAjuste = em.find(Ajuste.class, ajuste.getCodOrden());
            Turno unTurnoOld = persistentAjuste.getUnTurno();
            Turno unTurnoNew = ajuste.getUnTurno();
            if (unTurnoNew != null) {
                unTurnoNew = em.getReference(unTurnoNew.getClass(), unTurnoNew.getCodigo());
                ajuste.setUnTurno(unTurnoNew);
            }
            ajuste = em.merge(ajuste);
            if (unTurnoOld != null && !unTurnoOld.equals(unTurnoNew)) {
                unTurnoOld.setUnaOrdenTrabajo(null);
                unTurnoOld = em.merge(unTurnoOld);
            }
            if (unTurnoNew != null && !unTurnoNew.equals(unTurnoOld)) {
                LogicaDeNegocios.OrdenTrabajo oldUnaOrdenTrabajoOfUnTurno = unTurnoNew.getUnaOrdenTrabajo();
                if (oldUnaOrdenTrabajoOfUnTurno != null) {
                    oldUnaOrdenTrabajoOfUnTurno.setUnTurno(null);
                    oldUnaOrdenTrabajoOfUnTurno = em.merge(oldUnaOrdenTrabajoOfUnTurno);
                }
                unTurnoNew.setUnaOrdenTrabajo(ajuste);
                unTurnoNew = em.merge(unTurnoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = ajuste.getCodOrden();
                if (findAjuste(id) == null) {
                    throw new NonexistentEntityException("The ajuste with id " + id + " no longer exists.");
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
            Ajuste ajuste;
            try {
                ajuste = em.getReference(Ajuste.class, id);
                ajuste.getCodOrden();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ajuste with id " + id + " no longer exists.", enfe);
            }
            Turno unTurno = ajuste.getUnTurno();
            if (unTurno != null) {
                unTurno.setUnaOrdenTrabajo(null);
                unTurno = em.merge(unTurno);
            }
            em.remove(ajuste);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ajuste> findAjusteEntities() {
        return findAjusteEntities(true, -1, -1);
    }

    public List<Ajuste> findAjusteEntities(int maxResults, int firstResult) {
        return findAjusteEntities(false, maxResults, firstResult);
    }

    private List<Ajuste> findAjusteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ajuste.class));
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

    public Ajuste findAjuste(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ajuste.class, id);
        } finally {
            em.close();
        }
    }

    public int getAjusteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ajuste> rt = cq.from(Ajuste.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
