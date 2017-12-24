<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我提交的请求</title>
<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/css/font-awesome.css">
<link type="text/css" rel="stylesheet" href="/css/userMainPagev1.css">
<link rel="stylesheet" type="text/css" href="/css/bootstrap-table.min.css">
<link rel="stylesheet" href="/css/mytem.css">
<script src="/js/jquery-3.1.1.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="/js/bootstrap-table.min.js"></script>
        <script src="/js/bootstrap-table-zh-CN.min.js"></script>
        <script src="/js/Soft.js"></script>
</head>
<body>
<jsp:include page="../head.jsp"></jsp:include>
	<div class="top">
		<div class="tl">
			<h1 style="color: white;">交易记录</h1>
		</div>
		
	</div>
	<!-- top -->
	<div class="right-data">
		<div>全部交易</div>
        <div><table id="tb_departments" data-reorderable-columns="true"></table></div>
		</div>
	</div>

</body>
</html>