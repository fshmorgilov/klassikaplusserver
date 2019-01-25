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
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        String username = System.getenv("JDBC_DATABASE_USERNAME");
        String password = System.getenv("JDBC_DATABASE_PASSWORD");

        logger.info(new StringBuilder()
                .append("Starting server on database: ").append("URL: ").append(dbUrl)
                .append("User ").append(username)
                .append("Password ").append(password)
                .toString());
    }

}

