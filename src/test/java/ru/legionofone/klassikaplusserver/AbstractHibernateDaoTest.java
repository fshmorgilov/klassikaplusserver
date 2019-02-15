package ru.legionofone.klassikaplusserver;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.legionofone.klassikaplusserver.model.persistance.dao.IGenericDao;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbRevision;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbstractHibernateDaoTest {

    @Autowired
    IGenericDao<DbRevision> revisionDao;

    private DbRevision dbRevision;

    @Before
    public void prepare() {
        dbRevision = new DbRevision();
        dbRevision.setNumber(2);
        dbRevision.setDateCreated(new Date());
        dbRevision.setId(2);
    }

    @Test
    public void contextLoadsTest() {
        assertNotNull(revisionDao);
    }

    @Test
    public void saveRevisionTest() {
        revisionDao.setClazz(DbRevision.class);
        revisionDao.setTableName(DbRevision.provideTableName());
        revisionDao.update(dbRevision);
        DbRevision testRev = revisionDao.findOne(2);
        assertEquals(testRev, dbRevision);
    }

    @After
    public void nullify() {
        dbRevision = null;
    }

}

