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
import LogicaDeNegocios.Item;
import LogicaDeNegocios.Repuesto;
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
public class RepuestoJpaController implements Serializable {

    public RepuestoJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public RepuestoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Repuesto repuesto) throws PreexistingEntityException, Exception {
        if (repuesto.getVsItem() == null) {
            repuesto.setVsItem(new ArrayList<Item>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Item> attachedVsItem = new ArrayList<Item>();
            for (Item vsItemItemToAttach : repuesto.getVsItem()) {
                vsItemItemToAttach = em.getReference(vsItemItemToAttach.getClass(), vsItemItemToAttach.getCod());
                attachedVsItem.add(vsItemItemToAttach);
            }
            repuesto.setVsItem(attachedVsItem);
            em.persist(repuesto);
            for (Item vsItemItem : repuesto.getVsItem()) {
                LogicaDeNegocios.Autoparte oldUnaAutoparteOfVsItemItem = vsItemItem.getUnaAutoparte();
                vsItemItem.setUnaAutoparte(repuesto);
                vsItemItem = em.merge(vsItemItem);
                if (oldUnaAutoparteOfVsItemItem != null) {
                    oldUnaAutoparteOfVsItemItem.getVsItem().remove(vsItemItem);
                    oldUnaAutoparteOfVsItemItem = em.merge(oldUnaAutoparteOfVsItemItem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRepuesto(repuesto.getCodParte()) != null) {
                throw new PreexistingEntityException("Repuesto " + repuesto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Repuesto repuesto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Repuesto persistentRepuesto = em.find(Repuesto.class, repuesto.getCodParte());
            List<Item> vsItemOld = persistentRepuesto.getVsItem();
            List<Item> vsItemNew = repuesto.getVsItem();
            List<Item> attachedVsItemNew = new ArrayList<Item>();
            for (Item vsItemNewItemToAttach : vsItemNew) {
                vsItemNewItemToAttach = em.getReference(vsItemNewItemToAttach.getClass(), vsItemNewItemToAttach.getCod());
                attachedVsItemNew.add(vsItemNewItemToAttach);
            }
            vsItemNew = attachedVsItemNew;
            repuesto.setVsItem(vsItemNew);
            repuesto = em.merge(repuesto);
            for (Item vsItemOldItem : vsItemOld) {
                if (!vsItemNew.contains(vsItemOldItem)) {
                    vsItemOldItem.setUnaAutoparte(null);
                    vsItemOldItem = em.merge(vsItemOldItem);
                }
            }
            for (Item vsItemNewItem : vsItemNew) {
                if (!vsItemOld.contains(vsItemNewItem)) {
                    Repuesto oldUnaAutoparteOfVsItemNewItem = (Repuesto) vsItemNewItem.getUnaAutoparte();
                    vsItemNewItem.setUnaAutoparte(repuesto);
                    vsItemNewItem = em.merge(vsItemNewItem);
                    if (oldUnaAutoparteOfVsItemNewItem != null && !oldUnaAutoparteOfVsItemNewItem.equals(repuesto)) {
                        oldUnaAutoparteOfVsItemNewItem.getVsItem().remove(vsItemNewItem);
                        oldUnaAutoparteOfVsItemNewItem = em.merge(oldUnaAutoparteOfVsItemNewItem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = repuesto.getCodParte();
                if (findRepuesto(id) == null) {
                    throw new NonexistentEntityException("The repuesto with id " + id + " no longer exists.");
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
            Repuesto repuesto;
            try {
                repuesto = em.getReference(Repuesto.class, id);
                repuesto.getCodParte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The repuesto with id " + id + " no longer exists.", enfe);
            }
            List<Item> vsItem = repuesto.getVsItem();
            for (Item vsItemItem : vsItem) {
                vsItemItem.setUnaAutoparte(null);
                vsItemItem = em.merge(vsItemItem);
            }
            em.remove(repuesto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Repuesto> findRepuestoEntities() {
        return findRepuestoEntities(true, -1, -1);
    }

    public List<Repuesto> findRepuestoEntities(int maxResults, int firstResult) {
        return findRepuestoEntities(false, maxResults, firstResult);
    }

    private List<Repuesto> findRepuestoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Repuesto.class));
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

    public Repuesto findRepuesto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Repuesto.class, id);
        } finally {
            em.close();
        }
    }

    public int getRepuestoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Repuesto> rt = cq.from(Repuesto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
