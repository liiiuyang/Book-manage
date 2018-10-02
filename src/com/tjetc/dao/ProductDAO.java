package com.tjetc.dao;

import java.sql.SQLException;
import java.util.List;

import com.tjetc.domain.Product;

public interface ProductDAO {
	boolean addProduct(Product product) throws SQLException;
    List<Product> findAllProducts() throws SQLException;
    boolean deleteProductByPid(int pid) throws SQLException;
    Product findProductByPame(String pname) throws SQLException;
    Product findProductByPnameAndPrice(String pname,String price) throws SQLException;
    List<Product> findProductByPageNum(int pageNum,int pageSize) throws SQLException;
	int countAllProductsNum() throws SQLException;
}

