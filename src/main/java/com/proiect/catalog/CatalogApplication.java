package com.proiect.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //this means that this is a Spring Boot application
public class CatalogApplication {

    //if we want to run the application -> right click on this method/class -> 'Run CatalogApplication'
    //when we see "Started CatalogApplication in 5.105 seconds (JVM running for 6.621)" in logs => app started successfully
    public static void main(String[] args) {
        SpringApplication.run(CatalogApplication.class, args);
    }

}
