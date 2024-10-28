package com.seclore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seclore.demo.HelloWorld;

public class App {

	public static void main(String[] args) {
		//Loading Spring / IoC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		
		//Access a bean
		HelloWorld h = (HelloWorld) ctx.getBean("hello");
		//HelloWorld h = new HelloWorld(); //Why are we not creating this object? Why Spring?
		System.out.println(h.sayHello());
	}
}
