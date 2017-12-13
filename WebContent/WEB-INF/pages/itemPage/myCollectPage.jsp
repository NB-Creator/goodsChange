<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我提交的请求</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/font-awesome.css">
<link type="text/css" rel="stylesheet" href="css/userMainPagev1.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-table.js"></script>
<style type="text/css">

</style>

</head>
<body>
<jsp:include page="../head.jsp"></jsp:include>
	<div class="top">
		<div class="tl">
			<h1 style="color: white;">${sessionScope.user.nickname}的收藏</h1>
		</div>
		
	</div>
	<!-- top -->
	<div class="left-menu">
		<div class="menu-param" >
			<ul>
				<li><a href="./userMainPage">全部功能</a></li>
			</ul>
		</div>
		<!-- menu-param -->
		<div class="menu-param">
			<ul>
				<li><a href="./userMainPage">个人信息</a></li>
			</ul>
		</div>
		<!-- menu-param -->
		<div class="menu-param">
			<ul>
				<li><a href="#">我的货架</a></li>
			</ul>
		</div>
		<!-- menu-param -->
		<div class="menu-param">
			<ul>
				<li><a href="#">交易记录</a></li>
			</ul>
		</div>
		<!-- menu-param -->
		<div class="menu-param">
			<ul>
				<li><a href="./addItemPage">发布商品</a></li>
			</ul>
		</div>
		<!-- menu-param -->
		<div class="menu-param" style="background-color: rgb(245, 245, 245);">
			<ul>
				<li><a href="./myCollectPage">我的收藏</a></li>
			</ul>
		</div>
		<!-- menu-param -->
		<div class="menu-param">
			<ul>
				<li><a href="#">待处理的</a></li>
			</ul>
		</div>
		<!-- menu-param -->
		<div class="menu-param" >
			<ul >
				<li ><a href="./mySubmitPage">我提交的</a></li>
			</ul>
		</div>
		<!-- menu-param -->
		<div class="menu-param" >
			<ul>
				<li><a href="#">消息通知</a></li>
			</ul>
		</div>
		<!-- menu-param -->
	</div>
	<!-- left-menu -->
	<div class="right-data">
        <div class="row">
		  	<div class="col-sm-3 col-md-4">
		    	<div class="thumbnail">
		     		<img src="..." alt="..." style="width:200px;height:195px">
		      		<div class="caption">
		        		<h3>商品名称</h3>
		        		<p>商品价格：10￥</p>
		      		</div>
		    	</div>
		  	</div>
		  	
		  	<div class="col-sm-3 col-md-4">
		    	<div class="thumbnail">
		     		<img src="..." alt="..." style="width:200px;height:195px">
		      		<div class="caption">
		        		<h3>商品名称</h3>
		        		<p>商品价格：10￥</p>
		      		</div>
		    	</div>
		  	</div>
		  	
		  	<div class="col-sm-3 col-md-4">
		    	<div class="thumbnail">
		     		<img src="..." alt="..." style="width:200px;height:195px">
		      		<div class="caption">
		        		<h3>商品名称</h3>
		        		<p>商品价格：10￥</p>
		      		</div>
		    	</div>
		  	</div>
		</div>
		
		<div class="row">
		  	<div class="col-sm-3 col-md-4">
		    	<div class="thumbnail">
		     		<img src="..." alt="..." style="width:200px;height:195px">
		      		<div class="caption">
		        		<h3>商品名称</h3>
		        		<p>商品价格：10￥</p>
		      		</div>
		    	</div>
		  	</div>
		  	
		  	<div class="col-sm-3 col-md-4">
		    	<div class="thumbnail">
		     		<img src="..." alt="..." style="width:200px;height:195px">
		      		<div class="caption">
		        		<h3>商品名称</h3>
		        		<p>商品价格：10￥</p>
		      		</div>
		    	</div>
		  	</div>
		  	
		  	<div class="col-sm-3 col-md-4">
		    	<div class="thumbnail">
		     		<img src="..." alt="..." style="width:200px;height:195px">
		      		<div class="caption">
		        		<h3>商品名称</h3>
		        		<p>商品价格：10￥</p>
		      		</div>
		    	</div>
		  	</div>
		</div>
		
		<div class="row">
		  	<div class="col-sm-3 col-md-4">
		    	<div class="thumbnail">
		     		<img src="..." alt="..." style="width:200px;height:195px">
		      		<div class="caption">
		        		<h3>商品名称</h3>
		        		<p>商品价格：10￥</p>
		      		</div>
		    	</div>
		  	</div>
		  	
		  	<div class="col-sm-3 col-md-4">
		    	<div class="thumbnail">
		     		<img src="..." alt="..." style="width:200px;height:195px">
		      		<div class="caption">
		        		<h3>商品名称</h3>
		        		<p>商品价格：10￥</p>
		      		</div>
		    	</div>
		  	</div>
		  	
		  	<div class="col-sm-3 col-md-4">
		    	<div class="thumbnail">
		     		<img src="..." alt="..." style="width:200px;height:195px">
		      		<div class="caption">
		        		<h3>商品名称</h3>
		        		<p>商品价格：10￥</p>
		      		</div>
		    	</div>
		  	</div>
		</div>
    </div>  

</body>
<script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	
</script>
</html>