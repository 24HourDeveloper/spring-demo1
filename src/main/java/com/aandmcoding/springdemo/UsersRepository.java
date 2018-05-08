package com.aandmcoding.springdemo;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by A on 4/26/2018.
 */
public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
}
