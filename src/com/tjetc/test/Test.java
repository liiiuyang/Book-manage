package com.tjetc.test;

import java.sql.SQLException;

import com.tjetc.dao.impl.UserDAOImpl;
import com.tjetc.domain.User;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		UserDAOImpl udi = new UserDAOImpl();
		
		User user = udi.findUserByUsernameAndPassword("bbbb", "2");
		System.out.println("查询的用户信息是："+user);
		
	}

}
