package ru.legionofone.klassikaplusserver.model.persistance.dao.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateDao<T extends Serializable> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractHibernateDao.class);
    protected Class<T> clazz;

    @Autowired
    protected SessionFactory sessionFactory;

    @PersistenceContext
    protected EntityManager entityManager;

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
//        logger.info("Find All entities " + clazz.getName());
        // FIXME: 1/29/2019 make generic back
        return entityManager.createQuery("from items").getResultList();
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

    @Transactional
    public void deleteAll(){
        logger.info("Dropping table");
        entityManager.createQuery("DELETE FROM items").executeUpdate();
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}