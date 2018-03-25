package com.aandmcoding.springdemo;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AnimalRepository {

    private static final List<Animal> animal = Arrays.asList(
        new Animal("Ant", "Has for legs"),
        new Animal("Dog", "Has black long hair and great sense of smell"),
        new Animal("Rhino", "They have big horns and love to charge."),
        new Animal("Pig", "They have pig skin and make snort noise all day.")
    );

    public Animal getAnimal(){
        for(Animal animals : animal){
            return animals;
        }
        return null;
    }

    public List<Animal> allAnimals(){
        return animal;
    }
}
