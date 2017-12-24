/**
 * 
 */
var classification = "";
var imgpath = "";
var images = new Array();
function addImg(file, type) {
	var fileReader = new FileReader();
	var path = ""
	fileReader.readAsDataURL(file.files[0])
	fileReader.onload = function(evt) {
		path = evt.target.result
		if (images.length > 7) {
			alert("最多只能上传八张图片哦~");
			return;
		}
		for (var i = 0; i < images.length; i++) {
			var img = images[i]
			if (img.path == path) {
				alert("图片已经存在")
				return;
			}
		}
		var img = '<div class="btn_upload" onclick="deleteImg(this)">'
				+ '<img  src="' + path + '" /> ' + '</div>';
		$("#imgs").prepend(img)
		var image = {
			"span" : $("#imgs").children("div:first-child").children("span"),
			"file" : file.files[0],
			"path" : path
		}
		images.push(image)
		file.value = ""
	}

}

function deleteImg(img) {

	var src = $(img).children("img")[0].src;
	$(img).remove();
	for (var i = 0; i < images.length; i++) {
		var img = images[i]
		if (src == img.path) {
			images.splice(i, 1)
		}
	}

}
function uploadImgs() {
	for (var i = 0; i < images.length; i++) {
		var img = images[i];
		var form = new FormData();
		form.append("img", img.file);
		$.ajax({
			type : "post",
			url : "/file/uploadImg",
			data : form,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(data, status) {
				if (imgpath == "") {
					imgpath = data;
				} else {
					imgpath = imgpath + "*" + data;
				}
			},
			error : function() {
				alert("服务器异常");
			},
			complete : function() {

			}
		});
	}
}
window.onload = function() {
	$('#classification li').click(function() {
		classification = ($(this).text());
		alert(classification);
		$("#s_type").empty();
		$("#s_type").append(classification);
	});
}
function addItem() {
	var name = document.getElementById("name").value;
	var detail = document.getElementById("detail").value;
	var price = document.getElementById("price").value;
	var expect = document.getElementById("expect").value;

	if (name == "") {
		alert("请填写一个名称");
		return;
	}
	if (detail == "") {
		alert("你没有填写任何内容");
		return;
	}
	if (classification == "") {
		alert("请选择一个分类");
		return;
	}
	if (price == "") {
		alert("请填写一个预估价格");
		return;

	}
	if (expect == "") {
		alert("请填写一个期望商品");
		return;
	}
	uploadImgs();

	$.ajax({
		url : '/item/uploadItem',
		type : 'post',
		dataType : 'text',
		traditional : true,
		data : {
			'name' : name,
			'detail' : detail,
			'img' : imgpath,
			'expect' : expect,
			'classification' : classification,
			'price' : price
		},
		success : function(data) {
			if (data == "success")
				self.location = "addSuccessPage";
			else
				alert("添加失败");
		},
		error : function() {
			alert("服务器异常-");
		}
	});
	classification = "";
	imgpath = "";
	images = new Array();
}