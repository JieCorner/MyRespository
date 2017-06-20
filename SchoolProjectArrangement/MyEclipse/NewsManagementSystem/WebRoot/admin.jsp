<%@ page language="java" import="java.util.*,org.apache.struts2.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>管理平台</title>
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
  	<script type="text/javascript" src="Javascript/admin.js"></script>
  	<style type="text/css">
     body{
       margin:0 auto;
     }
    </style>
  </head>
  <body>
 	<%
 		if(session.getAttribute("MANAGER")==null){
 			ServletActionContext.getResponse().sendRedirect("index.jsp");
 		}
 		else if("true".equals(session.getAttribute("MANAGER").toString())){
 		}else{
 			ServletActionContext.getResponse().sendRedirect("index.jsp");
 		}
 	%>
     <div class="main">
     </br>
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
            <li><a href="#" data-toggle="modal" data-target="#myModal" style="color:ivory;font-size: larger">管理员</a></li>
            <li><a href='#' style='color:ivory;font-size: larger' data-toggle='modal' data-target='#UserExit'><img width='18px' height='18px' style='margin-top:-3px' src='Image/Exit.png'>退出</a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
  </div>

  <div class="center-block" style="width: 1300px;height: 1000px;margin-top: 40px" >
    <div style="float: left">
      <div class="list-group" style="width: 200px">
        <a href="#" class="list-group-item" style="background-color: #080808;color: #ffffff">新闻类别管理</a>
        <a href="AddNewsCategory.jsp" class="list-group-item" target="iFrame">增加新闻类别</a>
        <a href="GetCategoryListAction.action" class="list-group-item" target="iFrame">查看新闻类别</a>
      </div>
      <div class="list-group" style="width: 200px">
        <a href="#" class="list-group-item" style="background-color: #080808;color: #ffffff">新闻管理</a>
        <a href="getNewsCategoryListForNewAction.action" class="list-group-item" target="iFrame">发布新闻</a>
        <a href="getNewListAction.action" class="list-group-item" target="iFrame">查看新闻</a>
      </div>
    </div>
	<!-- 关联界面 -->
    <iframe name="iFrame" id="iFrame" width="1050px" height="1000px" scrolling="yes" style="margin-left: 50px;overflow-x:hidden" frameborder="0" src="getNewsCategoryListForNewAction.action"></iframe>
    </br>
  </div>
  <div style="width: 1348px;height: 200px;background-color:#000000"><!--页尾说明-->
    <div class="center-block" align="center" style="width: 1100px;height: 200px;background-color: #000000;padding-top:50px;color: ivory">
      <p>24小时客户服务热线:010-8008208820 常见问题解答 互联网违法和不良信息举报</p>
      <p>违法和不良信息举报电话：010-8008208820 举报邮箱：zgj1435@scse.com.cn</p>
      <p>新闻中心意见反馈留言板</p>
      <p>广州大学华软软件学院--郑耿杰 版权所有</p>
    </div>
  </div><!--页尾说明-->
  
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
