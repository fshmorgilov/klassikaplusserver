package ru.legionofone.klassikaplusserver.model.persistance.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.legionofone.klassikaplusserver.model.persistance.dao.base.IGenericDao;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Qualifier("itemRepo")
public class ItemDao implements IGenericDao<DbItem> {
    @Autowired
    protected SessionFactory sessionFactory;

    @PersistenceContext
    protected EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(ItemDao.class.getName());

    @Transactional
    public DbItem findOne(long id) {
        logger.info("Getting entity " + DbItem.class.getName() + "\n id: " + id);
        return getCurrentSession().get(DbItem.class, id);
    }

    @Transactional
    public List<DbItem> findAll() {
        logger.info("Find All entities " + DbItem.class.getName());
        return entityManager.createQuery("from " + DbItem.provideTableName()).getResultList();
    }

    @Transactional
    public void create(DbItem entity) {
        getCurrentSession().persist(entity);
    }

    @Transactional
    public void update(DbItem entity) {
        logger.info("Merging entity" + DbItem.class.getName());
        getCurrentSession().merge(entity);
    }

    @Transactional
    public void delete(DbItem entity) {
        logger.info("Deleting entity" + DbItem.class.getName());
        getCurrentSession().delete(entity);
    }

    @Transactional
    public void deleteById(long entityId) {
        logger.info("Deleting entity " + DbItem.class.getName() + "\n id: " + entityId);
        DbItem entity = findOne(entityId);
        delete(entity);
    }

    @Override
    @Deprecated
    public void setClazz(Class<DbItem> clazzToSet) {
    }

    @Override
    @Deprecated
    public void setTableName(String tableName) {
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
