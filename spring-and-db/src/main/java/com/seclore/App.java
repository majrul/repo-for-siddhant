package com.seclore;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seclore.demo.Product;
import com.seclore.demo.ProductInventory;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		ProductInventory inv = (ProductInventory) ctx.getBean("prodInv1");
		
		/*Product product = new Product();
		product.setName("Samsung S24");
		product.setPrice(79000);
		product.setQuantity(50);
		inv.add(product);*/
		
		List<Product> list = inv.fetchAll();
		list.forEach(System.out::println);
	}
}
