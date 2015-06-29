/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.GrupoParte;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class GrupoParteJpaController implements Serializable {

    public GrupoParteJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public GrupoParteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(GrupoParte grupoParte) throws PreexistingEntityException, Exception {
        if (grupoParte.getVsProveedor() == null) {
            grupoParte.setVsProveedor(new ArrayList<Proveedor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proveedor> attachedVsProveedor = new ArrayList<Proveedor>();
            for (Proveedor vsProveedorProveedorToAttach : grupoParte.getVsProveedor()) {
                vsProveedorProveedorToAttach = em.getReference(vsProveedorProveedorToAttach.getClass(), vsProveedorProveedorToAttach.getDni());
                attachedVsProveedor.add(vsProveedorProveedorToAttach);
            }
            grupoParte.setVsProveedor(attachedVsProveedor);
            em.persist(grupoParte);
            for (Proveedor vsProveedorProveedor : grupoParte.getVsProveedor()) {
                vsProveedorProveedor.getVsGrupoParte().add(grupoParte);
                vsProveedorProveedor = em.merge(vsProveedorProveedor);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGrupoParte(grupoParte.getCodGrupo()) != null) {
                throw new PreexistingEntityException("GrupoParte " + grupoParte + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(GrupoParte grupoParte) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GrupoParte persistentGrupoParte = em.find(GrupoParte.class, grupoParte.getCodGrupo());
            List<Proveedor> vsProveedorOld = persistentGrupoParte.getVsProveedor();
            List<Proveedor> vsProveedorNew = grupoParte.getVsProveedor();
            List<Proveedor> attachedVsProveedorNew = new ArrayList<Proveedor>();
            for (Proveedor vsProveedorNewProveedorToAttach : vsProveedorNew) {
                vsProveedorNewProveedorToAttach = em.getReference(vsProveedorNewProveedorToAttach.getClass(), vsProveedorNewProveedorToAttach.getDni());
                attachedVsProveedorNew.add(vsProveedorNewProveedorToAttach);
            }
            vsProveedorNew = attachedVsProveedorNew;
            grupoParte.setVsProveedor(vsProveedorNew);
            grupoParte = em.merge(grupoParte);
            for (Proveedor vsProveedorOldProveedor : vsProveedorOld) {
                if (!vsProveedorNew.contains(vsProveedorOldProveedor)) {
                    vsProveedorOldProveedor.getVsGrupoParte().remove(grupoParte);
                    vsProveedorOldProveedor = em.merge(vsProveedorOldProveedor);
                }
            }
            for (Proveedor vsProveedorNewProveedor : vsProveedorNew) {
                if (!vsProveedorOld.contains(vsProveedorNewProveedor)) {
                    vsProveedorNewProveedor.getVsGrupoParte().add(grupoParte);
                    vsProveedorNewProveedor = em.merge(vsProveedorNewProveedor);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = grupoParte.getCodGrupo();
                if (findGrupoParte(id) == null) {
                    throw new NonexistentEntityException("The grupoParte with id " + id + " no longer exists.");
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
            GrupoParte grupoParte;
            try {
                grupoParte = em.getReference(GrupoParte.class, id);
                grupoParte.getCodGrupo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The grupoParte with id " + id + " no longer exists.", enfe);
            }
            List<Proveedor> vsProveedor = grupoParte.getVsProveedor();
            for (Proveedor vsProveedorProveedor : vsProveedor) {
                vsProveedorProveedor.getVsGrupoParte().remove(grupoParte);
                vsProveedorProveedor = em.merge(vsProveedorProveedor);
            }
            em.remove(grupoParte);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<GrupoParte> findGrupoParteEntities() {
        return findGrupoParteEntities(true, -1, -1);
    }

    public List<GrupoParte> findGrupoParteEntities(int maxResults, int firstResult) {
        return findGrupoParteEntities(false, maxResults, firstResult);
    }

    private List<GrupoParte> findGrupoParteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(GrupoParte.class));
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

    public GrupoParte findGrupoParte(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(GrupoParte.class, id);
        } finally {
            em.close();
        }
    }

    public int getGrupoParteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<GrupoParte> rt = cq.from(GrupoParte.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
