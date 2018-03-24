package com.aandmcoding.springdemo;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name;
    private String description;

    private List<String> animals = new ArrayList<>();

    public Animal(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Animal(String name, String description, List<String> animals) {
        this.name = name;
        this.description = description;
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getAnimals() {
        return animals;
    }
}
