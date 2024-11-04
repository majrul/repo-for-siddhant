package com.seclore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@ComponentScan("com.abc.controller")
//@PropertySource("classpath:mysettings.props")
public class SpringBootIntroApplication {

	public static void main(String[] args) {
		//System.setProperty("spring.profiles.active", "prod");
		SpringApplication.run(SpringBootIntroApplication.class, args);
	}

}
