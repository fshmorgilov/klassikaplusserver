package ru.legionofone.klassikaplusserver.service;

import ru.legionofone.klassikaplusserver.model.domain.StockItem;

import java.util.List;
import java.util.Optional;

public interface StockItemService {

    Optional<List<StockItem>> getNewItems();

    Optional<List<StockItem>> getAllItems();
}
