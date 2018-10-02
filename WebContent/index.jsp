<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">
			* { margin: 0px; padding: 0px;}
			#container { width:100% ; height:600px ;}
			#header { width:100% ; height:150px ; background:url(images/header.png);}
			#main {width:80% ; height:650px ; margin: 0 auto; margin-top: 10px; background:url(images/main.jpg);font-family:SimSun;}
			#foot {width:100% ; height:120px ; margin-top:10px ;background:url(images/foot.jpg);}
			#left { width:70% ; height:650px ; float: left;text-align:center;color: #ff0033;} 
			#right { width:30% ; height:650px ; background:;float: left;} 
			#logo { width: 150px; height:150px ; float: left; margin-left:300px ;}
			#nav { width: 800px; height:150px ; float: left; margin-left: 150px;font-family:SimSun;}
			#notice{font-size: 22px; color:#fff;}
			#copy{ width: 500px; height:30px ; font-size: 16px; color: #fff; margin-left: 750px;float: left;margin-top: 50px;text-align:center;}
			#live{ width: 500px; height:30px ; font-size: 16px;margin-left: 750px;float: left;margin-top: 50px;text-align:center;}
			ul{ list-style: none;}
			li{ float: left; padding-left:30px ; line-height: 150px; font-size: 18px;color: orange;}
			a{font-size: 20px; line-height: 1.4; color: orange;}
</style>
<body>
	<div id="container">
			<div id="header">
				<div id="logo">
					<img src="images/logo.jpg"/>
				</div>
				<div id="nav">
					<ul>
						<li>首页</li>
						<li><a href="login.jsp" target="_blank">登录</a></li>
						<li><a href="register.jsp" target="_blank">注册</a></li>
						<li><a href="#" target="_blank">评价</a></li>
						<li><a href="#" target="_blank">个人中心</li>
						<li><a href="#" target="_blank">帮助</li>

					</ul>
				</div>
			</div>
			<div id="main">
				<div id="left" >
				    <span id="live">
					    <a href="ShowAllUsersServlet">显示所有的用户信息</a><br/>
						<a href="showAllProductServlet">显示所有的商品信息</a><br/>
						<a href="ShowUsersByPageNumServlet?pageNum=1&pageSize=5">按分页技术查询用户信息</a><br/>
						<a href="addProduct.jsp">添加书籍信息</a><br/>
					</span>			
				</div>
				<div id="right">
				    <marquee id="notice" direction="up" onMouseOut=this.start() onMouseOver=this.stop()>
						公告信息<br/>
						&thinsp; &thinsp; 本月30日，BUG网上书店即将迎来开店一周年。为了感谢广大日本原版书籍爱好者对我店的支持，将举行9月限定优惠活动~！<br/>
			            &thinsp; &thinsp;活动时间：2018年9月30日~2018年10月10日<br/>
			            &thinsp; &thinsp;内容：<br/>
			            &thinsp; &thinsp;1.面向来店客人：向一次性购买100元以上书籍的客人赠送20元商品卷。（注意：该商品购书当日不可使用。）<br/>
			            &thinsp; &thinsp;2.面向网购客人：一次性购买100元以上书籍的交易，将免快递费。<br/>
			            &thinsp; &thinsp;欢迎大家能利用这个机会，购买到自己喜欢的日本原版书籍~！				
					</marquee>
					
				</div>
			</div>
			<div id="foot">
				<span id="copy">Copyright &copy; 2018.Bug.bookstore 版权所有</span>
			</div>
		</div>
</body>
</html>