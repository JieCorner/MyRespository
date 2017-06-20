<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  	<link rel="stylesheet" href="CSS/bootstrap.min.css">
  	<link rel="shortcut icon" type="image/x-icon" href="logo/logo.png"/>
  	<script type="text/javascript" src="Javascript/jquery1.2.0.js"></script>
  	<script src="Javascript/bootstrap.min.js" type="text/javascript"></script>
  	<script type="text/javascript" src="Javascript/Register.js"></script>
	<style type="text/css">
    body{
      margin:0 auto;
    }
    #bg_main{
      margin-top: 50px;
      width: 1349px;
      height: 700px;
      background-image: url('Image/register_bg.jpg');
      background-size: 100% 700px;
      mso-font-width: 100%;
    }
    #registerPanel{
      width: 400px;
      margin-top: 80px;
      float: left;
      margin-left: 200px;
    }
    .errorMessage{
    	color:red;
    	float:right;
    }
    .label{
    	font-size:15px;
    }
  </style>
  </head>
  <body>
     <div class="main">
    <nav class="navbar navbar-default navbar-fixed-top navbar-inverse" >
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#"><img src="logo/logo-white.png" style="margin-top: -15px;width: 50px;height:50px" /></a>
          <a class="navbar-brand" href="#" style="color:ivory">新闻</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="index.jsp" style="color:ivory;font-size: larger">返回首页</a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
  </div>
  <div id="bg_main">
    <img style="float: left;margin-left: 250px;margin-top: 120px" src="logo/logo.png">
    <div id="registerPanel">
      <div class="panel panel-default" style="border:1px solid #1F1F1F"><!--面板-->
        <div class="panel-heading" style="background: #1F1F1F;">
          <h2 class="panel-title" style="font-size:25px;color: white">用户注册</h2>
        </div>
        <div class="panel-body" style="margin-left:50px">
			<s:form action="RegisterAction">
    			<s:textfield class="form-control" name="username" placeholder="请输入注册用户名" label="用户名"/></label>
    			<td></br></td>
    			<s:password class="form-control" name="password" placeholder="请输入注册密码" label="密码"/></label>
    			<s:password class="form-control" name="repassword" label="确认密码" placeholder="请再次输入密码"/>
    			<td></br></td>
    			<s:textfield class="form-control" name="age" placeholder="请输入您的年龄" label="年龄"/></label>
    			<td></br></td>
    			<s:textfield class="form-control" name="email" placeholder="请输入您的邮箱" label="邮箱"/></label>
    			<td></br></td>
    			<s:submit class="btn btn-default" value="确定"/>
    		</s:form>
        </div>
      </div>
    </div>
  </div>
  <div style="width: 1349px;height: 200px;background-color:#000000"><!--页尾说明-->
    <div class="center-block" align="center" style="width: 1100px;height: 200px;background-color: #000000;padding-top:50px;color: ivory">
      <p>24小时客户服务热线:010-8008208820 常见问题解答 互联网违法和不良信息举报</p>
      <p>违法和不良信息举报电话：010-8008208820 举报邮箱：zgj1435@scse.com.cn</p>
      <p>新闻中心意见反馈留言板</p>
      <p>广州大学华软软件学院--郑耿杰 版权所有</p>
    </div>
  </div><!--页尾说明-->

  </div>
  </body>
</html>
