<%@ page language="java" import="java.util.*,org.apache.struts2.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title><s:property value="%{news.title}"/></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8">
	<link rel="stylesheet" href="CSS/bootstrap.min.css">
	<link rel="shortcut icon" type="image/x-icon" href="logo/logo.png"/>
	<script type="text/javascript" src="Javascript/jquery1.2.0.js"></script>
  	<script src="Javascript/bootstrap.min.js" type="text/javascript"></script>
  	<style type="text/css">
    body{
      margin:0 auto;
    }
    #main{
      width:1050px;
      height:100px;
    }
  </style>
  <script>
  $(document).ready(function(){
	  	var num=0;
	      var pagination=$(".pagination");
	      var CommentPage=0;
	  	//请求获得评论页数
	  	$.ajax({
		        type : 'GET',
		        url : 'getCommentPagetAction.action',
		        data : {
		        	newsID:"<s:property value='%{news.NumberId}'/>"
		        },
		        success : function (response, stutas, xhr) {
		          CommentPage=parseInt(response.CommentPage);
		          //alert(response.CommentPage);//有几条
		        	if(parseInt(response.CommentPage)/10<1){
		          		num=response.CommentPage/10;
		          		$("#showComment").load("getCommentListAction?news.NumberId=<s:property value='%{news.NumberId}' />", {startlist:1,endlist:response.CommentPage}, "");
		          	}else{
		          		if(parseInt(response.CommentPage)%10==0){
		          			num=parseInt(response.CommentPage/10);
		          		}else{
		          			num=parseInt(response.CommentPage/10)+1;
		          		}
		          		$("#showComment").load("getCommentListAction?news.NumberId=<s:property value='%{news.NumberId}' />", {startlist:1,endlist:10}, "");
		          	}
		            if(num<1){
		                  pagination.append("<li ><a href='javascript:void(0)' >&laquo</a></li>"+
		                 "<li class='active'><a href='javascript:void(0)'>1</a></li>"+
		                 "<li ><a href='javascript:void(0)'>&raquo</a></li>");
		            }else if(num <=8){
		                  pagination.append("<li ><a href='javascript:void(0)' >&laquo</a></li>"+
		                      "<li class='active'><a href='javascript:void(0)'>1</a></li>");
		                  for(var i=2;i<=num;i++){
		                      pagination.append("<li ><a href='javascript:void(0)'>"+i+"</a></li>");
		                  }
		                  pagination.append("<li ><a href='javascript:void(0)'>&raquo</a></li>");
		            }else if(num>8){
		                  pagination.append("<li ><a href='javascript:void(0)' >&laquo</a></li>"+
		                      "<li class='active'><a href='javascript:void(0)'>1</a></li>");
		                  for(var i=2;i<=7;i++){
		                      pagination.append("<li ><a href='javascript:void(0)'>"+i+"</a></li>");
		                  }
		                  pagination.append("<li ><a href='javascript:void(0)'>...</a></li>"+"<li ><a href='javascript:void(0)'>&raquo</a></li>");
		             }
		              
		        }
		      });
	  	
	  	$(document).on("click",".pagination li",function(){ 
	  		
	  		if($(this).text()=="«"){
	  			if($(".pagination .active").prev().text()!="«"){
	  				var a=$(".pagination .active").index();
	  				$(".pagination .active").prev().addClass("active").click();
	  				$(".pagination li").eq(a).removeClass("active");
	  			}
	  		}else if($(this).text()=="»"){
	  			if($(".pagination .active").next().text()!="»"){
	  				var a=$(".pagination .active").index();
	  				$(".pagination .active").next().addClass("active").click();
	  				$(".pagination li").eq(a).removeClass("active");
	  			}
	  		}else{
	  			if(parseInt($(this).text())==num){
	      			$("#showComment").load("getCommentListAction?news.NumberId=<s:property value='%{news.NumberId}' />", {startlist:parseInt($(this).text())*10-9,endlist:parseInt(CommentPage)}, "");
	      			$(".pagination .active").removeClass("active");
	          		$(this).addClass("active");
	      		}else{
	      			$("#showComment").load("getCommentListAction?news.NumberId=<s:property value='%{news.NumberId}' />", {startlist:parseInt($(this).text())*10-9,endlist:parseInt($(this).text())*10}, "");
	      			$(".pagination .active").removeClass("active");
	          		$(this).addClass("active");
	      		}
	  		}
	  		$(window).scrollTop($("#PublishConment").offset().top);
			});
	  	
	  	
	  	
			$(".UserLoginButton").click(function(){
			 $.ajax({
		        type : 'GET',
		        url : 'LoginAction.action',
		        data : {
		        	username:$("#inputusername").val(),
		        	password:$("#inputpassword").val()
		            },
		        success : function (response, stutas, xhr) {
		        	if(response.requestResult=="success"){
		        		$("#closeModel").click();
		        		alert("登录成功");
		        		location.reload();
		        	}else{
		        		$("#errormessage").prepend("<img src='Image/alarm.png' style='margin-top: -3px'>用户名或密码错误,请重新输入!");
		        	}
		        }
		      });
	    });
	    
	    $(".exit").click(function(){
			 $.ajax({
		        type : 'GET',
		        url : 'ExitAction.action',
		        data : {},
		        success : function (response, stutas, xhr) {
		        	if(response.requestResult=="success"){
		        		window.location.href="index.jsp"; 
		        	}else{
		        		alert("退出异常!");
		        	}
		        }
		      });
	     });
	    
	    $("#PublishConment").click(function(){
	  	  $.ajax({
	  	        type : 'GET',
	  	        url : 'addCommentAction.action',
	  	        data : {
	  	        	userID:"<s:property value='%{#session.USERID}'/>",
	  	        	newsID:$("#NID").val(),
	  	        	"comment.context":$("#CommentContent").val()
	  	        },
	  	        success : function (response, stutas, xhr) {
	  	        	if(response.requestResult=="success"){
	  	        		alert("发表成功!");
	  	        		$("#CommentContent").val("");
	  	        		location.reload();
	  	        	}else if(response.requestResult=="Commentlength"){
	  	        		alert("评论请控制在30个字以内!");
	  	        	}else if(response.requestResult=="Commentnull"){
	  	        		alert("评论不允许为空!");
	  	        	}else{
	  	        		alert("请先登录再发表评论!");
	  	        	}
	  	        }
	  	      });
	      });
	    
	    var st=$("#showpublishtime").text().split('.');
	    $("#showpublishtime").text(st[0]);
	    
	  });
  </script>
  </head>
  <body>
   <%
		//禁止页面缓存
		response.addHeader("Cache-Control", "no-store, must-revalidate");
		response.addHeader("Expires", "Thu, 01 Jan 1970 00:00:01 GMT");
	%>
  <%
  	if(session.getAttribute("MANAGER")!=null){
	  		//重定向到admin页面
	  		ServletActionContext.getResponse().sendRedirect("admin.jsp");
	  	}
   %>
    <div id="main">
    <nav class="navbar navbar-default navbar-fixed-top navbar-inverse" >
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><img src="logo/logo-white.png" style="margin-top: -15px;width: 50px;height:50px" /></a>
          <a class="navbar-brand" href="#" style="color:ivory">新闻</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li>
            <% 
       		 if(session.getAttribute("USERNAME")==null)
 		  	 {
 				out.print("<a href='#' data-toggle='modal' data-target='#myModal' style='color:ivory;font-size: larger'>登录</a>");
 				out.print("</li><li id='indexRegister'><a href='Register.jsp'  style='color:ivory;font-size: larger'>注册</a></li>");
 		  	 }else{
 		  		out.print("<a href='#' style='color:ivory;font-size: larger'>"+session.getAttribute("USERNAME")+"</a></li>");
 		  		out.print("<li><a href='#' style='color:ivory;font-size: larger' data-toggle='modal' data-target='#UserExit'><img width='18px' height='18px' style='margin-top:-3px' src='Image/Exit.png'>退出</a></li>");
 		   	 }
         	%>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
   </div>
   
   <div style="width:1024px;margin-top: 40px;" class="center-block">
    <h1 align="center"><s:property value="%{news.title}"/></h1></br>
    <div style="float: right;color: #999999"><span>来源:<s:property value="%{news.NewsSource}"/></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="showpublishtime"><s:property value="%{news.time}" /></span></div>
    </br>
    <hr/>
    <%
    	out.print(ServletActionContext.getRequest().getAttribute("NEWSCONTENT"));
     %>
    <hr/>
    
    <div style="margin-left: 75px;width: 800px">
      <h3>发表评论:</h3>
      	<s:hidden id="NID"  value="%{news.NumberId}" />
      	<s:textarea id="CommentContent" style="width: 650px;height: 150px;resize:none;"  class="form-control"></s:textarea>
      	<div class="btn btn-default" id="PublishConment" style="margin-left: 570px;margin-top: 20px">发表评论</div>
	<div id="showComment"></div><!-- 显示评论 -->
    <!-- 分页 -->
    <div class="center-block" style="float:right">
		<ul class="pagination" style="margin-left: auto;margin-right: auto">
        </ul>
    </div>
    <!-- 分页 -->
  </div>
 </div>
   
   
   <div style="width: 100%;height: 200px;background-color:#000000;margin-top: 100px"><!--页尾说明-->
    <div class="center-block" align="center" style="width: 1100px;height: 200px;background-color: #000000;padding-top:50px;color: ivory">
      <p>24小时客户服务热线:010-8008208820 常见问题解答 互联网违法和不良信息举报</p>
      <p>违法和不良信息举报电话：010-8008208820 举报邮箱：zgj1435@scse.com.cn</p>
      <p>新闻中心意见反馈留言板</p>
      <p>广州大学华软软件学院--郑耿杰 版权所有</p>
    </div>
  </div><!--页尾说明-->
  <!--登录窗口-->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
       aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close"
                  data-dismiss="modal" aria-hidden="true">
            &times;
          </button>
          <h4 class="modal-title" id="myModalLabel">
            <img src="logo/logo.png" style="margin-top: -5px;width: 50px;height:50px" />用户登录
          </h4>
        </div>
        <br class="modal-body">
        <!--表单-->
          <div class="form-group form-inline" style="margin-left: 150px">
          <font id="errormessage" style="color:red;margin-left:30px"></font></br>
            <label>用户名：</label>
            <input id="inputusername" type="text" name="username" class="form-control" placeholder="请输入用户名">
          </div>
          <div class="form-group form-inline" style="margin-left: 150px">
            <label>密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
            <input id="inputpassword" type="password" name="password" class="form-control" placeholder="请输入密码">
          </div>
          </br>
        </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-default center-block UserLoginButton" style="width:150px;color:ivory">登录</button>
          <button id="closeModel"  type="button" class="btn btn-default hidden" data-dismiss="modal">关闭</button>
      </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal -->
    <div class="modal fade" id="UserExit" tabindex="-1" role="dialog"
       aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog" style="width:200px;margin-top:200px;">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close"
                  data-dismiss="modal" aria-hidden="true">
            &times;
          </button>
          <h4 class="modal-title" id="myModalLabel">
            <img src="logo/logo.png" style="margin-top:-5px;width: 50px;height:50px" />确定退出?
          </h4>
        </div>
        <br class="modal-body">
        	<div style="margin-left:50px">
        		<button type="button" class="btn btn-default exit" style="margin-left:25px;color:ivory">确认</button>
        	</div>
          </br>
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal -->
  </body>
</html>
