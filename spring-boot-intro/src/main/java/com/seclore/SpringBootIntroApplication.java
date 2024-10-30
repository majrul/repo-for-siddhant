package com.seclore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.abc.controller")
public class SpringBootIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIntroApplication.class, args);
	}

}
