/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Employee;
import static Services.entity.entityManager;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 *
 * @author KIENDINH
 */
public class JPAPaginController<T> implements Serializable {

    final Class<T> genericClass;

    public JPAPaginController(Class<T> typeParameterClass) {
        this.genericClass = typeParameterClass;

    }

    public JPAPaginController(EntityManagerFactory emf, Class<T> typeParameterClass) {
        this.emf = emf;
        this.genericClass = typeParameterClass;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    private List<T> findAllEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(genericClass));
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

    private  List<T> findAllEntityByUser(String user, boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> c = cq.from(genericClass);
            cq.select(c);
            Employee e = entityManager.find(Employee.class,user);
            //ParameterExpression<Entity.Employee> p = cb.parameter(e);
           cq.where(cb.equal(c.get("username"), e));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            List<T> x = q.getResultList();
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<T> findSortUserEntities(String user, int maxResults, int firstResult) {
        return findAllEntityByUser(user, false, maxResults, firstResult);
    }

    public List<T> findSortEntities(int maxResults, int firstResult) {
        return findAllEntities(false, maxResults, firstResult);
    }

    public int getCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(genericClass);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
