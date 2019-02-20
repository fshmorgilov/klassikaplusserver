package ru.legionofone.klassikaplusserver.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.legionofone.klassikaplusserver.service.CatalogService;

@RestController("revision")
public class RevisionController {

    private static final Logger logger = LoggerFactory.getLogger(RevisionController.class.getName());

    private CatalogService catalog;

    @Autowired
    public RevisionController(CatalogService service) {
        this.catalog = service;
    }

    @GetMapping("get_revision")
    public Integer getCurrentRevision() {
        logger.info("Providing revision number");
        return catalog.getRevision();
    }


    @PostMapping("update_revision")
    public ResponseEntity updateRevision() {
        logger.info("Request updating revision");
        catalog.updateRevision();
        return ResponseEntity.ok().build();
    }
}
