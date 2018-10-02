package com.tjetc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjetc.domain.User;
import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ShowUsersByPageNumServlet
 */
public class ShowUsersByPageNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUsersByPageNumServlet() {
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
		String pageNumStr = request.getParameter("pageNum");
		String pageSizeStr = request.getParameter("pageSize");
		System.out.println(pageNumStr+"===="+pageSizeStr);
		//将String类型转换为int类型
		int  pageNum = Integer.parseInt(pageNumStr);
		int  pageSize = Integer.parseInt(pageSizeStr);
		
		UserService usi = new UserServiceImpl();
		List<User> users = null;
		try {
			users = usi.findUsersByPageNum(pageNum, pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//计算总页数
		int pageNumAll = 0;
		int usersNum=0;
		try {
			usersNum = usi.countAllUsersNum();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(usersNum/5==0){
			pageNumAll=usersNum/5;
		}else{
			pageNumAll=usersNum/5+1;
		}
		System.out.println("一共需要"+pageNumAll+"页显示用户信息");
		
		request.setAttribute("users", users);
		request.setAttribute("pageNumAll", pageNumAll);
		request.getRequestDispatcher("showUsersByPageNum.jsp").forward(request, response);
		
	}

}
