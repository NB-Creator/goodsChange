
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>消息通知</title>
<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/css/bootstrap-table.css">
<link type="text/css" rel="stylesheet" href="/css/font-awesome.css">

<script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-table.js"></script>
<link href="css/message.css" rel="stylesheet">
<style>
.message_body {
	width: 100%;
	margin-top: 50px;
	/*padding-left: 20px;
					padding-right:20px ;*/
	border-top: 3px solid black;
}

.message_title {
	margin-top: -30px;
	width: 100%;
	height: 30px;
	font-size: 20px;
	background: black;
	color: wheat;
	padding-left: 20px;
	font-family: "微软雅黑";
	font-weight: 600;
}
.table {table-layout:fixed;}
.message_box {
	width: 100%;
	height: auto;
	margin-top: 20px;
	padding: 20px;
	background: rgb(253, 248, 241);
}

.message_param {
	width: 100%;
	height: 50px;
	border-bottom: 1px solid #D9EDF7;
}

.tips {
	width: 100%;
	height: 30px;
	line-height: 30px;
	text-align: center;
}
</style>
</head>

<body>
	<jsp:include page="../head-top.jsp"></jsp:include>
	<div class="message_body">
		<div class="message_title">交换通知</div>

		<div class="message_box" id="message_box">
		</div>
		<div class="tips">没有更多消息</div>
	</div>

	<!-- <div class="container">
	      <div class="message">
	        <div class="row">
	          <div class="sub-menu col-xs-2">
	            <h4>消息提醒</h4>
	            <ul>
	              <li><a href="#">商品消息</a></li>
	              <li><a href="#">处理消息</a></li>
	              <li><a href="#">评论</a></li>
	              <li><a href="#">系统消息</a></li>
	            </ul>
	          </div>
	          <div class="content col-xs-10">
	            <h2>商品消息 <small>共9条</small></h2>
	            <div class="msg-item">
	              <div class="msg-item-head"><b>物流信息：</b>你物品有新的动态</div>
	              <div class="msg-item-body clearfix">
	                  <div class="msg-item-img">
	                    <a href="#"><img src="/images/img1.jpg" alt=""></a>
	                  </div>
	                  <div class="msg-item-txt">
	                    <h5>订单号：10905724548****613</h5>
	                    <p>快递已签收</p>
	                    <a href="#">详细信息</a>
	                  </div>
	              </div>
	              <div class="msg-item-footer">
	                  <p>1天前</p>
	              </div>
	            </div>
	            <div class="msg-item">
	              <div class="msg-item-head"><b>物流信息：</b>你物品有新的动态</div>
	              <div class="msg-item-body clearfix">
	                  <div class="msg-item-img">
	                    <a href="#"><img src="/images/img1.jpg" alt=""></a>
	                  </div>
	                  <div class="msg-item-txt">
	                    <h5>订单号：10905724548****613</h5>
	                    <p>快递已签收</p>
	                    <a href="#">详细信息</a>
	                  </div>
	              </div>
	              <div class="msg-item-footer">
	                  <p>1天前</p>
	              </div>
	            </div>
	            <div class="msg-item">
	              <div class="msg-item-head"><b>物流信息：</b>你物品有新的动态</div>
	              <div class="msg-item-body clearfix">
	                  <div class="msg-item-img">
	                    <a href="#"><img src="/images/img1.jpg" alt=""></a>
	                  </div>
	                  <div class="msg-item-txt">
	                    <h5>订单号：10905724548****613</h5>
	                    <p>快递已签收</p>
	                    <a href="#">详细信息</a>
	                  </div>
	              </div>
	              <div class="msg-item-footer">
	                  <p>1天前</p>
	              </div>
	            </div>
	            <div class="msg-item">
	              <div class="msg-item-head"><b>物流信息：</b>你物品有新的动态</div>
	              <div class="msg-item-body clearfix">
	                  <div class="msg-item-img">
	                    <a href="#"><img src="/images/img1.jpg" alt=""></a>
	                  </div>
	                  <div class="msg-item-txt">
	                    <h5>订单号：10905724548****613</h5>
	                    <p>快递已签收</p>
	                    <a href="#">详细信息</a>
	                  </div>
	              </div>
	              <div class="msg-item-footer">
	                  <p>1天前</p>
	              </div>
	            </div>
	            <div class="msg-item">
	              <div class="msg-item-head"><b>物流信息：</b>你物品有新的动态</div>
	              <div class="msg-item-body clearfix">
	                  <div class="msg-item-img">
	                    <a href="#"><img src="/images/img1.jpg" alt=""></a>
	                  </div>
	                  <div class="msg-item-txt">
	                    <h5>订单号：10905724548****613</h5>
	                    <p>快递已签收</p>
	                    <a href="#">详细信息</a>
	                  </div>
	              </div>
	              <div class="msg-item-footer">
	                  <p>1天前</p>
	              </div>
	            </div>
	            <div class="msg-item">
	              <div class="msg-item-head"><b>物流信息：</b>你物品有新的动态</div>
	              <div class="msg-item-body clearfix">
	                  <div class="msg-item-img">
	                    <a href="#"><img src="/images/img1.jpg" alt=""></a>
	                  </div>
	                  <div class="msg-item-txt">
	                    <h5>订单号：10905724548****613</h5>
	                    <p>快递已签收</p>
	                    <a href="#">详细信息</a>
	                  </div>
	              </div>
	              <div class="msg-item-footer">
	                  <p>1天前</p>
	              </div>
	            </div>
	            <div class="msg-item">
	              <div class="msg-item-head"><b>物流信息：</b>你物品有新的动态</div>
	              <div class="msg-item-body clearfix">
	                  <div class="msg-item-img">
	                    <a href="#"><img src="/images/img1.jpg" alt=""></a>
	                  </div>
	                  <div class="msg-item-txt">
	                    <h5>订单号：10905724548****613</h5>
	                    <p>快递已签收</p>
	                    <a href="#">详细信息</a>
	                  </div>
	              </div>
	              <div class="msg-item-footer">
	                  <p>1天前</p>
	              </div>
	            </div>
	            <div class="msg-item">
	              <div class="msg-item-head"><b>物流信息：</b>你物品有新的动态</div>
	              <div class="msg-item-body clearfix">
	                  <div class="msg-item-img">
	                    <a href="#"><img src="/images/img1.jpg" alt=""></a>
	                  </div>
	                  <div class="msg-item-txt">
	                    <h5>订单号：10905724548****613</h5>
	                    <p>快递已签收</p>
	                    <a href="#">详细信息</a>
	                  </div>
	              </div>
	              <div class="msg-item-footer">
	                  <p>1天前</p>
	              </div>
	            </div>
	
	            <nav aria-label="Page navigation">
	              <ul class="pagination">
	                <li>
	                  <a href="#" aria-label="Previous">
	                    <span aria-hidden="true">&laquo;</span>
	                  </a>
	                </li>
	                <li class="active"><a href="#">1</a></li>
	                <li><a href="#">2</a></li>
	                <li><a href="#">3</a></li>
	                <li><a href="#">4</a></li>
	                <li><a href="#">5</a></li>
	                <li>
	                  <a href="#" aria-label="Next">
	                    <span aria-hidden="true">&raquo;</span>
	                  </a>
	                </li>
	              </ul>
	            </nav>
	          </div>    
	        </div>
	      </div>
	    </div>
	 -->

