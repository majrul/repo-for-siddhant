package com.seclore.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${myprop}")
	private String myprop;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello from Spring Boot "  + myprop;
	}
}
	