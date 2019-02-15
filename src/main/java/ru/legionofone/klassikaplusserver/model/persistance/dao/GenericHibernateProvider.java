package ru.legionofone.klassikaplusserver.model.persistance.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.legionofone.klassikaplusserver.model.persistance.dao.base.IGenericDao;
import ru.legionofone.klassikaplusserver.model.persistance.dao.base.AbstractHibernateDao;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbEntity;

@Repository
@Primary
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateProvider<T extends DbEntity>
        extends AbstractHibernateDao<T> implements IGenericDao<T> {
//
}