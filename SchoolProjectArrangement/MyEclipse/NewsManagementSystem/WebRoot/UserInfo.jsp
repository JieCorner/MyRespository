<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" type="image/x-icon" href="logo/logo.png"/>
    <link href="CSS/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="Javascript/jquery1.2.0.js"></script>
    <script src="Javascript/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="Javascript/UserInfo.js"></script>
    <style type="text/css">
    img:hover{
        box-shadow: 15px 15px 20px rgba(50,50,50,0.4);
        width:300px;
        height:300px;
        z-index: 2;
        transform:rotate(0deg) scale(1.20);
        -webkit-transform:rotate(0deg) scale(1.20);
    }
    img{
        z-index: 1;
        -webkit-transition: all 0.5s ease-in;
        -moz-transition: all 0.5s ease-in;
        -ms-transition: all 0.5s ease-in;
        -o-transition: all 0.5s ease-in;
        transition: all 0.5s ease-in;
     }
    </style>
  </head>
  <body>
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
            <li><a href="index.jsp" style="color:ivory;font-size: larger">返回首页</a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
    </div>
</nav>
</div>
<div style="width:50px;height:80px"></div>

<div style="width: 1100px;height: 500px;" class="center-block">
    <div style="float: left;margin-left: 150px;margin-top: 29px">
        <label style="float: left">用户头像：</label>
        <img src="./uploadAvatar/${sessionScope.USERNAME}.jpg?rand=<%=Math.random()%>" class="p1" width="200px" height="200px">
    </div>
    <div style="float: right;margin-right: 150px">
        <div class="panel panel-default" style="border:1px solid #1F1F1F"><!--面板-->
            <div class="panel-heading" style="background: #1F1F1F;">
                <h2 class="panel-title" style="font-size:25px;color: white">用户个人信息</h2>
            </div>
            <div class="panel-body" style="margin-top: 30px;">
                <s:form action="UpdateUserInfoAction?user.id=%{user.id}">
                <s:textfield class="form-control" id="userId" value="%{user.id}" style="display:none"/>
    			<s:textfield class="form-control" id="username" name="user.username" placeholder="%{user.username}" label="用户名" readonly="true"/></label>
    			<td></br></td>
    			<s:password class="form-control" id="password" name="user.password"  placeholder="修改密码" label="密码"/></label>
    			<td></br></td>
    			<s:textfield class="form-control"  id="age" name="user.age" placeholder="%{user.age}" label="年龄" readonly="true"/></label>
    			<td></br></td>
    			<s:textfield class="form-control"  id="email" value="%{user.email}" name="user.email" placeholder="%{user.email}" label="邮箱"/></label>
    			<td></br></td>
    		</s:form>
    			<button id="fixInfo" data-toggle='modal' data-target='#UserUpdate' class="btn btn-default">确认修改</button>
                <br>
            </div><!--panel-body-->
        </div><!--panel-default-->
    </div>
</div>
<div style="width: 100%;height: 200px;background-color:#000000"><!--页尾说明-->
    <div class="center-block" align="center" style="width: 1100px;height: 200px;background-color: #000000;padding-top:50px;color: ivory">
        <p>24小时客户服务热线:010-8008208820 常见问题解答 互联网违法和不良信息举报</p>
        <p>违法和不良信息举报电话：010-8008208820 举报邮箱：zgj1435@scse.com.cn</p>
        <p>新闻中心意见反馈留言板</p>
        <p>广州大学华软软件学院--郑耿杰 版权所有</p>
    </div>
</div><!--页尾说明-->

<div class="modal fade" id="UserUpdate" tabindex="-1" role="dialog"
       aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog" >
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close"
                  data-dismiss="modal" aria-hidden="true">
            &times;
          </button>
          <h4 class="modal-title" id="myModalLabel">
            <img src="logo/logo.png" style="margin-top:-5px;width: 50px;height:50px" />请输入您原来的密码
          </h4>
        </div>
        <br class="modal-body">
        	<div style="margin-left:50px">
        		<label>原始密码:</label><input type="password" style="width:400px;" class="form-control" id="OldPassword" name="user.password" /></label>
        		</br><button type="button" style="align:center" class="btn btn-default sureUpdate" style="margin-left:25px;color:ivory">确认</button>
        	</div>
          </br>
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal -->

  </body>
</html>
