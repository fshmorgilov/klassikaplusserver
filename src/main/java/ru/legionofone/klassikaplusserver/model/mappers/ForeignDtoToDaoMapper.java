package ru.legionofone.klassikaplusserver.model.mappers;

import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;
import ru.legionofone.klassikaplusserver.model.mappers.base.Mapping;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbItem;
import ru.legionofone.klassikaplusserver.web.dto.obtained.ItemDto;

import java.util.Optional;

public class ForeignDtoToDaoMapper extends Mapping<ItemDto, DbItem> {

    private static final Logger logger = LoggerFactory.getLogger(ForeignDtoToDaoMapper.class);

    // FIXME: 2/25/2019 refactor to @Value
    private static String siteUrl = "https://klassikaplus.ru/";

    @Override
    public DbItem map(ItemDto itemDto) {
        DbItem item = new DbItem();
        item.setExtId(itemDto.getId());
        if (itemDto.getDescription() != null)
            item.setDescription(itemDto.getDescription());
        item.setPrice(priceParcel(cleanString(itemDto
                .getPrice()))
                .orElse(999999.99));
        if (itemDto.getImage() != null && !"".equals(itemDto.getImage()))
            item.setPhoto(itemDto.getImage());
        item.setName(itemDto.getPagetitle());
        item.setIcon(itemDto.getImgMini());
        item.setNovelty(noveltyParcel(cleanString(itemDto
                .getNew()))
                .orElse(false));
        item.setPageAlias(siteUrl + itemDto.getUri());

        logger.debug("Mapped :" + item.toString());
        return item;
    }

    private Optional<Double> priceParcel(@Nullable String priceString) {
        return Optional.ofNullable(Double.parseDouble(priceString));
    }

    private Optional<Boolean> noveltyParcel(@Nullable String noveltyString) {
        Boolean novelty;
        if (noveltyString != null) {
            if (noveltyString.equals("1"))
                novelty = true;
            else if (noveltyString.equals("0"))
                novelty = false;
            else novelty = null;
        } else novelty = null;
        return Optional.ofNullable(novelty);
    }

    @Nullable
    private String cleanString(@Nullable String stringToClean) {
        return StringUtils.deleteAny(stringToClean, " ");
    }
}
