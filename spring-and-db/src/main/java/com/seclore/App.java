package com.seclore;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.seclore.demo.Product;
import com.seclore.demo.ProductInventory;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		ProductInventory inv = (ProductInventory) ctx.getBean("prodInv3a");
		
		/*Product product = new Product();
		product.setName("Samsung S24");
		product.setPrice(79000);
		product.setQuantity(50);
		inv.add(product);*/
		
		for(int i=0; i<5; i++) {
			long ms1 = System.currentTimeMillis();
			List<Product> list = inv.fetchAll();
			long ms2 = System.currentTimeMillis();
			System.out.println("approx time taken to fetch " + (ms2 - ms1) + " ms");
		}
	}
}
