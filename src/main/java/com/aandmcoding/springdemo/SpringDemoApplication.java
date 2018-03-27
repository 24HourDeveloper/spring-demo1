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
			amRepository.save(new AnimalController("Ant", "Has for legs."));
			amRepository.save(new AnimalController("Dog", "Has black long hair and great sense of smell."));
			amRepository.save(new AnimalController("Rhino", "They have big horns and love to charge."));
			amRepository.save(new AnimalController("Pig", "They have pig skin and make snort noise all day."));
			amRepository.save(new AnimalController("Wolf", "Is a huge dog that runs with a pack."));
		};
	}
}
