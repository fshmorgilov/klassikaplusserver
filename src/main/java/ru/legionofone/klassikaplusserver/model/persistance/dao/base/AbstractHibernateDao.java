package ru.legionofone.klassikaplusserver.model.persistance.dao.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateDao<T extends Serializable> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractHibernateDao.class);
    private Class<T> clazz;

    @Autowired
    SessionFactory sessionFactory;

    public final void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(long id) {
        logger.info("Getting entity " + clazz.getName() + "\n id: " + id);
        return (T) getCurrentSession().get(clazz, id);
    }

    public List<T> findAll() {
        logger.info("Find All entities " + clazz.getName());
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    public void create(T entity) {
        logger.info("Creating entity" + clazz.getName());
        getCurrentSession().persist(entity);
    }

    public void update(T entity) {
        logger.info("Merging entity" + clazz.getName());
        getCurrentSession().merge(entity);
    }

    public void delete(T entity) {

        logger.info("Deleting entity" + clazz.getName());
        getCurrentSession().delete(entity);
    }

    public void deleteById(long entityId) {
        logger.info("Deleting entity " + clazz.getName() + "\n id: " + entityId);
        T entity = findOne(entityId);
        delete(entity);
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}