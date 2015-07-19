
package Persistencia;

import LogicaDeNegocios.AtencionPublico;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import LogicaDeNegocios.Sucursal;
import LogicaDeNegocios.Localidad;
import LogicaDeNegocios.Externo;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AtencionPublicoJpaController implements Serializable {

    public AtencionPublicoJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public AtencionPublicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AtencionPublico atencionPublico) throws PreexistingEntityException, Exception {
        if (atencionPublico.getVsExterno() == null) {
            atencionPublico.setVsExterno(new ArrayList<Externo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sucursal unaSucursal = atencionPublico.getUnaSucursal();
            if (unaSucursal != null) {
                unaSucursal = em.getReference(unaSucursal.getClass(), unaSucursal.getCodSuc());
                atencionPublico.setUnaSucursal(unaSucursal);
            }
            Localidad unaLocalidad = atencionPublico.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad = em.getReference(unaLocalidad.getClass(), unaLocalidad.getCodigo());
                atencionPublico.setUnaLocalidad(unaLocalidad);
            }
            List<Externo> attachedVsExterno = new ArrayList<Externo>();
            for (Externo vsExternoExternoToAttach : atencionPublico.getVsExterno()) {
                vsExternoExternoToAttach = em.getReference(vsExternoExternoToAttach.getClass(), vsExternoExternoToAttach.getCodPedido());
                attachedVsExterno.add(vsExternoExternoToAttach);
            }
            atencionPublico.setVsExterno(attachedVsExterno);
            em.persist(atencionPublico);
            if (unaSucursal != null) {
                unaSucursal.getVsEmpleado().add(atencionPublico);
                unaSucursal = em.merge(unaSucursal);
            }
            if (unaLocalidad != null) {
                unaLocalidad.getVsEmpleado().add(atencionPublico);
                unaLocalidad = em.merge(unaLocalidad);
            }
            for (Externo vsExternoExterno : atencionPublico.getVsExterno()) {
                AtencionPublico oldRemitenteOfVsExternoExterno = vsExternoExterno.getRemitente();
                vsExternoExterno.setRemitente(atencionPublico);
                vsExternoExterno = em.merge(vsExternoExterno);
                if (oldRemitenteOfVsExternoExterno != null) {
                    oldRemitenteOfVsExternoExterno.getVsExterno().remove(vsExternoExterno);
                    oldRemitenteOfVsExternoExterno = em.merge(oldRemitenteOfVsExternoExterno);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAtencionPublico(atencionPublico.getDni()) != null) {
                throw new PreexistingEntityException("AtencionPublico " + atencionPublico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AtencionPublico atencionPublico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AtencionPublico persistentAtencionPublico = em.find(AtencionPublico.class, atencionPublico.getDni());
            Sucursal unaSucursalOld = persistentAtencionPublico.getUnaSucursal();
            Sucursal unaSucursalNew = atencionPublico.getUnaSucursal();
            Localidad unaLocalidadOld = persistentAtencionPublico.getUnaLocalidad();
            Localidad unaLocalidadNew = atencionPublico.getUnaLocalidad();
            List<Externo> vsExternoOld = persistentAtencionPublico.getVsExterno();
            List<Externo> vsExternoNew = atencionPublico.getVsExterno();
            if (unaSucursalNew != null) {
                unaSucursalNew = em.getReference(unaSucursalNew.getClass(), unaSucursalNew.getCodSuc());
                atencionPublico.setUnaSucursal(unaSucursalNew);
            }
            if (unaLocalidadNew != null) {
                unaLocalidadNew = em.getReference(unaLocalidadNew.getClass(), unaLocalidadNew.getCodigo());
                atencionPublico.setUnaLocalidad(unaLocalidadNew);
            }
            List<Externo> attachedVsExternoNew = new ArrayList<Externo>();
            for (Externo vsExternoNewExternoToAttach : vsExternoNew) {
                vsExternoNewExternoToAttach = em.getReference(vsExternoNewExternoToAttach.getClass(), vsExternoNewExternoToAttach.getCodPedido());
                attachedVsExternoNew.add(vsExternoNewExternoToAttach);
            }
            vsExternoNew = attachedVsExternoNew;
            atencionPublico.setVsExterno(vsExternoNew);
            atencionPublico = em.merge(atencionPublico);
            if (unaSucursalOld != null && !unaSucursalOld.equals(unaSucursalNew)) {
                unaSucursalOld.getVsEmpleado().remove(atencionPublico);
                unaSucursalOld = em.merge(unaSucursalOld);
            }
            if (unaSucursalNew != null && !unaSucursalNew.equals(unaSucursalOld)) {
                unaSucursalNew.getVsEmpleado().add(atencionPublico);
                unaSucursalNew = em.merge(unaSucursalNew);
            }
            if (unaLocalidadOld != null && !unaLocalidadOld.equals(unaLocalidadNew)) {
                unaLocalidadOld.getVsEmpleado().remove(atencionPublico);
                unaLocalidadOld = em.merge(unaLocalidadOld);
            }
            if (unaLocalidadNew != null && !unaLocalidadNew.equals(unaLocalidadOld)) {
                unaLocalidadNew.getVsEmpleado().add(atencionPublico);
                unaLocalidadNew = em.merge(unaLocalidadNew);
            }
            for (Externo vsExternoOldExterno : vsExternoOld) {
                if (!vsExternoNew.contains(vsExternoOldExterno)) {
                    vsExternoOldExterno.setRemitente(null);
                    vsExternoOldExterno = em.merge(vsExternoOldExterno);
                }
            }
            for (Externo vsExternoNewExterno : vsExternoNew) {
                if (!vsExternoOld.contains(vsExternoNewExterno)) {
                    AtencionPublico oldRemitenteOfVsExternoNewExterno = vsExternoNewExterno.getRemitente();
                    vsExternoNewExterno.setRemitente(atencionPublico);
                    vsExternoNewExterno = em.merge(vsExternoNewExterno);
                    if (oldRemitenteOfVsExternoNewExterno != null && !oldRemitenteOfVsExternoNewExterno.equals(atencionPublico)) {
                        oldRemitenteOfVsExternoNewExterno.getVsExterno().remove(vsExternoNewExterno);
                        oldRemitenteOfVsExternoNewExterno = em.merge(oldRemitenteOfVsExternoNewExterno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = atencionPublico.getDni();
                if (findAtencionPublico(id) == null) {
                    throw new NonexistentEntityException("The atencionPublico with id " + id + " no longer exists.");
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
            AtencionPublico atencionPublico;
            try {
                atencionPublico = em.getReference(AtencionPublico.class, id);
                atencionPublico.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The atencionPublico with id " + id + " no longer exists.", enfe);
            }
            Sucursal unaSucursal = atencionPublico.getUnaSucursal();
            if (unaSucursal != null) {
                unaSucursal.getVsEmpleado().remove(atencionPublico);
                unaSucursal = em.merge(unaSucursal);
            }
            Localidad unaLocalidad = atencionPublico.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad.getVsEmpleado().remove(atencionPublico);
                unaLocalidad = em.merge(unaLocalidad);
            }
            List<Externo> vsExterno = atencionPublico.getVsExterno();
            for (Externo vsExternoExterno : vsExterno) {
                vsExternoExterno.setRemitente(null);
                vsExternoExterno = em.merge(vsExternoExterno);
            }
            em.remove(atencionPublico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AtencionPublico> findAtencionPublicoEntities() {
        return findAtencionPublicoEntities(true, -1, -1);
    }

    public List<AtencionPublico> findAtencionPublicoEntities(int maxResults, int firstResult) {
        return findAtencionPublicoEntities(false, maxResults, firstResult);
    }

    private List<AtencionPublico> findAtencionPublicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AtencionPublico.class));
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

    public AtencionPublico findAtencionPublico(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AtencionPublico.class, id);
        } finally {
            em.close();
        }
    }

    public int getAtencionPublicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AtencionPublico> rt = cq.from(AtencionPublico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
