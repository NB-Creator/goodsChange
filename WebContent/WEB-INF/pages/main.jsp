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
body, div, form, img, ul, ol, li, dl, dt, dd, form, p, h1 ,a{
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
	height: 100px;
	padding: 1px 0 0 10%;
	line-height: 100px;
	float: left;
	color: white;
	background-color: rgba(237, 244, 237, 0.5);
}

.dock a {
	font-size: 25px;
	color: black;
	padding: 5px;
	text-decoration:none;
}

.dock a:link {
	text-decoration: none;
	color:white;
}

.dock a:visited {
	border: 1px solid white;
	color:black;
	border-radius: 5px;
	margin: 5px;
	text-decoration: none;
}

.dock a:hover {
	border: 1px solid white;
	color:black:;
	border-radius: 5px;
	margin: 5px;
	text-decoration: none;
}

.dock a:active {
	text-decoration: none;
	color:black;
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
	padding: 5px;
	background-color: rgba(237, 244, 237, 0.8);
}

#uName, #eData {
	float: right;
	color: #669;
	margin-left: 10px;
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
				<div id="uName" style="display: none">${requestScope.user.nickname}</div>
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
		<label><a href="#"><span class=" icon-home"></span>首页</a></label> <a
			href="#"><span class=" icon-fire"></span> 推荐</a> <a href="#"><span
			class=" icon-fire"></span> 最新</a> <a href="#"><span
			class=" icon-fire"></span> 热门</a> <a href="#"><span
			class=" icon-fire"></span> 关注</a>

	</div>
	<!-- /.dock -->



	<div class="middle">
		<jsp:include page="home.jsp"></jsp:include>

	</div>
	<!-- /.middle -->

	<div class="right">
		<div class="myinfo">

			我的 <br>

			<!-- 按钮触发模态框 -->
			<button class="btn btn-primary btn-lg" data-toggle="modal"
				data-target="#myModal">发布商品..</button>
			<!-- 模态框（Modal） -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>

							<input type="text" class="form-control" id="essay_title"
								placeholder="商品名">
						</div>
						<div class="modal-body">
							<textarea id="essay_info" style="width: 100%; height: 200px;"
								placeholder="内容写在这里"></textarea>


							<ul class="nav nav-tabs">
								<li class="dropdown" id="type"><a class="dropdown-toggle"
									data-toggle="dropdown" href="#"> 选择一个分类 <span class="caret"></span>
								</a>
									<ul class="dropdown-menu">

										<li><a href="#"></a></li>
										<li><a href="#"></a></li>
										<li><a href="#"></a></li>
										<li><a href="#"></a></li>
										<li><a href="#"></a></li>
										<li><a href="#"></a></li>
										<li><a href="#"><input type="text"
												placeholder="自己写一个"></a></li>
									</ul>
									<div id="s_type" style="margin-left: 50px;"></div></li>
								<li class="dropdown" id="label"><a class="dropdown-toggle"
									data-toggle="dropdown" href="#"> 选择一个标签 <span class="caret"></span>
								</a>
									<ul class="dropdown-menu">
										<li><a href="#">今天心情不太好</a></li>
										<li><a href="#">男朋友打游戏不理我</a></li>
										<li><a href="#">女朋友彻夜不归我心忧</a></li>
										<li><a href="#">室友游戏太大声</a></li>
										<li><a href="#">老板又不发工资</a></li>
										<li><a href="#"><input type="text"
												placeholder="自己写一个"></a></li>
									</ul>
									<div id="s_label"></div></li>
							</ul>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary"
								data-dismiss="modal" onclick="addEssay()">发布</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</div>

			<br>发个秘密吧 <br> 好友动态 与我相关
		</div>

	</div>
	<!-- /.right -->



</body>
<script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	var essay_type;
	var essay_lable;

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
			self.location = "/PrySecret/loginForm.do";
		} else {
			self.location = "/PrySecret/userMainForm.do";

		}
	}
	function out() {
		self.location = "/PrySecret/outServ.do";
	}

	function addEssay() {
		var title = document.getElementById("essay_title").value;
		var info = document.getElementById("essay_info").value;
		if (title == "") {
			alert("请填写一个标题");
			return;
		}
		if (info == "") {
			alert("你没有填写任何内容");
			return;
		}
		if (essay_type == "") {
			alert("请选择一个分类");
			return;
		}
		if (essay_label = "") {
			alert("请选择一个标签");
			return;

		}
		$.ajax({
			url : '/PrySecret/addEssay.do',
			type : 'post',
			dataType : 'text',
			data : {
				'title' : title,
				'info' : info,
				'type' : essay_type,
				'label' : essay_label
			},
			success : function(data) {

			},
			error : function() {
				alert("服务器异常");
			}

		});
		essay_type = "";
		essay_label = "";
	}
</script>
</html>