package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RatingsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingsMicroserviceApplication.class, args);
	}

}
