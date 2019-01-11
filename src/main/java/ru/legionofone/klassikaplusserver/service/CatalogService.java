package ru.legionofone.klassikaplusserver.service;

import ru.legionofone.klassikaplusserver.model.domain.CatalogItem;

import java.util.List;
import java.util.Optional;

public interface CatalogService {

    Optional<List<CatalogItem>> getNewItems();

    Optional<List<CatalogItem>> getAllItems();
}
