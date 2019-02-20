package ru.legionofone.klassikaplusserver.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.legionofone.klassikaplusserver.service.CatalogService;
import ru.legionofone.klassikaplusserver.web.dto.provided.AndroidItemDto;
import ru.legionofone.klassikaplusserver.web.dto.provided.DataDto;
import ru.legionofone.klassikaplusserver.web.dto.provided.ErrorDto;
import ru.legionofone.klassikaplusserver.web.dto.provided.ResponseDto;

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
    public ResponseEntity getStock(@RequestParam @Nullable String deviceId) {
        logger.info("NOVELTY Request from client: " + deviceId);
        return ResponseEntity
                .notFound()
                .build();
    }
}
