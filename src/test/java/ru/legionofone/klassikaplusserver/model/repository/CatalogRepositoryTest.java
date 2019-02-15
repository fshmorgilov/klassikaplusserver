package ru.legionofone.klassikaplusserver.model.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.legionofone.klassikaplusserver.model.persistance.dao.base.IGenericDao;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbItem;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbRevision;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatalogRepositoryTest {

    @Autowired
    @Qualifier("itemRepo")
    private IGenericDao<DbItem> dbItemDao;
    @Autowired
    @Qualifier("revisionRepo")
    private IGenericDao<DbRevision> dbRevisionDao;
    @Autowired
    private CatalogRepository repository;
    Integer revNumber;

    @Before
    public void setupTests() {
    }

    @Test
    public void nonNullDependeciesTest() {
        assertNotNull(dbItemDao);
        assertNotNull(dbRevisionDao);
        assertNotNull(repository);
    }

    @Test
    public void updateCatalogItems() {
        // TODO: 2/15/2019
    }

    @Test
    public void provideCatalogNovelties() {
        // TODO: 2/15/2019
    }

    @Test
    public void getRevision() {
        revNumber = repository.getRevision();
        assertEquals(Integer.valueOf(1), revNumber);
    }

    @Test
    public void updateRevision() {
        repository.getRevision();
        repository.updateRevision();
        revNumber = repository.getRevision();
        assertEquals(revNumber, Integer.valueOf(2));
    }

    @After
    public void unset(){
        revNumber = null;
        dbRevisionDao.deleteAll();
    }
}