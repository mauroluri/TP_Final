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
import LogicaDeNegocios.Provincia;
import LogicaDeNegocios.Calle;
import java.util.ArrayList;
import java.util.List;
import LogicaDeNegocios.Cliente;
import LogicaDeNegocios.Empleado;
import LogicaDeNegocios.Localidad;
import LogicaDeNegocios.Proveedor;
import LogicaDeNegocios.Sucursal;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ale
 */
public class LocalidadJpaController implements Serializable {

    public LocalidadJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public LocalidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Localidad localidad) throws PreexistingEntityException, Exception {
        if (localidad.getVsCalle() == null) {
            localidad.setVsCalle(new ArrayList<Calle>());
        }
        if (localidad.getVsCliente() == null) {
            localidad.setVsCliente(new ArrayList<Cliente>());
        }
        if (localidad.getVsEmpleado() == null) {
            localidad.setVsEmpleado(new ArrayList<Empleado>());
        }
        if (localidad.getVsProveedor() == null) {
            localidad.setVsProveedor(new ArrayList<Proveedor>());
        }
        if (localidad.getVsSucursal() == null) {
            localidad.setVsSucursal(new ArrayList<Sucursal>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Provincia provincia = localidad.getProvincia();
            if (provincia != null) {
                provincia = em.getReference(provincia.getClass(), provincia.getCodigo());
                localidad.setProvincia(provincia);
            }
            List<Calle> attachedVsCalle = new ArrayList<Calle>();
            for (Calle vsCalleCalleToAttach : localidad.getVsCalle()) {
                vsCalleCalleToAttach = em.getReference(vsCalleCalleToAttach.getClass(), vsCalleCalleToAttach.getNombre());
                attachedVsCalle.add(vsCalleCalleToAttach);
            }
            localidad.setVsCalle(attachedVsCalle);
            List<Cliente> attachedVsCliente = new ArrayList<Cliente>();
            for (Cliente vsClienteClienteToAttach : localidad.getVsCliente()) {
                vsClienteClienteToAttach = em.getReference(vsClienteClienteToAttach.getClass(), vsClienteClienteToAttach.getDni());
                attachedVsCliente.add(vsClienteClienteToAttach);
            }
            localidad.setVsCliente(attachedVsCliente);
            List<Empleado> attachedVsEmpleado = new ArrayList<Empleado>();
            for (Empleado vsEmpleadoEmpleadoToAttach : localidad.getVsEmpleado()) {
                vsEmpleadoEmpleadoToAttach = em.getReference(vsEmpleadoEmpleadoToAttach.getClass(), vsEmpleadoEmpleadoToAttach.getDni());
                attachedVsEmpleado.add(vsEmpleadoEmpleadoToAttach);
            }
            localidad.setVsEmpleado(attachedVsEmpleado);
            List<Proveedor> attachedVsProveedor = new ArrayList<Proveedor>();
            for (Proveedor vsProveedorProveedorToAttach : localidad.getVsProveedor()) {
                vsProveedorProveedorToAttach = em.getReference(vsProveedorProveedorToAttach.getClass(), vsProveedorProveedorToAttach.getDni());
                attachedVsProveedor.add(vsProveedorProveedorToAttach);
            }
            localidad.setVsProveedor(attachedVsProveedor);
            List<Sucursal> attachedVsSucursal = new ArrayList<Sucursal>();
            for (Sucursal vsSucursalSucursalToAttach : localidad.getVsSucursal()) {
                vsSucursalSucursalToAttach = em.getReference(vsSucursalSucursalToAttach.getClass(), vsSucursalSucursalToAttach.getCodSuc());
                attachedVsSucursal.add(vsSucursalSucursalToAttach);
            }
            localidad.setVsSucursal(attachedVsSucursal);
            em.persist(localidad);
            if (provincia != null) {
                provincia.getLocalidades().add(localidad);
                provincia = em.merge(provincia);
            }
            for (Calle vsCalleCalle : localidad.getVsCalle()) {
                vsCalleCalle.getVsLocalidad().add(localidad);
                vsCalleCalle = em.merge(vsCalleCalle);
            }
            for (Cliente vsClienteCliente : localidad.getVsCliente()) {
                Localidad oldUnaLocalidadOfVsClienteCliente = vsClienteCliente.getUnaLocalidad();
                vsClienteCliente.setUnaLocalidad(localidad);
                vsClienteCliente = em.merge(vsClienteCliente);
                if (oldUnaLocalidadOfVsClienteCliente != null) {
                    oldUnaLocalidadOfVsClienteCliente.getVsCliente().remove(vsClienteCliente);
                    oldUnaLocalidadOfVsClienteCliente = em.merge(oldUnaLocalidadOfVsClienteCliente);
                }
            }
            for (Empleado vsEmpleadoEmpleado : localidad.getVsEmpleado()) {
                Localidad oldUnaLocalidadOfVsEmpleadoEmpleado = vsEmpleadoEmpleado.getUnaLocalidad();
                vsEmpleadoEmpleado.setUnaLocalidad(localidad);
                vsEmpleadoEmpleado = em.merge(vsEmpleadoEmpleado);
                if (oldUnaLocalidadOfVsEmpleadoEmpleado != null) {
                    oldUnaLocalidadOfVsEmpleadoEmpleado.getVsEmpleado().remove(vsEmpleadoEmpleado);
                    oldUnaLocalidadOfVsEmpleadoEmpleado = em.merge(oldUnaLocalidadOfVsEmpleadoEmpleado);
                }
            }
            for (Proveedor vsProveedorProveedor : localidad.getVsProveedor()) {
                Localidad oldUnaLocalidadOfVsProveedorProveedor = vsProveedorProveedor.getUnaLocalidad();
                vsProveedorProveedor.setUnaLocalidad(localidad);
                vsProveedorProveedor = em.merge(vsProveedorProveedor);
                if (oldUnaLocalidadOfVsProveedorProveedor != null) {
                    oldUnaLocalidadOfVsProveedorProveedor.getVsProveedor().remove(vsProveedorProveedor);
                    oldUnaLocalidadOfVsProveedorProveedor = em.merge(oldUnaLocalidadOfVsProveedorProveedor);
                }
            }
            for (Sucursal vsSucursalSucursal : localidad.getVsSucursal()) {
                Localidad oldUnaLocalidadOfVsSucursalSucursal = vsSucursalSucursal.getUnaLocalidad();
                vsSucursalSucursal.setUnaLocalidad(localidad);
                vsSucursalSucursal = em.merge(vsSucursalSucursal);
                if (oldUnaLocalidadOfVsSucursalSucursal != null) {
                    oldUnaLocalidadOfVsSucursalSucursal.getVsSucursal().remove(vsSucursalSucursal);
                    oldUnaLocalidadOfVsSucursalSucursal = em.merge(oldUnaLocalidadOfVsSucursalSucursal);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLocalidad(localidad.getCodigo()) != null) {
                throw new PreexistingEntityException("Localidad " + localidad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Localidad localidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Localidad persistentLocalidad = em.find(Localidad.class, localidad.getCodigo());
            Provincia provinciaOld = persistentLocalidad.getProvincia();
            Provincia provinciaNew = localidad.getProvincia();
            List<Calle> vsCalleOld = persistentLocalidad.getVsCalle();
            List<Calle> vsCalleNew = localidad.getVsCalle();
            List<Cliente> vsClienteOld = persistentLocalidad.getVsCliente();
            List<Cliente> vsClienteNew = localidad.getVsCliente();
            List<Empleado> vsEmpleadoOld = persistentLocalidad.getVsEmpleado();
            List<Empleado> vsEmpleadoNew = localidad.getVsEmpleado();
            List<Proveedor> vsProveedorOld = persistentLocalidad.getVsProveedor();
            List<Proveedor> vsProveedorNew = localidad.getVsProveedor();
            List<Sucursal> vsSucursalOld = persistentLocalidad.getVsSucursal();
            List<Sucursal> vsSucursalNew = localidad.getVsSucursal();
            if (provinciaNew != null) {
                provinciaNew = em.getReference(provinciaNew.getClass(), provinciaNew.getCodigo());
                localidad.setProvincia(provinciaNew);
            }
            List<Calle> attachedVsCalleNew = new ArrayList<Calle>();
            for (Calle vsCalleNewCalleToAttach : vsCalleNew) {
                vsCalleNewCalleToAttach = em.getReference(vsCalleNewCalleToAttach.getClass(), vsCalleNewCalleToAttach.getNombre());
                attachedVsCalleNew.add(vsCalleNewCalleToAttach);
            }
            vsCalleNew = attachedVsCalleNew;
            localidad.setVsCalle(vsCalleNew);
            List<Cliente> attachedVsClienteNew = new ArrayList<Cliente>();
            for (Cliente vsClienteNewClienteToAttach : vsClienteNew) {
                vsClienteNewClienteToAttach = em.getReference(vsClienteNewClienteToAttach.getClass(), vsClienteNewClienteToAttach.getDni());
                attachedVsClienteNew.add(vsClienteNewClienteToAttach);
            }
            vsClienteNew = attachedVsClienteNew;
            localidad.setVsCliente(vsClienteNew);
            List<Empleado> attachedVsEmpleadoNew = new ArrayList<Empleado>();
            for (Empleado vsEmpleadoNewEmpleadoToAttach : vsEmpleadoNew) {
                vsEmpleadoNewEmpleadoToAttach = em.getReference(vsEmpleadoNewEmpleadoToAttach.getClass(), vsEmpleadoNewEmpleadoToAttach.getDni());
                attachedVsEmpleadoNew.add(vsEmpleadoNewEmpleadoToAttach);
            }
            vsEmpleadoNew = attachedVsEmpleadoNew;
            localidad.setVsEmpleado(vsEmpleadoNew);
            List<Proveedor> attachedVsProveedorNew = new ArrayList<Proveedor>();
            for (Proveedor vsProveedorNewProveedorToAttach : vsProveedorNew) {
                vsProveedorNewProveedorToAttach = em.getReference(vsProveedorNewProveedorToAttach.getClass(), vsProveedorNewProveedorToAttach.getDni());
                attachedVsProveedorNew.add(vsProveedorNewProveedorToAttach);
            }
            vsProveedorNew = attachedVsProveedorNew;
            localidad.setVsProveedor(vsProveedorNew);
            List<Sucursal> attachedVsSucursalNew = new ArrayList<Sucursal>();
            for (Sucursal vsSucursalNewSucursalToAttach : vsSucursalNew) {
                vsSucursalNewSucursalToAttach = em.getReference(vsSucursalNewSucursalToAttach.getClass(), vsSucursalNewSucursalToAttach.getCodSuc());
                attachedVsSucursalNew.add(vsSucursalNewSucursalToAttach);
            }
            vsSucursalNew = attachedVsSucursalNew;
            localidad.setVsSucursal(vsSucursalNew);
            localidad = em.merge(localidad);
            if (provinciaOld != null && !provinciaOld.equals(provinciaNew)) {
                provinciaOld.getLocalidades().remove(localidad);
                provinciaOld = em.merge(provinciaOld);
            }
            if (provinciaNew != null && !provinciaNew.equals(provinciaOld)) {
                provinciaNew.getLocalidades().add(localidad);
                provinciaNew = em.merge(provinciaNew);
            }
            for (Calle vsCalleOldCalle : vsCalleOld) {
                if (!vsCalleNew.contains(vsCalleOldCalle)) {
                    vsCalleOldCalle.getVsLocalidad().remove(localidad);
                    vsCalleOldCalle = em.merge(vsCalleOldCalle);
                }
            }
            for (Calle vsCalleNewCalle : vsCalleNew) {
                if (!vsCalleOld.contains(vsCalleNewCalle)) {
                    vsCalleNewCalle.getVsLocalidad().add(localidad);
                    vsCalleNewCalle = em.merge(vsCalleNewCalle);
                }
            }
            for (Cliente vsClienteOldCliente : vsClienteOld) {
                if (!vsClienteNew.contains(vsClienteOldCliente)) {
                    vsClienteOldCliente.setUnaLocalidad(null);
                    vsClienteOldCliente = em.merge(vsClienteOldCliente);
                }
            }
            for (Cliente vsClienteNewCliente : vsClienteNew) {
                if (!vsClienteOld.contains(vsClienteNewCliente)) {
                    Localidad oldUnaLocalidadOfVsClienteNewCliente = vsClienteNewCliente.getUnaLocalidad();
                    vsClienteNewCliente.setUnaLocalidad(localidad);
                    vsClienteNewCliente = em.merge(vsClienteNewCliente);
                    if (oldUnaLocalidadOfVsClienteNewCliente != null && !oldUnaLocalidadOfVsClienteNewCliente.equals(localidad)) {
                        oldUnaLocalidadOfVsClienteNewCliente.getVsCliente().remove(vsClienteNewCliente);
                        oldUnaLocalidadOfVsClienteNewCliente = em.merge(oldUnaLocalidadOfVsClienteNewCliente);
                    }
                }
            }
            for (Empleado vsEmpleadoOldEmpleado : vsEmpleadoOld) {
                if (!vsEmpleadoNew.contains(vsEmpleadoOldEmpleado)) {
                    vsEmpleadoOldEmpleado.setUnaLocalidad(null);
                    vsEmpleadoOldEmpleado = em.merge(vsEmpleadoOldEmpleado);
                }
            }
            for (Empleado vsEmpleadoNewEmpleado : vsEmpleadoNew) {
                if (!vsEmpleadoOld.contains(vsEmpleadoNewEmpleado)) {
                    Localidad oldUnaLocalidadOfVsEmpleadoNewEmpleado = vsEmpleadoNewEmpleado.getUnaLocalidad();
                    vsEmpleadoNewEmpleado.setUnaLocalidad(localidad);
                    vsEmpleadoNewEmpleado = em.merge(vsEmpleadoNewEmpleado);
                    if (oldUnaLocalidadOfVsEmpleadoNewEmpleado != null && !oldUnaLocalidadOfVsEmpleadoNewEmpleado.equals(localidad)) {
                        oldUnaLocalidadOfVsEmpleadoNewEmpleado.getVsEmpleado().remove(vsEmpleadoNewEmpleado);
                        oldUnaLocalidadOfVsEmpleadoNewEmpleado = em.merge(oldUnaLocalidadOfVsEmpleadoNewEmpleado);
                    }
                }
            }
            for (Proveedor vsProveedorOldProveedor : vsProveedorOld) {
                if (!vsProveedorNew.contains(vsProveedorOldProveedor)) {
                    vsProveedorOldProveedor.setUnaLocalidad(null);
                    vsProveedorOldProveedor = em.merge(vsProveedorOldProveedor);
                }
            }
            for (Proveedor vsProveedorNewProveedor : vsProveedorNew) {
                if (!vsProveedorOld.contains(vsProveedorNewProveedor)) {
                    Localidad oldUnaLocalidadOfVsProveedorNewProveedor = vsProveedorNewProveedor.getUnaLocalidad();
                    vsProveedorNewProveedor.setUnaLocalidad(localidad);
                    vsProveedorNewProveedor = em.merge(vsProveedorNewProveedor);
                    if (oldUnaLocalidadOfVsProveedorNewProveedor != null && !oldUnaLocalidadOfVsProveedorNewProveedor.equals(localidad)) {
                        oldUnaLocalidadOfVsProveedorNewProveedor.getVsProveedor().remove(vsProveedorNewProveedor);
                        oldUnaLocalidadOfVsProveedorNewProveedor = em.merge(oldUnaLocalidadOfVsProveedorNewProveedor);
                    }
                }
            }
            for (Sucursal vsSucursalOldSucursal : vsSucursalOld) {
                if (!vsSucursalNew.contains(vsSucursalOldSucursal)) {
                    vsSucursalOldSucursal.setUnaLocalidad(null);
                    vsSucursalOldSucursal = em.merge(vsSucursalOldSucursal);
                }
            }
            for (Sucursal vsSucursalNewSucursal : vsSucursalNew) {
                if (!vsSucursalOld.contains(vsSucursalNewSucursal)) {
                    Localidad oldUnaLocalidadOfVsSucursalNewSucursal = vsSucursalNewSucursal.getUnaLocalidad();
                    vsSucursalNewSucursal.setUnaLocalidad(localidad);
                    vsSucursalNewSucursal = em.merge(vsSucursalNewSucursal);
                    if (oldUnaLocalidadOfVsSucursalNewSucursal != null && !oldUnaLocalidadOfVsSucursalNewSucursal.equals(localidad)) {
                        oldUnaLocalidadOfVsSucursalNewSucursal.getVsSucursal().remove(vsSucursalNewSucursal);
                        oldUnaLocalidadOfVsSucursalNewSucursal = em.merge(oldUnaLocalidadOfVsSucursalNewSucursal);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = localidad.getCodigo();
                if (findLocalidad(id) == null) {
                    throw new NonexistentEntityException("The localidad with id " + id + " no longer exists.");
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
            Localidad localidad;
            try {
                localidad = em.getReference(Localidad.class, id);
                localidad.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The localidad with id " + id + " no longer exists.", enfe);
            }
            Provincia provincia = localidad.getProvincia();
            if (provincia != null) {
                provincia.getLocalidades().remove(localidad);
                provincia = em.merge(provincia);
            }
            List<Calle> vsCalle = localidad.getVsCalle();
            for (Calle vsCalleCalle : vsCalle) {
                vsCalleCalle.getVsLocalidad().remove(localidad);
                vsCalleCalle = em.merge(vsCalleCalle);
            }
            List<Cliente> vsCliente = localidad.getVsCliente();
            for (Cliente vsClienteCliente : vsCliente) {
                vsClienteCliente.setUnaLocalidad(null);
                vsClienteCliente = em.merge(vsClienteCliente);
            }
            List<Empleado> vsEmpleado = localidad.getVsEmpleado();
            for (Empleado vsEmpleadoEmpleado : vsEmpleado) {
                vsEmpleadoEmpleado.setUnaLocalidad(null);
                vsEmpleadoEmpleado = em.merge(vsEmpleadoEmpleado);
            }
            List<Proveedor> vsProveedor = localidad.getVsProveedor();
            for (Proveedor vsProveedorProveedor : vsProveedor) {
                vsProveedorProveedor.setUnaLocalidad(null);
                vsProveedorProveedor = em.merge(vsProveedorProveedor);
            }
            List<Sucursal> vsSucursal = localidad.getVsSucursal();
            for (Sucursal vsSucursalSucursal : vsSucursal) {
                vsSucursalSucursal.setUnaLocalidad(null);
                vsSucursalSucursal = em.merge(vsSucursalSucursal);
            }
            em.remove(localidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Localidad> findLocalidadEntities() {
        return findLocalidadEntities(true, -1, -1);
    }

    public List<Localidad> findLocalidadEntities(int maxResults, int firstResult) {
        return findLocalidadEntities(false, maxResults, firstResult);
    }

    private List<Localidad> findLocalidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Localidad.class));
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

    public Localidad findLocalidad(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Localidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getLocalidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Localidad> rt = cq.from(Localidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
