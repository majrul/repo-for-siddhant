package com.seclore.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("prodInv4")
public class ProductInventoryImpl4 implements ProductInventory {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Product product) {
		em.persist(product);
	}

	@Override
	public List<Product> fetchAll() {
		return em
				.createQuery("select p from Product p", Product.class)
				.getResultList();
	}

}