package ru.legionofone.klassikaplusserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class KlassikaplusServerApplication {

    private static final Logger logger = LoggerFactory.getLogger(KlassikaplusServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KlassikaplusServerApplication.class, args);
    }

}

