package ru.legionofone.klassikaplusserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.legionofone.klassikaplusserver.model.domain.CatalogItem;
import ru.legionofone.klassikaplusserver.model.repository.CatalogRepository;
import ru.legionofone.klassikaplusserver.web.dto.provided.catalog.AndroidItemDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService {

    private static final Logger logger = LoggerFactory.getLogger(CatalogServiceImpl.class);

    final CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Optional<List<AndroidItemDto>> getNewItems() {
        logger.info("Service Providing novelties");
        List<AndroidItemDto> items = catalogRepository.provideCatalogNovelties();
        return Optional.ofNullable(items);
    }

    @Override
    public Integer getRevision() {
        return catalogRepository.refreshRevision();
    }

    @Override
    public void updateRevision() {
        catalogRepository.updateRevision();
    }

    @Override
    public Map<Integer, String> getCategories() {
        return catalogRepository.provideCategories();
    }

    @Override
    public Optional<List<AndroidItemDto>> provideItemsByCategory(Integer categoryId) {
        if (!catalogRepository.provideCategories().keySet().contains(categoryId)) return Optional.empty();
        List<AndroidItemDto> items = catalogRepository.provideItemsByCategory(categoryId);
        return Optional.ofNullable(items);
    }
}
