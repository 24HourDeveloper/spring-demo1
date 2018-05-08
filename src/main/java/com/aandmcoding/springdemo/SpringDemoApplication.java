package com.aandmcoding.springdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	//setup initial values in the database at runtime
	@Bean
	CommandLineRunner runner(AmRepository amRepository, UsersRepository usersRepository){
		return args -> {

			// TODO: figure out how to use a relative path instead of absolute
			amRepository.save(new Animal("Ant", "Has for legs.", "/img/ant.jpg"));
			amRepository.save(new Animal("Dog", "Has black long hair and great sense of smell.", "/img/dog.jpg"));
			amRepository.save(new Animal("Rhino", "They have big horns and love to charge.", "/img/rhino.jpg"));
			amRepository.save(new Animal("Pig", "They have pig skin and make snort noise all day.", "/img/pig.jpg"));
			amRepository.save(new Animal("Wolf", "Is a huge dog that runs with a pack.", "/img/wolf.jpg"));

			usersRepository.save(new Users("mike", "moore"));
			usersRepository.save(new Users("a", "q"));
		};
	}

	@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("5120MB");
		factory.setMaxRequestSize("5120MB");
		return factory.createMultipartConfig();
	}
}
