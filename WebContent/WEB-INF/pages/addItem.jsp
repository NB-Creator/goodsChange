<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap-table.css">
<link type="text/css" rel="stylesheet" href="css/font-awesome.css">
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-table.js"></script>


<title>Insert title here</title>
<style type="text/css">
body, div, form, img, ul, ol, li, dl, dt, dd, form, p, h1, a {
	margin: 0px;
	padding: 0px;
	border: 0px none;
	list-style: none outside none;
	text-decoration: none;
}

body {
	background-image: url("images/mian.jpg");
}

.top {
	width: 100%;
	height: 70px;
	background-color: white;
	float: left;
	padding-left: 10%;
	padding-top: 20px;
	filter: alpha(Opacity = 80);
	-moz-opacity: 0.8;
	opacity: 0.8;
}

.top h1 {
	float: left;
	color: #669;
	float: left;
}

.top ul {
	float: right;
	font-weight: 1000;
}

ul li {
	float: left;
	font-family: "微软雅黑";
	font-style: inherit;
	font-weight: 10000;
	font-size: 1.3em;
	margin-right: 30px;
}

.title {
	float: left;
	width: 100%;
	height: 30px;
	line-height: 30px;
	color: white;
	background-color: rgba(118, 118, 118, 0.6);
	padding-left: 20%;
	border-radius: 5px;
}

.middle {
	width: 60%;
	margin-left: 20%;
	margin-right: 20%;
	background-color: rgba(242, 242, 242, 1);
	border: 1px solid darkgrey;
	padding: 20px 20px 60px 20px;
	border-top: 0;
	
}

.bt {
	width: 100%;
	margin: 30px 0 0 0;
	padding: 10px 20% 5px 20%;
	float: left;
}

.parame {
	width: 100%;
	padding: 10px 0 5px 0;
	float: left;
}

.imgs {
	width: 100%;;
	float: left;
}

.imgs img {
	float: left;
	width: 100px;
	height: 100px;
	margin-right: 10px;
}

.photo {
	width: 100px;
	height: 100px;
	border: 1px solid;
	text-align: center;
	line-height: 100px;
	float: left;
}

.photo img {
	width: 100px;
	height: 100px;
}

.file {
	float: left;
	height: 100px;
	width: 100px;
	overflow: hidden;
	font-size: 300px;
	position: absolute;
	top: 470px;
	opacity: 0;
	filter: alpha(opacity = 0);
	cursor: pointer;
	opacity: 0;
}
</style>
</head>
<body>
	<div class="top">
		<h1>HLB</h1>


		<div class="">
			<div class="col-lg-3">
				<div class="input-group">
					<input type="text" class="form-control" id="inputNumber"
						placeholder="输入关键字搜索"> <span class="input-group-btn">
						<button class="btn btn-default" type="button"
							onclick="submitNumber()">Go!</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
		</div>
		<!-- /.row -->
		<ul>

			<li onmouseover="show('uName')" onmouseout="remove('uName')"
				onclick="uControl()"><span class="icon-user"></span>
				<div id="uName" style="display: none">${sessionScope.user.nickname}</div>
			</li>
			<li onmouseover="show('eData')" onmouseout="remove('eData')"><span
				class="icon-envelope"></span>
				<div id="eData" style="display: none">未读：${requestScope.nRead}</div>
			</li>
			<li><span class=" icon-off" onclick="out()"></span></li>
		</ul>

	</div>
	<!-- /.top -->
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
						<li><a href="#">数码</a></li>
						<li><a href="#">服装</a></li>
						<li><a href="#">书籍</a></li>
						<li><a href="#">工具</a></li>
						<li><a href="#">运动</a></li>
						<li><a href="#">其它</a></li>
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
				点击上传图片 <img alt="" width=15%  src=""> <input
					class="file" type="file" onchange="addImg(this)" ></input>
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
<script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	var classification = "";
	var imgpath = "";
	var images = new Array();
	function addImg(file, type) {
		var fileReader = new FileReader();
		var path = ""
		fileReader.readAsDataURL(file.files[0])
		fileReader.onload = function(evt) {
			path = evt.target.result
			if (images.length > 7) {
				alert("最多只能上传八张图片哦~");
				return;
			}
			for (var i = 0; i < images.length; i++) {
				var img = images[i]
				if (img.path == path) {
					alert("图片已经存在")
					return;
				}
			}
			var img = '<div class="btn_upload" onclick="deleteImg(this)">'
				+ '<img  src="'+path+'" /> ' + '</div>';
			$("#imgs").prepend(img)
			var image = {
				"span" : $("#imgs").children("div:first-child")
						.children("span"),
				"file" : file.files[0],
				"path" : path
			}
			images.push(image)
			file.value = ""
		}

	}
	
	function deleteImg(img) {
		
		var src = $(img).children("img")[0].src;
		$(img).remove();
		for (var i = 0; i < images.length; i++) {
			var img = images[i]
			if (src == img.path) {
				images.splice(i, 1)
			}
		}

	}
	function uploadImgs() {
		for (var i = 0; i < images.length; i++) {
			var img = images[i];
			var form = new FormData();
			form.append("img", img.file);
			$.ajax({
				type : "post",
				url : "./uploadImg",
				data : form,
				async : false,
				cache : false,
				contentType : false,
				processData : false,
				success : function(data, status) {
					if (imgpath == "") {
						imgpath = data;
					} else {
						imgpath = imgpath + "*" + data;
					}
				},
				error : function() {
					alert("服务器异常");
				},
				complete : function() {

				}
			});
		}
	}
	/* function uploadPath() {
		alert(imgpath);
		$.ajax({
			type : "post",
			url : "./getImgpath",
			data : {
				"path" : imgpath
			},
			traditional : true,
			success : function(data) {
				alert(data);
				
				imgpath="";
			},
			error : function() {
				alert("服务器异常");
			},
			complete : function() {

			}
		});
	} */

	$('#classification li').click(function() {
		classification = ($(this).text());
		$("#s_type").empty();
		$("#s_type").append(classification);
	})
	/* function uploadImages(file) {

		var form = new FormData();
		form.append("img", file);

		$.ajax({
			type : "post",
			url : "/_MSP_ItemByItem/uploadImg",
			data : form,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(data, status) {
				alert(data);
				$("#img")[0].src = "http://localhost:8080/_MSP_ItemByItem/"
						+ data;
			},
			error : function() {
				alert("服务器异常");
			},
			complete : function() {

			}
		});
	} */

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
		if (classification == "") {
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
		uploadImgs();

		$.ajax({
			url : './uploadItem',
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
				location.reload();
			},
			error : function() {
				alert("服务器异常");
			}
		});
		classification = "";
		imgpath = "";
		images = new Array();
	}
</script>

</html>