package ru.legionofone.klassikaplusserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.legionofone.klassikaplusserver.model.domain.StockItem;

import java.util.List;
import java.util.Optional;

@Component
public class StockItemServiceImpl implements StockItemService {

    private static final Logger logger = LoggerFactory.getLogger(StockItemServiceImpl.class);

    @Override
    public Optional<List<StockItem>> getNewItems() {
        return Optional.empty();
    }

    @Override
    public Optional<List<StockItem>> getAllItems() {
        return Optional.empty();
    }
}
