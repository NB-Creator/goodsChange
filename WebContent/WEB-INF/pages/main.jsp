<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>换了呗</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap-table.css">
<link type="text/css" rel="stylesheet" href="css/font-awesome.css">
<!-- Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-table.js"></script>
<style type="text/css">
.bottom {
	background-color: rgb(242,242,242);
}

.class-box {
	width: 1200px;
	height: 400px;
	margin: 0 auto;
	margin-top: 20px;
	margin-bottom: 20px;
	border-bottom: 1px solid rgb(229, 229, 229);
}

.class-box span {
	float: left;
	width: 100%;
	height: 50px;
	padding-left:5px;
	font-size: 20px;
	font-weight:500;
	line-height: 50px;
	background:rgba(255,0,0,0.8);
	color:white;
}

.item-box {
	width: 1200px;
	height: 380px;
	float: left;
}

.item {
	float: left;
	width: 300px;
	height: 190px;
	padding: 10px 5px 0 25px;
	
	background-color: white;
}

.item img {
	width: 240px;
	height: 120px;
}

.item .span {
	width: 100%;
	height: 18px;
	margin-top: 3px;
	padding-left: 50px;
	line-height: 18px;
}

#sort {
	width: 100%;
	height: 100%;
}

#sortlist {
	width: 150px;
	height: 30px;
	float: left;
}

#sortlist a {
	color: white;
	font-size: 120%;
	height: 100%;
	float: left;
}

#lunbo {
	width: 50%;
	height: 550px;
}

.itemClass {
	margin-top: -655px;
	width: 200px;
	height: 655px;
	z-index: 999;
	position: absolute;
	background: rgba(26, 25, 25, 0.5);
	left: 2px;
	color: white;
}

.cTitle {
	width: 100%;
	height: 50px; font-size : 20px;
	line-height: 50px;
	font-weight: 700;
	padding-left: 30px;
	background: rgb(255, 51, 51);
	font-size: 20px;
}

.geduan {
	width: 100%;
	height: 5px;
	background: rgb(255, 51, 51);
}

.dock {
	width: 100%;
	height: 50px;
	background: rgba(14, 13, 13, 0.6);
	padding-left: 250px;
	font-size: 20px;
	font-weight: 500;
	float: left;
	color: white;
	margin-top: -55px;
	z-index: 99;
	position: absolute;
}

.dock ul {
	list-style: none;
}

.dock li {
	width: 100px;
	height: 50px;
	line-height: 50px;
	float: left;
	text-decoration: none;
}

