/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.Encargado;
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
 * @author Alee
 */
public class EncargadoJpaController implements Serializable {

    public EncargadoJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public EncargadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Encargado encargado) throws PreexistingEntityException, Exception {
        if (encargado.getVsTurno() == null) {
            encargado.setVsTurno(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sucursal unaSucursal = encargado.getUnaSucursal();
            if (unaSucursal != null) {
                unaSucursal = em.getReference(unaSucursal.getClass(), unaSucursal.getCodSuc());
                encargado.setUnaSucursal(unaSucursal);
            }
            Localidad unaLocalidad = encargado.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad = em.getReference(unaLocalidad.getClass(), unaLocalidad.getCodigo());
                encargado.setUnaLocalidad(unaLocalidad);
            }
            List<Turno> attachedVsTurno = new ArrayList<Turno>();
            for (Turno vsTurnoTurnoToAttach : encargado.getVsTurno()) {
                vsTurnoTurnoToAttach = em.getReference(vsTurnoTurnoToAttach.getClass(), vsTurnoTurnoToAttach.getCodigo());
                attachedVsTurno.add(vsTurnoTurnoToAttach);
            }
            encargado.setVsTurno(attachedVsTurno);
            em.persist(encargado);
            if (unaSucursal != null) {
                unaSucursal.getVsEmpleado().add(encargado);
                unaSucursal = em.merge(unaSucursal);
            }
            if (unaLocalidad != null) {
                unaLocalidad.getVsEmpleado().add(encargado);
                unaLocalidad = em.merge(unaLocalidad);
            }
            for (Turno vsTurnoTurno : encargado.getVsTurno()) {
                vsTurnoTurno.getVsEmpleado().add(encargado);
                vsTurnoTurno = em.merge(vsTurnoTurno);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEncargado(encargado.getDni()) != null) {
                throw new PreexistingEntityException("Encargado " + encargado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Encargado encargado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Encargado persistentEncargado = em.find(Encargado.class, encargado.getDni());
            Sucursal unaSucursalOld = persistentEncargado.getUnaSucursal();
            Sucursal unaSucursalNew = encargado.getUnaSucursal();
            Localidad unaLocalidadOld = persistentEncargado.getUnaLocalidad();
            Localidad unaLocalidadNew = encargado.getUnaLocalidad();
            List<Turno> vsTurnoOld = persistentEncargado.getVsTurno();
            List<Turno> vsTurnoNew = encargado.getVsTurno();
            if (unaSucursalNew != null) {
                unaSucursalNew = em.getReference(unaSucursalNew.getClass(), unaSucursalNew.getCodSuc());
                encargado.setUnaSucursal(unaSucursalNew);
            }
            if (unaLocalidadNew != null) {
                unaLocalidadNew = em.getReference(unaLocalidadNew.getClass(), unaLocalidadNew.getCodigo());
                encargado.setUnaLocalidad(unaLocalidadNew);
            }
            List<Turno> attachedVsTurnoNew = new ArrayList<Turno>();
            for (Turno vsTurnoNewTurnoToAttach : vsTurnoNew) {
                vsTurnoNewTurnoToAttach = em.getReference(vsTurnoNewTurnoToAttach.getClass(), vsTurnoNewTurnoToAttach.getCodigo());
                attachedVsTurnoNew.add(vsTurnoNewTurnoToAttach);
            }
            vsTurnoNew = attachedVsTurnoNew;
            encargado.setVsTurno(vsTurnoNew);
            encargado = em.merge(encargado);
            if (unaSucursalOld != null && !unaSucursalOld.equals(unaSucursalNew)) {
                unaSucursalOld.getVsEmpleado().remove(encargado);
                unaSucursalOld = em.merge(unaSucursalOld);
            }
            if (unaSucursalNew != null && !unaSucursalNew.equals(unaSucursalOld)) {
                unaSucursalNew.getVsEmpleado().add(encargado);
                unaSucursalNew = em.merge(unaSucursalNew);
            }
            if (unaLocalidadOld != null && !unaLocalidadOld.equals(unaLocalidadNew)) {
                unaLocalidadOld.getVsEmpleado().remove(encargado);
                unaLocalidadOld = em.merge(unaLocalidadOld);
            }
            if (unaLocalidadNew != null && !unaLocalidadNew.equals(unaLocalidadOld)) {
                unaLocalidadNew.getVsEmpleado().add(encargado);
                unaLocalidadNew = em.merge(unaLocalidadNew);
            }
            for (Turno vsTurnoOldTurno : vsTurnoOld) {
                if (!vsTurnoNew.contains(vsTurnoOldTurno)) {
                    vsTurnoOldTurno.getVsEmpleado().remove(encargado);
                    vsTurnoOldTurno = em.merge(vsTurnoOldTurno);
                }
            }
            for (Turno vsTurnoNewTurno : vsTurnoNew) {
                if (!vsTurnoOld.contains(vsTurnoNewTurno)) {
                    vsTurnoNewTurno.getVsEmpleado().add(encargado);
                    vsTurnoNewTurno = em.merge(vsTurnoNewTurno);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = encargado.getDni();
                if (findEncargado(id) == null) {
                    throw new NonexistentEntityException("The encargado with id " + id + " no longer exists.");
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
            Encargado encargado;
            try {
                encargado = em.getReference(Encargado.class, id);
                encargado.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The encargado with id " + id + " no longer exists.", enfe);
            }
            Sucursal unaSucursal = encargado.getUnaSucursal();
            if (unaSucursal != null) {
                unaSucursal.getVsEmpleado().remove(encargado);
                unaSucursal = em.merge(unaSucursal);
            }
            Localidad unaLocalidad = encargado.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad.getVsEmpleado().remove(encargado);
                unaLocalidad = em.merge(unaLocalidad);
            }
            List<Turno> vsTurno = encargado.getVsTurno();
            for (Turno vsTurnoTurno : vsTurno) {
                vsTurnoTurno.getVsEmpleado().remove(encargado);
                vsTurnoTurno = em.merge(vsTurnoTurno);
            }
            em.remove(encargado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Encargado> findEncargadoEntities() {
        return findEncargadoEntities(true, -1, -1);
    }

    public List<Encargado> findEncargadoEntities(int maxResults, int firstResult) {
        return findEncargadoEntities(false, maxResults, firstResult);
    }

    private List<Encargado> findEncargadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Encargado.class));
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

    public Encargado findEncargado(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Encargado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEncargadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Encargado> rt = cq.from(Encargado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
