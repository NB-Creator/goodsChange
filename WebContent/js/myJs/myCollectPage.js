//页面加载后自动执行
$(function () {
	getCollect();
});
var itemlist;
var num = 9;
// 获取收藏列表
function getCollect() {
	var itemid = $("#itemid").text();
	$.ajax({
        url:"/item/getCollect",
        type:"get",
        success:function(data){//data为后台返回的json字符串内容为已提交订单(类ExcData.java)的列表，通过JSON.parse解析
        	itemlist=JSON.parse(data);
            showItem();
        },
        erro:function () {
            alert("服务器炸了");
        }
    });
}
// 显示
function showItem(){
	
	var box = $(".itembox");
	var load = $(".loadbox");//显示加载按钮的容器
	box.empty();
	load.empty();
	for (var j =0; j < num; j++) {
		if (itemlist[j] == null) {
			box.append("<div class='col-sm-12' style='color:white;text-align: center;'>已经没有啦》_《~</div>");
			return;
		}
		var e = "<div class='col-sm-3 col-md-4' style='color:white;'>" + "<div class='thumbnail'>" 
				+"<div class='gname' style='width:200px;height:35px'>"
					+"<a style='color:black;' href='/item/itemid="+itemlist[j].id+"'>"+itemlist[j].name+"</a></div>"
					+"<a href='/item/itemid="+itemlist[j].id+"'>"
						+"<img style='width:400px;height:200px' src='/"+itemlist[j].imgpath[0]+"'>"
					+"</a></div>"
				+ "<div class='caption'>" +"<h3>"+ itemlist[j].name + "</h3>"+"<p>商品价格："+itemlist[j].price+"</p>"
				+ "</div>" +"</div>"+ "</div>";
		box.append(e);
	}
	if (num < itemlist.length) {
		load.append("<a href='javascript:onload()'><div class='load' style='color=white;text-align: center;'>加载更多...</div></a>");
	}
}
// 加载更多
function onload() {
	num += 6;
	showItem();
}
