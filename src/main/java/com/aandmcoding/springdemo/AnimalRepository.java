package com.aandmcoding.springdemo;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by A on 3/25/2018.
 */
public interface AnimalRepository extends CrudRepository<AnimalController, Long> {

    AnimalController findByName(String name);
}