</body>

<script type="text/javascript">
	var users = $('#message_box').bootstrapTable({
		url : "/getMessage", //请求的后台连接，需要请求到json数据
		method : 'get', //请求方式
		striped : true, //是否显示行间隔色
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, //是否显示分页（*）
		sortable : true, //是否启用排序
		sortOrder : "asc", //排序方式
		queryParams : function(param) {
			return {};
		},
		sidePagination : "client", //分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, //初始化加载第一页，默认第一页
		pageSize : 5, //每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ], //可供选择的每页的行数（*）
		showExport : true, //是否显示导出	
		exportDataType : "basic", //basic', 'all', 'selected'.
		columns : [ {
			field : 'usernameA',
			title : '发送者',
			width:'20%',
		}, {
			field : 'excId',
			title : '交换单id',
			formatter:"excUrl",
			editable : true,
			events : "read",
			width:'25%',
		}, {
			field : 'message',
			title : '备注信息',
			editable : true,
			width:'35%',
		},{
			field:"statu",
			title:'状态',
			formatter:"status",
			width:'10%',
		}, {
			field : 'do',
			title : '操作',
			formatter : "options",
			events : "events",
			width:'200px',
		} ],
		/* 修改后点勾那个按钮触发的方法 */
	})
	function options(value, row, index) {
		return [
				'<button type="button" class="delete btn btn-default  btn-sm" style=" width:100%;">删除</button>', ]
				.join('');
	}
	function status(value,row,index){
		if(row.statu==0)
			return "未读";
		else if(row.statu==1)
			return "已读"
	}
	function excUrl(value,row,index){
		return "<a href='excData?excid="+row.excId+"'>"+value+"</a>"
	}
	var events = window.operateEvents = {
		'click .delete' : function(e, value, row, index) {
			$.ajax({
				type : "get", //ajax post方式请求
				url : "/deleteMsg",
				dataType : "text",//因为处理方法返回的类型 text
				data : {//请求的参数
					"excId" : row.excId,
				},
				success : function(data) {
					if (data =="s") {
						alert("删除成功")
						users.bootstrapTable("refresh", {
							url : "/getMessage"
						})
					}
				},
				error : function(msg) {
					alert("服务器GG了...");
				}
			});
		}
	};
	var read = window.operateEvents = {
			
			'click a' : function(e, value, row, index) {
				$.ajax({
					type : "get", //ajax post方式请求
					url : "/changeMessage",
					dataType:"text",
					data:{
						"excId":value
					},
					success : function(data) {
						alert("cheng");
					},
					error : function() {
						
					}
				});
			}
		}
</script>
</html>