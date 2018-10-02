package com.tjetc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tjetc.dao.UserDAO;
import com.tjetc.domain.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public boolean addUser(User user) throws SQLException {
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
	     //String sql = "insert into user(username,password) values(?,?)";
	     String sql = "insert into user values(null,?,?,?,?,?)";
	     PreparedStatement pstmt = conn.prepareStatement(sql);
	     pstmt.setString(1, user.getUsername());
	     pstmt.setString(2, user.getPassword());
	     pstmt.setString(3, user.getMail());
	     pstmt.setString(4, user.getPhone());
	     pstmt.setString(5, user.getAddress());
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
	public List<User> findAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		//多态   
		List<User> users = new ArrayList<User>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?  useUnicode=yes&characterEncoding=utf8", "root", "1");
	     System.out.println(conn);
	     String sql = "select * from user";
	     PreparedStatement pstmt = conn.prepareStatement(sql);
	     ResultSet rs =  pstmt.executeQuery();
	     while(rs.next()){
	    	int userid= rs.getInt(1);
	    	String username = rs.getString(2);
	    	String password = rs.getString(3);
	    	String mail = rs.getString(4);
	    	String phone = rs.getString(5);
	    	String address = rs.getString(6);
	    	User user = new User(userid, username,password, mail, phone, address);
	    	users.add(user);
	     }
	     rs.close();
	     pstmt.close();
	     conn.close();
		return users;
	}

	@Override
	public boolean deleteUserByUserid(int userid) throws SQLException {
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
	     String sql = "delete from user where userid=?";
	     PreparedStatement pstmt = conn.prepareStatement(sql);
	     pstmt.setInt(1, userid);
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
	public User findUserByUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		User user = null;
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
	     pstmt.setString(1, username);
	     ResultSet rs =  pstmt.executeQuery();
	     while(rs.next()){
	    	int userid= rs.getInt(1);
	    	//String username = rs.getString(2);
	    	String password = rs.getString(3);
	    	String mail = rs.getString(4);
	    	String phone = rs.getString(5);
	    	String address = rs.getString(6);
	    	user = new User(userid, username,password, mail, phone, address);
	     }
	     rs.close();
	     pstmt.close();
	     conn.close();
		return user;
	}

	
	public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		User user = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?  useUnicode=yes&characterEncoding=utf8", "root", "1");
	     System.out.println(conn);
	     String sql = "select * from user where username=? and password=?";
	     PreparedStatement pstmt = conn.prepareStatement(sql);
	     pstmt.setString(1, username);
	     pstmt.setString(2, password);
	     ResultSet rs =  pstmt.executeQuery();
	     while(rs.next()){
	    	int userid= rs.getInt(1);
	    	//String username = rs.getString(2);
	    	//String password = rs.getString(3);
	    	String mail = rs.getString(4);
	    	String phone = rs.getString(5);
	    	String address = rs.getString(6);
	    	user = new User(userid, username,password, mail, phone, address);
	     }
	     rs.close();
	     pstmt.close();
	     conn.close();
		return user;
	}

	@Override
	public List<User> findUsersByPageNum(int pageNum,int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		//多态   
		List<User> users = new ArrayList<User>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?  useUnicode=yes&characterEncoding=utf8", "root", "1");
	     System.out.println(conn);
	     String sql = "select * from user limit ?,?";
	     PreparedStatement pstmt = conn.prepareStatement(sql);
	     pstmt.setInt(1,  (pageNum-1)*pageSize);
	     pstmt.setInt(2, pageSize);
	     ResultSet rs =  pstmt.executeQuery();
	     while(rs.next()){
	    	int userid= rs.getInt(1);
	    	String username = rs.getString(2);
	    	String password = rs.getString(3);
	    	String mail = rs.getString(4);
	    	String phone = rs.getString(5);
	    	String address = rs.getString(6);
	    	User user = new User(userid, username,password, mail, phone, address);
	    	users.add(user);
	     }
	     rs.close();
	     pstmt.close();
	     conn.close();
		return users;
	}

	@Override
	public int countAllUsersNum() throws SQLException {
		// TODO Auto-generated method stub
		int num=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?  useUnicode=yes&characterEncoding=utf8", "root", "1");
	     System.out.println(conn);
	     String sql = "select count(*) from user";
	     PreparedStatement pstmt = conn.prepareStatement(sql);
	     ResultSet rs =  pstmt.executeQuery();
	     if(rs.next()){
	    	 num = rs.getInt(1);
	     }
	     rs.close();
	     pstmt.close();
	     conn.close();
		 return num;
	}
	

}
