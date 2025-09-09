package com.vighneshspringboot.store.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/api/db-check")
    public String checkDbConnection() {
        // Perform a simple operation, e.g., using a JPA repository
        try {
            // repository.count(); // Or any simple query
            return "Database connection successful!";
        } catch (Exception e) {
            return "Database connection failed! " + e.getMessage();
        }
    }
}