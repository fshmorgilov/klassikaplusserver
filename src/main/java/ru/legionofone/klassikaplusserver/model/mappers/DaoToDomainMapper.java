package ru.legionofone.klassikaplusserver.model.mappers;

import ru.legionofone.klassikaplusserver.model.domain.CatalogItem;
import ru.legionofone.klassikaplusserver.model.mappers.base.Mapping;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbItem;

public class DaoToDomainMapper extends Mapping<DbItem, CatalogItem> {
    @Override
    public CatalogItem map(DbItem dbItem) {
        return null;
    }
}
