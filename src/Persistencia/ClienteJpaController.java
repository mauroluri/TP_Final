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
import LogicaDeNegocios.Localidad;
import LogicaDeNegocios.Calle;
import LogicaDeNegocios.Cliente;
import LogicaDeNegocios.Turno;
import java.util.ArrayList;
import java.util.List;
import LogicaDeNegocios.Vehiculo;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alee
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) throws PreexistingEntityException, Exception {
        if (cliente.getVsTurno() == null) {
            cliente.setVsTurno(new ArrayList<Turno>());
        }
        if (cliente.getVsVehiculo() == null) {
            cliente.setVsVehiculo(new ArrayList<Vehiculo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Localidad unaLocalidad = cliente.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad = em.getReference(unaLocalidad.getClass(), unaLocalidad.getCodigo());
                cliente.setUnaLocalidad(unaLocalidad);
            }
            Calle unaCalle = cliente.getUnaCalle();
            if (unaCalle != null) {
                unaCalle = em.getReference(unaCalle.getClass(), unaCalle.getNombre());
                cliente.setUnaCalle(unaCalle);
            }
            List<Turno> attachedVsTurno = new ArrayList<Turno>();
            for (Turno vsTurnoTurnoToAttach : cliente.getVsTurno()) {
                vsTurnoTurnoToAttach = em.getReference(vsTurnoTurnoToAttach.getClass(), vsTurnoTurnoToAttach.getCodigo());
                attachedVsTurno.add(vsTurnoTurnoToAttach);
            }
            cliente.setVsTurno(attachedVsTurno);
            List<Vehiculo> attachedVsVehiculo = new ArrayList<Vehiculo>();
            for (Vehiculo vsVehiculoVehiculoToAttach : cliente.getVsVehiculo()) {
                vsVehiculoVehiculoToAttach = em.getReference(vsVehiculoVehiculoToAttach.getClass(), vsVehiculoVehiculoToAttach.getNroChasis());
                attachedVsVehiculo.add(vsVehiculoVehiculoToAttach);
            }
            cliente.setVsVehiculo(attachedVsVehiculo);
            em.persist(cliente);
            if (unaLocalidad != null) {
                unaLocalidad.getVsCliente().add(cliente);
                unaLocalidad = em.merge(unaLocalidad);
            }
            if (unaCalle != null) {
                unaCalle.getVsCliente().add(cliente);
                unaCalle = em.merge(unaCalle);
            }
            for (Turno vsTurnoTurno : cliente.getVsTurno()) {
                Cliente oldUnClienteOfVsTurnoTurno = vsTurnoTurno.getUnCliente();
                vsTurnoTurno.setUnCliente(cliente);
                vsTurnoTurno = em.merge(vsTurnoTurno);
                if (oldUnClienteOfVsTurnoTurno != null) {
                    oldUnClienteOfVsTurnoTurno.getVsTurno().remove(vsTurnoTurno);
                    oldUnClienteOfVsTurnoTurno = em.merge(oldUnClienteOfVsTurnoTurno);
                }
            }
            for (Vehiculo vsVehiculoVehiculo : cliente.getVsVehiculo()) {
                Cliente oldUnClienteOfVsVehiculoVehiculo = vsVehiculoVehiculo.getUnCliente();
                vsVehiculoVehiculo.setUnCliente(cliente);
                vsVehiculoVehiculo = em.merge(vsVehiculoVehiculo);
                if (oldUnClienteOfVsVehiculoVehiculo != null) {
                    oldUnClienteOfVsVehiculoVehiculo.getVsVehiculo().remove(vsVehiculoVehiculo);
                    oldUnClienteOfVsVehiculoVehiculo = em.merge(oldUnClienteOfVsVehiculoVehiculo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCliente(cliente.getDni()) != null) {
                throw new PreexistingEntityException("Cliente " + cliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getDni());
            Localidad unaLocalidadOld = persistentCliente.getUnaLocalidad();
            Localidad unaLocalidadNew = cliente.getUnaLocalidad();
            Calle unaCalleOld = persistentCliente.getUnaCalle();
            Calle unaCalleNew = cliente.getUnaCalle();
            List<Turno> vsTurnoOld = persistentCliente.getVsTurno();
            List<Turno> vsTurnoNew = cliente.getVsTurno();
            List<Vehiculo> vsVehiculoOld = persistentCliente.getVsVehiculo();
            List<Vehiculo> vsVehiculoNew = cliente.getVsVehiculo();
            if (unaLocalidadNew != null) {
                unaLocalidadNew = em.getReference(unaLocalidadNew.getClass(), unaLocalidadNew.getCodigo());
                cliente.setUnaLocalidad(unaLocalidadNew);
            }
            if (unaCalleNew != null) {
                unaCalleNew = em.getReference(unaCalleNew.getClass(), unaCalleNew.getNombre());
                cliente.setUnaCalle(unaCalleNew);
            }
            List<Turno> attachedVsTurnoNew = new ArrayList<Turno>();
            for (Turno vsTurnoNewTurnoToAttach : vsTurnoNew) {
                vsTurnoNewTurnoToAttach = em.getReference(vsTurnoNewTurnoToAttach.getClass(), vsTurnoNewTurnoToAttach.getCodigo());
                attachedVsTurnoNew.add(vsTurnoNewTurnoToAttach);
            }
            vsTurnoNew = attachedVsTurnoNew;
            cliente.setVsTurno(vsTurnoNew);
            List<Vehiculo> attachedVsVehiculoNew = new ArrayList<Vehiculo>();
            for (Vehiculo vsVehiculoNewVehiculoToAttach : vsVehiculoNew) {
                vsVehiculoNewVehiculoToAttach = em.getReference(vsVehiculoNewVehiculoToAttach.getClass(), vsVehiculoNewVehiculoToAttach.getNroChasis());
                attachedVsVehiculoNew.add(vsVehiculoNewVehiculoToAttach);
            }
            vsVehiculoNew = attachedVsVehiculoNew;
            cliente.setVsVehiculo(vsVehiculoNew);
            cliente = em.merge(cliente);
            if (unaLocalidadOld != null && !unaLocalidadOld.equals(unaLocalidadNew)) {
                unaLocalidadOld.getVsCliente().remove(cliente);
                unaLocalidadOld = em.merge(unaLocalidadOld);
            }
            if (unaLocalidadNew != null && !unaLocalidadNew.equals(unaLocalidadOld)) {
                unaLocalidadNew.getVsCliente().add(cliente);
                unaLocalidadNew = em.merge(unaLocalidadNew);
            }
            if (unaCalleOld != null && !unaCalleOld.equals(unaCalleNew)) {
                unaCalleOld.getVsCliente().remove(cliente);
                unaCalleOld = em.merge(unaCalleOld);
            }
            if (unaCalleNew != null && !unaCalleNew.equals(unaCalleOld)) {
                unaCalleNew.getVsCliente().add(cliente);
                unaCalleNew = em.merge(unaCalleNew);
            }
            for (Turno vsTurnoOldTurno : vsTurnoOld) {
                if (!vsTurnoNew.contains(vsTurnoOldTurno)) {
                    vsTurnoOldTurno.setUnCliente(null);
                    vsTurnoOldTurno = em.merge(vsTurnoOldTurno);
                }
            }
            for (Turno vsTurnoNewTurno : vsTurnoNew) {
                if (!vsTurnoOld.contains(vsTurnoNewTurno)) {
                    Cliente oldUnClienteOfVsTurnoNewTurno = vsTurnoNewTurno.getUnCliente();
                    vsTurnoNewTurno.setUnCliente(cliente);
                    vsTurnoNewTurno = em.merge(vsTurnoNewTurno);
                    if (oldUnClienteOfVsTurnoNewTurno != null && !oldUnClienteOfVsTurnoNewTurno.equals(cliente)) {
                        oldUnClienteOfVsTurnoNewTurno.getVsTurno().remove(vsTurnoNewTurno);
                        oldUnClienteOfVsTurnoNewTurno = em.merge(oldUnClienteOfVsTurnoNewTurno);
                    }
                }
            }
            for (Vehiculo vsVehiculoOldVehiculo : vsVehiculoOld) {
                if (!vsVehiculoNew.contains(vsVehiculoOldVehiculo)) {
                    vsVehiculoOldVehiculo.setUnCliente(null);
                    vsVehiculoOldVehiculo = em.merge(vsVehiculoOldVehiculo);
                }
            }
            for (Vehiculo vsVehiculoNewVehiculo : vsVehiculoNew) {
                if (!vsVehiculoOld.contains(vsVehiculoNewVehiculo)) {
                    Cliente oldUnClienteOfVsVehiculoNewVehiculo = vsVehiculoNewVehiculo.getUnCliente();
                    vsVehiculoNewVehiculo.setUnCliente(cliente);
                    vsVehiculoNewVehiculo = em.merge(vsVehiculoNewVehiculo);
                    if (oldUnClienteOfVsVehiculoNewVehiculo != null && !oldUnClienteOfVsVehiculoNewVehiculo.equals(cliente)) {
                        oldUnClienteOfVsVehiculoNewVehiculo.getVsVehiculo().remove(vsVehiculoNewVehiculo);
                        oldUnClienteOfVsVehiculoNewVehiculo = em.merge(oldUnClienteOfVsVehiculoNewVehiculo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = cliente.getDni();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            Localidad unaLocalidad = cliente.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad.getVsCliente().remove(cliente);
                unaLocalidad = em.merge(unaLocalidad);
            }
            Calle unaCalle = cliente.getUnaCalle();
            if (unaCalle != null) {
                unaCalle.getVsCliente().remove(cliente);
                unaCalle = em.merge(unaCalle);
            }
            List<Turno> vsTurno = cliente.getVsTurno();
            for (Turno vsTurnoTurno : vsTurno) {
                vsTurnoTurno.setUnCliente(null);
                vsTurnoTurno = em.merge(vsTurnoTurno);
            }
            List<Vehiculo> vsVehiculo = cliente.getVsVehiculo();
            for (Vehiculo vsVehiculoVehiculo : vsVehiculo) {
                vsVehiculoVehiculo.setUnCliente(null);
                vsVehiculoVehiculo = em.merge(vsVehiculoVehiculo);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
