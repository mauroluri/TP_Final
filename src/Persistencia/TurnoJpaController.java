
package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import LogicaDeNegocios.Cliente;
import LogicaDeNegocios.Vehiculo;
import LogicaDeNegocios.OrdenTrabajo;
import LogicaDeNegocios.Turno;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TurnoJpaController implements Serializable {

    public TurnoJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turno turno) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente unCliente = turno.getUnCliente();
            if (unCliente != null) {
                unCliente = em.getReference(unCliente.getClass(), unCliente.getDni());
                turno.setUnCliente(unCliente);
            }
            Vehiculo unVehiculo = turno.getUnVehiculo();
            if (unVehiculo != null) {
                unVehiculo = em.getReference(unVehiculo.getClass(), unVehiculo.getNroChasis());
                turno.setUnVehiculo(unVehiculo);
            }
            OrdenTrabajo unaOrdenTrabajo = turno.getUnaOrdenTrabajo();
            if (unaOrdenTrabajo != null) {
                unaOrdenTrabajo = em.getReference(unaOrdenTrabajo.getClass(), unaOrdenTrabajo.getCodOrden());
                turno.setUnaOrdenTrabajo(unaOrdenTrabajo);
            }
            em.persist(turno);
            if (unCliente != null) {
                unCliente.getVsTurno().add(turno);
                unCliente = em.merge(unCliente);
            }
            if (unVehiculo != null) {
                unVehiculo.getVsTurnosPend().add(turno);
                unVehiculo = em.merge(unVehiculo);
            }
            if (unaOrdenTrabajo != null) {
                Turno oldUnTurnoOfUnaOrdenTrabajo = unaOrdenTrabajo.getUnTurno();
                if (oldUnTurnoOfUnaOrdenTrabajo != null) {
                    oldUnTurnoOfUnaOrdenTrabajo.setUnaOrdenTrabajo(null);
                    oldUnTurnoOfUnaOrdenTrabajo = em.merge(oldUnTurnoOfUnaOrdenTrabajo);
                }
                unaOrdenTrabajo.setUnTurno(turno);
                unaOrdenTrabajo = em.merge(unaOrdenTrabajo);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTurno(turno.getCodigo()) != null) {
                throw new PreexistingEntityException("Turno " + turno + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno persistentTurno = em.find(Turno.class, turno.getCodigo());
            Cliente unClienteOld = persistentTurno.getUnCliente();
            Cliente unClienteNew = turno.getUnCliente();
            Vehiculo unVehiculoOld = persistentTurno.getUnVehiculo();
            Vehiculo unVehiculoNew = turno.getUnVehiculo();
            OrdenTrabajo unaOrdenTrabajoOld = persistentTurno.getUnaOrdenTrabajo();
            OrdenTrabajo unaOrdenTrabajoNew = turno.getUnaOrdenTrabajo();
            if (unClienteNew != null) {
                unClienteNew = em.getReference(unClienteNew.getClass(), unClienteNew.getDni());
                turno.setUnCliente(unClienteNew);
            }
            if (unVehiculoNew != null) {
                unVehiculoNew = em.getReference(unVehiculoNew.getClass(), unVehiculoNew.getNroChasis());
                turno.setUnVehiculo(unVehiculoNew);
            }
            if (unaOrdenTrabajoNew != null) {
                unaOrdenTrabajoNew = em.getReference(unaOrdenTrabajoNew.getClass(), unaOrdenTrabajoNew.getCodOrden());
                turno.setUnaOrdenTrabajo(unaOrdenTrabajoNew);
            }
            turno = em.merge(turno);
            if (unClienteOld != null && !unClienteOld.equals(unClienteNew)) {
                unClienteOld.getVsTurno().remove(turno);
                unClienteOld = em.merge(unClienteOld);
            }
            if (unClienteNew != null && !unClienteNew.equals(unClienteOld)) {
                unClienteNew.getVsTurno().add(turno);
                unClienteNew = em.merge(unClienteNew);
            }
            if (unVehiculoOld != null && !unVehiculoOld.equals(unVehiculoNew)) {
                unVehiculoOld.getVsTurnosPend().remove(turno);
                unVehiculoOld = em.merge(unVehiculoOld);
            }
            if (unVehiculoNew != null && !unVehiculoNew.equals(unVehiculoOld)) {
                unVehiculoNew.getVsTurnosPend().add(turno);
                unVehiculoNew = em.merge(unVehiculoNew);
            }
            if (unaOrdenTrabajoOld != null && !unaOrdenTrabajoOld.equals(unaOrdenTrabajoNew)) {
                unaOrdenTrabajoOld.setUnTurno(null);
                unaOrdenTrabajoOld = em.merge(unaOrdenTrabajoOld);
            }
            if (unaOrdenTrabajoNew != null && !unaOrdenTrabajoNew.equals(unaOrdenTrabajoOld)) {
                Turno oldUnTurnoOfUnaOrdenTrabajo = unaOrdenTrabajoNew.getUnTurno();
                if (oldUnTurnoOfUnaOrdenTrabajo != null) {
                    oldUnTurnoOfUnaOrdenTrabajo.setUnaOrdenTrabajo(null);
                    oldUnTurnoOfUnaOrdenTrabajo = em.merge(oldUnTurnoOfUnaOrdenTrabajo);
                }
                unaOrdenTrabajoNew.setUnTurno(turno);
                unaOrdenTrabajoNew = em.merge(unaOrdenTrabajoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = turno.getCodigo();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
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
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            Cliente unCliente = turno.getUnCliente();
            if (unCliente != null) {
                unCliente.getVsTurno().remove(turno);
                unCliente = em.merge(unCliente);
            }
            Vehiculo unVehiculo = turno.getUnVehiculo();
            if (unVehiculo != null) {
                unVehiculo.getVsTurnosPend().remove(turno);
                unVehiculo = em.merge(unVehiculo);
            }
            OrdenTrabajo unaOrdenTrabajo = turno.getUnaOrdenTrabajo();
            if (unaOrdenTrabajo != null) {
                unaOrdenTrabajo.setUnTurno(null);
                unaOrdenTrabajo = em.merge(unaOrdenTrabajo);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
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

    public Turno findTurno(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
