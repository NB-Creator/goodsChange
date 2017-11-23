<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 引入jstl表达式依赖文件 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- bootstrap相关文件的导入 -->
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap-table.css">
<link type="text/css" rel="stylesheet" href="css/font-awesome.css">
<link type="text/css" rel="stylesheet" href="css/excPage.css">

<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/bootstrap-table.js"></script>

<style type="text/css">

/* 去除一些基础标签的属性值 */
body, div, form, img, ul, ol, li, dl, dt, dd, form, p, h1 {
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
	<jsp:include page="../head.jsp"></jsp:include>

	<div class="excBox">
		<p><span class="icon-edit" style="margin-right:5px;"></span>交换信息填写</p>
		<div class="exc_top">
		</div>
		<div class="exc_middle">
			<div class="d_write">
				<div class="e_param"><span class="icon-caret-right"></span>商品ID:${excitem.id}</div>
				<div class="e_param"><span class="icon-caret-right"></span>商品名：${excitem.name}</div>
				<div class="e_img"><span class="icon-caret-right"></span>商品图片：<br />
				<c:forEach items="${excitem.imgpath}" var="imgp">
					<img alt="" src="${imgp}">
				</c:forEach>
					
				</div>
				<div class="e_param"><span class="icon-caret-right"></span>商品分类：${excitem.classification}</div>
				<div class="e_mItem"><span class="icon-caret-right"></span>交换商品：
					<br><div class="e_mP"><span>点击右侧我的商品添加到此处</span></div>
				</div>
				<div class="e_mData"><span class="icon-caret-right"></span>备注：<br/>
				<textarea rows="5" cols=""></textarea>
				</div>
				<div class="button">
					<button type="button" class="btn btn-default">提交</button>
					<a href="./itemPage/itemid=${excitem.id}"><button type="button" class="btn btn-default">取消</button></a>
				</div>
			</div>
			<div class="m_item">
				<p>我的商品:（点击选中交换）</p>
				<ul class="item_l">
				</ul>
				<div class="fydiv">
					<ul class="fenye">
					</ul>
				</div>
			</div>
			<!-- .m_item -->
		</div>
		<div class="exc_bottom"></div>
	</div>

</body>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	var jsonData = null;
	var length;
	window.onload = getData;
	function getData() {
		$.ajax({
			url : "./getItemList",
			type : 'get',
			success : function(data) {
				jsonData = JSON.parse(data);
				length = jsonData.length;

				getPage(1);
			},
			erro : function() {
				alert("erro");
			}
		});
	}

	function addTo(j){
		
		var ul = $(".e_mP");
		ul.empty();
		var e = "<li>"
			+ "<div class='item_logo' onclick='remove()'><img width='100px' height='100px' src="+jsonData[j].imgpath[0]+"></div>"
			+ "<div class='item_id'>商品ID:" + jsonData[j].id
			+ "</div></br>" + "<div class='item_name'>"
			+ jsonData[j].name + "<button onclick='remove()' class='btn btn-defualt'>点击删除</button></div></li>";
	ul.append(e);
		
	}
	
	function remove(){
		var ite = $(".e_mP");
		ite.empty();
		ite.append("<span>点击右侧我的商品添加到此处</span>");
	}
	function getPage(pn) {
		var dataCount = length;
		var pageSize = 4;
		var pageCount = Math.ceil(dataCount / pageSize);
		if (pn == 0 || pn > pageCount) {
			return;
		}
		var ul = $(".item_l");
		ul.empty();
		//console.log(pageCount+"..."+pn)
		paintPage(pageCount, pn); //
		var startPage = pageSize * (pn - 1);

		if (pageCount == 1) { // 
			for (var j = 0; j < dataCount; j++) {
				var fun="addTo("+j+")";
				var e =  "<li>"
					+ "<div class='item_logo' onclick='"+fun+"'><img width='100px' height='100px' src="+jsonData[j].imgpath[0]+"></div>"
					+ "<div class='item_id'>ID:" + jsonData[j].id
					+ "</div></br>" + "<div class='item_name'>"
					+ jsonData[j].name + "</div></li>";
				ul.append(e);
			}
		} else { //
			var e = "";
			var endPage = pn < pageCount ? pageSize * pn : dataCount;
			for (var j = startPage; j < endPage; j++) {
				var fun="addTo("+j+")";
				var e =  "<li>"
					+ "<div class='item_logo' onclick='"+fun+"'><img width='100px' height='100px' src="+jsonData[j].imgpath[0]+"></div>"
					+ "<div class='item_id'>ID:" + jsonData[j].id
					+ "</div></br>" + "<div class='item_name'>"
					+ jsonData[j].name + "</div></li>";
				ul.append(e);
			}
		}
	}

	//绘制页码
	function paintPage(number, currNum) //number 总页数,currNum 当前页  
	{
		var pageUl = $(".fenye");
		pageUl.empty();
		var ulDetail = "";

		if (number == 1) {
			ulDetail = "<li class=\"prev\"><a href=\"javascript:void(0)\">上一页</a></li>"
					+ "<li class=\"numb choose\"><a href=\"javascript:getPage(1)\">1</a></li>"
					+ "<li class=\"next\"><a href=\"javascript:void(0)\">下一页</a></li>";
		} else if (number == 2) {
			ulDetail = "<li class=\"prev\"><a href=\"javascript:getPage(1)\">上一页</a></li>"
					+ "<li class=\"numb"
					+ choosele(currNum, 1)
					+ "\"><a href=\"javascript:getPage(1)\">1</a></li>"
					+ "<li class=\"numb"
					+ choosele(currNum, 2)
					+ "\"><a href=\"javascript:getPage(2)\">2</a></li>"
					+ "<li class=\"next\"><a href=\"javascript:getPage(2)\">下一页</a></li>";
		} else if (number == 3) {
			ulDetail = "<li class=\"prev\"><a href=\"javascript:getPage("
					+ parseInt(currNum - 1) + ")\">上一页</a></li>"
					+ "<li class=\"numb" + choosele(currNum, 1)
					+ "\"><a href=\"javascript:getPage(1)\">1</a></li>"
					+ "<li class=\"numb" + choosele(currNum, 2)
					+ "\"><a href=\"javascript:getPage(2)\">2</a></li>"
					+ "<li class=\"numb" + choosele(currNum, 3)
					+ "\"><a href=\"javascript:getPage(3)\">3</a></li>"
					+ "<li class=\"next\"><a href=\"javascript:getPage("
					+ parseInt(currNum + 1) + ")\">下一页</a></li>";
		} else if (number == currNum && currNum > 3) {
			ulDetail = "<li class=\"prev\"><a href=\"javascript:getPage("
					+ parseInt(currNum - 1) + ")\">上一页</a></li>"
					+ "<li class=\"numb\"><a href=\"javascript:getPage("
					+ parseInt(currNum - 2) + ")\">" + parseInt(currNum - 2)
					+ "</a></li>"
					+ "<li class=\"numb\"><a href=\"javascript:getPage("
					+ parseInt(currNum - 1) + ")\">" + parseInt(currNum - 1)
					+ "</a></li>"
					+ "<li class=\"numb choose\"><a href=\"javascript:getPage("
					+ currNum + ")\">" + currNum + "</a></li>"
					+ "<li class=\"next\"><a href=\"javascript:getPage("
					+ currNum + ")\">下一页</a></li>";
		} else if (currNum == 1 && number > 3) {
			ulDetail = "<li class=\"prev\"><a href=\"javascript:void(0)\">上一页</a></li>"
					+ "<li class=\"numb choose\"><a href=\"javascript:void(0)\">1</a></li>"
					+ "<li class=\"numb\"><a href=\"javascript:getPage(2)\">2</a></li>"
					+ "<li class=\"numb\"><a href=\"javascript:getPage(3)\">3</a></li>"
					+ "<li class=\"next\"><a href=\"javascript:getPage(2)\">下一页</a></li>";
		} else {
			ulDetail = "<li class=\"prev\"><a href=\"javascript:getPage("
					+ parseInt(currNum - 1) + ")\">上一页</a></li>"
					+ "<li class=\"numb\"><a href=\"javascript:getPage("
					+ parseInt(currNum - 1) + ")\">" + parseInt(currNum - 1)
					+ "</a></li>"
					+ "<li class=\"numb choose\"><a href=\"javascript:getPage("
					+ currNum + ")\">" + currNum + "</a></li>"
					+ "<li class=\"numb\"><a href=\"javascript:getPage("
					+ parseInt(currNum + 1) + ")\">" + parseInt(currNum + 1)
					+ "</a></li>"
					+ "<li class=\"next\"><a href=\"javascript:getPage("
					+ parseInt(currNum + 1) + ")\">下一页</a></li>";
		}

		$(".fenye").append(ulDetail);

	}

	function choosele(num, cur) {
		if (num == cur) {
			return " choose";
		} else {
			return "";
		}
	}
</script>
</html>