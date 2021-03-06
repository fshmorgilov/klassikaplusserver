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
import ru.legionofone.klassikaplusserver.web.controller.CatalogItemReceiver;
import ru.legionofone.klassikaplusserver.web.dto.obtained.ItemDto;
import ru.legionofone.klassikaplusserver.web.dto.provided.AndroidItemDto;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Component
public class CatalogRepository {

    private static final Logger logger = LoggerFactory.getLogger(CatalogRepository.class);
    private final ForeignDtoToDaoMapper dtoToDaoMapper = new ForeignDtoToDaoMapper();
    private final ListMapping<ItemDto, DbItem> foreignDtoToDaoListMapper = new ListMapping<>(new ForeignDtoToDaoMapper());

    private final IGenericDao<DbItem> genericHibernateProvider;
    private final CatalogItemReceiver receiver;
    private final DaoToDomainMapper toDomainMapper = new DaoToDomainMapper();
    private final DaoToDtoMapper daoToDtoMapper = new DaoToDtoMapper();
    private final Executor exec = Executors.newFixedThreadPool(4);

    @Autowired
    public CatalogRepository(IGenericDao<DbItem> genericHibernateProvider, CatalogItemReceiver receiver) {
        this.genericHibernateProvider = genericHibernateProvider;
        this.genericHibernateProvider.setClazz(DbItem.class);
        this.receiver = receiver;
    }

    public void updateCatalogItems() {
        exec.execute(() ->
                receiver.provide()
                        .ifPresentOrElse(
                                categoryDtos -> {
                                    genericHibernateProvider.deleteAll();
                                    categoryDtos.forEach(categoryDto -> categoryDto
                                            .getChildPages()
                                            .stream()
                                            .peek(itemDto -> logger.debug(itemDto.getDescription()))
                                            .map(dtoToDaoMapper::map)
                                            .peek(dbItem -> logger.info("Parsed item : " + dbItem.getName()))
                                            // TODO: 1/14/2019 Переделать в одну транзакцию
                                            .forEach(genericHibernateProvider::create));
                                    logger.info("Successfully obtained dataset");
                                },
                                () -> logger.warn("Failed to obtain new dataset"))
        );
    }

    public List<AndroidItemDto> provideCatalogNovelties() {
        return genericHibernateProvider.findAll().stream()
                .filter(DbItem::getNovelty)
                .map(daoToDtoMapper::map)
                .collect(Collectors.toList());
    }
}
