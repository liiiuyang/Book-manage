<%@page import="com.tjetc.domain.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息</title>
</head>
<body>
所有的商品信息如下：
	<table border="1px">
		<tr>
			<td>商品编号</td>
			<td>商品名</td>
			<td>商品价格</td>
			<td>商品图片</td>
			<td>商品数量</td>
			<td>操作</td>
			
		</tr>
	<%
		List<Product> products = (List<Product>)request.getAttribute("products");
		for(Product product:products){
	%>
		<tr>
			<td><%=product.getpid() %></td>
			<td><%=product.getPname() %></td>
			<td><%=product.getPrice() %></td>
			<td><%=product.getPhoto() %></td>
			<td><%=product.getNum() %></td>
			<td><a href="DeleteProductByPidServlet?pid=<%=product.getpid() %>">删除</a></td>
			
		</tr>
	  <%} %>
  </table>

</body>
</html>