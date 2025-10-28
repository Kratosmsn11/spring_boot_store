package com.vighneshspringboot.store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.util.UUID;

@Entity
@Table(name = "categories", schema = "subshub")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", length = 100)
    private String name;

    public Category(){}

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}