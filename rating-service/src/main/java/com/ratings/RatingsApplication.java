package com.ratings;

import com.ratings.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Simple Rating microservice that will be consumed by other microservices (as Tour service)
 * */
@SpringBootApplication
public class RatingsApplication {

	@Autowired
	private RatingsService ratingsService;

	public static void main(String[] args) {
		SpringApplication.run(RatingsApplication.class, args);
	}
}
