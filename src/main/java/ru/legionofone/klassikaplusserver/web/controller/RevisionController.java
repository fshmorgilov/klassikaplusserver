package ru.legionofone.klassikaplusserver.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.legionofone.klassikaplusserver.service.CatalogService;
import ru.legionofone.klassikaplusserver.web.dto.provided.revision.ResponseDto;

import java.util.ArrayList;

@RestController("revision")
public class RevisionController {

    private static final Logger logger = LoggerFactory.getLogger(RevisionController.class.getName());

    private CatalogService catalog;

    @Autowired
    public RevisionController(CatalogService service) {
        this.catalog = service;
    }

    @GetMapping
    public ResponseEntity getCurrentRevision() {
        logger.info("Providing revision number");
        ObjectMapper mapper = new ObjectMapper();
        ResponseDto dto = new ResponseDto();
        dto.setData(catalog.getRevision());
        dto.setStatus("OK");
        dto.setErrors(new ArrayList<>());
        return ResponseEntity.ok(mapper.convertValue(dto, ResponseDto.class));
    }


    @PostMapping("update_revision")
    public ResponseEntity updateRevision() {
        logger.info("Request updating revision");
        catalog.updateRevision();
        return ResponseEntity.ok().build();
    }
}
