package com.tjetc.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.tjetc.dao.UserDAO;
import com.tjetc.dao.impl.UserDAOImpl;
import com.tjetc.domain.User;
import com.tjetc.service.UserService;

public class UserServiceImpl implements UserService {
	UserDAO udi = new UserDAOImpl();

	@Override
	public User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		//UserDAOImpl udi = new UserDAOImpl();
		//UserDAO udi = new UserDAOImpl();
		return udi.findUserByUsernameAndPassword(username, password);
	}

	@Override
	public boolean register(User user) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		//先判断用户名是否已经存在，如果已经存在，不可以注册，如果不存在，可以注册
		User userFind = udi.findUserByUsername(user.getUsername());
		if(userFind!=null){//如果已经存在，不可以注册
			flag = false;
		}else{//如果不存在，可以注册
			udi.addUser(user);
			flag = true;
		}
		return flag;
	}

	@Override
	public List<User> showAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		return udi.findAllUsers();
	}

	@Override
	public boolean deleteUserByUserid(int userid) throws SQLException {
		// TODO Auto-generated method stub
		return udi.deleteUserByUserid(userid);
	}

	@Override
	public List<User> findUsersByPageNum(int pageNum, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		return udi.findUsersByPageNum(pageNum, pageSize);
	}

	@Override
	public int countAllUsersNum() throws SQLException {
		// TODO Auto-generated method stub
		return udi.countAllUsersNum();
	}

	@Override
	public boolean checkUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag=false;
		User user =  udi.findUserByUsername(username);
		if(user==null){
			flag=true;
		}
		return flag;
	}

}
