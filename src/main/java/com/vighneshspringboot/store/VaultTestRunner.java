package com.vighneshspringboot.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class VaultTestRunner implements CommandLineRunner {

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

    @Override
    public void run(String... args) {
        System.out.println("DB Username from Vault: " + dbUsername);
        System.out.println("DB Password from Vault: " + dbPassword);
    }
}