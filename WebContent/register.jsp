<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" >
<title>注册</title>
<link rel="stylesheet" href="css/style.css">
<body style="background-image: url('images/backgroud.jpg');">

<div class="register-container">	
	<div>
		<p>注册信息</p>
	</div>
	
	<form action="RegisterServlet" method="post" id="registerForm">
		<div>
			<input type="text" name="username" class="username" placeholder="您的用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="text" name="phone" class="phone_number" placeholder="输入手机号码" autocomplete="off" id="number"/>
		</div>
		<div>
			<input type="mail" name="mail" class="email" placeholder="输入邮箱" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="address" name="address" class="address" placeholder="输入收货地址" oncontextmenu="return false" onpaste="return false" />
		</div>

		<button id="submit" type="submit">注 册</button>
	</form>
	<a href="index.jsp">
		<button type="button" class="register-tis">已经有账号？</button>
	</a>

</div>
</body>

</html>