<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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

.dock {
	width: 100%;
	height: 500px;
	margin-top: 60px; padding : 1px 0 0 10%;
	line-height: 100px;
	float: left;
	color: white;
	background-color: rgba(237, 244, 237, 0.5);
	padding: 1px 0 0 10%;
}

.dock a {
	font-size: 25px;
	color: black;
	padding: 10px;
	margin-left: 10px;
	text-decoration: none;
}

.dock a:link {
	text-decoration: none;
	color: black;
}

.dock a:visited {
	border: 1px solid white;
	color: red;
	border-radius: 5px;
	margin: 5px;
	text-decoration: none;
}

.dock a:hover {
	border: 1px solid white;
	color: black:;
	border-radius: 5px;
	margin: 5px;
	text-decoration: none;
}

.dock a:active {
	text-decoration: none;
	color: black;
}
.iclass{
   width: 200px;
	float: left;
	height: 536px;
	color: #fff;
	background-color: rgba(105,105,105,0.5);
	position: absolute;
	z-index: 100;
	margin-top: -36px;
	line-height: 36px;
	font-size: 20px;
	
}
.itemclass {
	width: 200px;
	float: left;
	height: 36px;
	color: #fff;
	line-height: 36px;
	font-size: 15px;
	padding-left: 3px;
}

.itemclass span {
	margin-right: 5px;
}

.middle {
	width: 50%;
	margin: 10px 3px 0 10%;
	/* background-color: white; */
	background-color: rgba(237, 244, 237, 0.8);
	float: left;
	border: 1px solid rgb(212, 212, 212);
	padding: 5px;
}

.right {
	width: 25%;
	height: 900px;
	margin: 10px 3px 0 0;
	/* background-color: white; */
	float: left;
	border: 1px solid rgb(212, 212, 212);
	padding: 5px 0 0 20px;
	background-color: rgba(237, 244, 237, 0.8);
}

#uName, #eData {
	float: right;
	color: #669;
	margin-left: 10px;
}

.myinfo button {
	marigin: 10px;
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
	<div class="dock">
		<div class="iclass">
		
		<div class="itemclass" style="background-color: #FF0036; font-size:20px;">
			<span class="icon-list icon-1x"></span>商品分类
		</div>
		<div class="itemclass">
			<span class="icon-list icon-1x"></span>商品分fdasf
		</div>
		<div class="itemclass">
			<span class="icon-list icon-1x"></span>商品分类
		</div>
		</div>

	</div>
	<!-- /.dock -->



	<div class="middle"></div>
	<!-- /.middle -->

	<div class="right">
		<div class="myinfo">
			<h3>我的</h3>
			<br>
			<button class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#myModal"><a href="./addItemPage">发布商品..</a></button>
			<br> <br>

			<button class="btn btn-defaul " data-toggle="modal"
				style="background-color: white;">我关注过的</button>
			<br> <br>
			<button class="btn btn-defaul " data-toggle="modal"
				style="background-color: #C8E5BC;">与我相关的</button>
			<br> <br>
			<button class="btn btn-defaul " data-toggle="modal"
				style="background-color: #9ACFEA">查找个用户</button>
			<br> <br>
		</div>

		<div class="public">
			<h3>热门分类</h3>
			<button class="btn btn-defaul " data-toggle="modal"
				style="background-color: white;">标签1</button>

			<button class="btn btn-defaul " data-toggle="modal"
				style="background-color: white;">标签2</button>


		</div>
	</div>
	<!-- /.right -->
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
					+ '<img  src="'+path+'" />' + '</div>';
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
			self.location = "./loginPage";
		} else {
			self.location = "./userMainPage";

		}
	}
	function out() {
		self.location = "./outServ.do";
	}

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