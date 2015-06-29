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
import LogicaDeNegocios.Calle;
import LogicaDeNegocios.Localidad;
import java.util.ArrayList;
import java.util.List;
import LogicaDeNegocios.Empleado;
import LogicaDeNegocios.Sucursal;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alee
 */
public class SucursalJpaController implements Serializable {

    public SucursalJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public SucursalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sucursal sucursal) throws PreexistingEntityException, Exception {
        if (sucursal.getVsCalle() == null) {
            sucursal.setVsCalle(new ArrayList<Calle>());
        }
        if (sucursal.getVsEmpleado() == null) {
            sucursal.setVsEmpleado(new ArrayList<Empleado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calle calleSuc = sucursal.getCalleSuc();
            if (calleSuc != null) {
                calleSuc = em.getReference(calleSuc.getClass(), calleSuc.getNombre());
                sucursal.setCalleSuc(calleSuc);
            }
            Localidad unaLocalidad = sucursal.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad = em.getReference(unaLocalidad.getClass(), unaLocalidad.getCodigo());
                sucursal.setUnaLocalidad(unaLocalidad);
            }
            List<Calle> attachedVsCalle = new ArrayList<Calle>();
            for (Calle vsCalleCalleToAttach : sucursal.getVsCalle()) {
                vsCalleCalleToAttach = em.getReference(vsCalleCalleToAttach.getClass(), vsCalleCalleToAttach.getNombre());
                attachedVsCalle.add(vsCalleCalleToAttach);
            }
            sucursal.setVsCalle(attachedVsCalle);
            List<Empleado> attachedVsEmpleado = new ArrayList<Empleado>();
            for (Empleado vsEmpleadoEmpleadoToAttach : sucursal.getVsEmpleado()) {
                vsEmpleadoEmpleadoToAttach = em.getReference(vsEmpleadoEmpleadoToAttach.getClass(), vsEmpleadoEmpleadoToAttach.getDni());
                attachedVsEmpleado.add(vsEmpleadoEmpleadoToAttach);
            }
            sucursal.setVsEmpleado(attachedVsEmpleado);
            em.persist(sucursal);
            if (calleSuc != null) {
                Sucursal oldUnaSucursalOfCalleSuc = calleSuc.getUnaSucursal();
                if (oldUnaSucursalOfCalleSuc != null) {
                    oldUnaSucursalOfCalleSuc.setCalleSuc(null);
                    oldUnaSucursalOfCalleSuc = em.merge(oldUnaSucursalOfCalleSuc);
                }
                calleSuc.setUnaSucursal(sucursal);
                calleSuc = em.merge(calleSuc);
            }
            if (unaLocalidad != null) {
                unaLocalidad.getVsSucursal().add(sucursal);
                unaLocalidad = em.merge(unaLocalidad);
            }
            for (Calle vsCalleCalle : sucursal.getVsCalle()) {
                Sucursal oldUnaSucursalOfVsCalleCalle = vsCalleCalle.getUnaSucursal();
                vsCalleCalle.setUnaSucursal(sucursal);
                vsCalleCalle = em.merge(vsCalleCalle);
                if (oldUnaSucursalOfVsCalleCalle != null) {
                    oldUnaSucursalOfVsCalleCalle.getVsCalle().remove(vsCalleCalle);
                    oldUnaSucursalOfVsCalleCalle = em.merge(oldUnaSucursalOfVsCalleCalle);
                }
            }
            for (Empleado vsEmpleadoEmpleado : sucursal.getVsEmpleado()) {
                Sucursal oldUnaSucursalOfVsEmpleadoEmpleado = vsEmpleadoEmpleado.getUnaSucursal();
                vsEmpleadoEmpleado.setUnaSucursal(sucursal);
                vsEmpleadoEmpleado = em.merge(vsEmpleadoEmpleado);
                if (oldUnaSucursalOfVsEmpleadoEmpleado != null) {
                    oldUnaSucursalOfVsEmpleadoEmpleado.getVsEmpleado().remove(vsEmpleadoEmpleado);
                    oldUnaSucursalOfVsEmpleadoEmpleado = em.merge(oldUnaSucursalOfVsEmpleadoEmpleado);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSucursal(sucursal.getCodSuc()) != null) {
                throw new PreexistingEntityException("Sucursal " + sucursal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sucursal sucursal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sucursal persistentSucursal = em.find(Sucursal.class, sucursal.getCodSuc());
            Calle calleSucOld = persistentSucursal.getCalleSuc();
            Calle calleSucNew = sucursal.getCalleSuc();
            Localidad unaLocalidadOld = persistentSucursal.getUnaLocalidad();
            Localidad unaLocalidadNew = sucursal.getUnaLocalidad();
            List<Calle> vsCalleOld = persistentSucursal.getVsCalle();
            List<Calle> vsCalleNew = sucursal.getVsCalle();
            List<Empleado> vsEmpleadoOld = persistentSucursal.getVsEmpleado();
            List<Empleado> vsEmpleadoNew = sucursal.getVsEmpleado();
            if (calleSucNew != null) {
                calleSucNew = em.getReference(calleSucNew.getClass(), calleSucNew.getNombre());
                sucursal.setCalleSuc(calleSucNew);
            }
            if (unaLocalidadNew != null) {
                unaLocalidadNew = em.getReference(unaLocalidadNew.getClass(), unaLocalidadNew.getCodigo());
                sucursal.setUnaLocalidad(unaLocalidadNew);
            }
            List<Calle> attachedVsCalleNew = new ArrayList<Calle>();
            for (Calle vsCalleNewCalleToAttach : vsCalleNew) {
                vsCalleNewCalleToAttach = em.getReference(vsCalleNewCalleToAttach.getClass(), vsCalleNewCalleToAttach.getNombre());
                attachedVsCalleNew.add(vsCalleNewCalleToAttach);
            }
            vsCalleNew = attachedVsCalleNew;
            sucursal.setVsCalle(vsCalleNew);
            List<Empleado> attachedVsEmpleadoNew = new ArrayList<Empleado>();
            for (Empleado vsEmpleadoNewEmpleadoToAttach : vsEmpleadoNew) {
                vsEmpleadoNewEmpleadoToAttach = em.getReference(vsEmpleadoNewEmpleadoToAttach.getClass(), vsEmpleadoNewEmpleadoToAttach.getDni());
                attachedVsEmpleadoNew.add(vsEmpleadoNewEmpleadoToAttach);
            }
            vsEmpleadoNew = attachedVsEmpleadoNew;
            sucursal.setVsEmpleado(vsEmpleadoNew);
            sucursal = em.merge(sucursal);
            if (calleSucOld != null && !calleSucOld.equals(calleSucNew)) {
                calleSucOld.setUnaSucursal(null);
                calleSucOld = em.merge(calleSucOld);
            }
            if (calleSucNew != null && !calleSucNew.equals(calleSucOld)) {
                Sucursal oldUnaSucursalOfCalleSuc = calleSucNew.getUnaSucursal();
                if (oldUnaSucursalOfCalleSuc != null) {
                    oldUnaSucursalOfCalleSuc.setCalleSuc(null);
                    oldUnaSucursalOfCalleSuc = em.merge(oldUnaSucursalOfCalleSuc);
                }
                calleSucNew.setUnaSucursal(sucursal);
                calleSucNew = em.merge(calleSucNew);
            }
            if (unaLocalidadOld != null && !unaLocalidadOld.equals(unaLocalidadNew)) {
                unaLocalidadOld.getVsSucursal().remove(sucursal);
                unaLocalidadOld = em.merge(unaLocalidadOld);
            }
            if (unaLocalidadNew != null && !unaLocalidadNew.equals(unaLocalidadOld)) {
                unaLocalidadNew.getVsSucursal().add(sucursal);
                unaLocalidadNew = em.merge(unaLocalidadNew);
            }
            for (Calle vsCalleOldCalle : vsCalleOld) {
                if (!vsCalleNew.contains(vsCalleOldCalle)) {
                    vsCalleOldCalle.setUnaSucursal(null);
                    vsCalleOldCalle = em.merge(vsCalleOldCalle);
                }
            }
            for (Calle vsCalleNewCalle : vsCalleNew) {
                if (!vsCalleOld.contains(vsCalleNewCalle)) {
                    Sucursal oldUnaSucursalOfVsCalleNewCalle = vsCalleNewCalle.getUnaSucursal();
                    vsCalleNewCalle.setUnaSucursal(sucursal);
                    vsCalleNewCalle = em.merge(vsCalleNewCalle);
                    if (oldUnaSucursalOfVsCalleNewCalle != null && !oldUnaSucursalOfVsCalleNewCalle.equals(sucursal)) {
                        oldUnaSucursalOfVsCalleNewCalle.getVsCalle().remove(vsCalleNewCalle);
                        oldUnaSucursalOfVsCalleNewCalle = em.merge(oldUnaSucursalOfVsCalleNewCalle);
                    }
                }
            }
            for (Empleado vsEmpleadoOldEmpleado : vsEmpleadoOld) {
                if (!vsEmpleadoNew.contains(vsEmpleadoOldEmpleado)) {
                    vsEmpleadoOldEmpleado.setUnaSucursal(null);
                    vsEmpleadoOldEmpleado = em.merge(vsEmpleadoOldEmpleado);
                }
            }
            for (Empleado vsEmpleadoNewEmpleado : vsEmpleadoNew) {
                if (!vsEmpleadoOld.contains(vsEmpleadoNewEmpleado)) {
                    Sucursal oldUnaSucursalOfVsEmpleadoNewEmpleado = vsEmpleadoNewEmpleado.getUnaSucursal();
                    vsEmpleadoNewEmpleado.setUnaSucursal(sucursal);
                    vsEmpleadoNewEmpleado = em.merge(vsEmpleadoNewEmpleado);
                    if (oldUnaSucursalOfVsEmpleadoNewEmpleado != null && !oldUnaSucursalOfVsEmpleadoNewEmpleado.equals(sucursal)) {
                        oldUnaSucursalOfVsEmpleadoNewEmpleado.getVsEmpleado().remove(vsEmpleadoNewEmpleado);
                        oldUnaSucursalOfVsEmpleadoNewEmpleado = em.merge(oldUnaSucursalOfVsEmpleadoNewEmpleado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = sucursal.getCodSuc();
                if (findSucursal(id) == null) {
                    throw new NonexistentEntityException("The sucursal with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sucursal sucursal;
            try {
                sucursal = em.getReference(Sucursal.class, id);
                sucursal.getCodSuc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sucursal with id " + id + " no longer exists.", enfe);
            }
            Calle calleSuc = sucursal.getCalleSuc();
            if (calleSuc != null) {
                calleSuc.setUnaSucursal(null);
                calleSuc = em.merge(calleSuc);
            }
            Localidad unaLocalidad = sucursal.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad.getVsSucursal().remove(sucursal);
                unaLocalidad = em.merge(unaLocalidad);
            }
            List<Calle> vsCalle = sucursal.getVsCalle();
            for (Calle vsCalleCalle : vsCalle) {
                vsCalleCalle.setUnaSucursal(null);
                vsCalleCalle = em.merge(vsCalleCalle);
            }
            List<Empleado> vsEmpleado = sucursal.getVsEmpleado();
            for (Empleado vsEmpleadoEmpleado : vsEmpleado) {
                vsEmpleadoEmpleado.setUnaSucursal(null);
                vsEmpleadoEmpleado = em.merge(vsEmpleadoEmpleado);
            }
            em.remove(sucursal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sucursal> findSucursalEntities() {
        return findSucursalEntities(true, -1, -1);
    }

    public List<Sucursal> findSucursalEntities(int maxResults, int firstResult) {
        return findSucursalEntities(false, maxResults, firstResult);
    }

    private List<Sucursal> findSucursalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sucursal.class));
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

    public Sucursal findSucursal(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sucursal.class, id);
        } finally {
            em.close();
        }
    }

    public int getSucursalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sucursal> rt = cq.from(Sucursal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
