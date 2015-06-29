/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.Autoparte;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import LogicaDeNegocios.Item;
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
public class AutoparteJpaController implements Serializable {

    public AutoparteJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public AutoparteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Autoparte autoparte) throws PreexistingEntityException, Exception {
        if (autoparte.getVsItem() == null) {
            autoparte.setVsItem(new ArrayList<Item>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Item> attachedVsItem = new ArrayList<Item>();
            for (Item vsItemItemToAttach : autoparte.getVsItem()) {
                vsItemItemToAttach = em.getReference(vsItemItemToAttach.getClass(), vsItemItemToAttach.getCod());
                attachedVsItem.add(vsItemItemToAttach);
            }
            autoparte.setVsItem(attachedVsItem);
            em.persist(autoparte);
            for (Item vsItemItem : autoparte.getVsItem()) {
                Autoparte oldUnaAutoparteOfVsItemItem = vsItemItem.getUnaAutoparte();
                vsItemItem.setUnaAutoparte(autoparte);
                vsItemItem = em.merge(vsItemItem);
                if (oldUnaAutoparteOfVsItemItem != null) {
                    oldUnaAutoparteOfVsItemItem.getVsItem().remove(vsItemItem);
                    oldUnaAutoparteOfVsItemItem = em.merge(oldUnaAutoparteOfVsItemItem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAutoparte(autoparte.getCodParte()) != null) {
                throw new PreexistingEntityException("Autoparte " + autoparte + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Autoparte autoparte) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autoparte persistentAutoparte = em.find(Autoparte.class, autoparte.getCodParte());
            List<Item> vsItemOld = persistentAutoparte.getVsItem();
            List<Item> vsItemNew = autoparte.getVsItem();
            List<Item> attachedVsItemNew = new ArrayList<Item>();
            for (Item vsItemNewItemToAttach : vsItemNew) {
                vsItemNewItemToAttach = em.getReference(vsItemNewItemToAttach.getClass(), vsItemNewItemToAttach.getCod());
                attachedVsItemNew.add(vsItemNewItemToAttach);
            }
            vsItemNew = attachedVsItemNew;
            autoparte.setVsItem(vsItemNew);
            autoparte = em.merge(autoparte);
            for (Item vsItemOldItem : vsItemOld) {
                if (!vsItemNew.contains(vsItemOldItem)) {
                    vsItemOldItem.setUnaAutoparte(null);
                    vsItemOldItem = em.merge(vsItemOldItem);
                }
            }
            for (Item vsItemNewItem : vsItemNew) {
                if (!vsItemOld.contains(vsItemNewItem)) {
                    Autoparte oldUnaAutoparteOfVsItemNewItem = vsItemNewItem.getUnaAutoparte();
                    vsItemNewItem.setUnaAutoparte(autoparte);
                    vsItemNewItem = em.merge(vsItemNewItem);
                    if (oldUnaAutoparteOfVsItemNewItem != null && !oldUnaAutoparteOfVsItemNewItem.equals(autoparte)) {
                        oldUnaAutoparteOfVsItemNewItem.getVsItem().remove(vsItemNewItem);
                        oldUnaAutoparteOfVsItemNewItem = em.merge(oldUnaAutoparteOfVsItemNewItem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = autoparte.getCodParte();
                if (findAutoparte(id) == null) {
                    throw new NonexistentEntityException("The autoparte with id " + id + " no longer exists.");
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
            Autoparte autoparte;
            try {
                autoparte = em.getReference(Autoparte.class, id);
                autoparte.getCodParte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The autoparte with id " + id + " no longer exists.", enfe);
            }
            List<Item> vsItem = autoparte.getVsItem();
            for (Item vsItemItem : vsItem) {
                vsItemItem.setUnaAutoparte(null);
                vsItemItem = em.merge(vsItemItem);
            }
            em.remove(autoparte);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Autoparte> findAutoparteEntities() {
        return findAutoparteEntities(true, -1, -1);
    }

    public List<Autoparte> findAutoparteEntities(int maxResults, int firstResult) {
        return findAutoparteEntities(false, maxResults, firstResult);
    }

    private List<Autoparte> findAutoparteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Autoparte.class));
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

    public Autoparte findAutoparte(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Autoparte.class, id);
        } finally {
            em.close();
        }
    }

    public int getAutoparteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Autoparte> rt = cq.from(Autoparte.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
