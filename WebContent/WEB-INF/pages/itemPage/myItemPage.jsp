<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的货架</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/font-awesome.css">
<link type="text/css" rel="stylesheet" href="css/userMainPagev1.css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-table.min.css">
<link rel="stylesheet" href="css/mytem.css">

<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-table.js"></script>
<script src="js/Soft1.js"></script>
<script src="js/soft2.js"></script>
<script src="js/soft3.js"></script>
<script src="js/soft4.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table.min.js"></script>
<script src="js/bootstrap-table-zh-CN.min.js"></script>
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="../head-top.jsp"></jsp:include>
	<div class="top">
		<div class="tl">
			<h1 style="color: white;">我的货架</h1>
		</div>

	</div>
	<!-- top -->

	<div class="right-data">
		<div>
			<ul class="tem_ul">
				<li><a class="a_1">所有订单</a></li>
				<li><a class="a_2">未发货</a></li>
				<li><a class="a_3">已发货</a></li>
				<li><a class="a_4">待评价</a></li>
			</ul>
		</div>
		<div class="div_">
			<div class="div_1" id="a_1" style="display: block;">
				<table id="tb_departments1" data-reorderable-columns="true"></table>
			</div>
			<div class="div_1" id="a_2">
				<table id="tb_departments2" data-reorderable-columns="true"></table>
			</div>
			<div class="div_1" id="a_3">
				<table id="tb_departments3" data-reorderable-columns="true"></table>
			</div>
			<div class="div_1" id="a_4">
				<table id="tb_departments4" data-reorderable-columns="true"></table>
			</div>
		</div>
	</div>

</body>

<script type="text/javascript">
	
</script>
</html>