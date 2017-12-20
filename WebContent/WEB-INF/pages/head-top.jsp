<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.head-top {
	width: 100%;
	height:35px;
	line-height:35px;
	background-color: rgb(242, 242, 242);
	border-bottom: 1px solid red;
	padding-left:70px;
	color: #669;
	font-weight: 300;
	font-size: 15px;
	
	
}

.head-top ul {
	float: right;
	list-style:none;
}

.head-top ul li {
	float: left;
	font-family: "微软雅黑";
	font-style: inherit;
	font-weight: 10000;
	
	margin-right: 30px;
}

.head-top a {
	text-decoration: none;
	float:left;
	color: black;
	line-height:35px;
}

.head-top a:link {
	text-decoration: none;
	color: black;
}

.head-top a:visited {
	border: 1px solid white;
	color: grey;
	border-radius: 5px;
	margin: 5px;
	text-decoration: none;
}

.head-top a:hover {
	
}

.head-top a:active {
	text-decoration: none;
	color: black;
}

.head-top #uName, #eData {
	float: right;
	color: #669;
	margin-left: 10px;
}
</style>
</head>
<body>
	<div class="head-top">
		<a href="/mainPage" style="color:red;font-weight: 500;font-size: 20px;font-style: italic;"><span class="icon-home" ></span>HLB</a>
		<ul>
			<li><span class="icon-user"></span>
				<div id="uName">
					<c:if test="${empty sessionScope.user.nickname}" var="userExits">
						<a href="/loginPage">请登录</a>
					</c:if>
					<a href="/userMainPage">${sessionScope.user.nickname}</a>
				</div></li>
			<li><span class="icon-envelope"></span>
				<div id="eData">消息：${requestScope.nRead}</div></li>
			<li><span class=" icon-off"> </span> <c:if
					test="${!empty sessionScope.user.nickname}">
					<a href="/userQuit">退出</a>
				</c:if></li>
		</ul>

	</div>
</body>
</html>