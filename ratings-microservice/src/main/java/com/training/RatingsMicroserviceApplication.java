package com.training;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

@SpringBootApplication
@EnableCaching
public class RatingsMicroserviceApplication {

	@Bean
	public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
	    return (builder) -> builder
	      .withCacheConfiguration("ratings.cache",
	        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(30)));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RatingsMicroserviceApplication.class, args);
	}

}
