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
import LogicaDeNegocios.GrupoParte;
import LogicaDeNegocios.Proveedor;
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
public class ProveedorJpaController implements Serializable {

    public ProveedorJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public ProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedor proveedor) throws PreexistingEntityException, Exception {
        if (proveedor.getVsGrupoParte() == null) {
            proveedor.setVsGrupoParte(new ArrayList<GrupoParte>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Localidad unaLocalidad = proveedor.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad = em.getReference(unaLocalidad.getClass(), unaLocalidad.getCodigo());
                proveedor.setUnaLocalidad(unaLocalidad);
            }
            List<GrupoParte> attachedVsGrupoParte = new ArrayList<GrupoParte>();
            for (GrupoParte vsGrupoParteGrupoParteToAttach : proveedor.getVsGrupoParte()) {
                vsGrupoParteGrupoParteToAttach = em.getReference(vsGrupoParteGrupoParteToAttach.getClass(), vsGrupoParteGrupoParteToAttach.getCodGrupo());
                attachedVsGrupoParte.add(vsGrupoParteGrupoParteToAttach);
            }
            proveedor.setVsGrupoParte(attachedVsGrupoParte);
            em.persist(proveedor);
            if (unaLocalidad != null) {
                unaLocalidad.getVsProveedor().add(proveedor);
                unaLocalidad = em.merge(unaLocalidad);
            }
            for (GrupoParte vsGrupoParteGrupoParte : proveedor.getVsGrupoParte()) {
                vsGrupoParteGrupoParte.getVsProveedor().add(proveedor);
                vsGrupoParteGrupoParte = em.merge(vsGrupoParteGrupoParte);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProveedor(proveedor.getDni()) != null) {
                throw new PreexistingEntityException("Proveedor " + proveedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedor proveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor persistentProveedor = em.find(Proveedor.class, proveedor.getDni());
            Localidad unaLocalidadOld = persistentProveedor.getUnaLocalidad();
            Localidad unaLocalidadNew = proveedor.getUnaLocalidad();
            List<GrupoParte> vsGrupoParteOld = persistentProveedor.getVsGrupoParte();
            List<GrupoParte> vsGrupoParteNew = proveedor.getVsGrupoParte();
            if (unaLocalidadNew != null) {
                unaLocalidadNew = em.getReference(unaLocalidadNew.getClass(), unaLocalidadNew.getCodigo());
                proveedor.setUnaLocalidad(unaLocalidadNew);
            }
            List<GrupoParte> attachedVsGrupoParteNew = new ArrayList<GrupoParte>();
            for (GrupoParte vsGrupoParteNewGrupoParteToAttach : vsGrupoParteNew) {
                vsGrupoParteNewGrupoParteToAttach = em.getReference(vsGrupoParteNewGrupoParteToAttach.getClass(), vsGrupoParteNewGrupoParteToAttach.getCodGrupo());
                attachedVsGrupoParteNew.add(vsGrupoParteNewGrupoParteToAttach);
            }
            vsGrupoParteNew = attachedVsGrupoParteNew;
            proveedor.setVsGrupoParte(vsGrupoParteNew);
            proveedor = em.merge(proveedor);
            if (unaLocalidadOld != null && !unaLocalidadOld.equals(unaLocalidadNew)) {
                unaLocalidadOld.getVsProveedor().remove(proveedor);
                unaLocalidadOld = em.merge(unaLocalidadOld);
            }
            if (unaLocalidadNew != null && !unaLocalidadNew.equals(unaLocalidadOld)) {
                unaLocalidadNew.getVsProveedor().add(proveedor);
                unaLocalidadNew = em.merge(unaLocalidadNew);
            }
            for (GrupoParte vsGrupoParteOldGrupoParte : vsGrupoParteOld) {
                if (!vsGrupoParteNew.contains(vsGrupoParteOldGrupoParte)) {
                    vsGrupoParteOldGrupoParte.getVsProveedor().remove(proveedor);
                    vsGrupoParteOldGrupoParte = em.merge(vsGrupoParteOldGrupoParte);
                }
            }
            for (GrupoParte vsGrupoParteNewGrupoParte : vsGrupoParteNew) {
                if (!vsGrupoParteOld.contains(vsGrupoParteNewGrupoParte)) {
                    vsGrupoParteNewGrupoParte.getVsProveedor().add(proveedor);
                    vsGrupoParteNewGrupoParte = em.merge(vsGrupoParteNewGrupoParte);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = proveedor.getDni();
                if (findProveedor(id) == null) {
                    throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.");
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
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.", enfe);
            }
            Localidad unaLocalidad = proveedor.getUnaLocalidad();
            if (unaLocalidad != null) {
                unaLocalidad.getVsProveedor().remove(proveedor);
                unaLocalidad = em.merge(unaLocalidad);
            }
            List<GrupoParte> vsGrupoParte = proveedor.getVsGrupoParte();
            for (GrupoParte vsGrupoParteGrupoParte : vsGrupoParte) {
                vsGrupoParteGrupoParte.getVsProveedor().remove(proveedor);
                vsGrupoParteGrupoParte = em.merge(vsGrupoParteGrupoParte);
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedor.class));
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

    public Proveedor findProveedor(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedor> rt = cq.from(Proveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
