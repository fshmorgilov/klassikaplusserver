package ru.legionofone.klassikaplusserver.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import ru.legionofone.klassikaplusserver.service.CatalogService;
import ru.legionofone.klassikaplusserver.web.dto.provided.catalog.AndroidItemDto;
import ru.legionofone.klassikaplusserver.web.dto.provided.catalog.DataDto;
import ru.legionofone.klassikaplusserver.web.dto.provided.ErrorDto;
import ru.legionofone.klassikaplusserver.web.dto.provided.catalog.ResponseDto;
import ru.legionofone.klassikaplusserver.web.dto.provided.catalog.category.CategoryDataDto;
import ru.legionofone.klassikaplusserver.web.dto.provided.catalog.category.CategoryResponseDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("catalog")
public class CatalogItemController {

    final CatalogService catalogService;

    private static final Logger logger = LoggerFactory.getLogger(CatalogItemController.class);
    private final String OK_STATUS = "ok";

    @Autowired
    public CatalogItemController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping(path = "novelties")
    public ResponseEntity getNovelties(@RequestParam(required = false) @Nullable String deviceId) {
        final ObjectMapper toJsonMapper = new ObjectMapper();
        logger.info("NOVELTY Request from client: " + deviceId);
        List<AndroidItemDto> items = catalogService.getNewItems()
                .orElse(new ArrayList<>());
        logger.debug("Items obtained: ");
        items.stream()
                .map(AndroidItemDto::getName)
                .forEach(logger::debug);
        if (!items.isEmpty()) {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setStatus(OK_STATUS);
            DataDto dataDto = new DataDto();
            List<ErrorDto> errors = new ArrayList<>();
            dataDto.setItems(items);
            responseDto.setErrors(errors);
            responseDto.setData(dataDto);
            responseDto.setRevision(catalogService.getRevision());
            logger.debug("Formed message " + items.toString());
            return ResponseEntity
                    .ok()
                    .body(toJsonMapper.convertValue(responseDto, ResponseDto.class));
        } else {
            logger.info("No novelties found");
            return ResponseEntity
                    .noContent()
                    .build();
        }
    }

    @GetMapping(path = "get_stock")
    public ResponseEntity getStock(@RequestParam(required = false) @Nullable String deviceId) {
        logger.info("NOVELTY Request from client: " + deviceId);
        return ResponseEntity
                .notFound()
                .build();
    }

    @GetMapping(path = "{category}")
    public ResponseEntity getItemsByCategory(@PathVariable @NonNull String category) {
        return ResponseEntity.badRequest()
                .build();
    }

    @GetMapping(path = "get_categories")
    public ResponseEntity getCategories(@RequestParam(required = false) @Nullable String deviceId)  {
        final ObjectMapper toJsonObjectMapper = new ObjectMapper();
        List<String> categories = catalogService.getCategories();
        if (categories != null && !categories.isEmpty()) {
            CategoryResponseDto dto = new CategoryResponseDto();
            CategoryDataDto dataDto = new CategoryDataDto();
            dataDto.setItems(categories);
            dto.setData(dataDto);
            dto.setErrors(new ArrayList<>());
            dto.setStatus("Ok");
            dto.setRevision(catalogService.getRevision());
            return ResponseEntity.ok().body(toJsonObjectMapper.convertValue(dto, CategoryResponseDto.class));
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
