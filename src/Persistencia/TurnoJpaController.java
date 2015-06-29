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
import LogicaDeNegocios.Cliente;
import LogicaDeNegocios.Vehiculo;
import LogicaDeNegocios.Empleado;
import java.util.ArrayList;
import java.util.List;
import LogicaDeNegocios.OrdenTrabajo;
import LogicaDeNegocios.Turno;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alee
 */
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
        if (turno.getVsEmpleado() == null) {
            turno.setVsEmpleado(new ArrayList<Empleado>());
        }
        if (turno.getVsOrdenTrabajo() == null) {
            turno.setVsOrdenTrabajo(new ArrayList<OrdenTrabajo>());
        }
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
            List<Empleado> attachedVsEmpleado = new ArrayList<Empleado>();
            for (Empleado vsEmpleadoEmpleadoToAttach : turno.getVsEmpleado()) {
                vsEmpleadoEmpleadoToAttach = em.getReference(vsEmpleadoEmpleadoToAttach.getClass(), vsEmpleadoEmpleadoToAttach.getDni());
                attachedVsEmpleado.add(vsEmpleadoEmpleadoToAttach);
            }
            turno.setVsEmpleado(attachedVsEmpleado);
            List<OrdenTrabajo> attachedVsOrdenTrabajo = new ArrayList<OrdenTrabajo>();
            for (OrdenTrabajo vsOrdenTrabajoOrdenTrabajoToAttach : turno.getVsOrdenTrabajo()) {
                vsOrdenTrabajoOrdenTrabajoToAttach = em.getReference(vsOrdenTrabajoOrdenTrabajoToAttach.getClass(), vsOrdenTrabajoOrdenTrabajoToAttach.getCodOrden());
                attachedVsOrdenTrabajo.add(vsOrdenTrabajoOrdenTrabajoToAttach);
            }
            turno.setVsOrdenTrabajo(attachedVsOrdenTrabajo);
            em.persist(turno);
            if (unCliente != null) {
                unCliente.getVsTurno().add(turno);
                unCliente = em.merge(unCliente);
            }
            if (unVehiculo != null) {
                unVehiculo.getVsTurnosPend().add(turno);
                unVehiculo = em.merge(unVehiculo);
            }
            for (Empleado vsEmpleadoEmpleado : turno.getVsEmpleado()) {
                vsEmpleadoEmpleado.getVsTurno().add(turno);
                vsEmpleadoEmpleado = em.merge(vsEmpleadoEmpleado);
            }
            for (OrdenTrabajo vsOrdenTrabajoOrdenTrabajo : turno.getVsOrdenTrabajo()) {
                Turno oldUnTurnoOfVsOrdenTrabajoOrdenTrabajo = vsOrdenTrabajoOrdenTrabajo.getUnTurno();
                vsOrdenTrabajoOrdenTrabajo.setUnTurno(turno);
                vsOrdenTrabajoOrdenTrabajo = em.merge(vsOrdenTrabajoOrdenTrabajo);
                if (oldUnTurnoOfVsOrdenTrabajoOrdenTrabajo != null) {
                    oldUnTurnoOfVsOrdenTrabajoOrdenTrabajo.getVsOrdenTrabajo().remove(vsOrdenTrabajoOrdenTrabajo);
                    oldUnTurnoOfVsOrdenTrabajoOrdenTrabajo = em.merge(oldUnTurnoOfVsOrdenTrabajoOrdenTrabajo);
                }
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
            List<Empleado> vsEmpleadoOld = persistentTurno.getVsEmpleado();
            List<Empleado> vsEmpleadoNew = turno.getVsEmpleado();
            List<OrdenTrabajo> vsOrdenTrabajoOld = persistentTurno.getVsOrdenTrabajo();
            List<OrdenTrabajo> vsOrdenTrabajoNew = turno.getVsOrdenTrabajo();
            if (unClienteNew != null) {
                unClienteNew = em.getReference(unClienteNew.getClass(), unClienteNew.getDni());
                turno.setUnCliente(unClienteNew);
            }
            if (unVehiculoNew != null) {
                unVehiculoNew = em.getReference(unVehiculoNew.getClass(), unVehiculoNew.getNroChasis());
                turno.setUnVehiculo(unVehiculoNew);
            }
            List<Empleado> attachedVsEmpleadoNew = new ArrayList<Empleado>();
            for (Empleado vsEmpleadoNewEmpleadoToAttach : vsEmpleadoNew) {
                vsEmpleadoNewEmpleadoToAttach = em.getReference(vsEmpleadoNewEmpleadoToAttach.getClass(), vsEmpleadoNewEmpleadoToAttach.getDni());
                attachedVsEmpleadoNew.add(vsEmpleadoNewEmpleadoToAttach);
            }
            vsEmpleadoNew = attachedVsEmpleadoNew;
            turno.setVsEmpleado(vsEmpleadoNew);
            List<OrdenTrabajo> attachedVsOrdenTrabajoNew = new ArrayList<OrdenTrabajo>();
            for (OrdenTrabajo vsOrdenTrabajoNewOrdenTrabajoToAttach : vsOrdenTrabajoNew) {
                vsOrdenTrabajoNewOrdenTrabajoToAttach = em.getReference(vsOrdenTrabajoNewOrdenTrabajoToAttach.getClass(), vsOrdenTrabajoNewOrdenTrabajoToAttach.getCodOrden());
                attachedVsOrdenTrabajoNew.add(vsOrdenTrabajoNewOrdenTrabajoToAttach);
            }
            vsOrdenTrabajoNew = attachedVsOrdenTrabajoNew;
            turno.setVsOrdenTrabajo(vsOrdenTrabajoNew);
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
            for (Empleado vsEmpleadoOldEmpleado : vsEmpleadoOld) {
                if (!vsEmpleadoNew.contains(vsEmpleadoOldEmpleado)) {
                    vsEmpleadoOldEmpleado.getVsTurno().remove(turno);
                    vsEmpleadoOldEmpleado = em.merge(vsEmpleadoOldEmpleado);
                }
            }
            for (Empleado vsEmpleadoNewEmpleado : vsEmpleadoNew) {
                if (!vsEmpleadoOld.contains(vsEmpleadoNewEmpleado)) {
                    vsEmpleadoNewEmpleado.getVsTurno().add(turno);
                    vsEmpleadoNewEmpleado = em.merge(vsEmpleadoNewEmpleado);
                }
            }
            for (OrdenTrabajo vsOrdenTrabajoOldOrdenTrabajo : vsOrdenTrabajoOld) {
                if (!vsOrdenTrabajoNew.contains(vsOrdenTrabajoOldOrdenTrabajo)) {
                    vsOrdenTrabajoOldOrdenTrabajo.setUnTurno(null);
                    vsOrdenTrabajoOldOrdenTrabajo = em.merge(vsOrdenTrabajoOldOrdenTrabajo);
                }
            }
            for (OrdenTrabajo vsOrdenTrabajoNewOrdenTrabajo : vsOrdenTrabajoNew) {
                if (!vsOrdenTrabajoOld.contains(vsOrdenTrabajoNewOrdenTrabajo)) {
                    Turno oldUnTurnoOfVsOrdenTrabajoNewOrdenTrabajo = vsOrdenTrabajoNewOrdenTrabajo.getUnTurno();
                    vsOrdenTrabajoNewOrdenTrabajo.setUnTurno(turno);
                    vsOrdenTrabajoNewOrdenTrabajo = em.merge(vsOrdenTrabajoNewOrdenTrabajo);
                    if (oldUnTurnoOfVsOrdenTrabajoNewOrdenTrabajo != null && !oldUnTurnoOfVsOrdenTrabajoNewOrdenTrabajo.equals(turno)) {
                        oldUnTurnoOfVsOrdenTrabajoNewOrdenTrabajo.getVsOrdenTrabajo().remove(vsOrdenTrabajoNewOrdenTrabajo);
                        oldUnTurnoOfVsOrdenTrabajoNewOrdenTrabajo = em.merge(oldUnTurnoOfVsOrdenTrabajoNewOrdenTrabajo);
                    }
                }
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
            List<Empleado> vsEmpleado = turno.getVsEmpleado();
            for (Empleado vsEmpleadoEmpleado : vsEmpleado) {
                vsEmpleadoEmpleado.getVsTurno().remove(turno);
                vsEmpleadoEmpleado = em.merge(vsEmpleadoEmpleado);
            }
            List<OrdenTrabajo> vsOrdenTrabajo = turno.getVsOrdenTrabajo();
            for (OrdenTrabajo vsOrdenTrabajoOrdenTrabajo : vsOrdenTrabajo) {
                vsOrdenTrabajoOrdenTrabajo.setUnTurno(null);
                vsOrdenTrabajoOrdenTrabajo = em.merge(vsOrdenTrabajoOrdenTrabajo);
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
