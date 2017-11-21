<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/font-awesome.css">
<link type="text/css" rel="stylesheet" href="css/userMainPagev1.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-table.js"></script>
<style type="text/css">
a {
	text-decoration: none;
	color:black;
}

a:link {
	text-decoration: none;
	color: black;
}

 a:visited {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
	color: black;
}

a:active {
	text-decoration: none;
	color: black;
}

</style>
</head>
<body>
	<jsp:include page="../head-top.jsp"></jsp:include>
	<div class="top">
		<div>
			<h1 style="color: white;">${sessionScope.user.nickname}</h1>
		</div>

	</div>
	<!-- top -->
	<div class="left-menu">
		<div class="menu-param" style="background-color: rgb(245, 245, 245);">
			<ul>
				<li><a href="#">全部功能</a></li>
			</ul>
		</div>
		<!-- menu-param -->
		<div class="menu-param">
			<ul>
				<li><a href="#">个人信息</a></li>
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
		<div class="menu-param">
			<ul>
				<li><a href="#">我的收藏</a></li>
			</ul>
		</div>
		<!-- menu-param -->
		<div class="menu-param">
			<ul>
				<li><a href="#">待处理的</a></li>
			</ul>
		</div>
		<!-- menu-param -->
		<div class="menu-param">
			<ul>
				<li><a href="#">我提交的</a></li>
			</ul>
		</div>
		<!-- menu-param -->
		<div class="menu-param">
			<ul>
				<li><a href="#">消息通知</a></li>
			</ul>
		</div>
		<!-- menu-param -->
	</div>
	<!-- left-menu -->

	<div class="right-data">
		<div class="u-data">
			<div class="u-logo"></div>
			<div class="u-nick">${sessionScope.user.username}(${sessionScope.user.nickname})</div>
		</div>
		<div class="d-table">
			<div class="dt-param">已提交的</div>
			<div class="dt-param">待处理的</div>
			<div class="dt-param">未处理的</div>
			<div class="dt-param" style="border-right: 0;">已接受的</div>
		</div>
		<div class="all-data">
			<div class="a-top">
				<div id="a-top">
					<div id="a_top_label" style="width: 50%; float: left;">
						<div>详细资料</div>
					</div>
					<span class="icon-edit" onclick="show_changeData()"></span>
				</div>
			</div>

			<div class="show-data" id="show-data">
				<div class="a-param">
					<span>姓名：${sessionScope.user.name}</span>
				</div>
				<div class="a-param" style="background-color: rgb(224, 234, 238);">
					<span>所在地:</span>${sessionScope.user.address}
				</div>
				<div class="a-param">
					<span>邮箱：${sessionScope.user.mail}</span>
				</div>
				<div class="a-param" style="background-color: rgb(224, 234, 238);">
					<span>历史成交量：</span>
				</div>
				<div class="a-param">
					<span>最近交易：</span>
				</div>
			</div>
			<!-- showdata -->

			<div id="change-data" style="padding: 10px; display: none;">
				<div class="col-lg-6">
					<div class="form-group">
						<label>昵称：</label> <input type="email" class="form-control"
							id="nickname" placeholder="nickname">
					</div>

					<div class="form-group">
						<label>姓名：</label> <input type="email" class="form-control"
							id="name" placeholder="name">
					</div>
					<div class="form-group">
						<label>地址：</label> <input type="email" class="form-control"
							id="address" placeholder="address">
					</div>

					<div class="form-group">
						<label>邮箱：</label> <input type="email" class="form-control"
							id="mail" placeholder="mail">
							<div id="tips_mail"></div>
					</div>
					
					<a  id="a_1"><span class="icon-caret-down" onclick="show_pass()"><label>修改密码</label></span></a>
					
					<div class="password" id="pass" style="display: none;">
						<div class="form-group">
							<label>密码：</label> <input type="password" class="form-control"
								id="new_password_1" placeholder="new password">
						</div>
						<div class="form-group">
							<label>确认密码：</label> <input type="password" class="form-control"
								id="new_password_2" placeholder="validate password">
								<div id="tips_1"></div>
						</div>
						<div class="form-group">
							<label>输入原密码：</label> <input type="email" class="form-control"
								id="old_password" placeholder="old password">
								<div id="tips_2"></div>
						</div>
						
						<a ><span class="icon-caret-up" onclick="close_pass()"><label>取消</label></span></a>
					</div>
				</div>
			</div>


		</div>
	</div>

</body>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	
	function sendData(){
		var nickname=$("#nickname").val();
		var name=$("#name").val();
		var address=$("#address").val();
		var mail=$("#mail").val();
		var new_password_1=$("#new_password_1").val();
		var new_password_2=$("#new_password_2").val();
		var old_password=$("#old_password").val();
		$("#tips_mail").empty();
		$("#tips_1").empty();
		$("#tips_2").empty();
		if(new_password_1!=null){
			if(new_password_2!=new_password_1){
				$("#tips_1").append("两次密码不同");
				return;
			}
		}
		var result=mail.match(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/); 
          if(mail!=""&&result==null) 
          	{
          		$("#tips_mail").append("邮箱格式错误(格式示例：xxxxxx@xx.xx)");
          		return;
          	}
          	$.ajax({
          		type:"post",
          		url:"./changeInfo",
          		dataType:"json",
          		data:{
          			"nickname":nickname,
          			"name":name,
          			"address":address,
          			"mail":mail,
          			"password":new_password_1,
          			"oldpassword":old_password
          		},
          		success:function(data){
          			if(data=="oldpasserro"){
          				$("#tips_2").append("密码错误");
          			}else if(data=="success"){
          				alert(data);
          				window.location="";
          			}
          		},
          		erro:function(){
          			alert("访问服务器出错...")
          		}
          	});
   
	}
	
	
	function show(id) {

		var m = document.getElementById(id);
		m.style.display = "block";
	}

	function remove(id) {
		var m = document.getElementById(id);
		m.style.display = "none";
	}

	function color(b) {

		for (var a = 1; a < 6; a++) {
			if (a == b) {
				var m = document.getElementById(a);
				m.style.background = "white";
			} else {
				m = document.getElementById(a);
				m.style.background = "rgb(238,238,238)";
			}

		}

	}

	function show_changeData() {

		document.getElementById("change-data").style.display = "block";
		document.getElementById("show-data").style.display = "none";
		document.getElementById("a-top").style.display = "none";
		$(".a-top")
				.append(
						"<p style='float:left;'>修改资料</p>"
							+"<button onclick='back()' type='button' "
							+ "class='btn btn-default' style='margin-top:10px;float:right;'>取消</button>"
							+"<button onclick='sendData()' type='button' "
							+ "class='btn btn-default' style='margin-top:10px;float:right;'>确认</button>")

	}
	function back() {
		
		$(".a-top button").remove();
		$(".a-top p").remove();
		document.getElementById("a-top").style.display = "block";
		document.getElementById("change-data").style.display = "none";
		document.getElementById("show-data").style.display = "block";
	}

	function show_pass(){
		document.getElementById("pass").style.display = "block";
		document.getElementById("a_1").style.display = "none";
	}
	
	function close_pass(){
		document.getElementById("pass").style.display = "none";
		document.getElementById("a_1").style.display = "block";
	}


</script>
</html>