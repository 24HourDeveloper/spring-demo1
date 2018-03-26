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
			amRepository.save(new AnimalController("ant", "Has four legs"));
			amRepository.save(new AnimalController("dog", "Like to wag its tail"));
			amRepository.save(new AnimalController("cat", "like to chase after mice"));
			amRepository.save(new AnimalController("bird", "like to to fly"));
			amRepository.save(new AnimalController("cow", "like to eat grass"));
		};
	}
}
