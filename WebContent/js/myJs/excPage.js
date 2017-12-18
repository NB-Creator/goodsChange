/**
 * 
 */
var jsonData = null;
var length;
window.onload = getData;

function sendData(){
	var gid_a=$("#gid_a").text();
	var gid_b=$("#gid_b").text();
	var info=$("#info").val();
	if(gid_a==""){
		var g_a = $(".e_mP");
		g_a.empty();
		g_a.append("<div style='color:red;'>你没有选择一个用以交换的商品</div>");
		return;
		
	}
	$.ajax({
		url:'./itemExc',
		type:'post',
		dataType:'text',
		data:{
			"gid_a":gid_a,
			"gid_b":gid_b,
			"info":info
		},
		success:function(data){
			
				self.location="./excSuccess?"+data;
			
		},
		erro:function(){
			alert("服务器异常...")
		}
		
	});
}

function getData() {
	var username=$("#username").text();
	
	$.ajax({
		url : "./getItemList",
		type : 'post',
		dataType:"text",
		contentType:"application/json",
		data:JSON.stringify({
			"uid":username
		}),
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

function addTo(j) {

	var ul = $(".e_mP");
	ul.empty();
	var e = "<li>"
			+ "<div class='item_logo' onclick='remove()'><img width='100px' height='100px' src="
			+ jsonData[j].imgpath[0]
			+ "></div>"
			+ "<div class='item_id'><span style='margin-top:5px;'>商品ID:</span><div id='gid_a'>"
			+ jsonData[j].id
			+ "</div></div></br>"
			+ "<div class='item_name'>"
			+ jsonData[j].name
			+ "<button onclick='remove()' class='btn btn-defualt'>点击删除</button></div></li>";
	ul.append(e);

}

function remove() {
	var ite = $(".e_mP");
	ite.empty();
	ite.append("<span>点击右侧我的商品添加到此处</span>");
}
function getPage(pn) {
	var dataCount = length;
	var pageSize = 4;
	var pageCount = Math.ceil(dataCount / pageSize);
	var ul = $(".item_l");
	
	if (pn == 0 || pn > pageCount) {
		return;
	}
	// console.log(pageCount+"..."+pn)
	paintPage(pageCount, pn); //
	var startPage = pageSize * (pn - 1);
	ul.empty();
	if(length==0){
		ul.append("<label style='margin-top:30px;color:red;'>你还没有上传任何商品</label><a href='./addItemPage'><button class='btn btn-danger'>点我上传</button></a>");
		return;
	}
	if (pageCount == 1) { // 
		for (var j = 0; j < dataCount; j++) {
			var fun = "addTo(" + j + ")";
			var e = "<li>" + "<div class='item_logo' onclick='" + fun
					+ "'><img width='100px' height='100px' src="
					+ jsonData[j].imgpath[0] + "></div>"
					+ "<div class='item_id'>ID:" + jsonData[j].id
					+ "</div></br>" + "<div class='item_name'>"
					+ jsonData[j].name + "</div></li>";
			ul.append(e);
		}
	} else { //
		var e = "";
		var endPage = pn < pageCount ? pageSize * pn : dataCount;
		for (var j = startPage; j < endPage; j++) {
			var fun = "addTo(" + j + ")";
			var e = "<li>" + "<div class='item_logo' onclick='" + fun
					+ "'><img width='100px' height='100px' src="
					+ jsonData[j].imgpath[0] + "></div>"
					+ "<div class='item_id'>ID:" + jsonData[j].id
					+ "</div></br>" + "<div class='item_name'>"
					+ jsonData[j].name + "</div></li>";
			ul.append(e);
		}
	}
}

// 绘制页码
function paintPage(number, currNum) // number 总页数,currNum 当前页
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
				+ "<li class=\"next\"><a href=\"javascript:getPage(" + currNum
				+ ")\">下一页</a></li>";
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