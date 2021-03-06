package ru.legionofone.klassikaplusserver.model.persistance;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.legionofone.klassikaplusserver.model.persistance.dao.IGenericDao;
import ru.legionofone.klassikaplusserver.model.persistance.dao.base.AbstractHibernateDao;

import java.io.Serializable;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateProvider<T extends Serializable>
        extends AbstractHibernateDao<T> implements IGenericDao<T> {
//
}