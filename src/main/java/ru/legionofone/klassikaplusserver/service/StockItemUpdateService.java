package ru.legionofone.klassikaplusserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.legionofone.klassikaplusserver.model.repository.CatalogRepository;
import ru.legionofone.klassikaplusserver.web.controller.CatalogItemReceiver;

@Service
public class StockItemUpdateService {

    private static final Logger logger = LoggerFactory.getLogger(CatalogService.class);

    private final CatalogRepository repository;
    private final CatalogItemReceiver catalogItemReceiver;

    @Autowired
    public StockItemUpdateService(CatalogRepository repository, CatalogItemReceiver catalogItemReceiver) {
        this.repository = repository;
        this.catalogItemReceiver = catalogItemReceiver;
    }

    @Scheduled(fixedRate = 5000)
    public void updateCatalogItem() {
        logger.info("Beginning routine procedure updating items");
        repository.updateCatalogItems();
        logger.info("Finished updating items");
        //TODO Запрос на сторону сайта
    }
}
