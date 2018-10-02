package com.tjetc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DeleteUserByUseridServlet
 */
public class DeleteUserByUseridServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserByUseridServlet() {
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
		String useridStr = request.getParameter("userid");
		System.out.println(useridStr);
		// 将String类型转化为int
		int userid = Integer.parseInt(useridStr);
		
		System.out.println("接收到的userid="+userid);
		// 创建对象 
		UserService us = new UserServiceImpl();
		boolean flag = false;
		// 调用service层的删除数据的方法
		try {
			flag = us.deleteUserByUserid(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("是否删除成功："+flag);
		// 页面跳转
		if(flag==true){
			request.getRequestDispatcher("ShowAllUsersServlet").forward(request, response);
			
		}
	}

}
