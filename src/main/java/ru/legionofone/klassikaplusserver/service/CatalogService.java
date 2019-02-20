package ru.legionofone.klassikaplusserver.service;

import ru.legionofone.klassikaplusserver.model.domain.CatalogItem;
import ru.legionofone.klassikaplusserver.web.dto.provided.AndroidItemDto;

import java.util.List;
import java.util.Optional;

public interface CatalogService {

    Optional<List<AndroidItemDto>> getNewItems();

    Optional<List<CatalogItem>> getAllItems();

    Integer getRevision();

    void updateRevision();
}
