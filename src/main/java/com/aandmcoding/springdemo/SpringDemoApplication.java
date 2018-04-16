package com.aandmcoding.springdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	//setup initial values in the database at runtime
	@Bean
	CommandLineRunner runner(AmRepository amRepository){
		return args -> {
			amRepository.save(new AnimalController("Ant", "ant"));
			amRepository.save(new AnimalController("Dog", "dog"));
			amRepository.save(new AnimalController("Rhino", "rhino"));
			amRepository.save(new AnimalController("Pig", "pig"));
			amRepository.save(new AnimalController("Wolf", "wolf"));
		};
	}
}
