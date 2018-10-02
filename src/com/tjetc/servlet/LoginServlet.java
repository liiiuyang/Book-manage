package com.tjetc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjetc.domain.User;
import com.tjetc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		request.setCharacterEncoding("utf-8");
		//获取数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("获取的用户名："+username);
		System.out.println("获取的密码："+password);
		
		//模拟固定值，只有用户名是a密码是1的用户才可以登录到首页
		/*if(username.equals("a") && password.equals("1")){//可以登录,跳转到首页
			response.sendRedirect("index.jsp");
		}else{//不可以登录，跳转到注册或者是登录页面
			response.sendRedirect("login.jsp");
		}*/
		
		UserServiceImpl usi = new UserServiceImpl();
		User user=null;
		try {
			user = usi.login(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null){//用户存在可以登录,跳转到首页
			response.sendRedirect("index.jsp");
		}else{//用户不存在不可以登录,跳转到登录页面
			request.setAttribute("msg", "用户名不存在或者密码错误！");
			//response.sendRedirect("login.jsp");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
