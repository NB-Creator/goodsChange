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
	var excId=GetUrlParam("excId");
	$.ajax({
		url : "",
		type : "get",
		dataType : "text",
		data:{
			"excId":excId
		},
		success : function(data) {
			var excData = JSON.parse(data);
			loadData(excData);
		},
		erro : function() {

		}
	});
}
function loadData(excData) {
	$(".excId").append(excData.excId);
	$(".excDate").append(excData.excDate);
	
	$("#glogo_A").append(
			"<img width='150px' height='150px' src=" + excData.gimg_a[0] + ">");
	$("#gid_A").append(excData.gid_a);
	$("#gname_A").append(exccData.gname_a);
	
	$("#glogo_B").append(
			"<img width='150px' height='150px' src=" + excData.gimg_b[0] + ">");
	$("#gid_B").append(excData.gid_b);
	$("#gname_B").append(excData.gname_b);
	
	$(".excInfo").apppend(excData.info);
}