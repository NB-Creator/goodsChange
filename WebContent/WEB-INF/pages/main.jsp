<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap-table.css">
<link type="text/css" rel="stylesheet" href="css/font-awesome.css">
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-table.js"></script>
<style type="text/css">

</style>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="dock">
		<div class="btn-group btn-group-lg">
			<button type="button" class="btn btn-default dropdown-toggle "
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
				style="opacity: 0.8;">
				价格选择 <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" style="opacity: 0.5;">
				<li><a href="#">0~10元</a></li>
				<li><a href="#">10~20元</a></li>
				<li><a href="#">20~30元</a></li>
				<li><a href="#">30元以上</a></li>
			</ul>
		</div>
		<div class="btn-group btn-group-lg ">
			<button type="button" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				衣物 <span class="caret"></span>
			</button>
		</div>
		<div class="btn-group btn-group-lg">
			<button type="button" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				学习用品 <span class="caret"></span>
			</button>
		</div>
		<div class="btn-group btn-group-lg">
			<button type="button" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				生活用品 <span class="caret"></span>
			</button>
		</div>
		<div class="btn-group btn-group-lg">
			<button type="button" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				运动用品 <span class="caret"></span>
			</button>
		</div>
		<div class="btn-group btn-group-lg">
			<button type="button" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				其他 <span class="caret"></span>
			</button>
		</div>
	</div>
	<!-- /.dock -->
	<div class="middle">
		<div class="row1">
			<c:forEach items="${itemlist}" var="item" end="9">
			<div class="col-sm-4 col-md-4">
				<div class="thumbnail">
					<c:forEach items="${item.imgpath}" var="imgpath" end="0">
					<a href="itemPage/itemid=${item.id}"><img src="${imgpath}" alt="...">${item.name}</a>
					</c:forEach>
					<div class="caption">
						<h4>商品描述:</h4>${item.detail}
						<p style="font-size: 20px;">价格预估:${item.price}</p>
						<p>
							<a href="#" class="btn btn-primary" role="button"
								style="font-size: x-small;">联系卖家</a> <a href="#"
								class="btn btn-default" role="button"
								style="font-size: x-small;">确认交换</a>
						</p>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
			<nav aria-label="..." style="width: 100%;float:left;">
			<ul class="pager" style="margin-left: 0;">
				<li><a href="#">上一页</a></li>
				<li><a href="#">下一页</a></li>
			</ul>
			</nav>

		</div>

</body>
<script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	var classification;
	var imgpath;
	$('#type li').click(function() {
		essay_type = ($(this).text());
		$("#s_type").empty();
		$("#s_type").append(essay_type);
	})
	$('#label li').click(function() {
		essay_label = ($(this).text());
		$("#s_label").empty();
		$("#s_label").append(essay_label);
	})
	function show(id) {
		var m = document.getElementById(id);
		m.style.display = "block";
	}
	function remove(id) {
		var m = document.getElementById(id);
		m.style.display = "none";
	}
	function uControl() {
		var m = document.getElementById("uName");
		m.style.display = "block";
		var a = document.getElementById('uName').innerText;
		if (a == "") {
			self.location = "loginPage";
		} else {
			self.location = "userMainPage";
		}
	}
	function out() {
		self.location = "./userQuit";
	}
	function uploadImg(file) {
		var fileReader = new FileReader();
		var path = "";
		uploadImages(file.files[0])
	}
	function uploadImages(file) {

		var form = new FormData();
		form.append("img", file);
		alert("123123");
		$.ajax({
			type : "post",
			url : "/_MSP_ItemByItem/uploadImg",
			data : form,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(data, status) {
				$("#logo")[0].src = "http://localhost:8080/_MSP_ItemByItem/"
						+ data;
			},
			error : function() {
				alert("服务器异常");
			},
			complete : function() {
			}
		});
	}

	function addItem() {

		var name = document.getElementById("name").value;
		var detail = document.getElementById("detail").value;
		var price = document.getElementById("price").value;
		var expect = document.getElementById("expect").value;

		if (name == "") {
			alert("请填写一个名称");
			return;
		}
		if (detail == "") {
			alert("你没有填写任何内容");
			return;
		}
		if (itemtype == "") {
			alert("请选择一个分类");
			return;
		}
		if (price == "") {
			alert("请填写一个预估价格");
			return;
		}
		if (expect == "") {
			alert("请填写一个期望商品");
			return;
		}
		$.ajax({
			url : '/uploadItem',
			type : 'post',
			dataType : 'text',
			data : {
				'name' : name,
				'detail' : detail,
				'img' : imgpath,
				'expect' : expect,
				'classification' : classification,
				'price' : price
			},
			success : function(data) {
			},
			error : function() {
				alert("服务器异常");
			}
		});
		classification = "";
		imgpath = "";
	}
</script>
</html>