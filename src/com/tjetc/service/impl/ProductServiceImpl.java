package com.tjetc.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.tjetc.dao.ProductDAO;
import com.tjetc.dao.impl.ProductDAOImpl;
import com.tjetc.domain.Product;
import com.tjetc.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDAO udi  = new ProductDAOImpl();

	@Override
	public Product login(String pname, String price) throws SQLException {
		// TODO Auto-generated method stub
		// udi = new ProductDAOImpl();
		//ProductDAO udi = new ProductDAOImpl();
		return udi.findProductByPnameAndPrice(pname, price);
	}

	@Override
	public boolean register(Product product) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		//先判断用户名是否已经存在，如果已经存在，不可以注册，如果不存在，可以注册
		Product productFind = udi.findProductByPame(product.getPname());
		if(productFind!=null){//如果已经存在，不可以注册
			flag = false;
		}else{//如果不存在，可以注册
			udi.addProduct(product);
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Product> showAllProducts() throws SQLException {
		// TODO Auto-generated method stub
		return udi.findAllProducts();
	}

	@Override
	public boolean deleteProductByPid(int pid) throws SQLException {
		// TODO Auto-generated method stub
		return  udi.deleteProductByPid(pid);
	}

	@Override
	public boolean deleteProductByPid(String pidStr) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
