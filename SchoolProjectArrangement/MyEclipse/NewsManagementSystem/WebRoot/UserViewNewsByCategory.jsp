<%@ page language="java" import="java.util.*,org.apache.struts2.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>新闻类型:<s:property value="%{categoryName}" /></title>
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
  	<script type="text/javascript" src="Javascript/UserViewNewsByCategory.js"></script>
  	<style type="text/css">
    body{
      margin:0 auto;
    }
    #main{
      width:1050px;
      height:100px;
    }
    .RealNewsIntro{
    	color:#B7B7B7;
      margin-top: 15px;
    }
  </style>
  </head>
  <body>
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
        <a href="index.jsp" class="navbar-form navbar-left" style="color:ivory;font-size: larger;margin-left:10px;margin-top:14px">返回首页</a>
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
   
   <div style="width:1024px;margin-top: 20px;" class="center-block">
   
    <h1>新闻类型:<s:property value="%{categoryName}" /></h1><hr/>
    
    <s:iterator value="newslist" var="news">
     	<div class="RealtimeNew" style="width: 500px;height: 100px;margin-top: 40px;">
    		<img style="height: 120px;width: 180px;float:left;margin-right: 20px;" class="media-object" src="<s:property value='#news.picName'/>"/>
    		<div style="width: 300px;float: left"><h3><s:a href="ViewNewsForUserAction?news.NumberId=%{#news.NumberId}" style="color:#000000"><p><s:property value="#news.title" /></p></s:a></h3>
    			<p class="RealNewsIntro"><s:property value="#news.NewsSource" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#news.viewtimes" />次浏览</p>
    		</div>
    	</div>
   </s:iterator>
   
    
    </br>
  </div>
   
   
   <div style="width: 100%;height: 200px;background-color:#000000;margin-top:150px;"><!--页尾说明-->
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
