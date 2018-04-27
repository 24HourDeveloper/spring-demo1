package com.aandmcoding.springdemo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


/**
 * Created by A on 3/25/2018.
 */

@Entity
@Document(collection = "animal")
public class Animal {
    @Id
    private String id;
    private String name;
    private String description;

    public Animal(){}

    public Animal(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
