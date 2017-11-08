<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous"> -->
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap-table.css">

<link type="text/css" rel="stylesheet" href="css/font-awesome.css">

<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- Bootstrap 核心 JavaScript 文件 -->


<script type="text/javascript" src="/js/bootstrap.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.js"></script>



<style type="text/css">
body, div, form, img, ul, ol, li, dl, dt, dd, form, p, h1 {
	margin: 0px;
	padding: 0px;
	border: 0px none;
	list-style: none outside none;
	text-decoration: none;
}

.recommend, .hot, .new {
	height: 300px;
	border: 1px solid;
	margin: 5px;
	padding: 5px;
	border-radius: 1px;
	border-color: rgb(223, 240, 240);
	background-color: white;
}

.hot {
	
}

.date, .title, .author {
	float: left;
	width: 33%;
	height: 10%;
	line-height: 20px;
	text-align: center;
}

.info {
	width: 100%;
	height: 70%;
	float: left;
	border-top: 1px solid;
}

.control {
	width: 100%;
	height: 12%;
	float: left;
	text-align: right;
}

.ld {
	width: 60px;
	float: right;
	padding: 0 10px 0 10px;
	margin-left: 20%;
	border: 1px solid;
	border-radius: 15px;
	border: 1px solid;
}
</style>
</head>
<body>
	<label>推荐</label>
	<div class="recommend">
		<div class="author">${author.nickName}</div>
		<!-- .author -->
		<div class="title">${essay.title}</div>
		<!-- .title -->
		<div class="date">${essay.date}</div>
		<!-- .date -->
		<div class="info">内容</div>
		<!-- .info -->
		<div class="control">

			<span class=" icon-comment"> 评论(112)</span>
			<div class="ld">

				<span class=" icon-thumbs-up icon-1x"
					style="color: green; float: left"></span> <span
					class="icon-thumbs-down icon-1x"></span>
			</div>
			<!-- /.ld -->
		</div>
		<!-- /.control -->
	</div>
	<!-- /.recommend -->
	<label>热门</label>
	<div class="hot">
		<div class="author">${author.nickName}</div>
		<!-- .author -->
		<div class="title">${essay.title}</div>
		<!-- .title -->
		<div class="date">${essay.date}</div>
		<!-- .date -->
		<div class="info">内容</div>
		<!-- .info -->
		<div class="control">

			<span class=" icon-comment"> 评论(112)</span>
			<div class="ld">

				<span class=" icon-thumbs-up icon-1x"
					style="color: green; float: left"></span> <span
					class="icon-thumbs-down icon-1x"></span>
			</div>
			<!-- /.ld -->
		</div>
		<!-- /.control -->
	</div>
	<!-- /.hot -->
	<label onclick="show()">最新</label>
	<div class="new">
		<div class="author">${author.nickName}</div>
		<!-- .author -->
		<div class="title">${essay.title}</div>
		<!-- .title -->
		<div class="date">${essay.date}</div>
		<!-- .date -->
		<div class="info">内容</div>
		<!-- .info -->
		<div class="control">

			<span class=" icon-comment"> 评论(112)</span>
			<div class="ld">

				<span class=" icon-thumbs-up icon-1x"
					style="color: green; float: left"></span> <span
					class="icon-thumbs-down icon-1x"></span>
			</div>
			<!-- /.ld -->
		</div>
		<!-- /.control -->
	</div>
	<!-- /.new -->
</body>
<script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	function show() {
		alert("not data");

	}
</script>
</html>