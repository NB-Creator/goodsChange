/**
 * 
 */
window.onload=function(){
		document.getElementById("div1").checked=true;	
	}
	$("#div1").click(function(){
		var div1=document.getElementById("div1");
		var div2=document.getElementById("div2");
		div1.style.background="rgb(225, 218, 68)";
		div1.style.color="white";
		div2.style.background="white";
		div2.style.color="black";
		document.getElementById("div3").style.display="block";
		document.getElementById("div4").style.display="none";
	});
	$("#div2").click(function(){
		var div1=document.getElementById("div1");
		var div2=document.getElementById("div2");
		div2.style.background="rgb(225, 218, 68)";
		div2.style.color="white";
		div1.style.background="white";
		div1.style.color="black";
		document.getElementById("div4").style.display="block";
		document.getElementById("div3").style.display="none";
	});
	
	function sendMessage(itemid){
		var message;
		message=$("#i-message").val();
		if(message==""){
			message=$("#i-message").val("你什么都没填诶");
			return;
		}
		$.ajax({
			url:'../',
			type:post,
			dataType:text,
			data:{
				'id':itemid,
				'message':message
			},
			success:function(data){
			
			},
			erro:function(data){
				
			}
		});
	}
	$(function(){
		$(".img-li img").mouseover(function(e){
			$(".img-bg img").attr('src',this.src);
		});
	});