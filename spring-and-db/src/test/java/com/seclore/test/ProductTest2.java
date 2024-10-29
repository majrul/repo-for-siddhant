package com.seclore.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.seclore.demo.Product;
import com.seclore.demo.ProductInventory;
import com.seclore.demo.ProductRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:my-spring-config.xml")
public class ProductTest2 {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void add() {
		Product product = new Product();
		product.setName("Samsung S24");
		product.setPrice(69000);
		product.setQuantity(50);
		productRepository.save(product);
		
		//assert is missing
	}

	@RepeatedTest(5)
	void fetch() {
		long ms1 = System.currentTimeMillis();
		List<Product> list = productRepository.findAll();
		long ms2 = System.currentTimeMillis();
		System.out.println("approx time taken to fetch " + (ms2 - ms1) + " ms");
		//list.forEach(System.out::println);
		//no println to be used in test cases
		assertTrue(list.size() > 0);
	}
}
