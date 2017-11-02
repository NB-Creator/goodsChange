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
	text-align: center;
	
}
.top {
	width: 100%;
	height: 50px;
	line-height: 50px;
	float: left;
	text-align: left;
	padding-left: 20%;
	background-color: rgb(63,68,72);
	color: rgb(250, 250, 250);
	font-size: 25px;
}

.dataInput {
	margin: 0 auto;
	width: 60%;
	text-align: center;
	color:rgb(25, 25, 25);
	background-color: rgb(240,240,255) ;
	padding-bottom: 30px;
}
</style>
</head>
<body>

	<div class="top">HUAN</div>
	<div class="dataInput">
		<h1>REGISTER</h1>
		<table
			style="border-collapse: separate; border-spacing: 0px 10px; margin: auto; text-align: right;">


			<tr>
				<td><label>昵称：</label></td>
				<td><input type="text" id="nickName" name="nickName"
					class="form-control" placeholder="请输入昵称"></td>
			</tr>

			<tr>
				<td><label>密码：</label></td>
				<td><input type="password" id="password" name="password"
					class="form-control" placeholder="输入密码"></td>
			</tr>



			<tr>
				<td><label>确认密码：</label></td>
				<td><input type="password" id="password2" name="password"
					class="form-control" placeholder="确认密码"></td>
			</tr>
			<tr>
				<td><label>姓名：</label></td>
				<td><input type="text" id="userName" name="userName"
					class="form-control" placeholder="姓名"></td>
			</tr>
			<tr>
				<td><label>生日：</label></td>
			</tr>
			<tr>
				<td>年:</td>
				<td>
					<div class="col-lg-6">
						<input type="text" id="year" class="form-control"
							placeholder="year">
					</div>
				</td>
			</tr>
			<tr>
				<td>月:</td>
				<td><div class="col-lg-6">
						<input type="text" id="month" class="form-control"
							placeholder="month">
					</div></td>
			</tr>
			<tr>
				<td>日:</td>
				<td><div class="col-lg-6">
						<input type="text" id="day" class="form-control" placeholder="Day">
					</div></td>
			</tr>
			<tr>
				<td><label>性别：</label></td>
				<td><input type="text" id="sex" name="sex" class="form-control"
					placeholder="性别"></td>
			</tr>

			<tr>
				<td><label>邮箱：</label></td>
				<td><input type="text" id="email" name="email"
					class="form-control" placeholder="邮箱"></td>
			</tr>
			<tr>
				<td><label>电话：</label></td>
				<td><input type="text" id="phone" name="phone"
					class="form-control" placeholder="电话"></td>
			</tr>


		</table>
		
		<div >
	<!-- /.row -->
	<label id="message"></label>
	<br>
	<button class="btn btn-info" type="button" onclick="login()">确认</button>
	</div>

	</div>
	<!-- /.col-lg-6 -->
	

</body>

<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	function login() {

		var nickName = document.getElementById('nickName').value;
		var userName = document.getElementById('userName').value;
		var password = document.getElementById('password').value;
		var password2 = document.getElementById('password2').value;
		var year = document.getElementById('year').value;
		var month = document.getElementById('month').value;
		var day = document.getElementById('day').value;
		var sex = document.getElementById('sex').value;
		var phone = document.getElementById('phone').value;
		var email = document.getElementById('email').value;

		var birth = year + "-" + month + "-" + day;
		$("#message").empty();
		if (nickName == "" || userName == "" || password == "" || year == ""
				|| month == "" || day == "" || sex == "" || phone == ""
				|| email == "") {
			$("#message").append("<br>请将信息填写完整<br><br>")
		} else if (password != password2) {
			$("#message").append("<br>两次密码不一样<br><br>")
		} else {
			$.ajax({
				url : '/PrySecret/addUser.do',
				type : 'post',
				dataType : 'text',
				data : {
					"userId" : 0,
					"nickName" : nickName,
					"userName" : userName,
					"password" : password,
					"sex" : sex,
					"birth" : birth,
					"email" : email,
					"phone" : phone
				},
				success : function(data) {
					if (data == "the phone exist") {
						alert("此手机号已注册，请重新输入");
					} else if (data == "the email exist") {
						alert("此邮箱已注册，请重新输入");
					} else if (data == "success") {
						self.location = "/PrySecret/regSuccess.do";

					}
				},
				error : function() {
					alert("出现预期之外的错误，请联系维护人员...");
				}
			});
		}
	}
</script>
</ html>