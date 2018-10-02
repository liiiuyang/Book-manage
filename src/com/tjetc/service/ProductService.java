package com.tjetc.service;

import java.sql.SQLException;
import java.util.List;

import com.tjetc.domain.Product;

public interface ProductService {
	//登录方法
	Product login(String pname,String price) throws SQLException ;
	//注册方法
	boolean register(Product product) throws SQLException ;
	//显示所有用户的方法
	List<Product> showAllProducts() throws SQLException ;
	boolean deleteProductByPid(String pidStr) throws SQLException;
	boolean deleteProductByPid(int pid) throws SQLException;
}
