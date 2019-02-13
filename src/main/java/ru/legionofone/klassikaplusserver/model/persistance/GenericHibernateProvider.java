package ru.legionofone.klassikaplusserver.model.persistance;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.legionofone.klassikaplusserver.model.persistance.dao.IGenericDao;
import ru.legionofone.klassikaplusserver.model.persistance.dao.base.AbstractHibernateDao;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbEntity;

import java.io.Serializable;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateProvider<T extends DbEntity>
        extends AbstractHibernateDao<T> implements IGenericDao<T> {
//
}