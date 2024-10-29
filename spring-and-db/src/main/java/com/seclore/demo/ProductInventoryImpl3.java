package com.seclore.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("prodInv3")
public class ProductInventoryImpl3 implements ProductInventory {

	@Autowired //DI
	private DataSource dataSource;
	
	@Override
	public void add(Product product) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "insert into product(name, price, quantity) values(?, ?, ?)";
		jt.update(sql, product.getName(), product.getPrice(), product.getQuantity());
	}

	@Override
	public List<Product> fetchAll() {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "select * from product";
		List<Product> list = jt.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
		return list;
	}

}

