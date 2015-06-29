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
import LogicaDeNegocios.Sucursal;
import LogicaDeNegocios.Localidad;
import LogicaDeNegocios.Perito;
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
public class PeritoJpaController implements Serializable {

    public PeritoJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public PeritoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Perito perito) throws PreexistingEntityException, Exception {
        if (perito.getVsTurno() == null) {
            perito.setVsTurno(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sucursal unaSucursal = perito.getUnaSucursal();
            if (unaSucursal != null) {
                unaSucursal = em.getReference(unaSucursal.getClass(), unaSucursal.getCodSuc());
                perito.setUnaSucursal(unaSucursal);
            }
            Localidad unaLocalidad = perito.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad = em.getReference(unaLocalidad.getClass(), unaLocalidad.getCodigo());
                perito.setUnaLocalidad(unaLocalidad);
            }
            List<Turno> attachedVsTurno = new ArrayList<Turno>();
            for (Turno vsTurnoTurnoToAttach : perito.getVsTurno()) {
                vsTurnoTurnoToAttach = em.getReference(vsTurnoTurnoToAttach.getClass(), vsTurnoTurnoToAttach.getCodigo());
                attachedVsTurno.add(vsTurnoTurnoToAttach);
            }
            perito.setVsTurno(attachedVsTurno);
            em.persist(perito);
            if (unaSucursal != null) {
                unaSucursal.getVsEmpleado().add(perito);
                unaSucursal = em.merge(unaSucursal);
            }
            if (unaLocalidad != null) {
                unaLocalidad.getVsEmpleado().add(perito);
                unaLocalidad = em.merge(unaLocalidad);
            }
            for (Turno vsTurnoTurno : perito.getVsTurno()) {
                vsTurnoTurno.getVsEmpleado().add(perito);
                vsTurnoTurno = em.merge(vsTurnoTurno);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPerito(perito.getDni()) != null) {
                throw new PreexistingEntityException("Perito " + perito + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Perito perito) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Perito persistentPerito = em.find(Perito.class, perito.getDni());
            Sucursal unaSucursalOld = persistentPerito.getUnaSucursal();
            Sucursal unaSucursalNew = perito.getUnaSucursal();
            Localidad unaLocalidadOld = persistentPerito.getUnaLocalidad();
            Localidad unaLocalidadNew = perito.getUnaLocalidad();
            List<Turno> vsTurnoOld = persistentPerito.getVsTurno();
            List<Turno> vsTurnoNew = perito.getVsTurno();
            if (unaSucursalNew != null) {
                unaSucursalNew = em.getReference(unaSucursalNew.getClass(), unaSucursalNew.getCodSuc());
                perito.setUnaSucursal(unaSucursalNew);
            }
            if (unaLocalidadNew != null) {
                unaLocalidadNew = em.getReference(unaLocalidadNew.getClass(), unaLocalidadNew.getCodigo());
                perito.setUnaLocalidad(unaLocalidadNew);
            }
            List<Turno> attachedVsTurnoNew = new ArrayList<Turno>();
            for (Turno vsTurnoNewTurnoToAttach : vsTurnoNew) {
                vsTurnoNewTurnoToAttach = em.getReference(vsTurnoNewTurnoToAttach.getClass(), vsTurnoNewTurnoToAttach.getCodigo());
                attachedVsTurnoNew.add(vsTurnoNewTurnoToAttach);
            }
            vsTurnoNew = attachedVsTurnoNew;
            perito.setVsTurno(vsTurnoNew);
            perito = em.merge(perito);
            if (unaSucursalOld != null && !unaSucursalOld.equals(unaSucursalNew)) {
                unaSucursalOld.getVsEmpleado().remove(perito);
                unaSucursalOld = em.merge(unaSucursalOld);
            }
            if (unaSucursalNew != null && !unaSucursalNew.equals(unaSucursalOld)) {
                unaSucursalNew.getVsEmpleado().add(perito);
                unaSucursalNew = em.merge(unaSucursalNew);
            }
            if (unaLocalidadOld != null && !unaLocalidadOld.equals(unaLocalidadNew)) {
                unaLocalidadOld.getVsEmpleado().remove(perito);
                unaLocalidadOld = em.merge(unaLocalidadOld);
            }
            if (unaLocalidadNew != null && !unaLocalidadNew.equals(unaLocalidadOld)) {
                unaLocalidadNew.getVsEmpleado().add(perito);
                unaLocalidadNew = em.merge(unaLocalidadNew);
            }
            for (Turno vsTurnoOldTurno : vsTurnoOld) {
                if (!vsTurnoNew.contains(vsTurnoOldTurno)) {
                    vsTurnoOldTurno.getVsEmpleado().remove(perito);
                    vsTurnoOldTurno = em.merge(vsTurnoOldTurno);
                }
            }
            for (Turno vsTurnoNewTurno : vsTurnoNew) {
                if (!vsTurnoOld.contains(vsTurnoNewTurno)) {
                    vsTurnoNewTurno.getVsEmpleado().add(perito);
                    vsTurnoNewTurno = em.merge(vsTurnoNewTurno);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = perito.getDni();
                if (findPerito(id) == null) {
                    throw new NonexistentEntityException("The perito with id " + id + " no longer exists.");
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
            Perito perito;
            try {
                perito = em.getReference(Perito.class, id);
                perito.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The perito with id " + id + " no longer exists.", enfe);
            }
            Sucursal unaSucursal = perito.getUnaSucursal();
            if (unaSucursal != null) {
                unaSucursal.getVsEmpleado().remove(perito);
                unaSucursal = em.merge(unaSucursal);
            }
            Localidad unaLocalidad = perito.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad.getVsEmpleado().remove(perito);
                unaLocalidad = em.merge(unaLocalidad);
            }
            List<Turno> vsTurno = perito.getVsTurno();
            for (Turno vsTurnoTurno : vsTurno) {
                vsTurnoTurno.getVsEmpleado().remove(perito);
                vsTurnoTurno = em.merge(vsTurnoTurno);
            }
            em.remove(perito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Perito> findPeritoEntities() {
        return findPeritoEntities(true, -1, -1);
    }

    public List<Perito> findPeritoEntities(int maxResults, int firstResult) {
        return findPeritoEntities(false, maxResults, firstResult);
    }

    private List<Perito> findPeritoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Perito.class));
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

    public Perito findPerito(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Perito.class, id);
        } finally {
            em.close();
        }
    }

    public int getPeritoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Perito> rt = cq.from(Perito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
