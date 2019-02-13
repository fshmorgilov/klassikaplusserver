package ru.legionofone.klassikaplusserver.model.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.legionofone.klassikaplusserver.model.mappers.DaoToDomainMapper;
import ru.legionofone.klassikaplusserver.model.mappers.DaoToDtoMapper;
import ru.legionofone.klassikaplusserver.model.mappers.ForeignDtoToDaoMapper;
import ru.legionofone.klassikaplusserver.model.mappers.base.ListMapping;
import ru.legionofone.klassikaplusserver.model.persistance.dao.IGenericDao;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbItem;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbRevision;
import ru.legionofone.klassikaplusserver.web.controller.CatalogItemReceiver;
import ru.legionofone.klassikaplusserver.web.dto.obtained.ItemDto;
import ru.legionofone.klassikaplusserver.web.dto.provided.AndroidItemDto;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Component
public class CatalogRepository {

    private static final Logger logger = LoggerFactory.getLogger(CatalogRepository.class);
    private final ForeignDtoToDaoMapper dtoToDaoMapper = new ForeignDtoToDaoMapper();
    private final ListMapping<ItemDto, DbItem> foreignDtoToDaoListMapper = new ListMapping<>(new ForeignDtoToDaoMapper());

    private final IGenericDao<DbItem> dbItemDao;
    private final CatalogItemReceiver receiver;
    private final DaoToDomainMapper toDomainMapper = new DaoToDomainMapper();
    private final DaoToDtoMapper daoToDtoMapper = new DaoToDtoMapper();
    private final Executor exec = Executors.newFixedThreadPool(4);
    private final IGenericDao<DbRevision> dbRevisionDao;

    private Integer revision;

    @Autowired
    public CatalogRepository(IGenericDao<DbItem> dbItemDao, CatalogItemReceiver receiver, IGenericDao<DbRevision> dbRevisionDao) {
        this.dbItemDao = dbItemDao;
        this.dbItemDao.setClazz(DbItem.class);
        this.dbRevisionDao = dbRevisionDao;
        this.dbRevisionDao.setClazz(DbRevision.class);
        this.receiver = receiver;
        getRevision();
    }

    public void updateCatalogItems() {
        exec.execute(() ->
                receiver.provide()
                        .ifPresentOrElse(
                                categoryDtos -> {
                                    dbItemDao.deleteAll();
                                    categoryDtos.forEach(categoryDto -> categoryDto
                                            .getChildPages()
                                            .stream()
                                            .peek(itemDto -> logger.debug(itemDto.getDescription()))
                                            .map(dtoToDaoMapper::map)
                                            .peek(dbItem -> logger.info("Parsed item : " + dbItem.getName()))
                                            // TODO: 1/14/2019 Переделать в одну транзакцию
                                            .forEach(dbItemDao::create));
                                    logger.info("Successfully obtained dataset");
                                },
                                () -> logger.warn("Failed to obtain new dataset"))
        );
    }

    public List<AndroidItemDto> provideCatalogNovelties() {
        return dbItemDao.findAll().stream()
                .filter(DbItem::getNovelty)
                .map(daoToDtoMapper::map)
                .collect(Collectors.toList());
    }


    public synchronized Integer getRevision() {
        if (revision == null) {
            revision = dbRevisionDao.findAll()
                    .stream()
                    .map(DbRevision::getId)
                    .sorted()
                    .findFirst()
                    .orElse(1);
        }
        logger.info("Current revision : " + revision);
        return revision;
    }

    public void updateRevision() {
        logger.info("Increasing revision. Old: " + revision);
        this.revision = ++revision;
        CompletableFuture.runAsync(() -> {
            DbRevision rev = new DbRevision();
            rev.setNumber(revision);
            dbRevisionDao.update(rev);
        });
    }
}
