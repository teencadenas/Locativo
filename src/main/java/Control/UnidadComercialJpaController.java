/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Clases.UnidadComercial;
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
public class UnidadComercialJpaController implements Serializable {

    public UnidadComercialJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UnidadComercial unidadComercial) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(unidadComercial);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findUnidadComercial(unidadComercial.getIdUnidadComercial()) != null) {
                throw new PreexistingEntityException("UnidadComercial " + unidadComercial + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UnidadComercial unidadComercial) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            unidadComercial = em.merge(unidadComercial);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = unidadComercial.getIdUnidadComercial();
                if (findUnidadComercial(id) == null) {
                    throw new NonexistentEntityException("The unidadComercial with id " + id + " no longer exists.");
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
            UnidadComercial unidadComercial;
            try {
                unidadComercial = em.getReference(UnidadComercial.class, id);
                unidadComercial.getIdUnidadComercial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The unidadComercial with id " + id + " no longer exists.", enfe);
            }
            em.remove(unidadComercial);
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

    public List<UnidadComercial> findUnidadComercialEntities() {
        return findUnidadComercialEntities(true, -1, -1);
    }

    public List<UnidadComercial> findUnidadComercialEntities(int maxResults, int firstResult) {
        return findUnidadComercialEntities(false, maxResults, firstResult);
    }

    private List<UnidadComercial> findUnidadComercialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UnidadComercial.class));
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

    public UnidadComercial findUnidadComercial(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UnidadComercial.class, id);
        } finally {
            em.close();
        }
    }

    public int getUnidadComercialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UnidadComercial> rt = cq.from(UnidadComercial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
