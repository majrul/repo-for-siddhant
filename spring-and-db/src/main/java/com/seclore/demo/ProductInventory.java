package com.seclore.demo;

import java.util.List;

public interface ProductInventory {

	public void add(Product product);
	public List<Product> fetchAll();
	
}
