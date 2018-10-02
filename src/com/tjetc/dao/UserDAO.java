package com.tjetc.dao;

import java.sql.SQLException;
import java.util.List;

import com.tjetc.domain.User;

public interface UserDAO {
	//添加用户的方法
	//public abstract boolean addUser(User user) throws SQLException;
	boolean addUser(User user) throws SQLException;
	//获取所有的用户信息
	List<User> findAllUsers() throws SQLException;
	//根据用户的id删除当前用户
	boolean deleteUserByUserid(int userid) throws SQLException;
	//根据用户的username查询当前用户信息
	User findUserByUsername(String username) throws SQLException;
	//根据用户名和密码查询当前用户信息
	User findUserByUsernameAndPassword(String username,String password) throws SQLException;
	//查询某页数据
	List<User> findUsersByPageNum(int pageNum,int pageSize) throws SQLException;
	//用户总数据量
	int countAllUsersNum() throws SQLException;
}
