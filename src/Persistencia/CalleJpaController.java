/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.Calle;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import LogicaDeNegocios.Sucursal;
import LogicaDeNegocios.Cliente;
import java.util.ArrayList;
import java.util.List;
import LogicaDeNegocios.Localidad;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ale
 */
public class CalleJpaController implements Serializable {

    public CalleJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public CalleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Calle calle) throws PreexistingEntityException, Exception {
        if (calle.getVsCliente() == null) {
            calle.setVsCliente(new ArrayList<Cliente>());
        }
        if (calle.getVsLocalidad() == null) {
            calle.setVsLocalidad(new ArrayList<Localidad>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sucursal unaSucursal = calle.getUnaSucursal();
            if (unaSucursal != null) {
                unaSucursal = em.getReference(unaSucursal.getClass(), unaSucursal.getCodSuc());
                calle.setUnaSucursal(unaSucursal);
            }
            List<Cliente> attachedVsCliente = new ArrayList<Cliente>();
            for (Cliente vsClienteClienteToAttach : calle.getVsCliente()) {
                vsClienteClienteToAttach = em.getReference(vsClienteClienteToAttach.getClass(), vsClienteClienteToAttach.getDni());
                attachedVsCliente.add(vsClienteClienteToAttach);
            }
            calle.setVsCliente(attachedVsCliente);
            List<Localidad> attachedVsLocalidad = new ArrayList<Localidad>();
            for (Localidad vsLocalidadLocalidadToAttach : calle.getVsLocalidad()) {
                vsLocalidadLocalidadToAttach = em.getReference(vsLocalidadLocalidadToAttach.getClass(), vsLocalidadLocalidadToAttach.getCodigo());
                attachedVsLocalidad.add(vsLocalidadLocalidadToAttach);
            }
            calle.setVsLocalidad(attachedVsLocalidad);
            em.persist(calle);
            if (unaSucursal != null) {
                Calle oldCalleSucOfUnaSucursal = unaSucursal.getCalleSuc();
                if (oldCalleSucOfUnaSucursal != null) {
                    oldCalleSucOfUnaSucursal.setUnaSucursal(null);
                    oldCalleSucOfUnaSucursal = em.merge(oldCalleSucOfUnaSucursal);
                }
                unaSucursal.setCalleSuc(calle);
                unaSucursal = em.merge(unaSucursal);
            }
            for (Cliente vsClienteCliente : calle.getVsCliente()) {
                Calle oldUnaCalleOfVsClienteCliente = vsClienteCliente.getUnaCalle();
                vsClienteCliente.setUnaCalle(calle);
                vsClienteCliente = em.merge(vsClienteCliente);
                if (oldUnaCalleOfVsClienteCliente != null) {
                    oldUnaCalleOfVsClienteCliente.getVsCliente().remove(vsClienteCliente);
                    oldUnaCalleOfVsClienteCliente = em.merge(oldUnaCalleOfVsClienteCliente);
                }
            }
            for (Localidad vsLocalidadLocalidad : calle.getVsLocalidad()) {
                vsLocalidadLocalidad.getVsCalle().add(calle);
                vsLocalidadLocalidad = em.merge(vsLocalidadLocalidad);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCalle(calle.getNombre()) != null) {
                throw new PreexistingEntityException("Calle " + calle + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Calle calle) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calle persistentCalle = em.find(Calle.class, calle.getNombre());
            Sucursal unaSucursalOld = persistentCalle.getUnaSucursal();
            Sucursal unaSucursalNew = calle.getUnaSucursal();
            List<Cliente> vsClienteOld = persistentCalle.getVsCliente();
            List<Cliente> vsClienteNew = calle.getVsCliente();
            List<Localidad> vsLocalidadOld = persistentCalle.getVsLocalidad();
            List<Localidad> vsLocalidadNew = calle.getVsLocalidad();
            if (unaSucursalNew != null) {
                unaSucursalNew = em.getReference(unaSucursalNew.getClass(), unaSucursalNew.getCodSuc());
                calle.setUnaSucursal(unaSucursalNew);
            }
            List<Cliente> attachedVsClienteNew = new ArrayList<Cliente>();
            for (Cliente vsClienteNewClienteToAttach : vsClienteNew) {
                vsClienteNewClienteToAttach = em.getReference(vsClienteNewClienteToAttach.getClass(), vsClienteNewClienteToAttach.getDni());
                attachedVsClienteNew.add(vsClienteNewClienteToAttach);
            }
            vsClienteNew = attachedVsClienteNew;
            calle.setVsCliente(vsClienteNew);
            List<Localidad> attachedVsLocalidadNew = new ArrayList<Localidad>();
            for (Localidad vsLocalidadNewLocalidadToAttach : vsLocalidadNew) {
                vsLocalidadNewLocalidadToAttach = em.getReference(vsLocalidadNewLocalidadToAttach.getClass(), vsLocalidadNewLocalidadToAttach.getCodigo());
                attachedVsLocalidadNew.add(vsLocalidadNewLocalidadToAttach);
            }
            vsLocalidadNew = attachedVsLocalidadNew;
            calle.setVsLocalidad(vsLocalidadNew);
            calle = em.merge(calle);
            if (unaSucursalOld != null && !unaSucursalOld.equals(unaSucursalNew)) {
                unaSucursalOld.setCalleSuc(null);
                unaSucursalOld = em.merge(unaSucursalOld);
            }
            if (unaSucursalNew != null && !unaSucursalNew.equals(unaSucursalOld)) {
                Calle oldCalleSucOfUnaSucursal = unaSucursalNew.getCalleSuc();
                if (oldCalleSucOfUnaSucursal != null) {
                    oldCalleSucOfUnaSucursal.setUnaSucursal(null);
                    oldCalleSucOfUnaSucursal = em.merge(oldCalleSucOfUnaSucursal);
                }
                unaSucursalNew.setCalleSuc(calle);
                unaSucursalNew = em.merge(unaSucursalNew);
            }
            for (Cliente vsClienteOldCliente : vsClienteOld) {
                if (!vsClienteNew.contains(vsClienteOldCliente)) {
                    vsClienteOldCliente.setUnaCalle(null);
                    vsClienteOldCliente = em.merge(vsClienteOldCliente);
                }
            }
            for (Cliente vsClienteNewCliente : vsClienteNew) {
                if (!vsClienteOld.contains(vsClienteNewCliente)) {
                    Calle oldUnaCalleOfVsClienteNewCliente = vsClienteNewCliente.getUnaCalle();
                    vsClienteNewCliente.setUnaCalle(calle);
                    vsClienteNewCliente = em.merge(vsClienteNewCliente);
                    if (oldUnaCalleOfVsClienteNewCliente != null && !oldUnaCalleOfVsClienteNewCliente.equals(calle)) {
                        oldUnaCalleOfVsClienteNewCliente.getVsCliente().remove(vsClienteNewCliente);
                        oldUnaCalleOfVsClienteNewCliente = em.merge(oldUnaCalleOfVsClienteNewCliente);
                    }
                }
            }
            for (Localidad vsLocalidadOldLocalidad : vsLocalidadOld) {
                if (!vsLocalidadNew.contains(vsLocalidadOldLocalidad)) {
                    vsLocalidadOldLocalidad.getVsCalle().remove(calle);
                    vsLocalidadOldLocalidad = em.merge(vsLocalidadOldLocalidad);
                }
            }
            for (Localidad vsLocalidadNewLocalidad : vsLocalidadNew) {
                if (!vsLocalidadOld.contains(vsLocalidadNewLocalidad)) {
                    vsLocalidadNewLocalidad.getVsCalle().add(calle);
                    vsLocalidadNewLocalidad = em.merge(vsLocalidadNewLocalidad);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = calle.getNombre();
                if (findCalle(id) == null) {
                    throw new NonexistentEntityException("The calle with id " + id + " no longer exists.");
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
            Calle calle;
            try {
                calle = em.getReference(Calle.class, id);
                calle.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calle with id " + id + " no longer exists.", enfe);
            }
            Sucursal unaSucursal = calle.getUnaSucursal();
            if (unaSucursal != null) {
                unaSucursal.setCalleSuc(null);
                unaSucursal = em.merge(unaSucursal);
            }
            List<Cliente> vsCliente = calle.getVsCliente();
            for (Cliente vsClienteCliente : vsCliente) {
                vsClienteCliente.setUnaCalle(null);
                vsClienteCliente = em.merge(vsClienteCliente);
            }
            List<Localidad> vsLocalidad = calle.getVsLocalidad();
            for (Localidad vsLocalidadLocalidad : vsLocalidad) {
                vsLocalidadLocalidad.getVsCalle().remove(calle);
                vsLocalidadLocalidad = em.merge(vsLocalidadLocalidad);
            }
            em.remove(calle);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Calle> findCalleEntities() {
        return findCalleEntities(true, -1, -1);
    }

    public List<Calle> findCalleEntities(int maxResults, int firstResult) {
        return findCalleEntities(false, maxResults, firstResult);
    }

    private List<Calle> findCalleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Calle.class));
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

    public Calle findCalle(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Calle.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Calle> rt = cq.from(Calle.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
