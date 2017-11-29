<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap-table.css">
<link type="text/css" rel="stylesheet" href="css/font-awesome.css">
<link type="text/css" rel="stylesheet" href="css/addItem.css">
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/myJs/addItem.js"></script>


<title>发布商品</title>
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="../head.jsp"></jsp:include>
	<!-- 按钮触发模态框 -->
	<div class="title">
		<span class="icon-edit"></span>填写商品基本信息
	</div>
	<div class="middle" style="overflow: auto;">
		<div class="parame">
			<span>商品名：</span><input type="text" id="name">
		</div>

		<div class="parame">
			<ul class="nav nav-tabs">
				<li class="dropdown" id="classification"><a
					class="dropdown-toggle" data-toggle="dropdown" href="#"
					style="padding: 0; color: black;"> 选择商品分类 <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">手机</a></li>
						<li><a href="#">电脑</a></li>
						<li><a href="#">衣物</a></li>
						<li><a href="#">书籍</a></li>
						<li><a href="#">游戏</a></li>
						<li><a href="#">运动</a></li>
						<li><a href="#">原创</a></li>
					</ul>
					<div id="s_type" style="margin-left: 50px;"></div></li>

			</ul>
		</div>

		<div class="parame">
			<span>商品描述：</span>
			<textarea id="detail" style="width: 100%; height: 200px;"
				placeholder="添加对商品的描述"></textarea>
		</div>
		<div class="parame">
			<span>添加商品图片（点击图片可删除）：</span> <br />
			<div class="photo" onclick="upImg()">
				点击上传图片 <img alt="" width=15% src=""> <input class="file"
					type="file" onchange="addImg(this)"></input>
			</div>

		</div>
		<div class="imgs" id="imgs"></div>

		<div class="parame">
			<span>输入一个保底价格：</span><input type="text" id="price">
		</div>
		<div class="parame">
			<span>输入一个期望商品：</span><input type="text" id="expect">
		</div>
		<div class="bt">
			<button type="button" class="btn btn-primary" onclick="addItem()"
				style="width: 100%; margin: 0;">发布</button>
		</div>

	</div>
	<div></div>

	<!-- /.modal-content -->

	<!-- /.modal -->

</body>



</html>