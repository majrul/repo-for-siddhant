package com.seclore.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seclore.demo.Product;
import com.seclore.demo.ProductInventory;

public class ProductTest {

	private static ProductInventory inv;
	
	@BeforeAll
	static void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		inv = (ProductInventory) ctx.getBean("prodInv2");		
	}
	
	@Test
	void add() {
		Product product = new Product();
		product.setName("Samsung S23");
		product.setPrice(39000);
		product.setQuantity(50);
		inv.add(product);
		
		//assert is missing
	}

	@Test
	void fetch() {
		List<Product> list = inv.fetchAll();
		list.forEach(System.out::println);
		//no println to be used in test cases
		assertTrue(list.size() > 0);
	}
}
