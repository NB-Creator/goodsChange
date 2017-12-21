//页面加载后自动执行
$(function () {
	getData();
});
var subMit;
//获取以提交的商品数据列表
function getData() {
    $.ajax({
        url:"/getExchange",
        type:"get",
        dataType:"text",
        success:function(data){//data为后台返回的json字符串内容为已提交订单(类ExcData.java)的列表，通过JSON.parse解析
            subMit=JSON.parse(data);
            showData();
        },
        erro:function () {
            alert("服务器炸了");
        }
    });
}

var num=10;

//将json数据添加到网页
function showData() {
	var json={};
	var box = $(".itemTable");//用以显示数据的容器
    var load = $(".loadbox");//显示加载按钮的容器
    box.empty();
    load.empty();
    
	for (var j =0; j < num; j++) {
		if (subMit[j] == null) {//当列表遍历完后显示提示信息
			box.append("<div class='tips'>已无更多信息</div>");
			return;
		}
		var e ="<div class='order'>"+
					"<div class='img_a'><img src="+subMit[j].img_a+">"+
					"<div class='gname'><a href='/itemPage/itemid="+subMit[j].gid_a+"'>"+subMit[j].gname_a+"</a></div>"+
					"</div>"+
					"<div class='img_b'><img src="+subMit[j].img_b+">"+
						"<div class='gname'><a href='/itemPage/itemid="+subMit[j].gid_b+"'>"+subMit[j].gname_b+"</a></div>"+
					"</div>"+
					"<div class='eid'>单号："+subMit[j].excId+"</div>"+
					"<div class='eDate'>提交时间："+subMit[j].excDate+"</div>"+	
					"<div class='eInfo'>备注信息："+subMit[j].info+"</div>"
			" </div>"
		box.append(e);
	}
	if (num < subMit.length) {
		load
				.append("<a href='javascript:onload()'><div class='load'>加载更多...</div></a>");
	}


}

//加载更多数据
function onload() {
	num += 10;
	showData();
}

