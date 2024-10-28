package com.seclore.demo;

import org.springframework.stereotype.Component;

@Component("helloworld")
public class HelloWorld {

	public HelloWorld() {
		System.out.println("HelloWorld()");
	}
	
	public String sayHello() {
		return "Hello Everyone!";
	}
}

