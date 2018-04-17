package com.aandmcoding.springdemo;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by A on 3/25/2018.
 */
public interface AmRepository extends CrudRepository<Animal, Long> {
    Animal findByName(String name);
}
