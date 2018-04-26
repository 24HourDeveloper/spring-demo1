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
//	@Bean
//	CommandLineRunner runner(AmRepository amRepository){
//		return args -> {
//
//			amRepository.save(new Animal("Ant", "Has for legs.", "ant"));
//			amRepository.save(new Animal("Dog", "Has black long hair and great sense of smell.", "dog"));
//			amRepository.save(new Animal("Rhino", "They have big horns and love to charge.", "rhino"));
//			amRepository.save(new Animal("Pig", "They have pig skin and make snort noise all day.", "pig"));
//			amRepository.save(new Animal("Wolf", "Is a huge dog that runs with a pack.", "wolf"));
//		};
//	}
}
