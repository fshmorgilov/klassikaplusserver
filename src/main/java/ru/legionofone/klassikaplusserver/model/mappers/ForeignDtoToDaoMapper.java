package ru.legionofone.klassikaplusserver.model.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.legionofone.klassikaplusserver.model.mappers.base.Mapping;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbItem;
import ru.legionofone.klassikaplusserver.web.dto.obtained.ItemDto;

public class ForeignDtoToDaoMapper extends Mapping<ItemDto, DbItem> {

    private static final Logger logger = LoggerFactory.getLogger(ForeignDtoToDaoMapper.class);

    @Override
    public DbItem map(ItemDto itemDto) {
        DbItem item = new DbItem();
        item.setExtId(itemDto.getId());
        if (itemDto.getDescription() != null) item.setDescription(itemDto.getDescription());
        item.setPrice(Double.valueOf(itemDto.getPrice()));
        if (itemDto.getImage() != null && !"".equals(itemDto.getImage()))
            item.setPhoto(itemDto.getImage());
//        else if (itemDto.getPhotogallery().getImage() != null && !"".equals(itemDto.getPhotogallery().getImage()))
//            item.setPhoto(itemDto.getPhotogallery().getImage());
        item.setName(itemDto.getPagetitle());
        item.setIcon(itemDto.getImgMini());
        item.setNovelty(Boolean.valueOf(itemDto.getNew()));
        item.setPageAlias(itemDto.getPagetitle());
//todo конвертер для галлереи изображений
        //todo validator

        logger.debug("Mapped :" + item.toString());
        return item;
    }
}
