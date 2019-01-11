package ru.legionofone.klassikaplusserver.web.controller;

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

@RestController
@RequestMapping("stock")
public class CatalogItemController {

    final CatalogService catalogService;

    private static final Logger logger = LoggerFactory.getLogger(CatalogItemController.class);

    @Autowired
    public CatalogItemController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping(path = "get_novelties")
    public ResponseEntity getNovelties(@RequestParam @Nullable String deviceId) {
        logger.info("NOVELTY Request from client: " + deviceId);
        return ResponseEntity
                .ok()
                .body("PLACEHOLDER");
    }

    @GetMapping(path = "get_stock")
    public ResponseEntity getStock(@RequestParam @Nullable String deviceId) {
        logger.info("NOVELTY Request from client: " + deviceId);
        return ResponseEntity
                .notFound()
                .build();
    }
}
