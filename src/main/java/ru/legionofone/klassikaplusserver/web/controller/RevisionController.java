package ru.legionofone.klassikaplusserver.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.legionofone.klassikaplusserver.service.CatalogService;

@RestController("revision")
public class RevisionController {

    final CatalogService service;

    @Autowired
    public RevisionController(CatalogService service) {
        this.service = service;
    }

    @GetMapping
    public Integer getRevision(@RequestParam(required = false) String deviceId) {
        return service.getRevision();
    }
}
