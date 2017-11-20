<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/head.css">
<title>Insert title here</title>
</head>
<body>
	<div class="head">
		<div class="logo">
			<a href="./mainPage" style="color:rgb(255, 0, 45);"><h1>HLB</h1></a>
			<h4>环保生活就上换了呗</h4>
		</div>
		<div class="">
			<div class="col-lg-4"
				style="margin-top: 30px; color: rgb(255, 0, 45);">
				<div class="input-group">
					<input type="text" class="form-control" id="inputNumber"
						placeholder="输入关键字搜索"> <span class="input-group-btn">
						<button class="btn btn-default" type="button"
							onclick="submitNumber()">搜索</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
		</div>
		<!-- /.row -->

		<ul>
			<li ><span class="icon-user"></span>
				<div id="uName">
					<c:if test="${empty sessionScope.user.nickname}" var="userExits">
						<a href="./loginPage">请登录</a>
					</c:if>
					<a href="./userMainPage">${sessionScope.user.nickname}</a>
				</div></li>
			<li><span class="icon-envelope"></span>
				<div id="eData">消息：${requestScope.nRead}</div></li>
			<li><span class=" icon-off"> </span> <c:if
					test="${!empty sessionScope.user.nickname}">
					<a href="./userQuit">退出</a>
				</c:if></li>
		</ul>

	</div>
	<!-- /.head -->
</body>
</html>