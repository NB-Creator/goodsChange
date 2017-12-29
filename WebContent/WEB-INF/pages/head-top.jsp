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
	height: 35px;
	line-height: 35px;
	background-color: rgb(242, 242, 242);
	border-bottom: 1px solid black;
	padding-left: 70px;
	color: #669;
	font-weight: 300;
	font-size: 15px;
}

.head-top ul {
	float: right;
	list-style: none;
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
	float: left;
	color: black;
	line-height: 35px;
}

.head-top #uName, #eData {
	float: right;
	color: #669;
	margin-left: 10px;
}

#ul li, #ul a {
	float: none;
	color: white;
}

#ul li, #ul  a:link {
	
} /* 未访问链接*/
#ul li, #ul  a:visited {
	
} /* 已访问链接 */
#ul li, #ul  a:hover {
	color: black;
} /* 鼠标移动到链接上 */
#ul li, #ul  a:active {
	color: #0000FF;
} /* 鼠标点击时 */
</style>
</head>
<body>
	<div class="head-top">
		<a href="/mainPage"
			style="color: red; font-weight: 500; font-size: 20px; font-style: italic;"><span
			class="icon-home"></span>HLB</a>
		<ul>
			<li class="dropdown" style="margin-right:100px;"><span class="icon-user"></span>
				<div id="uName" class="dropdown">
					<c:if test="${empty sessionScope.user.nickname}" var="userExits">
						<a href="/loginPage">请登录</a>
					</c:if>
					<c:if test="${!empty sessionScope.user.nickname}" var="userExits">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.user.nickname}</a>
						<b class="caret"></b>
						<br>
						<ul class="dropdown-menu" id="ul"
							style="z-index: 999; background: rgba(0, 0, 0, 0.8);">
							<li><a href="/admin/userMainPage"><span
									class="icon-user"></span>用户中心</a></li>
							<li><a href="/admin/myCollectPage"><span
									class="icon-folder-open"></span>我的收藏</a></li>

							<li><a href="/admin/message" id="msg"><span
									class="icon-comment-alt"></span></a></li>
							<li><a href="/logout"><span class=" icon-off"> </span>注销</a></li>
							<!-- <li class="divider"></li>
								<li><a href="#">分离的链接</a></li>
								<li class="divider"></li>
								<li><a href="#">另一个分离的链接</a></li> -->
						</ul>
					</c:if>
				</div></li>
		</ul>

	</div>
</body>

<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "/unread",
			type : "get",
			dataType : "text",
			success : function(data) {
				$("#msg").append("消息：" + data);
			},
			erro : function() {

			}

		});

	});
</script>
</html>