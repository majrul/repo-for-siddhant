package com.seclore.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

//TODO: create table product(id int primary key auto_increment, name varchar(20), price double, quantity int);

@Component("prodInv1")
public class ProductInventoryImpl1 implements ProductInventory {

	@Override
	public void add(Product product) {
		Connection conn = null;
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("org.h2.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd");
			conn = DriverManager.getConnection("jdbc:h2:~/training", "sa", "");
			String sql = "insert into product(name, price, quantity) values(?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, product.getName());
			st.setDouble(2, product.getPrice());
			st.setInt(3, product.getQuantity());
			st.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException e) {
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
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("org.h2.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd");
			conn = DriverManager.getConnection("jdbc:h2:~/training", "sa", "");
			String sql = "select * from product";
			PreparedStatement st = conn.prepareStatement(sql);
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
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return list;
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

}

