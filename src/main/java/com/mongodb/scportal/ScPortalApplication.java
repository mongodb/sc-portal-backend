package com.mongodb.scportal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.mongodb.scportal.repository")
public class ScPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScPortalApplication.class, args);
	}

}

