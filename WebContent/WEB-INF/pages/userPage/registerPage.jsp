<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<style type="text/css">
body, div, form, img, ul, ol, li, dl, dt, dd, form, p, h1 {
	margin: 0px;
	padding: 0px;
	border: 0px none;
	list-style: none outside none;
	text-decoration: none;
}

body {
	text-align: center;
}

.top {
	width: 100%;
	height: 50px;
	line-height: 50px;
	float: left;
	text-align: left;
	padding-left: 20%;
	background-color: rgb(63, 68, 72);
	color: rgb(250, 250, 250);
	font-size: 25px;
}

.dataInput {
	margin: 0 auto;
	width: 60%;
	text-align: center;
	color: rgb(25, 25, 25);
	background-color: rgb(240, 240, 255);
	padding-bottom: 30px;
}
</style>
</head>
<body>

	<div class="top">用户注册</div>
	<div class="dataInput">
		<h3>请输入下列信息</h3>
		<table
			style="border-collapse: separate; border-spacing: 0px 10px; margin: auto; text-align: right;">

			<tr>
				<td><input type="text" id="username" name="username"
					class="form-control" placeholder="帐号"></td>
			</tr>
			<tr>
				<td><input type="password" id="password" name="password"
					class="form-control" placeholder="输入密码"></td>
			</tr>
			<tr>
				<td><input type="password" id="password2" name="password"
					class="form-control" placeholder="确认密码"></td>
			</tr>
			<tr>
				<td><input type="text" id="nickname" name="nickname"
					class="form-control" placeholder="请输入昵称"></td>
			</tr>
			<tr>
				<td><input type="text" id="name" name="name"
					class="form-control" placeholder="姓名"></td>
			</tr>
			<tr>
				<td><input type="text" id="address" name="address"
					class="form-control" placeholder="地址"></td>
			</tr>
			<tr>
				<td><input type="text" id="mail" name="mail"
					class="form-control" placeholder="邮箱"></td>
			</tr>
		</table>

		<div>
			<!-- /.row -->
			<label id="message"></label> <br>
			<button class="btn btn-info" type="button" onclick="login()">提交信息</button>
		</div>

	</div>
	<!-- /.col-lg-6 -->


</body>

<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	function login() {

		var username = document.getElementById('username').value;
		var nickname = document.getElementById('nickname').value;
		var password = document.getElementById('password').value;
		var password2 = document.getElementById('password2').value;
		var name = document.getElementById('name').value;
		var address = document.getElementById('address').value;
		var mail = document.getElementById('mail').value;
		$("#message").empty();
		if (nickname == "" || username == "" || password == "" || name == ""
				|| address == "" || mail == "") {
			$("#message").append("<br>请将信息填写完整<br><br>")
		} else if (password != password2) {
			$("#message").append("<br>两次密码不一样<br><br>")
		} else {
			$.ajax({
				url : './register',
				type : 'post',
				dataType : 'text',
				data : {
					"username" : username,
					"nickname" : nickname,
					"name" : name,
					"password" : password,
					"address" : address,
					"mail" : mail
				},
				success : function(data) {
					 if (data == "SUCCESS") {
						 alert("恭喜您注册成功，点击确定跳转到登录页面")
						self.location = "./loginPage";
					}else {
						
						alert(data);
					}
				},
				error : function() {
					alert("出现预期之外的错误，请联系维护人员...");
				}
			});
		}
	}
</script>
</html>