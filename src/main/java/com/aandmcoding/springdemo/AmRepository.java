package com.aandmcoding.springdemo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by A on 3/25/2018.
 */
public interface AmRepository extends MongoRepository<Animal, String> {
    Animal findByName(String name);
}
