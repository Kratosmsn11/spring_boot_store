package com.vighneshspringboot.store.controller;

import com.vighneshspringboot.store.model.User;
import com.vighneshspringboot.store.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserRepo userRepo;


    @Autowired
    public UserController(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<User> getAllUser(){
        return userRepo.findAll();
    }

}
