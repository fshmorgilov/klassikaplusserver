package ru.legionofone.klassikaplusserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StockItemUpdateService {

    private static final Logger logger = LoggerFactory.getLogger(CatalogService.class);

    @Scheduled(fixedRate = 5000)
    public void updateStockItem(){
        //TODO Запрос на сторону сайта
    }
}
