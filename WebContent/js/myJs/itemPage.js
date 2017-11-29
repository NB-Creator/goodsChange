/**
 * 
 */

window.onload = function() {
	$("#div1").click(function() {
		var div1 = document.getElementById("div1");
		var div2 = document.getElementById("div2");
		div1.style.background = "rgb(225, 218, 68)";
		div1.style.color = "white";
		div2.style.background = "white";
		div2.style.color = "black";
		document.getElementById("div3").style.display = "block";
		document.getElementById("div4").style.display = "none";
		
		getMessage();

	});
	$("#div2").click(function() {
		var div1 = document.getElementById("div1");
		var div2 = document.getElementById("div2");
		div2.style.background = "rgb(225, 218, 68)";
		div2.style.color = "white";
		div1.style.background = "white";
		div1.style.color = "black";
		document.getElementById("div4").style.display = "block";
		document.getElementById("div3").style.display = "none";
	});

}
var message = null;
var num = 10;
function getMessage() {
	var itemid=$("#itemid");
	$.ajax({
		url : "./",
		typpe : "post",
		dataType : "text",
		contentType : "application/json",
		data : JSON.stringify({
			"itemid" : itemid
		}),
		success : function(data) {
			message = JSON.parse(data);

			showMessage();
		}
	});
}
function showMessage() {
	var box = $(".messagebox");
	for (var j = (num - 10); j < num; j++) {
		if (message[j].uid == "") {
			box.append("<div class='tips'>已无更多评论</div>");
			return;
		}
		var e = "<span>" + "<div class='m_u_id'>" + message[j].uid + "</div>"
				+ "<div class='m_date'>" + message[j].date + "</div>"
				+ "<div class='m_info'>" + message[j].info + "</div>"
				+ "</span>";
		box.append(e);
	}
	var load=$(".loadbox");
	load.empty();
	if(num<message.length){
		load.append("<a href='javascript:onload()'><div class='load'>加载更多...</div></a>");
	}
}
//加载更多
function onload(){
	num+=10;
	showMessage();
}
// 发送留言
function sendMessage(itemid) {
	var message;
	message = $("#i-message").val();
	if (message == "") {
		message = $("#i-message").val("你什么都没填诶");
		return;
	}
	$.ajax({
		url : '../',
		type : "post",
		dataType : "text",
		data : {
			'id' : itemid,
			'message' : message
		},
		success : function(data) {

		},
		erro : function(data) {

		}
	});
}
// 收藏
function collect(itemid) {
	$.ajax({
		url : "./collect",
		type : "post",
		dataType : "text",
		success : function(data) {
			if (data == "success") {
				$("#collect").css("background", "color");
			} else {
				alert(data);
			}
		},
		erro : function() {

		}
	});
}
// 取消收藏
function cancelCollect(itemid) {
	$.ajax({
		url : "./cancelCollect",
		type : "post",
		dataType : "text",
		success : function(data) {
			if (data == "success") {
				$("#collect").css("background", "white");
			} else {
				alert(data);
			}
		},
		erro : function() {

		}
	});
}

// 图片展示
$(function() {
	$(".img-li img").mouseover(function(e) {
		$(".img-bg img").attr('src', this.src);
	});
});