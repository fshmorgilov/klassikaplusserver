package ru.legionofone.klassikaplusserver;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.legionofone.klassikaplusserver.model.persistance.GenericHibernateProvider;
import ru.legionofone.klassikaplusserver.model.persistance.dao.IGenericDao;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbItem;


@SpringBootTest
public class HibernateDaoTest {
    @Autowired
    IGenericDao<DbItem> dao;
    Class<DbItem> clazz;

    @Test
    public void testHibernateDao() {

        this.clazz = DbItem.class;
        assertTrue(clazz == DbItem.class);
    }

    @Test
    public void testHibernateDaoAccess(){
        GenericHibernateProvider<DbItem> provider = new GenericHibernateProvider<>();
        assertNotNull(provider);
    }
}
