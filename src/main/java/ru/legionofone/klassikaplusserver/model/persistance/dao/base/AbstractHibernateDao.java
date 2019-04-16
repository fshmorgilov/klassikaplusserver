package ru.legionofone.klassikaplusserver.model.persistance.dao.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbEntity;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbItem;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbRevision;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class AbstractHibernateDao<T extends DbEntity> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractHibernateDao.class);
    protected Class<T> clazz;
    protected String tableName;

    @Autowired
    protected SessionFactory sessionFactory;

    @PersistenceContext
    protected EntityManager entityManager;

    public final void setClazz(@NonNull Class<T> clazzToSet) {
        this.clazz = clazzToSet;
        if (clazz == DbItem.class) {
            this.tableName = DbItem.provideTableName();
            logger.info("Setting table name for this dao: " + tableName);
        } else if (clazz == DbRevision.class) {
            this.tableName = DbRevision.provideTableName();
            logger.info("Setting table name for this dao: " + tableName);
        } else throw new RuntimeException(clazz.getName() + " is not a valid Database object");
    }

    public final void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Transactional
    public T findOne(long id) {
        logger.info("Getting entity " + clazz.getName() + "\n id: " + id);
        return getCurrentSession().get(clazz, id);
    }

    @Transactional
    public List<T> findAll() {
//        logger.info("Find All entities " + clazz.getName());
        return entityManager.createQuery("from " + tableName).getResultList();
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
    public void deleteAll() {
        logger.info("Dropping table");
        entityManager.createQuery("DELETE FROM items").executeUpdate();
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}