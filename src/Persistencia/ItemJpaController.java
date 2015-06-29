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
import LogicaDeNegocios.Autoparte;
import LogicaDeNegocios.Deposito;
import LogicaDeNegocios.Item;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ale
 */
public class ItemJpaController implements Serializable {

    public ItemJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public ItemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Item item) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autoparte unaAutoparte = item.getUnaAutoparte();
            if (unaAutoparte != null) {
                unaAutoparte = em.getReference(unaAutoparte.getClass(), unaAutoparte.getCodParte());
                item.setUnaAutoparte(unaAutoparte);
            }
            Deposito unDeposito = item.getUnDeposito();
            if (unDeposito != null) {
                unDeposito = em.getReference(unDeposito.getClass(), unDeposito.getCod());
                item.setUnDeposito(unDeposito);
            }
            em.persist(item);
            if (unaAutoparte != null) {
                unaAutoparte.getVsItem().add(item);
                unaAutoparte = em.merge(unaAutoparte);
            }
            if (unDeposito != null) {
                unDeposito.getVsItem().add(item);
                unDeposito = em.merge(unDeposito);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findItem(item.getCod()) != null) {
                throw new PreexistingEntityException("Item " + item + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Item item) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Item persistentItem = em.find(Item.class, item.getCod());
            Autoparte unaAutoparteOld = persistentItem.getUnaAutoparte();
            Autoparte unaAutoparteNew = item.getUnaAutoparte();
            Deposito unDepositoOld = persistentItem.getUnDeposito();
            Deposito unDepositoNew = item.getUnDeposito();
            if (unaAutoparteNew != null) {
                unaAutoparteNew = em.getReference(unaAutoparteNew.getClass(), unaAutoparteNew.getCodParte());
                item.setUnaAutoparte(unaAutoparteNew);
            }
            if (unDepositoNew != null) {
                unDepositoNew = em.getReference(unDepositoNew.getClass(), unDepositoNew.getCod());
                item.setUnDeposito(unDepositoNew);
            }
            item = em.merge(item);
            if (unaAutoparteOld != null && !unaAutoparteOld.equals(unaAutoparteNew)) {
                unaAutoparteOld.getVsItem().remove(item);
                unaAutoparteOld = em.merge(unaAutoparteOld);
            }
            if (unaAutoparteNew != null && !unaAutoparteNew.equals(unaAutoparteOld)) {
                unaAutoparteNew.getVsItem().add(item);
                unaAutoparteNew = em.merge(unaAutoparteNew);
            }
            if (unDepositoOld != null && !unDepositoOld.equals(unDepositoNew)) {
                unDepositoOld.getVsItem().remove(item);
                unDepositoOld = em.merge(unDepositoOld);
            }
            if (unDepositoNew != null && !unDepositoNew.equals(unDepositoOld)) {
                unDepositoNew.getVsItem().add(item);
                unDepositoNew = em.merge(unDepositoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = item.getCod();
                if (findItem(id) == null) {
                    throw new NonexistentEntityException("The item with id " + id + " no longer exists.");
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
            Item item;
            try {
                item = em.getReference(Item.class, id);
                item.getCod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The item with id " + id + " no longer exists.", enfe);
            }
            Autoparte unaAutoparte = item.getUnaAutoparte();
            if (unaAutoparte != null) {
                unaAutoparte.getVsItem().remove(item);
                unaAutoparte = em.merge(unaAutoparte);
            }
            Deposito unDeposito = item.getUnDeposito();
            if (unDeposito != null) {
                unDeposito.getVsItem().remove(item);
                unDeposito = em.merge(unDeposito);
            }
            em.remove(item);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Item> findItemEntities() {
        return findItemEntities(true, -1, -1);
    }

    public List<Item> findItemEntities(int maxResults, int firstResult) {
        return findItemEntities(false, maxResults, firstResult);
    }

    private List<Item> findItemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Item.class));
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

    public Item findItem(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Item.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Item> rt = cq.from(Item.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
