/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.Equipamiento;
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
public class EquipamientoJpaController implements Serializable {

    public EquipamientoJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public EquipamientoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Equipamiento equipamiento) throws PreexistingEntityException, Exception {
        if (equipamiento.getVsItem() == null) {
            equipamiento.setVsItem(new ArrayList<Item>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Item> attachedVsItem = new ArrayList<Item>();
            for (Item vsItemItemToAttach : equipamiento.getVsItem()) {
                vsItemItemToAttach = em.getReference(vsItemItemToAttach.getClass(), vsItemItemToAttach.getCod());
                attachedVsItem.add(vsItemItemToAttach);
            }
            equipamiento.setVsItem(attachedVsItem);
            em.persist(equipamiento);
            for (Item vsItemItem : equipamiento.getVsItem()) {
                LogicaDeNegocios.Autoparte oldUnaAutoparteOfVsItemItem = vsItemItem.getUnaAutoparte();
                vsItemItem.setUnaAutoparte(equipamiento);
                vsItemItem = em.merge(vsItemItem);
                if (oldUnaAutoparteOfVsItemItem != null) {
                    oldUnaAutoparteOfVsItemItem.getVsItem().remove(vsItemItem);
                    oldUnaAutoparteOfVsItemItem = em.merge(oldUnaAutoparteOfVsItemItem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEquipamiento(equipamiento.getCodParte()) != null) {
                throw new PreexistingEntityException("Equipamiento " + equipamiento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Equipamiento equipamiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipamiento persistentEquipamiento = em.find(Equipamiento.class, equipamiento.getCodParte());
            List<Item> vsItemOld = persistentEquipamiento.getVsItem();
            List<Item> vsItemNew = equipamiento.getVsItem();
            List<Item> attachedVsItemNew = new ArrayList<Item>();
            for (Item vsItemNewItemToAttach : vsItemNew) {
                vsItemNewItemToAttach = em.getReference(vsItemNewItemToAttach.getClass(), vsItemNewItemToAttach.getCod());
                attachedVsItemNew.add(vsItemNewItemToAttach);
            }
            vsItemNew = attachedVsItemNew;
            equipamiento.setVsItem(vsItemNew);
            equipamiento = em.merge(equipamiento);
            for (Item vsItemOldItem : vsItemOld) {
                if (!vsItemNew.contains(vsItemOldItem)) {
                    vsItemOldItem.setUnaAutoparte(null);
                    vsItemOldItem = em.merge(vsItemOldItem);
                }
            }
            for (Item vsItemNewItem : vsItemNew) {
                if (!vsItemOld.contains(vsItemNewItem)) {
                    Equipamiento oldUnaAutoparteOfVsItemNewItem = (Equipamiento) vsItemNewItem.getUnaAutoparte();
                    vsItemNewItem.setUnaAutoparte(equipamiento);
                    vsItemNewItem = em.merge(vsItemNewItem);
                    if (oldUnaAutoparteOfVsItemNewItem != null && !oldUnaAutoparteOfVsItemNewItem.equals(equipamiento)) {
                        oldUnaAutoparteOfVsItemNewItem.getVsItem().remove(vsItemNewItem);
                        oldUnaAutoparteOfVsItemNewItem = em.merge(oldUnaAutoparteOfVsItemNewItem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = equipamiento.getCodParte();
                if (findEquipamiento(id) == null) {
                    throw new NonexistentEntityException("The equipamiento with id " + id + " no longer exists.");
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
            Equipamiento equipamiento;
            try {
                equipamiento = em.getReference(Equipamiento.class, id);
                equipamiento.getCodParte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The equipamiento with id " + id + " no longer exists.", enfe);
            }
            List<Item> vsItem = equipamiento.getVsItem();
            for (Item vsItemItem : vsItem) {
                vsItemItem.setUnaAutoparte(null);
                vsItemItem = em.merge(vsItemItem);
            }
            em.remove(equipamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Equipamiento> findEquipamientoEntities() {
        return findEquipamientoEntities(true, -1, -1);
    }

    public List<Equipamiento> findEquipamientoEntities(int maxResults, int firstResult) {
        return findEquipamientoEntities(false, maxResults, firstResult);
    }

    private List<Equipamiento> findEquipamientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Equipamiento.class));
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

    public Equipamiento findEquipamiento(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Equipamiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getEquipamientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Equipamiento> rt = cq.from(Equipamiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
