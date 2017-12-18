/**
 * 
 */
$(function() {
	getData();
});

function GetUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
function getData() {
	var itemId = GetUrlParam("itemId");
	$.ajax({
		url : "",
		type : "get",
		dataType : "text",
		data : {
			"itemId" : itemId
		},
		success : function(data) {
			var item ;
			item= JSON.parse(data);
			showData(item);
		},
		erro : function() {

		}

	});
}
function showData(item) {
	$("#i-name").append(item.name);
	$("#i-id").append(item.id);
	$("#i-date").append(item.date);
	$("#i-type").append(item.type);
	$("#i-expect").append(item.expect);
	$("#i-price").apppend(item.price);
	var length = item.img.length;
	for (var i = 0; i < length; i++) {
		$("#i-img").append("<img src='" + item.img[i] + "'>");
	}

	$("#i-info").append(item.detail);
	$("#i-collect").append(item.collect);
	$("#i-rq").append(item.rq);
	$("#i-comment").append(item.comment);
}