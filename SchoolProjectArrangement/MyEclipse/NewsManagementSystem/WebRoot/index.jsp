<%@ page language="java" import="java.util.*,org.apache.struts2.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>新闻中心</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="utf-8">
	<link rel="stylesheet" href="CSS/bootstrap.min.css">
	<link rel="shortcut icon" type="image/x-icon" href="logo/logo.png"/>
	<script type="text/javascript" src="Javascript/jquery1.2.0.js"></script>
  	<script src="Javascript/bootstrap.min.js" type="text/javascript"></script>
  	<script type="text/javascript" src="Javascript/index.js"></script>
  	<style type="text/css">
    body{
      margin:0 auto;
    }
    .RealNewsIntro{
    	color:#B7B7B7;
      margin-top: 15px;
    }
    .RealtimeNew{
      float: left;
    }
    .newCategoryClass{
      width: 100px;
      text-align: center;
    }
    #Realtimenewsdiv{
    	margin-left: 80px;
    }
  </style>
  </head>
  <body>
  <%
		//禁止页面缓存
		response.addHeader("Cache-Control", "no-store, must-revalidate");
		response.addHeader("Expires", "Thu, 01 Jan 1970 00:00:01 GMT");
	%>
  <%
  	if(session.getAttribute("INDEXDATA")==null){//表示没有数据要请求,转到action
		//重定向到admin页面
  		ServletActionContext.getResponse().sendRedirect("indexAction.action");
	}else if("get".equals(session.getAttribute("INDEXDATA").toString())){//表示获得到数据了
		//判断管理员
		if(session.getAttribute("MANAGER")!=null){
	  		//重定向到admin页面
	  		ServletActionContext.getResponse().sendRedirect("admin.jsp");
	  	}
		//设置为noget
		//ServletActionContext.getRequest().getSession().setAttribute("INDEXDATA", "noget");
	}else{//表示session里面为noget,重新请求数据
		ServletActionContext.getResponse().sendRedirect("indexAction.action");
	}
  %>
  <div class="main">
    <nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
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
          <ul class="nav navbar-nav" id="categorynav">
            <!--自动生成-->
          
          </ul>
          <s:form theme="simple" class="navbar-form navbar-left" action="selectNewsBytitleAction.action">
        	<div class="form-group">
          		<s:textfield name="selectNewBytitle" style="width:150px"  class="form-control" placeholder="请输入新闻标题"/>
          		<s:submit class="btn btn-default" value="查询"/>
        	</div>
        </s:form>
          <ul class="nav navbar-nav navbar-right">
            <li>
            <% 
       		 if(session.getAttribute("USERNAME")==null)
 		  	 {
 				out.print("<a href='#' data-toggle='modal' data-target='#myModal' style='color:ivory;font-size: larger'>登录</a>");
 				out.print("</li><li id='indexRegister'><a href='Register.jsp'  style='color:ivory;font-size: larger'>注册</a></li>");
 		  	 }else{
 		  		out.print("<a href='#' style='color:ivory;font-size: larger'>"+session.getAttribute("USERNAME")+"</a></li>");
 		  		out.print("<li class='dropdown'><a href='#' style='color:#ffffff' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>修改个人信息<span class='caret'></span></a>");
 		  		out.print("<ul class='dropdown-menu'><li><a href='#' data-toggle='modal' data-target='#UploadModal'>修改头像</a></li><li role='separator' class='divider'></li><li><a href='UpdateUserAction.action?user.id="+session.getAttribute("USERID")+"'>个人资料</a></li></ul></li>");
 		  		out.print("<li><a href='#' style='color:ivory;font-size: larger' data-toggle='modal' data-target='#UserExit'><img width='18px' height='18px' style='margin-top:-3px' src='Image/Exit.png'>退出</a></li>");
 		   	 }
         	%>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
  </div>

  <div class="center-block" style="width: 1100px;height: 100%;margin-top: 80px" >
    <!--实时新闻--> 
    <h1>实时新闻</h1><hr/>
    <div id="Realtimenewsdiv">
      <!--新闻列表-->
      
      <!--新闻列表-->
    </div><!--实时新闻-->
    </br>
    
    <!--分页-->
    <div class="center-block" style="width: 100px">

    </div>


  </div><!--新闻中心块-->
  <div style="float:left;width: 100%;height: 200px;background-color:#000000;margin-top:50px"><!--页尾说明-->
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
    
    <div class="modal fade" id="UploadModal" tabindex="-1" role="dialog"
       aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close"
                  data-dismiss="modal" aria-hidden="true">
            &times;
          </button>
          <h4 class="modal-title" id="myModalLabel">
            <img src="logo/logo.png" style="margin-top: -5px;width: 50px;height:50px" />上传用户头像
          </h4>
        </div>
        <br class="modal-body">
        	<div style="margin-left:50px">
        	<s:form action="uploadUserAvatar" enctype="multipart/form-data">
        		<s:hidden name="username" value="%{#session.USERNAME}" />
        		<s:file name="upload" label="请选择文件上传"/>
    			<s:submit class="btn btn-default center-block" style="width:150px;color:ivory" value="确认上传"/>
        	</s:form>
        	</div>
          </br>
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
