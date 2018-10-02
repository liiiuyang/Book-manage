package com.tjetc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjetc.dao.ProductDAO;
import com.tjetc.dao.impl.ProductDAOImpl;
import com.tjetc.domain.Product;

/**
 * Servlet implementation class showAllProductServlet
 */
public class showAllProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showAllProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO productDAO = new ProductDAOImpl();
		List<Product> products = null;
		 try {
			products= productDAO.findAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("查询到的数据的个数是："+products.size());
		//把数据放入到属性中
		request.setAttribute("products", products);
		//跳转页面
		request.getRequestDispatcher("showAllProduct.jsp").forward(request, response);
	}

}
