package com.mongodb.scportal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.mongodb.scportal.repository")
public class ScPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScPortalApplication.class, args);
	}

}

