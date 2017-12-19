var itemlist = null;
var num = 10;
// 获取收藏列表
function getCollect() {
	var uid = $("#username").text();
	$.ajax({
		type : "post",
		url : "../getCollect",
		dataType : "text",
		data : {
			'username' : username
		},
		success : function(data) {
			itemlist = JSON.parse(data);
			showItem();
		},
		erro : function() {
		}
	});
}
// 显示评论
function showItem(){
	
	var box = $(".row");
	box.empty();
	for (var j =0; j < num; j++) {
		if (itemlist[j] == null) {
			box.append("<div class='tips'>已无更多收藏</div>");
			return;
		}
		var e = "<div class='col-sm-3 col-md-4'>" + "<div class='thumbnail'>" 
				+"<img src='"+ itemlist[j].imgpath + "' alt='...' style='width:200px;height:195px'>"
				+ "<div class='caption's>" +"<h3>"+ itemlist[j].name + "</h3>"+"<p>商品价格："+itemlist[j].price+"</p>"
				+ "</div>" +"</div>"+ "</div>";
		box.append(e);
	}
	if (num < itemlist.length) {
		load
				.append("<a href='javascript:onload()'><div class='load'>加载更多...</div></a>");
	}
}
// 加载更多
function onload() {
	num += 10;
	showItem();
}
