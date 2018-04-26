package com.aandmcoding.springdemo;

import javax.persistence.*;

/**
 * Created by A on 3/25/2018.
 */

@Entity
@Table(name ="animal")
public class Animal {
    @Id @GeneratedValue
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String image;

    public Animal(){}

    public Animal(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
