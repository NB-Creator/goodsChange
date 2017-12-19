<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>用户主页</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/otherUser.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <link type="text/css" rel="stylesheet" href="../css/font-awesome.css">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
    <script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.1/jquery.js"></script>
    <script type="text/javascript" src="js/jpage.js"></script>
    <script type="text/javascript" src="js/page.js"></script>
</head>
<body>
     <jsp:include page="../head-top.jsp"></jsp:include>
    <div class="left-menu left">
        <ul>
            <li class="active">基本信息</li>
            <li>商品列表</li>
            <li>历史交易</li>
        </ul>
    </div>
    <div class="right-data left">
        <div>
            <div class="user-img left"><img></div>
            <!-- 添加头像 -->
            <div class="user-name left"><span>昵称</span><b>换了呗</b></div>
            <!--昵称-->
            <table class="user-infor clear back">
                <!--信息-->
                <caption>主要信息</caption>
                <tr>
                    <td><span>所在地:</span><b>四川省成都市龙泉驿区十陵上街1号</b></td>
                </tr>
                <tr>
                    <td><span>邮箱:</span><b>1253551@qq.com</b></td>
                </tr>
            </table>
        </div>
        <div>
            <div id="item-data">
                <div><img src="images/1.jpg" alt="">
                    <div class="item-name"><span>商品名</span><p >小笑傲小撒大叔大叔大哦</p></div>
                    <div class="item-mon"><span>简介</span><p>(其他用户的主页，即我们点击商品发布者名字进去的页面)</p></div>
                </div>
                <div><img src="images/2.jpg" alt="">
                    <div class="item-name"><span>商品名</span><p>2</p></div>
                    <div class="item-mon"><span>简介</span><p>(其他用户的主页，即我们点击商品发布者名字进去的页面)</p></div>
                </div>
                <div><img src="images/3.jpg" alt="">
                    <div class="item-name"><span>商品名</span><p>3</p></div>
                    <div class="item-mon"><span>简介</span><p>(其他用户的主页，即我们点击商品发布者名字进去的页面)</p></div>
                </div>
                <div><img src="images/4.jpg" alt="">
                    <div class="item-name"><span>商品名</span><p>4</p></div>
                    <div class="item-mon"><span>简介</span><p>(其他用户的主页，即我们点击商品发布者名字进去的页面)</p></div>
                </div>
            </div>
            <div id="test"></div>
            
            </div>
            <div>
                <table class="user-history">
                    <caption>历史交换数据</caption>
                    <tr>
                        <td><span>总交换量</span><b>200</b></td>
                    </tr>
                    <tr>
                        <td><span>交换成功量</span><b>80</b></td>
                    </tr>
                </table>
            </div>
        </div>
</body>
<script>
    $(document).ready(function () {
        $(".left-menu>ul>li").click(function () {
            $(this).parent().find("li").removeClass("active");
            $(this).addClass("active");
            var index = $(".left-menu>ul>li").index(this);
            $(".right-data").children("div").css("display", "none").eq(index).css("display", "block");
        })
        $(".right-data>div table tr:odd").addClass("backodd");
        $(".right-data>div table tr:even").addClass("backeven");
        $(".right-data>div table tr").mouseover(function () {
            $(this).addClass("backmouse");
        }).mouseout(function () {
            $(this).removeClass("backmouse");
        })
        
    })
</script>

</html>