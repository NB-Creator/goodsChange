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
		<link type="text/css" rel="stylesheet" href="./css/bootstrap.css">
		<link type="text/css" rel="stylesheet" href="./css/bootstrap-table.css">
		<link type="text/css" rel="stylesheet" href="./css/font-awesome.css">

		<script type="text/javascript" src="/js/jquery-3.1.1.js"></script>
		<script type="text/javascript" src="/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/js/bootstrap-table.js"></script>
		<link href="css/message.css" rel="stylesheet">
		<style>
			.message_body {
				width:100%;
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
			
			.message_box {
				width: 100%;
				height: auto;
				margin-top: 20px;
				padding: 20px;
				background: rgb(253,248,241);
			}
			
			.message_param {
				width: 100%;
				height: 50px;
				border-bottom: 1px solid #D9EDF7;
			}
			.tips{
				width: 100%;
				height: 30px;
				line-height: 30px;
				text-align: center;
			}
		</style>
	</head>

	<body>
		<!--<jsp:include page="../head-top.jsp"></jsp:include>-->
		<div class="message_body">
			<div class="message_title">系统通知</div>

			<div class="message_box">
				<div class="message_param"></div>
				<div class="message_param"></div>
				<div class="message_param"></div>
				<div class="message_param"></div>
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
		<script>
		</script>
	</body>

</html>