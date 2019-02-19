package ru.legionofone.klassikaplusserver.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.legionofone.klassikaplusserver.service.CatalogService;

import javax.servlet.http.HttpServletRequest;

@Controller
@EnableWebMvc
public class MainWebController {

    final CatalogService service;

    @Autowired
    public MainWebController(CatalogService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Anonymous") String name, Model model ){
        model.addAttribute("name", name);
        return "greeting";
    }

    @PostMapping("admin")
    public String admin(HttpServletRequest request){
        return "admin";
    }
}
