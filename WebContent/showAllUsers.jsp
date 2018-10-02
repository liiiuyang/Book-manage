<%@page import="com.tjetc.domain.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
	所有的用户信息如下：
	<table border="1px">
		<tr> 
			<td>用户编号</td>
			<td>用户名</td>
			<td>用户密码</td>
			<td>邮箱</td>
			<td>手机号</td>
			<td>地址</td>
			<td>操作</td>
		</tr>
	<%
		List<User> users = (List<User>)request.getAttribute("users");
		for(User user:users){
	%>
		<tr>
			<td><%=user.getUserid() %></td>
			<td><%=user.getUsername() %></td>
			<td><%=user.getPassword() %></td>
			<td><%=user.getMail() %></td>
			<td><%=user.getPhone() %></td>
			<td><%=user.getAddress() %></td>
			<td><a href="DeleteUserByUseridServlet?userid=<%=user.getUserid() %>">删除</a></td>
		</tr>
	  <%} %>
	  </table>
</body>
</html>