package com.vighneshspringboot.store.service;

import com.vighneshspringboot.store.model.User;
import com.vighneshspringboot.store.repository.UserRepo;
import org.keycloak.jose.jwk.JWK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Transactional
    public User getOrCreateCurrentUser(){

        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String keycloakUserId = jwt.getSubject();

        Optional<User> existingUser = userRepo.findById(keycloakUserId);

        if (existingUser.isPresent()){
            return existingUser.get();
        }else{
            String username = jwt.getClaimAsString("username");
            String email = jwt.getClaimAsString("email");

            User newUser = new User(keycloakUserId, username, email);

            return userRepo.save(newUser);
        }
    }
}
