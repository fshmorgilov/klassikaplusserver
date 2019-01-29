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
        getCurrentSession().persist(entity);
    }

    @Transactional
    public void update(T entity) {
        logger.info("Merging entity" + clazz.getName());
        getCurrentSession().merge(entity);
    }

    @Transactional
    public void delete(T entity) {
        logger.info("Deleting entity" + clazz.getName());
        getCurrentSession().delete(entity);
    }

    @Transactional
    public void deleteById(long entityId) {
        logger.info("Deleting entity " + clazz.getName() + "\n id: " + entityId);
        T entity = findOne(entityId);
        delete(entity);
    }


    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}