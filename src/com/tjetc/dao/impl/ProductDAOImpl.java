package com.tjetc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tjetc.dao.ProductDAO;
import com.tjetc.domain.Product;

public class ProductDAOImpl implements ProductDAO {
	@Override
	public boolean addProduct(Product product) throws SQLException{
		boolean flag = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?  useUnicode=yes&characterEncoding=utf8", "root", "1");
	     System.out.println(conn);
	   //String sql = "insert into Product(pname,price) values(?,?)";
	     String sql = "insert into product values(null,?,?,?,?)";
	     PreparedStatement pstmt = conn.prepareStatement(sql);
	     pstmt.setString(1, product.getPname());
	     pstmt.setString(2, product.getPrice());
	     pstmt.setString(3, product.getPhoto());
	     pstmt.setString(4, product.getNum());
	    
	     int num = pstmt.executeUpdate();
	     System.out.println("受影响的行数是："+num);
	     if(num>=1){
	    	 flag=true;
	     }
	     pstmt.close();
	     conn.close();
		 return flag;
	}

	public List<Product> findAllProducts() throws SQLException  {
		// TODO Auto-generated method stub
		//多态   
		List<Product> products = new ArrayList<Product>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?  useUnicode=yes&characterEncoding=utf8", "root", "1");
	     System.out.println(conn);
	     String sql = "select * from product";
	     PreparedStatement pstmt = conn.prepareStatement(sql);
	     ResultSet rs =  pstmt.executeQuery();
	     while(rs.next()){
	    	int pid= rs.getInt(1);
	    	String pname = rs.getString(2);
	    	String price = rs.getString(3);
	    	String photo = rs.getString(4);
	    	String num = rs.getString(5);
	    	
	    	Product product = new Product(pid, pname,price, photo, num);
	    	products.add(product);
	     }
	     rs.close();
	     pstmt.close();
	     conn.close();
		return products;
	}
	public boolean deleteProductByPid(int pid) throws SQLException  {
		// TODO Auto-generated method stub
		boolean flag = false;
	     try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?  useUnicode=yes&characterEncoding=utf8", "root", "1");
	     System.out.println(conn);
	     String sql = "delete from product where pid=?";
	     PreparedStatement pstmt = conn.prepareStatement(sql);
	     pstmt.setInt(1, pid);
	     int num = pstmt.executeUpdate();
	     System.out.println("受影响的行数是："+num);
	     if(num>=1){
	    	 flag=true;
	     }
	     pstmt.close();
	     conn.close();
		 return flag;
	}
	@Override
	public Product findProductByPame(String pname) throws SQLException {
		// TODO Auto-generated method stub
				Product product = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?  useUnicode=yes&characterEncoding=utf8", "root", "1");
			     System.out.println(conn);
			     String sql = "select * from user where username=?";
			     PreparedStatement pstmt = conn.prepareStatement(sql);
			     pstmt.setString(1, pname);
			     ResultSet rs =  pstmt.executeQuery();
			     while(rs.next()){
			    	int pid= rs.getInt(1);
			    	String pname1 = rs.getString(2);
			    	String price = rs.getString(3);
			    	String photo= rs.getString(4);
			    	String num = rs.getString(5);
			    	
			      product = new Product(pid, pname1,price, photo, num);
			     }
			     rs.close();
			     pstmt.close();
			     conn.close();
				return product;
	}

	@Override
	public Product findProductByPnameAndPrice(String pname, String price) throws SQLException {
		// TODO Auto-generated method stub
				Product product = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?  useUnicode=yes&characterEncoding=utf8", "root", "1");
			     System.out.println(conn);
			     String sql = "select * from product where pname=? and price=?";
			     PreparedStatement pstmt = conn.prepareStatement(sql);
			     pstmt.setString(1, pname);
			     pstmt.setString(2, price);
			     ResultSet rs =  pstmt.executeQuery();
			     while(rs.next()){
			    	int pid= rs.getInt(1);
			    	//String pname = rs.getString(2);
			    	//String price = rs.getString(3);
			    	String photo = rs.getString(4);
			    	String num = rs.getString(5);
			    	
			    	product = new Product(pid, pname,price,photo , num);
			     }
			     rs.close();
			     pstmt.close();
			     conn.close();
				return product;
	}

	@Override
	public List<Product> findProductByPageNum(int pageNum, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAllProductsNum() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
	



