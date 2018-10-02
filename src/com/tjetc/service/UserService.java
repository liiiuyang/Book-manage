package com.tjetc.service;

import java.sql.SQLException;
import java.util.List;

import com.tjetc.domain.User;

public interface UserService {
	//登录方法
	User login(String username,String password) throws SQLException ;
	//注册方法
	boolean register(User user) throws SQLException ;
	//显示所有用户的方法
	List<User> showAllUsers() throws SQLException ;
	//删除用户方法
	boolean deleteUserByUserid(int userid) throws SQLException;
	//按分页方式查询数据
	List<User> findUsersByPageNum(int pageNum,int pageSize) throws SQLException;
	//用户总数据量
	int countAllUsersNum() throws SQLException;
	//验证用户名是否可以使用
	boolean checkUsername(String username) throws SQLException;
}
