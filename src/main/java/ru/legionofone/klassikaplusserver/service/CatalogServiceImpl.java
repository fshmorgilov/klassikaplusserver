package ru.legionofone.klassikaplusserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.legionofone.klassikaplusserver.model.domain.CatalogItem;

import java.util.List;
import java.util.Optional;

@Component
public class CatalogServiceImpl implements CatalogService {

    private static final Logger logger = LoggerFactory.getLogger(CatalogServiceImpl.class);

    @Override
    public Optional<List<CatalogItem>> getNewItems() {
        return Optional.empty();
    }

    @Override
    public Optional<List<CatalogItem>> getAllItems() {
        return Optional.empty();
    }
}
