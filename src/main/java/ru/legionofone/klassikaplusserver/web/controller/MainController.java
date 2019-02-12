package ru.legionofone.klassikaplusserver.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String hello(Map<String, Object> model) {
        return "hello";
    }

    @GetMapping("/main")

    public String main(Map<String, Object> model) {
        model.put("messages", new Object()); // FIXME: 2/12/2019

        return "main";
    }

}
