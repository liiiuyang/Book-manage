package com.tjetc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjetc.domain.Product;
import com.tjetc.service.ProductService;
import com.tjetc.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		//设置编码方式
		request.setCharacterEncoding("utf-8");
		
		//获取数据
		String pname = request.getParameter("pname");
		String price = request.getParameter("price");
		String photo = request.getParameter("photo");
		String num = request.getParameter("num");

		System.out.println(pname+price+photo+num);
		//将数据放入到数据库中
		//创建UserService对象
		ProductService ps = new ProductServiceImpl();
		//创建User对象
		Product product = new Product(pname,price,photo,num);
		boolean flag = false;
		try {
			flag = ps.register(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("添加成功："+flag );
		
		if(flag==true){
			response.sendRedirect("showAllProduct.jsp");
		}else{
			request.setAttribute("msg", "商品名已经存在");
			request.getRequestDispatcher("addProduct.jsp").forward(request, response);;
		}
		
	}

}
