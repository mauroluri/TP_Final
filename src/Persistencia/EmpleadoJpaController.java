/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.Empleado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import LogicaDeNegocios.Sucursal;
import LogicaDeNegocios.Localidad;
import LogicaDeNegocios.Turno;
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
public class EmpleadoJpaController implements Serializable {

    public EmpleadoJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public EmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) throws PreexistingEntityException, Exception {
        if (empleado.getVsTurno() == null) {
            empleado.setVsTurno(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sucursal unaSucursal = empleado.getUnaSucursal();
            if (unaSucursal != null) {
                unaSucursal = em.getReference(unaSucursal.getClass(), unaSucursal.getCodSuc());
                empleado.setUnaSucursal(unaSucursal);
            }
            Localidad unaLocalidad = empleado.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad = em.getReference(unaLocalidad.getClass(), unaLocalidad.getCodigo());
                empleado.setUnaLocalidad(unaLocalidad);
            }
            List<Turno> attachedVsTurno = new ArrayList<Turno>();
            for (Turno vsTurnoTurnoToAttach : empleado.getVsTurno()) {
                vsTurnoTurnoToAttach = em.getReference(vsTurnoTurnoToAttach.getClass(), vsTurnoTurnoToAttach.getCodigo());
                attachedVsTurno.add(vsTurnoTurnoToAttach);
            }
            empleado.setVsTurno(attachedVsTurno);
            em.persist(empleado);
            if (unaSucursal != null) {
                unaSucursal.getVsEmpleado().add(empleado);
                unaSucursal = em.merge(unaSucursal);
            }
            if (unaLocalidad != null) {
                unaLocalidad.getVsEmpleado().add(empleado);
                unaLocalidad = em.merge(unaLocalidad);
            }
            for (Turno vsTurnoTurno : empleado.getVsTurno()) {
                vsTurnoTurno.getVsEmpleado().add(empleado);
                vsTurnoTurno = em.merge(vsTurnoTurno);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpleado(empleado.getDni()) != null) {
                throw new PreexistingEntityException("Empleado " + empleado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleado empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getDni());
            Sucursal unaSucursalOld = persistentEmpleado.getUnaSucursal();
            Sucursal unaSucursalNew = empleado.getUnaSucursal();
            Localidad unaLocalidadOld = persistentEmpleado.getUnaLocalidad();
            Localidad unaLocalidadNew = empleado.getUnaLocalidad();
            List<Turno> vsTurnoOld = persistentEmpleado.getVsTurno();
            List<Turno> vsTurnoNew = empleado.getVsTurno();
            if (unaSucursalNew != null) {
                unaSucursalNew = em.getReference(unaSucursalNew.getClass(), unaSucursalNew.getCodSuc());
                empleado.setUnaSucursal(unaSucursalNew);
            }
            if (unaLocalidadNew != null) {
                unaLocalidadNew = em.getReference(unaLocalidadNew.getClass(), unaLocalidadNew.getCodigo());
                empleado.setUnaLocalidad(unaLocalidadNew);
            }
            List<Turno> attachedVsTurnoNew = new ArrayList<Turno>();
            for (Turno vsTurnoNewTurnoToAttach : vsTurnoNew) {
                vsTurnoNewTurnoToAttach = em.getReference(vsTurnoNewTurnoToAttach.getClass(), vsTurnoNewTurnoToAttach.getCodigo());
                attachedVsTurnoNew.add(vsTurnoNewTurnoToAttach);
            }
            vsTurnoNew = attachedVsTurnoNew;
            empleado.setVsTurno(vsTurnoNew);
            empleado = em.merge(empleado);
            if (unaSucursalOld != null && !unaSucursalOld.equals(unaSucursalNew)) {
                unaSucursalOld.getVsEmpleado().remove(empleado);
                unaSucursalOld = em.merge(unaSucursalOld);
            }
            if (unaSucursalNew != null && !unaSucursalNew.equals(unaSucursalOld)) {
                unaSucursalNew.getVsEmpleado().add(empleado);
                unaSucursalNew = em.merge(unaSucursalNew);
            }
            if (unaLocalidadOld != null && !unaLocalidadOld.equals(unaLocalidadNew)) {
                unaLocalidadOld.getVsEmpleado().remove(empleado);
                unaLocalidadOld = em.merge(unaLocalidadOld);
            }
            if (unaLocalidadNew != null && !unaLocalidadNew.equals(unaLocalidadOld)) {
                unaLocalidadNew.getVsEmpleado().add(empleado);
                unaLocalidadNew = em.merge(unaLocalidadNew);
            }
            for (Turno vsTurnoOldTurno : vsTurnoOld) {
                if (!vsTurnoNew.contains(vsTurnoOldTurno)) {
                    vsTurnoOldTurno.getVsEmpleado().remove(empleado);
                    vsTurnoOldTurno = em.merge(vsTurnoOldTurno);
                }
            }
            for (Turno vsTurnoNewTurno : vsTurnoNew) {
                if (!vsTurnoOld.contains(vsTurnoNewTurno)) {
                    vsTurnoNewTurno.getVsEmpleado().add(empleado);
                    vsTurnoNewTurno = em.merge(vsTurnoNewTurno);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = empleado.getDni();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
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
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            Sucursal unaSucursal = empleado.getUnaSucursal();
            if (unaSucursal != null) {
                unaSucursal.getVsEmpleado().remove(empleado);
                unaSucursal = em.merge(unaSucursal);
            }
            Localidad unaLocalidad = empleado.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad.getVsEmpleado().remove(empleado);
                unaLocalidad = em.merge(unaLocalidad);
            }
            List<Turno> vsTurno = empleado.getVsTurno();
            for (Turno vsTurnoTurno : vsTurno) {
                vsTurnoTurno.getVsEmpleado().remove(empleado);
                vsTurnoTurno = em.merge(vsTurnoTurno);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
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

    public Empleado findEmpleado(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
