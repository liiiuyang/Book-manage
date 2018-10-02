<%@page import="com.tjetc.domain.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加书籍</title>
        <style type="text/css">
			#form{ margin:0 auto;text-align:center;}
		</style>
</head>
<body>
	            添加商品信息
	<form action="AddProductServlet" id="form">
		<table border="1px">
			<tr>
				<td>商品名</td>
				<td><input type="text" name="pname"/></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" name="price"/></td>
			</tr>
			<tr>
				<td>库存</td>
				<td><input type="text" name="num"/></td>
			</tr>	
			<tr>
				<td>选择要上传的图片</td>
				<td>
					<form action="SingleFileUploadServlet" method="post">
						<input type="file" name="photo"/><input type="submit" value="上传"/>
					</form>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="添加" id="btn1"/></td>
			</tr>
		</table>
	</form>
</body>
</html>