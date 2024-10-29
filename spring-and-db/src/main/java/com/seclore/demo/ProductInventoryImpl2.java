package com.seclore.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("prodInv2")
public class ProductInventoryImpl2 implements ProductInventory {

	@Autowired //DI
	private DataSource dataSource;
	
	@Override
	public void add(Product product) {
		Connection conn = null;
		try {
			long ms1 = System.currentTimeMillis();
			conn = dataSource.getConnection();
			long ms2 = System.currentTimeMillis();
			System.out.println("approx time to connect " + (ms2 - ms1) + " ms");
			
			String sql = "insert into product(name, price, quantity) values(?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, product.getName());
			st.setDouble(2, product.getPrice());
			st.setInt(3, product.getQuantity());
			st.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

	@Override
	public List<Product> fetchAll() {
		Connection conn = null;
		List<Product> list = new ArrayList<Product>();
		try {
			long ms1 = System.currentTimeMillis();
			conn = dataSource.getConnection();
			long ms2 = System.currentTimeMillis();
			System.out.println("approx time to connect " + (ms2 - ms1) + " ms");

			
			ms1 = System.currentTimeMillis();
			String sql = "select * from product";
			PreparedStatement st = conn.prepareStatement(sql);
			ms2 = System.currentTimeMillis();
			System.out.println("approx time to prepare query " + (ms2 - ms1) + " ms");

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setQuantity(rs.getInt(4));
				list.add(product);
			}
			return list;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

}

