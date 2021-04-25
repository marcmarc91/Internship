package com.arobs.internship.library;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication()
public class ArobsLibraryApplication {
    private static final Logger log = LoggerFactory.getLogger(ArobsLibraryApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ArobsLibraryApplication.class, args);
    }

}
