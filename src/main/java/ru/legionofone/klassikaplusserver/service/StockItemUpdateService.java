package ru.legionofone.klassikaplusserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbItem;
import ru.legionofone.klassikaplusserver.model.persistance.GenericHibernateDao;
import ru.legionofone.klassikaplusserver.web.controller.CatalogItemReceiver;

@Service
public class StockItemUpdateService {

    private static final Logger logger = LoggerFactory.getLogger(CatalogService.class);

    final GenericHibernateDao<DbItem> itemRepository;
    final CatalogItemReceiver catalogItemReceiver;

    @Autowired
    public StockItemUpdateService(GenericHibernateDao<DbItem> itemRepository, CatalogItemReceiver catalogItemReceiver) {
        this.itemRepository = itemRepository;
        this.catalogItemReceiver = catalogItemReceiver;
    }

    @Scheduled(fixedRate = 5000)
    public void updateCatalogItem() {

        catalogItemReceiver.provide();
        //TODO Запрос на сторону сайта
    }
}
