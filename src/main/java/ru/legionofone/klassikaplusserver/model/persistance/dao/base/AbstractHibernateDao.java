package ru.legionofone.klassikaplusserver.model.persistance.dao.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.OperationNotSupportedException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateDao<T extends Serializable> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractHibernateDao.class);
    protected Class<T> clazz;

    @Autowired
    SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    public final void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Transactional
    public T findOne(long id) {
        logger.info("Getting entity " + clazz.getName() + "\n id: " + id);
        return (T) getCurrentSession().get(clazz, id);
    }

    @Transactional
    public List<T> findAll() {
        logger.info("Find All entities " + clazz.getName());
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    @Transactional
    public void create(T entity) {
//        logger.info("Creating entity" + clazz.getName());
        getCurrentSession().persist(entity);
//        entityManager.persist(entity);
//        entityManager.detach(entity);
//        entityManager.getTransaction().commit();
    }

    @Transactional
    public void update(T entity) {
        logger.info("Merging entity" + clazz.getName());
        getCurrentSession().beginTransaction();
        getCurrentSession().merge(entity);
        getCurrentSession().getTransaction().commit();
    }

    @Transactional
    public void delete(T entity) {

        logger.info("Deleting entity" + clazz.getName());
        getCurrentSession().beginTransaction();
        getCurrentSession().delete(entity);
        getCurrentSession().getTransaction().commit();
    }

    @Transactional
    public void deleteById(long entityId) {
        logger.info("Deleting entity " + clazz.getName() + "\n id: " + entityId);
        T entity = findOne(entityId);
        getCurrentSession().beginTransaction();
        delete(entity);
        getCurrentSession().getTransaction().commit();
    }


    protected final Session getCurrentSession() {
//        if (entityManager != null ) {
//            return entityManager.getEntityManagerFactory().unwrap(SessionFactory.class).getCurrentSession();
//        } else {
//            logger.error("Failed to obtain session factory");
//            throw new NullPointerException(); // FIXME: 1/28/2019
//        }
        return sessionFactory.getCurrentSession();
    }
}