<%@page import="com.tjetc.domain.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息分页</title>
</head>
<body>
	当前页的用户信息如下：
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
	  总页数：<%=request.getAttribute("pageNumAll") %><br/>
		  <a href="ShowUsersByPageNumServlet?pageNum=1&pageSize=5">首页</a>
			 <%	Object obj = request.getAttribute("pageNumAll");
			    String str = obj.toString();
			 	int pageNumAll = Integer.parseInt(str);
			 	for(int i=1;i<=pageNumAll;i++){ %>
			 		<a href="ShowUsersByPageNumServlet?pageNum=<%=i %>&pageSize=5"><%=i %></a>
			  <%} %>
         <a href="ShowUsersByPageNumServlet?pageNum=${pageNumAll}&pageSize=5">末页</a>

</body>
</html>