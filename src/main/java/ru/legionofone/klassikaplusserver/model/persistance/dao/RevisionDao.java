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
import ru.legionofone.klassikaplusserver.model.persistance.dao.base.AbstractHibernateDao;
import ru.legionofone.klassikaplusserver.model.persistance.dao.base.IGenericDao;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbRevision;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Qualifier("revisionRepo")
public class RevisionDao implements IGenericDao<DbRevision> {


    private static final Logger logger = LoggerFactory.getLogger(AbstractHibernateDao.class);

    @Autowired
    protected SessionFactory sessionFactory;

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    public DbRevision findOne(long id) {
        logger.info("Getting entity " + DbRevision.class.getName() + "\n id: " + id);
        return getCurrentSession().get(DbRevision.class, id);
    }

    @Transactional
    public List<DbRevision> findAll() {
//        logger.info("Find All entities " + clazz.getName());
        return entityManager.createQuery("from " + DbRevision.provideTableName()).getResultList();
    }

    @Transactional
    public void create(DbRevision entity) {
        getCurrentSession().persist(entity);
    }

    @Transactional
    @Deprecated
    public void update(DbRevision entity) {
        logger.info("Merging entity " + DbRevision.class.getName());
        getCurrentSession().merge(entity);
    }

    @Transactional
    @Deprecated
    public void delete(DbRevision entity) {
        logger.info("Deleting entity" + DbRevision.class.getName());
        getCurrentSession().delete(entity);
    }

    @Transactional
    @Deprecated
    public void deleteById(long entityId) {
        logger.info("Deleting entity " + DbRevision.class.getName() + "\n id: " + entityId);
        DbRevision entity = findOne(entityId);
        delete(entity);
    }


    @Transactional
    @Deprecated
    public void deleteAll() {
        logger.info("Dropping table");
        entityManager.createQuery("DELETE FROM " + DbRevision.provideTableName()).executeUpdate();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Deprecated
    public void setClazz(Class<DbRevision> clazzToSet) {

    }

    @Override
    @Deprecated
    public void setTableName(String tableName) {

    }
}
