<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<style type="text/css">
body, div, form, img, ul, ol, li, dl, dt, dd, form, p, h1 {
	margin: 0px;
	padding: 0px;
	border: 0px none;
	list-style: none outside none;
	text-decoration: none;
}

body {
	background-image: url("images/uLog.jpg");
}

.div_1 {
	width: 100%;
	height: 800px;
}

.left {
	float: left;
	width: 45%;
	height: 100%;
	line-height: 100px;
	background-color: rgba(155, 0, 0, 0.1);
	color: darkorange;
	border-bottom: solid 1px darkblue;
	width: 45%;
}

img {
	width: 100%;
	height: 100%;
	
	float: left;
}

.right {
	width: 55%;
	height: 100%;
	float: right;
	background-color: rgba(240, 240, 240, 0.5);
}

.right_top {
	height: 20%;
	width: 100%;
	float: right;
	width: 100%;
	text-align: right;
	margin: 10px;
}

.login_box {
	width: 100%;
	height: 280px;
	text-align: center;
}

.login_box input {
	/*padding: 5px;
		font-size: 18px;
		width: 314px;
		margin-bottom: 5px;*/
	height: 50px;
	width: 400px;
	border: 1px solid #ccc;
	padding: 0 10px;
	font: 20px/1.6 tahoma, arial, sans-serif;
	display: inline-block;
	text-align: start;
	-webkit-writing-mode: horizontal-tb;
	margin-top: 20px;
	border-radius: 5px;
}

.login_box_tab {
	height: 50px;
	border-bottom: solid 1px #EFEFEF;
	margin-bottom: 2px;
}

.login_box  .btn {
	width: 400px;
	height: 50px;
	line-height: 40px;
	text-align: center;
	background-color: antiquewhite;
	font-size: 14px;
	border: 1px solid #ccc;
	border-radius: 5px;
	margin-top: 20px;
}

a {
	color: black;
	padding: 5px;
	text-decoration:none;
}

a:link {
	text-decoration: none;
	color:black;
}

a:visited {
	border: 1px solid white;
	color:black;
	border-radius: 5px;
	margin: 5px;
	text-decoration: none;
}

a:hover {
	border: 1px solid white;
	color:black:;
	border-radius: 5px;
	margin: 5px;
	text-decoration: none;
}

a:active {
	text-decoration: none;
	color:black;
}
</style>
</head>
<body>
	<div class="div_1" id="div_1">
		<div class="left"></div>
		<div class="right">
			<div class="right_top">
				<button type="button" class="btn btn-info" ></button><a href="./mainPage">进入首页</a>
				<button type="button" class="btn btn-info" ></button><a href="./registerPage">注册帐号</a>
				<button type="button" class="btn btn-info"></button><a href="#">找回密码</a>
			</div>
			<div class="login_box">
				<h1>HLB</h1>
				<p>welcome to huanlebe</p>
				<form name="form1">
					<div class="login_box_tab"></div>
					<input type="text" id="loginNumber" name="loginNumber"
						placeholder="plese enter id" />
					<div id="loginstate1"></div>
					<input type="text" onfocus="this.type='password'" id="userPwd"
						name="userPwd" placeholder="password" />
					<div id="loginstate2"></div>
					<A></A>
					<div class="btn" onclick="login()" >登录</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	function login() {
		$("#loginstate1").empty();
		$("#loginstate2").empty();
		var login = document.getElementById('loginNumber').value;

		var password = document.getElementById('userPwd').value;

		if (login == "") {
			$("#loginstate1").append("<br>帐号不能为空<br>");
		}
		if (password == "") {
			$("#loginstate2").append("<br>密码不能为空<br>");
		}

		$.ajax({
			url : "./login",
			type : 'post',
			dataType : 'text',
			data : {
				'username' : login,
				'password' : password
			},
			success : function(msg) {
				if(msg=="FALSE")
					alert(msg);
				else if(msg=="SUCCESS")
					self.location="./mainPage";
			},
			erro : function() {

			}

		});

	}

	function register() {

		self.location = "";

	}
</script>
</html>
