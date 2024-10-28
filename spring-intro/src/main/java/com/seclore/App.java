package com.seclore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seclore.config.MySpringConfig;
import com.seclore.demo.Calculator;
import com.seclore.demo.HelloWorld;

public class App {

	public static void main(String[] args) {
		//Loading Spring / IoC container
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MySpringConfig.class);
		
		//Access a bean
		for(int i=0; i<5; i++) {
			HelloWorld h = (HelloWorld) ctx.getBean("hello");
			//HelloWorld h = new HelloWorld(); //Why are we not creating this object? Why Spring?
			System.out.println(h.sayHello());
		}
		
		Calculator c = (Calculator) ctx.getBean("calc");
		System.out.println(c.add(10, 20));
	}
}
