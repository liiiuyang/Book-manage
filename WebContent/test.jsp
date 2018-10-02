<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="HelloServlet">访问HelloServlet</a>
	<hr/>
	<form action="HelloServlet" method="post" id="form1" name="form1">
		<table border="1px" width="400px" height="200px" align="center">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="登录" id="btn1"/></td>
			</tr>
		</table>
	</form>
	<hr/>
	<form action="HelloServlet" method="get" id="form1" name="form1">
		<table border="1px" width="400px" height="200px" align="center">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="登录" id="btn1"/></td>
			</tr>
		</table>
	</form>
</body>
</html>