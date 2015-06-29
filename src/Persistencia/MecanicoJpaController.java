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
import LogicaDeNegocios.Especialidad;
import LogicaDeNegocios.Sucursal;
import LogicaDeNegocios.Localidad;
import LogicaDeNegocios.Interno;
import LogicaDeNegocios.Mecanico;
import java.util.ArrayList;
import java.util.List;
import LogicaDeNegocios.Turno;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ale
 */
public class MecanicoJpaController implements Serializable {

    public MecanicoJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public MecanicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mecanico mecanico) throws PreexistingEntityException, Exception {
        if (mecanico.getVsInterno() == null) {
            mecanico.setVsInterno(new ArrayList<Interno>());
        }
        if (mecanico.getVsTurno() == null) {
            mecanico.setVsTurno(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especialidad unaEspecialidad = mecanico.getUnaEspecialidad();
            if (unaEspecialidad != null) {
                unaEspecialidad = em.getReference(unaEspecialidad.getClass(), unaEspecialidad.getNombre());
                mecanico.setUnaEspecialidad(unaEspecialidad);
            }
            Sucursal unaSucursal = mecanico.getUnaSucursal();
            if (unaSucursal != null) {
                unaSucursal = em.getReference(unaSucursal.getClass(), unaSucursal.getCodSuc());
                mecanico.setUnaSucursal(unaSucursal);
            }
            Localidad unaLocalidad = mecanico.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad = em.getReference(unaLocalidad.getClass(), unaLocalidad.getCodigo());
                mecanico.setUnaLocalidad(unaLocalidad);
            }
            List<Interno> attachedVsInterno = new ArrayList<Interno>();
            for (Interno vsInternoInternoToAttach : mecanico.getVsInterno()) {
                vsInternoInternoToAttach = em.getReference(vsInternoInternoToAttach.getClass(), vsInternoInternoToAttach.getCodPedido());
                attachedVsInterno.add(vsInternoInternoToAttach);
            }
            mecanico.setVsInterno(attachedVsInterno);
            List<Turno> attachedVsTurno = new ArrayList<Turno>();
            for (Turno vsTurnoTurnoToAttach : mecanico.getVsTurno()) {
                vsTurnoTurnoToAttach = em.getReference(vsTurnoTurnoToAttach.getClass(), vsTurnoTurnoToAttach.getCodigo());
                attachedVsTurno.add(vsTurnoTurnoToAttach);
            }
            mecanico.setVsTurno(attachedVsTurno);
            em.persist(mecanico);
            if (unaEspecialidad != null) {
                unaEspecialidad.getVsMecanico().add(mecanico);
                unaEspecialidad = em.merge(unaEspecialidad);
            }
            if (unaSucursal != null) {
                unaSucursal.getVsEmpleado().add(mecanico);
                unaSucursal = em.merge(unaSucursal);
            }
            if (unaLocalidad != null) {
                unaLocalidad.getVsEmpleado().add(mecanico);
                unaLocalidad = em.merge(unaLocalidad);
            }
            for (Interno vsInternoInterno : mecanico.getVsInterno()) {
                Mecanico oldUnMecanicoOfVsInternoInterno = vsInternoInterno.getUnMecanico();
                vsInternoInterno.setUnMecanico(mecanico);
                vsInternoInterno = em.merge(vsInternoInterno);
                if (oldUnMecanicoOfVsInternoInterno != null) {
                    oldUnMecanicoOfVsInternoInterno.getVsInterno().remove(vsInternoInterno);
                    oldUnMecanicoOfVsInternoInterno = em.merge(oldUnMecanicoOfVsInternoInterno);
                }
            }
            for (Turno vsTurnoTurno : mecanico.getVsTurno()) {
                vsTurnoTurno.getVsEmpleado().add(mecanico);
                vsTurnoTurno = em.merge(vsTurnoTurno);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMecanico(mecanico.getDni()) != null) {
                throw new PreexistingEntityException("Mecanico " + mecanico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mecanico mecanico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mecanico persistentMecanico = em.find(Mecanico.class, mecanico.getDni());
            Especialidad unaEspecialidadOld = persistentMecanico.getUnaEspecialidad();
            Especialidad unaEspecialidadNew = mecanico.getUnaEspecialidad();
            Sucursal unaSucursalOld = persistentMecanico.getUnaSucursal();
            Sucursal unaSucursalNew = mecanico.getUnaSucursal();
            Localidad unaLocalidadOld = persistentMecanico.getUnaLocalidad();
            Localidad unaLocalidadNew = mecanico.getUnaLocalidad();
            List<Interno> vsInternoOld = persistentMecanico.getVsInterno();
            List<Interno> vsInternoNew = mecanico.getVsInterno();
            List<Turno> vsTurnoOld = persistentMecanico.getVsTurno();
            List<Turno> vsTurnoNew = mecanico.getVsTurno();
            if (unaEspecialidadNew != null) {
                unaEspecialidadNew = em.getReference(unaEspecialidadNew.getClass(), unaEspecialidadNew.getNombre());
                mecanico.setUnaEspecialidad(unaEspecialidadNew);
            }
            if (unaSucursalNew != null) {
                unaSucursalNew = em.getReference(unaSucursalNew.getClass(), unaSucursalNew.getCodSuc());
                mecanico.setUnaSucursal(unaSucursalNew);
            }
            if (unaLocalidadNew != null) {
                unaLocalidadNew = em.getReference(unaLocalidadNew.getClass(), unaLocalidadNew.getCodigo());
                mecanico.setUnaLocalidad(unaLocalidadNew);
            }
            List<Interno> attachedVsInternoNew = new ArrayList<Interno>();
            for (Interno vsInternoNewInternoToAttach : vsInternoNew) {
                vsInternoNewInternoToAttach = em.getReference(vsInternoNewInternoToAttach.getClass(), vsInternoNewInternoToAttach.getCodPedido());
                attachedVsInternoNew.add(vsInternoNewInternoToAttach);
            }
            vsInternoNew = attachedVsInternoNew;
            mecanico.setVsInterno(vsInternoNew);
            List<Turno> attachedVsTurnoNew = new ArrayList<Turno>();
            for (Turno vsTurnoNewTurnoToAttach : vsTurnoNew) {
                vsTurnoNewTurnoToAttach = em.getReference(vsTurnoNewTurnoToAttach.getClass(), vsTurnoNewTurnoToAttach.getCodigo());
                attachedVsTurnoNew.add(vsTurnoNewTurnoToAttach);
            }
            vsTurnoNew = attachedVsTurnoNew;
            mecanico.setVsTurno(vsTurnoNew);
            mecanico = em.merge(mecanico);
            if (unaEspecialidadOld != null && !unaEspecialidadOld.equals(unaEspecialidadNew)) {
                unaEspecialidadOld.getVsMecanico().remove(mecanico);
                unaEspecialidadOld = em.merge(unaEspecialidadOld);
            }
            if (unaEspecialidadNew != null && !unaEspecialidadNew.equals(unaEspecialidadOld)) {
                unaEspecialidadNew.getVsMecanico().add(mecanico);
                unaEspecialidadNew = em.merge(unaEspecialidadNew);
            }
            if (unaSucursalOld != null && !unaSucursalOld.equals(unaSucursalNew)) {
                unaSucursalOld.getVsEmpleado().remove(mecanico);
                unaSucursalOld = em.merge(unaSucursalOld);
            }
            if (unaSucursalNew != null && !unaSucursalNew.equals(unaSucursalOld)) {
                unaSucursalNew.getVsEmpleado().add(mecanico);
                unaSucursalNew = em.merge(unaSucursalNew);
            }
            if (unaLocalidadOld != null && !unaLocalidadOld.equals(unaLocalidadNew)) {
                unaLocalidadOld.getVsEmpleado().remove(mecanico);
                unaLocalidadOld = em.merge(unaLocalidadOld);
            }
            if (unaLocalidadNew != null && !unaLocalidadNew.equals(unaLocalidadOld)) {
                unaLocalidadNew.getVsEmpleado().add(mecanico);
                unaLocalidadNew = em.merge(unaLocalidadNew);
            }
            for (Interno vsInternoOldInterno : vsInternoOld) {
                if (!vsInternoNew.contains(vsInternoOldInterno)) {
                    vsInternoOldInterno.setUnMecanico(null);
                    vsInternoOldInterno = em.merge(vsInternoOldInterno);
                }
            }
            for (Interno vsInternoNewInterno : vsInternoNew) {
                if (!vsInternoOld.contains(vsInternoNewInterno)) {
                    Mecanico oldUnMecanicoOfVsInternoNewInterno = vsInternoNewInterno.getUnMecanico();
                    vsInternoNewInterno.setUnMecanico(mecanico);
                    vsInternoNewInterno = em.merge(vsInternoNewInterno);
                    if (oldUnMecanicoOfVsInternoNewInterno != null && !oldUnMecanicoOfVsInternoNewInterno.equals(mecanico)) {
                        oldUnMecanicoOfVsInternoNewInterno.getVsInterno().remove(vsInternoNewInterno);
                        oldUnMecanicoOfVsInternoNewInterno = em.merge(oldUnMecanicoOfVsInternoNewInterno);
                    }
                }
            }
            for (Turno vsTurnoOldTurno : vsTurnoOld) {
                if (!vsTurnoNew.contains(vsTurnoOldTurno)) {
                    vsTurnoOldTurno.getVsEmpleado().remove(mecanico);
                    vsTurnoOldTurno = em.merge(vsTurnoOldTurno);
                }
            }
            for (Turno vsTurnoNewTurno : vsTurnoNew) {
                if (!vsTurnoOld.contains(vsTurnoNewTurno)) {
                    vsTurnoNewTurno.getVsEmpleado().add(mecanico);
                    vsTurnoNewTurno = em.merge(vsTurnoNewTurno);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = mecanico.getDni();
                if (findMecanico(id) == null) {
                    throw new NonexistentEntityException("The mecanico with id " + id + " no longer exists.");
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
            Mecanico mecanico;
            try {
                mecanico = em.getReference(Mecanico.class, id);
                mecanico.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mecanico with id " + id + " no longer exists.", enfe);
            }
            Especialidad unaEspecialidad = mecanico.getUnaEspecialidad();
            if (unaEspecialidad != null) {
                unaEspecialidad.getVsMecanico().remove(mecanico);
                unaEspecialidad = em.merge(unaEspecialidad);
            }
            Sucursal unaSucursal = mecanico.getUnaSucursal();
            if (unaSucursal != null) {
                unaSucursal.getVsEmpleado().remove(mecanico);
                unaSucursal = em.merge(unaSucursal);
            }
            Localidad unaLocalidad = mecanico.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad.getVsEmpleado().remove(mecanico);
                unaLocalidad = em.merge(unaLocalidad);
            }
            List<Interno> vsInterno = mecanico.getVsInterno();
            for (Interno vsInternoInterno : vsInterno) {
                vsInternoInterno.setUnMecanico(null);
                vsInternoInterno = em.merge(vsInternoInterno);
            }
            List<Turno> vsTurno = mecanico.getVsTurno();
            for (Turno vsTurnoTurno : vsTurno) {
                vsTurnoTurno.getVsEmpleado().remove(mecanico);
                vsTurnoTurno = em.merge(vsTurnoTurno);
            }
            em.remove(mecanico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mecanico> findMecanicoEntities() {
        return findMecanicoEntities(true, -1, -1);
    }

    public List<Mecanico> findMecanicoEntities(int maxResults, int firstResult) {
        return findMecanicoEntities(false, maxResults, firstResult);
    }

    private List<Mecanico> findMecanicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mecanico.class));
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

    public Mecanico findMecanico(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mecanico.class, id);
        } finally {
            em.close();
        }
    }

    public int getMecanicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mecanico> rt = cq.from(Mecanico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
