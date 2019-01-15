package ru.legionofone.klassikaplusserver.model.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.legionofone.klassikaplusserver.model.mappers.ForeignDtoToDaoMapper;
import ru.legionofone.klassikaplusserver.model.mappers.base.ListMapping;
import ru.legionofone.klassikaplusserver.model.persistance.dao.IGenericDao;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbItem;
import ru.legionofone.klassikaplusserver.web.controller.CatalogItemReceiver;
import ru.legionofone.klassikaplusserver.web.dto.obtained.ItemDto;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Component
public class CatalogRepository {

    private static final Logger logger = LoggerFactory.getLogger(CatalogRepository.class);
    private final ForeignDtoToDaoMapper dtoToDaoMapper = new ForeignDtoToDaoMapper();
    private final ListMapping<ItemDto, DbItem> foreignDtoToDaoListMapper = new ListMapping<>(new ForeignDtoToDaoMapper());

    private final IGenericDao<DbItem> genericHibernateProvider;
    private final CatalogItemReceiver receiver;

    @Autowired
    public CatalogRepository(IGenericDao<DbItem> genericHibernateProvider, CatalogItemReceiver receiver) {
        this.genericHibernateProvider = genericHibernateProvider;
        this.receiver = receiver;
    }

    public void updateCatalogItems() {
        CompletableFuture.runAsync(() ->
                receiver.provide()
                        .ifPresentOrElse(
                                categoryDtos -> categoryDtos.forEach(categoryDto -> categoryDto
                                        .getChildPages()
                                        .stream()
                                        // TODO: 1/14/2019 Дроп базы
                                        .map(dtoToDaoMapper::map)
                                        .peek(dbItem -> logger.info("Parsed item : " + dbItem.getName()))
                                        // TODO: 1/14/2019 Переделать в одну транзакцию
                                        .forEach(genericHibernateProvider::update)),
                                () -> logger.warn("Failed to obtain new dataset")),
                Executors.newSingleThreadExecutor());
    }
}
