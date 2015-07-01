package Persistencia;

import LogicaDeNegocios.Accesorio;
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

public class AccesorioJpaControlle implements Serializable {

    public AccesorioJpaControlle() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public AccesorioJpaControlle(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Accesorio accesorio) throws PreexistingEntityException, Exception {
        if (accesorio.getVsItem() == null) {
            accesorio.setVsItem(new ArrayList<Item>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Item> attachedVsItem = new ArrayList<Item>();
            for (Item vsItemItemToAttach : accesorio.getVsItem()) {
                vsItemItemToAttach = em.getReference(vsItemItemToAttach.getClass(), vsItemItemToAttach.getCod());
                attachedVsItem.add(vsItemItemToAttach);
            }
            accesorio.setVsItem(attachedVsItem);
            em.persist(accesorio);
            for (Item vsItemItem : accesorio.getVsItem()) {
                LogicaDeNegocios.Autoparte oldUnaAutoparteOfVsItemItem = vsItemItem.getUnaAutoparte();
                vsItemItem.setUnaAutoparte(accesorio);
                vsItemItem = em.merge(vsItemItem);
                if (oldUnaAutoparteOfVsItemItem != null) {
                    oldUnaAutoparteOfVsItemItem.getVsItem().remove(vsItemItem);
                    oldUnaAutoparteOfVsItemItem = em.merge(oldUnaAutoparteOfVsItemItem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAccesorio(accesorio.getCodParte()) != null) {
                throw new PreexistingEntityException("Accesorio " + accesorio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Accesorio accesorio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Accesorio persistentAccesorio = em.find(Accesorio.class, accesorio.getCodParte());
            List<Item> vsItemOld = persistentAccesorio.getVsItem();
            List<Item> vsItemNew = accesorio.getVsItem();
            List<Item> attachedVsItemNew = new ArrayList<Item>();
            for (Item vsItemNewItemToAttach : vsItemNew) {
                vsItemNewItemToAttach = em.getReference(vsItemNewItemToAttach.getClass(), vsItemNewItemToAttach.getCod());
                attachedVsItemNew.add(vsItemNewItemToAttach);
            }
            vsItemNew = attachedVsItemNew;
            accesorio.setVsItem(vsItemNew);
            accesorio = em.merge(accesorio);
            for (Item vsItemOldItem : vsItemOld) {
                if (!vsItemNew.contains(vsItemOldItem)) {
                    vsItemOldItem.setUnaAutoparte(null);
                    vsItemOldItem = em.merge(vsItemOldItem);
                }
            }
            for (Item vsItemNewItem : vsItemNew) {
                if (!vsItemOld.contains(vsItemNewItem)) {
                    Accesorio oldUnaAutoparteOfVsItemNewItem = (Accesorio) vsItemNewItem.getUnaAutoparte();
                    vsItemNewItem.setUnaAutoparte(accesorio);
                    vsItemNewItem = em.merge(vsItemNewItem);
                    if (oldUnaAutoparteOfVsItemNewItem != null && !oldUnaAutoparteOfVsItemNewItem.equals(accesorio)) {
                        oldUnaAutoparteOfVsItemNewItem.getVsItem().remove(vsItemNewItem);
                        oldUnaAutoparteOfVsItemNewItem = em.merge(oldUnaAutoparteOfVsItemNewItem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = accesorio.getCodParte();
                if (findAccesorio(id) == null) {
                    throw new NonexistentEntityException("The accesorio with id " + id + " no longer exists.");
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
            Accesorio accesorio;
            try {
                accesorio = em.getReference(Accesorio.class, id);
                accesorio.getCodParte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The accesorio with id " + id + " no longer exists.", enfe);
            }
            List<Item> vsItem = accesorio.getVsItem();
            for (Item vsItemItem : vsItem) {
                vsItemItem.setUnaAutoparte(null);
                vsItemItem = em.merge(vsItemItem);
            }
            em.remove(accesorio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Accesorio> findAccesorioEntities() {
        return findAccesorioEntities(true, -1, -1);
    }

    public List<Accesorio> findAccesorioEntities(int maxResults, int firstResult) {
        return findAccesorioEntities(false, maxResults, firstResult);
    }

    private List<Accesorio> findAccesorioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Accesorio.class));
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

    public Accesorio findAccesorio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Accesorio.class, id);
        } finally {
            em.close();
        }
    }

    public int getAccesorioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Accesorio> rt = cq.from(Accesorio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
