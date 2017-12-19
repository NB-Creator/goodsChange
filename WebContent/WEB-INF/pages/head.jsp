<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/head.css">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
	<div class="head">
		<div class="head-dock">
			<ul>
				<li><c:if test="${empty sessionScope.user.nickname}"
						var="userExits">
						<a href="/loginPage"><span class="icon-user"></span>请登录</a>
					</c:if> <c:if test="${!empty sessionScope.user.nickname}" var="userExits">
						<a href="/userMainPage"><span class="icon-user"></span>${sessionScope.user.nickname}</a>
					</c:if></li>
				<li><span class="icon-envelope"></span>
					消息：${requestScope.nRead}</li>
				<li><c:if test="${!empty sessionScope.user.nickname}">
						<a href="/userQuit"><span class=" icon-off"> </span>退出</a>
					</c:if></li>
			</ul>

		</div>
		<div class="logo">
			<a href="/mainPage" style="color: rgb(255, 0, 45);">HLeB</a>
			<h4>环保生活就上换了呗</h4>
		</div>
		<div class="">
			<div class="col-lg-6"
				style="margin-top: 30px; color: rgb(255, 0, 45);">
				<div class="input-group"
					style="border: 3px solid red; outline: none;">
					<input type="text" class="form-control" id="inputNumber"
						placeholder="输入关键字搜索"
						style="border-radius: 0px; border: 0; outline: none;"> <span
						class="input-group-btn">
						<a href="./selectPage"><button class="btn btn-default" type="button"
							onclick="submitNumber()"
							style="background-color: red; color: white;">搜索</button></a>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
		</div>
		<!-- /.row -->


	</div>
	<!-- /.head -->
</body>
</html>