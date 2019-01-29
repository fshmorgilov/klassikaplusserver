package ru.legionofone.klassikaplusserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.legionofone.klassikaplusserver.model.domain.CatalogItem;
import ru.legionofone.klassikaplusserver.model.repository.CatalogRepository;

import java.util.List;
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
    public Optional<List<CatalogItem>> getNewItems() {
        List<CatalogItem> items = catalogRepository.provideCatalogNovelties();
        if (items.isEmpty())
            return Optional.empty();
        else return Optional.of(items);
    }

    @Override
    public Optional<List<CatalogItem>> getAllItems() {
        return Optional.empty();
    }
}
