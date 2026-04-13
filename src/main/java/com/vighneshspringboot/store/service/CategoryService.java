package com.vighneshspringboot.store.service;

import com.vighneshspringboot.store.model.Category;
import com.vighneshspringboot.store.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Cacheable("categories")
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
