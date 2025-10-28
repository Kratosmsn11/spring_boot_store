package com.vighneshspringboot.store.controller;


import com.vighneshspringboot.store.model.Category;
import com.vighneshspringboot.store.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryController(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }
}
