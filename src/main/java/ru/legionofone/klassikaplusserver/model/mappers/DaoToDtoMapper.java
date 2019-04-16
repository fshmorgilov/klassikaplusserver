package ru.legionofone.klassikaplusserver.model.mappers;

import ru.legionofone.klassikaplusserver.model.mappers.base.Mapping;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbItem;
import ru.legionofone.klassikaplusserver.web.dto.provided.catalog.AndroidItemDto;

public class DaoToDtoMapper extends Mapping<DbItem, AndroidItemDto> {
    @Override
    public AndroidItemDto map(DbItem dbItem) {
        AndroidItemDto dto = new AndroidItemDto();
        dto.setId(dbItem.getId());
        dto.setExtId(dbItem.getExtId());
        dto.setName(dbItem.getName());
        dto.setDescription(dbItem.getDescription());
        dto.setVendorCode(dbItem.getVendorCode());
        dto.setNovelty(dbItem.getNovelty());
        dto.setPageAlias(dbItem.getPageAlias());
        if (!dbItem.getIcon().isEmpty())
            dto.setIcon(dbItem.getIcon());
        else
            dto.setIcon(dbItem.getPhoto());
        dto.setBasePrice(dbItem.getBasePrice());
        dto.setPrice(dbItem.getPrice());
        dto.setCategory(dbItem.getCategory());
        dto.setCategoryId(dbItem.getCategoryId());
        return dto;
    }
}
