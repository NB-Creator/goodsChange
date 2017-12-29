<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet" href="/css/head.css">
<title>Insert title here</title>
<style type="text/css">
.dropdown-menu{
	margin-right:100px;
}
#ul li, #ul a {
	float: none;
}
#inputNumber::-webkit-input-placeholder{
        color: black;
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
	<div class="head">
		<div class="head-dock">
			<ul>
				<li class="dropdown" style="margin-right:100px;">
					<div id="uName" class="dropdown">
						<c:if test="${empty sessionScope.user.nickname}" var="userExits">
							<a href="/loginPage"><span class="icon-user"></span>请登录</a>
						</c:if>
						<c:if test="${!empty sessionScope.user.nickname}" var="userExits">

							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span
								class="icon-user"></span>${sessionScope.user.nickname}</a>
							<b class="caret"></b>
							<br>
							<ul class="dropdown-menu" id="ul"
								style="z-index: 999; background: rgba(0, 0, 0, 0.8);">
								<li><a href="/admin/userMainPage"><span class="icon-user"></span>用户中心</a></li>
								<li><a href="/admin/myCollectPage"><span
										class="icon-folder-open"></span>我的收藏</a></li>
								<li ><a href="/admin/message" id="msg"><span 
										class="icon-comment-alt"></span></a></li>
								<li><a href="/logout"><span class=" icon-off">
									</span>注销</a></li>
								<!-- <li class="divider"></li>
								<li><a href="#">分离的链接</a></li>
								<li class="divider"></li>
								<li><a href="#">另一个分离的链接</a></li> -->
							</ul>
						</c:if>
					</div>
				</li>
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
						style="border-radius: 0px; border: 0; outline: none; background: rgba(245, 245, 245, 0.5); color: white;">
					<span class="input-group-btn"> <a href="./selectPage"><button
								class="btn btn-default" type="button" onclick="submitNumber()"
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
<script type="text/javascript">
$(function(){
	$.ajax({
		url:"/unread",
		type:"get",
		dataType:"text",
		success:function(data){
			$("#msg").append("消息："+data);
		},
		erro:function(){
			
		}
		
	});
	
});
</script>
</html>