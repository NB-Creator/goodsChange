<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
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
	width: 100%;
	height: 800px;
	background-color: rgb(232, 232, 232);
}

.top {
	width: 100%;
	height: 50px;
	line-height: 50px;
	float: left;
	text-align: left;
	padding-left: 20%;
	background-color: rgb(63,68,72);
	color: rgb(250, 251, 251);
	font-size: 25px;
}

.middle {
	width: 60%;
	height: 60%;
	float: left;
	margin-left: 20%;
	margin-right: 20%;
	background-color: rgb(250, 255, 255);
	text-align: center;
}

.middle h1 {
	margin-top: 20%;
	margin-bottom: 10%;
	font-family: "Microsoft YaHei";
	color: rgb(152, 20, 20);
	border-bottom: solid 1px darkblue;
}

.middle p {
	font-size: 20px;
	color: #666;
}

a:link {
	text-decoration: none;
	color: rgb(255, 255, 255);
}

a:visited {
	text-decoration: none;
	color: rgb(255, 255, 255);
}

a:hover {
	text-decoration: none;
	color: rgb(255, 255, 255);
}

a:active {
	text-decoration: none;
	color: rgb(255, 255, 255);
}
</style>
</head>

<body
	onload="javascript:window.resizeTo(screen.availWidth,screen.availHeight)">

	<div class="top">KUIMI</div>
	<div class="middle">
		<h1>恭喜您已成功注册KUIMI账号</h1>
		<p>您的帐号为:${requestScope.user.userId}</p>
		<br>
		<button type="button" class="btn btn-info" onclick="intToMain()"><a href="/PrySecret/mainForm.do"> 进入KUIMI</a></button>
	</div>
	<div class="bottom"></div>
</body>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	function inToMain(){
		$.post("");
		
	}
</script>
</html>
