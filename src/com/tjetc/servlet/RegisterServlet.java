package com.tjetc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjetc.domain.User;
import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		System.out.println(username);
		System.out.println(username+password+mail+phone+address);
		
		//将数据放入到数据库中
		//创建UserService对象
		UserService us = new UserServiceImpl();
		//创建User对象
		User user = new User(username,password,mail,phone,address);
		boolean flag = false;
		try {
			flag = us.register(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("注册成功："+flag );
		
		if(flag==true){
			response.sendRedirect("login.jsp");
		}else{
			request.setAttribute("msg", "用户名已经存在");
			request.getRequestDispatcher("register.jsp").forward(request, response);;
		}
		
	}

}
