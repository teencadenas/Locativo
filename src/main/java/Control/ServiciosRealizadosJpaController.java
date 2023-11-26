/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Clases.ServiciosRealizados;
import Control.exceptions.NonexistentEntityException;
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
public class ServiciosRealizadosJpaController implements Serializable {

    public ServiciosRealizadosJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ServiciosRealizados serviciosRealizados) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(serviciosRealizados);
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

    public void edit(ServiciosRealizados serviciosRealizados) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            serviciosRealizados = em.merge(serviciosRealizados);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = serviciosRealizados.getIdServicioRealizado();
                if (findServiciosRealizados(id) == null) {
                    throw new NonexistentEntityException("The serviciosRealizados with id " + id + " no longer exists.");
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
            ServiciosRealizados serviciosRealizados;
            try {
                serviciosRealizados = em.getReference(ServiciosRealizados.class, id);
                serviciosRealizados.getIdServicioRealizado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The serviciosRealizados with id " + id + " no longer exists.", enfe);
            }
            em.remove(serviciosRealizados);
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

    public List<ServiciosRealizados> findServiciosRealizadosEntities() {
        return findServiciosRealizadosEntities(true, -1, -1);
    }

    public List<ServiciosRealizados> findServiciosRealizadosEntities(int maxResults, int firstResult) {
        return findServiciosRealizadosEntities(false, maxResults, firstResult);
    }

    private List<ServiciosRealizados> findServiciosRealizadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ServiciosRealizados.class));
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

    public ServiciosRealizados findServiciosRealizados(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ServiciosRealizados.class, id);
        } finally {
            em.close();
        }
    }

    public int getServiciosRealizadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ServiciosRealizados> rt = cq.from(ServiciosRealizados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
