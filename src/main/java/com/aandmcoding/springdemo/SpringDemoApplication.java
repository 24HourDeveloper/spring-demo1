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

	@Bean
	CommandLineRunner runner(AnimalRepository animalRepository){
		return args -> {

			animalRepository.save(new AnimalController("ant", "Has four legs"));
			animalRepository.save(new AnimalController("dog", "Like to wag its tail"));
			animalRepository.save(new AnimalController("cat", "like to chase after mice"));
			animalRepository.save(new AnimalController("bird", "like to to fly"));
			animalRepository.save(new AnimalController("cow", "like to eat grass"));
		};
	}
}
