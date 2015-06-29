 
package Persistencia;

import LogicaDeNegocios.Deposito;
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
 
public class DepositoJpaController implements Serializable {

    public DepositoJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public DepositoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Deposito deposito) throws PreexistingEntityException, Exception {
        if (deposito.getVsItem() == null) {
            deposito.setVsItem(new ArrayList<Item>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Item> attachedVsItem = new ArrayList<Item>();
            for (Item vsItemItemToAttach : deposito.getVsItem()) {
                vsItemItemToAttach = em.getReference(vsItemItemToAttach.getClass(), vsItemItemToAttach.getCod());
                attachedVsItem.add(vsItemItemToAttach);
            }
            deposito.setVsItem(attachedVsItem);
            em.persist(deposito);
            for (Item vsItemItem : deposito.getVsItem()) {
                Deposito oldUnDepositoOfVsItemItem = vsItemItem.getUnDeposito();
                vsItemItem.setUnDeposito(deposito);
                vsItemItem = em.merge(vsItemItem);
                if (oldUnDepositoOfVsItemItem != null) {
                    oldUnDepositoOfVsItemItem.getVsItem().remove(vsItemItem);
                    oldUnDepositoOfVsItemItem = em.merge(oldUnDepositoOfVsItemItem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDeposito(deposito.getCod()) != null) {
                throw new PreexistingEntityException("Deposito " + deposito + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Deposito deposito) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Deposito persistentDeposito = em.find(Deposito.class, deposito.getCod());
            List<Item> vsItemOld = persistentDeposito.getVsItem();
            List<Item> vsItemNew = deposito.getVsItem();
            List<Item> attachedVsItemNew = new ArrayList<Item>();
            for (Item vsItemNewItemToAttach : vsItemNew) {
                vsItemNewItemToAttach = em.getReference(vsItemNewItemToAttach.getClass(), vsItemNewItemToAttach.getCod());
                attachedVsItemNew.add(vsItemNewItemToAttach);
            }
            vsItemNew = attachedVsItemNew;
            deposito.setVsItem(vsItemNew);
            deposito = em.merge(deposito);
            for (Item vsItemOldItem : vsItemOld) {
                if (!vsItemNew.contains(vsItemOldItem)) {
                    vsItemOldItem.setUnDeposito(null);
                    vsItemOldItem = em.merge(vsItemOldItem);
                }
            }
            for (Item vsItemNewItem : vsItemNew) {
                if (!vsItemOld.contains(vsItemNewItem)) {
                    Deposito oldUnDepositoOfVsItemNewItem = vsItemNewItem.getUnDeposito();
                    vsItemNewItem.setUnDeposito(deposito);
                    vsItemNewItem = em.merge(vsItemNewItem);
                    if (oldUnDepositoOfVsItemNewItem != null && !oldUnDepositoOfVsItemNewItem.equals(deposito)) {
                        oldUnDepositoOfVsItemNewItem.getVsItem().remove(vsItemNewItem);
                        oldUnDepositoOfVsItemNewItem = em.merge(oldUnDepositoOfVsItemNewItem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = deposito.getCod();
                if (findDeposito(id) == null) {
                    throw new NonexistentEntityException("The deposito with id " + id + " no longer exists.");
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
            Deposito deposito;
            try {
                deposito = em.getReference(Deposito.class, id);
                deposito.getCod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The deposito with id " + id + " no longer exists.", enfe);
            }
            List<Item> vsItem = deposito.getVsItem();
            for (Item vsItemItem : vsItem) {
                vsItemItem.setUnDeposito(null);
                vsItemItem = em.merge(vsItemItem);
            }
            em.remove(deposito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Deposito> findDepositoEntities() {
        return findDepositoEntities(true, -1, -1);
    }

    public List<Deposito> findDepositoEntities(int maxResults, int firstResult) {
        return findDepositoEntities(false, maxResults, firstResult);
    }

    private List<Deposito> findDepositoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Deposito.class));
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

    public Deposito findDeposito(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Deposito.class, id);
        } finally {
            em.close();
        }
    }

    public int getDepositoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Deposito> rt = cq.from(Deposito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
