<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 引入jstl表达式依赖文件 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>

<!-- bootstrap相关文件的导入 -->
<link type="text/css" rel="stylesheet" href="../css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="../css/bootstrap-table.css">
<link type="text/css" rel="stylesheet" href="../css/font-awesome.css">
<link type="text/css" rel="stylesheet" href="../css/itemPage.css">
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/bootstrap-table.js"></script>

<style type="text/css">

/* 去除一些基础标签的属性值 */
body, div, form, img, ul, ol, li, dl, dt, dd, form, p, h1, h3 {
	margin: 0px;
	padding: 0px;
	border: 0px none;
	list-style: none outside none;
	text-decoration: none;
}
</style>
</head>
<body>
	<!-- 导入顶部导航页面-->
	<jsp:include page="../head-top.jsp"></jsp:include>
	<div class="h-top">
		<a href="../mainPage">HLeB</a> <span>换出新感觉</span>
	</div>
	<div class="i-top">
		<div class="u-logo">
			<!-- 用户头像 -->
		</div>
		<div class="u-nickname">
			来自<br> <a href="../sellerPage/sellerid=${user_b.username}">${user_b.nickname}</a>
		</div>
		<div class="i-browse">
			浏览次数<br>15
		</div>
		<div class="i-date">
			发布时间<br>${itemdata.time}</div>
	</div>
	<!-- /.i-top -->

	<div class="i-box">
		<div class="i-img">
			<div class="img-bg">
				<img src="../${itemdata.imgpath[0]}">
			</div>
			<div class="img-li">
				<c:forEach items="${itemdata.imgpath}" var="imgpath">
					<img src="../${imgpath}">
				</c:forEach>
			</div>
		</div>
		<!-- /.i-img -->

		<div class="box-r">
			<div class="i-title">${itemdata.name}</div>
			<div class="i-price">
				参考价:<b>￥</b><span class="span">${itemdata.price}.00</span>
			</div>
			<div class="u-address">所在地:${user_b.address}</div>
			<div class="i-exchange">
				<a href="../excPage"><button type="button" style="width: 200px;"
					class="btn btn-info btn-lg">发起交换</button></a>
			</div>
			<div class="i-message">
				<button type="button" style="width: 200px;"
					class="btn btn-primary btn-lg"
					onclick="sendMessage(${itemdata.id})">发送留言</button>
			</div>
			<textarea id="i-message" rows="5" cols="" style="width: 200px"
				placeholder="添加留言"></textarea>
		</div>
		<!-- /.box-r -->
	</div>
	<!-- /.i-box -->

	<div class="detail">
		<div class="label">
			<ul>
				<li><a href="#1" id="div1"><span>宝贝介绍</span></a></li>
				<li><a href="#2" id="div2"><span>留言列表</span></a></li>
				<li><a href="#3"><span>其它</span></a></li>
			</ul>
		</div>
		<div class="detail-box" id="div3">
			<span>宝贝介绍</span><br> ${itemdata.detail}
		</div>
		<div class="detail-box" id="div4" style="display: none;">
			<span>留言</span><br>
		</div>

		<div class="u-item-l">
			<h3>该用户的其它商品</h3>
			<div class="u-item">
				<div class="u-item-img">
					<a href="../itemPage/itemid=${itemdata.id}"><img alt=""
						src="../${itemdata.imgpath[0]}"></a>
				</div>
				<div class="u-item-name">${itemdata.name}</div>
				<div class="u-item-price">
					￥<span>${itemdata.price}.00</span>
				</div>
			</div>
			<c:forEach items="u-item" var="item">
				<div class="u-item">
					<div class="u-item-img">
						<a href="../itemPage/itemid=${itemdata.id}"><img alt=""
							src="../${itemdata.imgpath[0]}"></a>
					</div>
					<div class="u-item-name">${itemdata.name}</div>
					<div class="u-item-price">
						￥<span>${itemdata.price}.00</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<!-- detail -->


</body>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	window.onload=function(){
		document.getElementById("div1").checked=true;	
	}
	$("#div1").click(function(){
		var div1=document.getElementById("div1");
		var div2=document.getElementById("div2");
		div1.style.background="rgb(225, 218, 68)";
		div1.style.color="white";
		div2.style.background="white";
		div2.style.color="black";
		document.getElementById("div3").style.display="block";
		document.getElementById("div4").style.display="none";
	});
	$("#div2").click(function(){
		var div1=document.getElementById("div1");
		var div2=document.getElementById("div2");
		div2.style.background="rgb(225, 218, 68)";
		div2.style.color="white";
		div1.style.background="white";
		div1.style.color="black";
		document.getElementById("div4").style.display="block";
		document.getElementById("div3").style.display="none";
	});
	
	function sendMessage(itemid){
		var message;
		message=$("#i-message").val();
		if(message==""){
			message=$("#i-message").val("你什么都没填诶");
			return;
		}
		$.ajax({
			url:'../',
			type:post,
			dataType:text,
			data:{
				'id':itemid,
				'message':message
			},
			success:function(data){
			
			},
			erro:function(data){
				
			}
		});
	}
	$(function(){
		$(".img-li img").mouseover(function(e){
			$(".img-bg img").attr('src',this.src);
		});
	});
</script>
</html>