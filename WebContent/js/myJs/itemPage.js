/**
 * 
 */

var message = null;
var num = 10;
// 获取评论列表
function getMessage() {
	var itemid = $("#itemid").text();
	
	$.ajax({
		url : "../getComment",
		type : "post",
		dataType : "text",
		
		data : {
			"itemid" : itemid
		},
		success : function(data) {
			message = JSON.parse(data);
			showMessage();
		}
	});
}
// 显示评论
function showMessage() {
	var box = $(".messagebox");
	box.empty();
	for (var j =0; j < num; j++) {
		if (message[j] == null) {
			box.append("<div class='tips'>已无更多评论</div>");
			return;
		}
		var e = "<span>" + "<div class='m_u_id'>" + message[j].u_id + "</div>"
				+ "<div class='m_date'>" + message[j].date + "</div>"
				+ "<div class='m_info'>" + message[j].info + "</div>"
				+ "</span>";
		box.append(e);
	}
	var load = $(".loadbox");
	load.empty();
	if (num < message.length) {
		load
				.append("<a href='javascript:onload()'><div class='load'>加载更多...</div></a>");
	}
}
// 加载更多
function onload() {
	num += 10;
	showMessage();
}
// 发送留言
function sendMessage(uid) {
	var message;
	var itemid = $("#itemid").text();
	message = $("#i-message").val();
	if (message == "") {
		message = $("#i-message").val("你什么都没填诶");
		return;
	}
	
	else{
		alert(uid);
		$.ajax({
			url : "../comment",
			type : "post",
			dataType : "text",
			data : {
				'g_id' : itemid,
				'info' : message,
				'u_id' : uid
			},
			success : function(data) {
				if (data == "success") {
					alert("发送次成功");
				}
			},
			erro : function() {
			}
		});
	}
}

// 是否已收藏
function isCollect() {
	var itemid = $("#itemid").text();
	var collect = $("#i_collect");
	$
			.ajax({
				url : "../isCollect",
				type : "get",
				dataType : "text",
				data : {
					"itemid" : itemid
				},
				success : function(data) {
					if (data == "exist") {
						collect
								.append("已收藏<br><span class='icon-heart-empty' id='collect' style='color:red;' onclick='cancelCollect()'></span></div>");
					} else if (data = "no") {
						collect
								.append("收藏<br><span class='icon-heart-empty' id='collect' onclick='collect()'></span></div>");
					}
				},
				erro : function() {

				}
			});
}

// 收藏
function collect() {
	var itemid = $("#itemid").text();
	var collect = $("#i_collect");
	$
			.ajax({
				url : "../collect",
				type : "post",
				dataType : "text",
				data : {
					"itemid" : itemid
				},
				success : function(data) {
					if (data == "success") {
						alert("收藏成功");
						collect.empty();
						collect
								.append("已收藏<br><span class='icon-heart-empty' id='collect' style='color:red;' onclick='cancelCollect()'></span></div>");
					} else {
						alert(data);
					}
				},
				erro : function() {
					alert("服务器异常");
				}
			});
}
// 取消收藏
function cancelCollect() {
	alert("取消");
	var itemid = $("#itemid").text();
	var collect = $("#i_collect");
	$
			.ajax({
				url : "../cancelCollect",
				type : "post",
				dataType : "text",
				data : {
					"itemid" : itemid
				},
				success : function(data) {
					if (data == "success") {
						collect.empty();
						collect
								.append("收藏<br><span class='icon-heart-empty' id='collect' onclick='collect()'></span></div>");
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
	$("#div1").click(function() {
		var div1 = document.getElementById("div1");
		var div2 = document.getElementById("div2");
		div1.style.background = "rgb(225, 218, 68)";
		div1.style.color = "white";
		div2.style.background = "white";
		div2.style.color = "black";
		document.getElementById("div3").style.display = "block";
		document.getElementById("div4").style.display = "none";

		

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
		getMessage();
	});
	isCollect();
	$(".img-li img").mouseover(function(e) {
		$(".img-bg img").attr('src', this.src);
	});
});