.dock a {
	text-decoration: none;
	color: white;
}
</style>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="dock">
		<ul>
			<li><a></a>今日热门</li>
			<li><a></a>最新上架</li>
			<li><a></a>我的收藏</li>
			<li><a></a>流览足迹</li>
		</ul>
	</div>
	<div class="container"
		style="height: 600px; width: 100%; margin: 0; padding: 0; z-index: -1;">
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox"
				style="height: 600px; width: 100%">
				
				
				<div class="item active"
					style="height: 600px; width: 100%; margin: 0; padding: 0;">
					<img src="https://img1.360buyimg.com/da/jfs/t15286/315/552134992/77628/d8eb2d02/5a30c4e7N41291ce7.jpg" alt="..."
						style="height: 600px; width: 100%;">

				</div>
				<div class="item"
					style="height: 600px; width: 100%; margin: 0; padding: 0;">
					<img src="https://img10.360buyimg.com/babel/jfs/t16312/112/456301669/85522/193af047/5a33700dN13d2b19c.jpg" alt="..."
						style="height: 600px; width: 100%;">

				</div>
				<div class="item"
					style="height: 600px; width: 100%; margin: 0; padding: 0;">
					<img src="//img14.360buyimg.com/da/jfs/t15097/171/562405323/97503/a0c34b9/5a310137N3c6e44d9.jpg" alt="..."
						style="height: 600px; width: 100%;">

				</div>
			</div>

			<!-- Controls -->
			<!-- <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev" style="height: 600px">
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next" style="height: 600px">
			    <span class="sr-only">Next</span>
			  </a> -->

		</div>
	</div>
	<div class="itemClass">
		<div class="sort" id="sort">
			<div class="cTitle">全部分类</div>
			<div class="geduan"></div>
			<ul>
				<li id="sortlist"><a href="#" id="smallsort">洗护用品</a></li>
				<li id="sortlist"><a href="#" id="smallsort">学习用具</a></li>
				<li id="sortlist"><a href="#" id="smallsort">生活用品</a></li>
				<li id="sortlist"><a href="#" id="smallsort">电脑配件</a></li>
				<li id="sortlist"><a href="#" id="smallsort">手机配件</a></li>
				<li id="sortlist"><a href="#" id="smallsort">化妆品</a></li>
				<li id="sortlist"><a href="#" id="smallsort">手机</a></li>
				<li id="sortlist"><a href="#" id="smallsort">电脑</a></li>
				<li id="sortlist"><a href="#" id="smallsort">服装</a></li>
				<li id="sortlist"><a href="#" id="smallsort">鞋靴</a></li>
				<li id="sortlist"><a href="#" id="smallsort">箱包</a></li>
				<li id="sortlist"><a href="#" id="smallsort">书本</a></li>
				<li id="sortlist"><a href="#" id="smallsort">零食</a></li>
				<li id="sortlist"><a href="#" id="smallsort">电器</a></li>
				<li id="sortlist"><a href="#" id="smallsort">装饰</a></li>
				<li id="sortlist"><a href="#" id="smallsort">其他</a></li>
			</ul>
		</div>
	</div>
	<!-- </div> -->
	<!-- /.dock -->
	<div class="bottom">
		<div class="class-box">

			<span>今日热门</span>
			<div class="item-box">
				<c:forEach items="${newlist}" var="items" end="7">
					<div class="item">
						<a href="item/itemid=${items.id}">
							<div class="item-img">
								<img alt="" src="${items.imgpath[0]}">
							</div>
						</a>
						<div class="span">${items.name}</div>
						<div class="span" style="text-align: left; color: red;">￥${items.price}</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="class-box">
			<span>最新上架</span>
			<div class="item-box">
				<c:forEach items="${newlist}" var="items" end="7">
					<div class="item">
						<a href="itemPage/itemid=${items.id}">
							<div class="item-img">
								<img alt="" src="${items.imgpath[0]}">
							</div>
						</a>
						<div class="span">${items.name}</div>
						<div class="span" style="text-align: right; color: red;">￥${items.price}</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="class-box">
			<span>手机控</span>
			<div class="item-box">
				<c:forEach items="${phonelist}" var="items" end="7">
					<div class="item">
						<a href="item/itemid=${items.id}">
							<div class="item-img">
								<img alt="" src="${items.imgpath[0]}">
							</div>
						</a>
						<div class="span">${items.name}</div>
						<div class="span" style="text-align: right; color: red;">￥${items.price}</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="class-box">
			<span>电脑也能换</span>
			<div class="item-box">
				<c:forEach items="${computerlist}" var="items" end="7">
					<div class="item">
						<a href="item/itemid=${items.id}">
							<div class="item-img">
								<img alt="" src="${items.imgpath[0]}">
							</div>
						</a>
						<div class="span">${items.name}</div>
						<div class="span" style="text-align: right; color: red;">￥${items.price}</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="class-box">
			<span>书达人</span>
			<div class="item-box">
				<c:forEach items="${booklist}" var="items" end="7">
					<div class="item">
						<a href="item/itemid=${items.id}">
							<div class="item-img">
								<img alt="" src="${items.imgpath[0]}">
							</div>
						</a>
						<div class="span">${items.name}</div>
						<div class="span" style="text-align: right; color: red;">￥${items.price}</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="class-box">
			<span>美人装</span>
			<div class="item-box">
				<c:forEach items="${clothinglist}" var="items" end="7">
					<div class="item">
						<a href="item/itemid=${items.id}">
							<div class="item-img">
								<img alt="" src="${items.imgpath[0]}">
							</div>
						</a>
						<div class="span">${items.name}</div>
						<div class="span" style="text-align: right; color: red;">￥${items.price}</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="class-box">
			<span>爱运动</span>
			<div class="item-box">
				<c:forEach items="${sportlist}" var="items" end="7">
					<div class="item">
						<a href="item/itemid=${items.id}">
							<div class="item-img">
								<img alt="" src="${items.imgpath[0]}">
							</div>
						</a>
						<div class="span">${items.name}</div>
						<div class="span" style="text-align: right; color: red;">￥${items.price}</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="class-box">
			<span>游戏宅</span>
			<div class="item-box">
				<c:forEach items="${gamelist}" var="items" end="7">
					<div class="item">
						<a href="item/itemid=${items.id}">
							<div class="item-img">
								<img alt="" src="${items.imgpath[0]}">
							</div>
						</a>
						<div class="span">${items.name}</div>
						<div class="span" style="text-align: right; color: red;">￥${items.price}</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="class-box">
			<span>创意达人</span>
			<div class="item-box">
				<c:forEach items="${originalitylist}" var="items" end="7">
					<div class="item">
						<a href="item/itemid=${items.id}">
							<div class="item-img">
								<img alt="" src="${items.imgpath[0]}">
							</div>
						</a>
						<div class="span">${items.name}</div>
						<div class="span" style="text-align: right; color: red;">￥${items.price}</div>
					</div>
				</c:forEach>
			</div>
		</div>

	</div>

</body>
</html>