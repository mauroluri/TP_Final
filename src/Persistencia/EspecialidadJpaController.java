/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import LogicaDeNegocios.Especialidad;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import LogicaDeNegocios.Mecanico;
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
public class EspecialidadJpaController implements Serializable {

    public EspecialidadJpaController() {
        emf=Persistence.createEntityManagerFactory("TP_FinalPU");
    }
    
    public EspecialidadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Especialidad especialidad) throws PreexistingEntityException, Exception {
        if (especialidad.getVsMecanico() == null) {
            especialidad.setVsMecanico(new ArrayList<Mecanico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Mecanico> attachedVsMecanico = new ArrayList<Mecanico>();
            for (Mecanico vsMecanicoMecanicoToAttach : especialidad.getVsMecanico()) {
                vsMecanicoMecanicoToAttach = em.getReference(vsMecanicoMecanicoToAttach.getClass(), vsMecanicoMecanicoToAttach.getDni());
                attachedVsMecanico.add(vsMecanicoMecanicoToAttach);
            }
            especialidad.setVsMecanico(attachedVsMecanico);
            em.persist(especialidad);
            for (Mecanico vsMecanicoMecanico : especialidad.getVsMecanico()) {
                Especialidad oldUnaEspecialidadOfVsMecanicoMecanico = vsMecanicoMecanico.getUnaEspecialidad();
                vsMecanicoMecanico.setUnaEspecialidad(especialidad);
                vsMecanicoMecanico = em.merge(vsMecanicoMecanico);
                if (oldUnaEspecialidadOfVsMecanicoMecanico != null) {
                    oldUnaEspecialidadOfVsMecanicoMecanico.getVsMecanico().remove(vsMecanicoMecanico);
                    oldUnaEspecialidadOfVsMecanicoMecanico = em.merge(oldUnaEspecialidadOfVsMecanicoMecanico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEspecialidad(especialidad.getNombre()) != null) {
                throw new PreexistingEntityException("Especialidad " + especialidad + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Especialidad especialidad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especialidad persistentEspecialidad = em.find(Especialidad.class, especialidad.getNombre());
            List<Mecanico> vsMecanicoOld = persistentEspecialidad.getVsMecanico();
            List<Mecanico> vsMecanicoNew = especialidad.getVsMecanico();
            List<Mecanico> attachedVsMecanicoNew = new ArrayList<Mecanico>();
            for (Mecanico vsMecanicoNewMecanicoToAttach : vsMecanicoNew) {
                vsMecanicoNewMecanicoToAttach = em.getReference(vsMecanicoNewMecanicoToAttach.getClass(), vsMecanicoNewMecanicoToAttach.getDni());
                attachedVsMecanicoNew.add(vsMecanicoNewMecanicoToAttach);
            }
            vsMecanicoNew = attachedVsMecanicoNew;
            especialidad.setVsMecanico(vsMecanicoNew);
            especialidad = em.merge(especialidad);
            for (Mecanico vsMecanicoOldMecanico : vsMecanicoOld) {
                if (!vsMecanicoNew.contains(vsMecanicoOldMecanico)) {
                    vsMecanicoOldMecanico.setUnaEspecialidad(null);
                    vsMecanicoOldMecanico = em.merge(vsMecanicoOldMecanico);
                }
            }
            for (Mecanico vsMecanicoNewMecanico : vsMecanicoNew) {
                if (!vsMecanicoOld.contains(vsMecanicoNewMecanico)) {
                    Especialidad oldUnaEspecialidadOfVsMecanicoNewMecanico = vsMecanicoNewMecanico.getUnaEspecialidad();
                    vsMecanicoNewMecanico.setUnaEspecialidad(especialidad);
                    vsMecanicoNewMecanico = em.merge(vsMecanicoNewMecanico);
                    if (oldUnaEspecialidadOfVsMecanicoNewMecanico != null && !oldUnaEspecialidadOfVsMecanicoNewMecanico.equals(especialidad)) {
                        oldUnaEspecialidadOfVsMecanicoNewMecanico.getVsMecanico().remove(vsMecanicoNewMecanico);
                        oldUnaEspecialidadOfVsMecanicoNewMecanico = em.merge(oldUnaEspecialidadOfVsMecanicoNewMecanico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = especialidad.getNombre();
                if (findEspecialidad(id) == null) {
                    throw new NonexistentEntityException("The especialidad with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especialidad especialidad;
            try {
                especialidad = em.getReference(Especialidad.class, id);
                especialidad.getNombre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The especialidad with id " + id + " no longer exists.", enfe);
            }
            List<Mecanico> vsMecanico = especialidad.getVsMecanico();
            for (Mecanico vsMecanicoMecanico : vsMecanico) {
                vsMecanicoMecanico.setUnaEspecialidad(null);
                vsMecanicoMecanico = em.merge(vsMecanicoMecanico);
            }
            em.remove(especialidad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Especialidad> findEspecialidadEntities() {
        return findEspecialidadEntities(true, -1, -1);
    }

    public List<Especialidad> findEspecialidadEntities(int maxResults, int firstResult) {
        return findEspecialidadEntities(false, maxResults, firstResult);
    }

    private List<Especialidad> findEspecialidadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Especialidad.class));
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

    public Especialidad findEspecialidad(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Especialidad.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspecialidadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Especialidad> rt = cq.from(Especialidad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
