package com.seclore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.seclore.demo.HelloWorld;

@Configuration
@ComponentScan("com.seclore.demo")
public class MySpringConfig {

	@Bean
	public HelloWorld hello() {
		return new HelloWorld();
	}
	
}
