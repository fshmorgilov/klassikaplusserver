package ru.legionofone.klassikaplusserver.model.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.legionofone.klassikaplusserver.model.mappers.DaoToDomainMapper;
import ru.legionofone.klassikaplusserver.model.mappers.DaoToDtoMapper;
import ru.legionofone.klassikaplusserver.model.mappers.ForeignDtoToDaoMapper;
import ru.legionofone.klassikaplusserver.model.mappers.base.ListMapping;
import ru.legionofone.klassikaplusserver.model.persistance.dao.base.IGenericDao;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbItem;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbRevision;
import ru.legionofone.klassikaplusserver.web.controller.CatalogItemReceiver;
import ru.legionofone.klassikaplusserver.web.dto.obtained.ItemDto;
import ru.legionofone.klassikaplusserver.web.dto.provided.catalog.AndroidItemDto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Component
public class CatalogRepository {

    private static final Logger logger = LoggerFactory.getLogger(CatalogRepository.class);
    private final ForeignDtoToDaoMapper dtoToDaoMapper = new ForeignDtoToDaoMapper();
    private final ListMapping<ItemDto, DbItem> foreignDtoToDaoListMapper = new ListMapping<>(new ForeignDtoToDaoMapper());

    private final IGenericDao<DbItem> dbItemDao;
    private final IGenericDao<DbRevision> dbRevisionDao;
    private final CatalogItemReceiver receiver;
    private final DaoToDomainMapper toDomainMapper = new DaoToDomainMapper();
    // TODO: 2/15/2019 refactor
    private final Executor exec = Executors.newFixedThreadPool(4);
    private static final List<String> categories = new ArrayList<>();

    private Integer revision;

    @Autowired
    public CatalogRepository(@Qualifier("itemRepo") IGenericDao<DbItem> dbItemDao,
                             @Qualifier("revisionRepo") IGenericDao<DbRevision> dbRevisionDao,
                             CatalogItemReceiver receiver) {
        this.dbItemDao = dbItemDao;
        this.receiver = receiver;
        this.dbRevisionDao = dbRevisionDao;
        refreshRevision();
        refreshCategories();
    }

    public void refreshCategories() {
        exec.execute(() -> {
            categories.clear();
            categories.addAll(dbItemDao.findAll().stream()
                    .map(DbItem::getCategory)
                    .distinct()
                    .collect(Collectors.toList()));
            logger.info("Categories updated\n Result:");
            categories.forEach(logger::info);
        });
    }

    public synchronized List<String> provideCategories() {
        return categories;
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
                                            .peek(dbItem -> {
                                                if (!categoryDto.getPagetitle().isEmpty())
                                                    dbItem.setCategory(categoryDto.getPagetitle());
                                            })
                                            // TODO: 1/14/2019 Переделать в одну транзакцию
                                            .forEach(dbItemDao::create));
                                    logger.info("Successfully obtained dataset");
                                },
                                () -> logger.warn("Failed to obtain new dataset"))
        );
    }

    public List<AndroidItemDto> provideCatalogNovelties() {
        final DaoToDtoMapper daoToDtoMapper = new DaoToDtoMapper();
        return dbItemDao.findAll().stream()
                .filter(DbItem::getNovelty)
                .map(daoToDtoMapper::map)
                .collect(Collectors.toList());
    }

    public synchronized Integer refreshRevision() {
        if (revision == null) {
            revision = dbRevisionDao.findAll()
                    .stream()
                    .map(DbRevision::getId)
                    .max(Integer::compare)
                    .orElse(1);
        }
        logger.info("Current revision : " + revision);
        return revision;
    }

    public void updateRevision() {
        logger.info("Increasing revision. Old: " + revision);
        this.revision = ++revision;
        exec.execute(() -> {
            DbRevision rev = new DbRevision();
            rev.setNumber(revision);
            dbRevisionDao.update(rev);
        });
    }

    public List<AndroidItemDto> provideItemsByCategory(String category) {
        final DaoToDtoMapper daoToDtoMapper = new DaoToDtoMapper();
        return dbItemDao.findAll().stream()
                .filter(dbItem -> dbItem.getCategory().equals(category))
                .map(daoToDtoMapper::map)
                .collect(Collectors.toList());
    }
}
