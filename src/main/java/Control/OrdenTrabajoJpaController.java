/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Clases.OrdenTrabajo;
import Control.exceptions.NonexistentEntityException;
import Control.exceptions.PreexistingEntityException;
import Control.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author teenc
 */
public class OrdenTrabajoJpaController implements Serializable {

    public OrdenTrabajoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OrdenTrabajo ordenTrabajo) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(ordenTrabajo);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findOrdenTrabajo(ordenTrabajo.getIdOrdenTrabajo()) != null) {
                throw new PreexistingEntityException("OrdenTrabajo " + ordenTrabajo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OrdenTrabajo ordenTrabajo) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ordenTrabajo = em.merge(ordenTrabajo);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ordenTrabajo.getIdOrdenTrabajo();
                if (findOrdenTrabajo(id) == null) {
                    throw new NonexistentEntityException("The ordenTrabajo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            OrdenTrabajo ordenTrabajo;
            try {
                ordenTrabajo = em.getReference(OrdenTrabajo.class, id);
                ordenTrabajo.getIdOrdenTrabajo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordenTrabajo with id " + id + " no longer exists.", enfe);
            }
            em.remove(ordenTrabajo);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OrdenTrabajo> findOrdenTrabajoEntities() {
        return findOrdenTrabajoEntities(true, -1, -1);
    }

    public List<OrdenTrabajo> findOrdenTrabajoEntities(int maxResults, int firstResult) {
        return findOrdenTrabajoEntities(false, maxResults, firstResult);
    }

    private List<OrdenTrabajo> findOrdenTrabajoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OrdenTrabajo.class));
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

    public OrdenTrabajo findOrdenTrabajo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OrdenTrabajo.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdenTrabajoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OrdenTrabajo> rt = cq.from(OrdenTrabajo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
