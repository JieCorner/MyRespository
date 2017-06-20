<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML">
<html>
  <head>
    <title>修改用户头像</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" type="image/x-icon" href="./logo/logo.png"/>
	<link href="./CSS/bootstrap.min.css" rel="stylesheet">
  	<link href="./CSS/cropper.css" rel="stylesheet">
  	<link href="./CSS/main.css" rel="stylesheet">
  	<script src="./Javascript/jquery.min.js"></script>
	<script src="./Javascript/cropper.js"></script>
	<script src="./Javascript/main.js"></script>
	<script src="./Javascript/bootstrap.min.js" type="text/javascript"></script>
	<style type="text/css">
		.input-group-addon{
			background-color:#000000;
			color:#ffffff;
		}
	</style>
	<script>
		$(document).ready(function(){
			$(".submitdata").click(function(){
				$.ajax({
 	       			 type : 'GET',
 	        		 url : './cutUserAvatarAction.action',
 	        		 data : {
 	        			username:$("#PUserName").text().trim(),
	                	dataX:$("#dataX").val(),
	                	dataY:$("#dataY").val(),
	                	dataWidth:$("#dataWidth").val(),
	                	dataHeight:$("#dataHeight").val()
 	            	},
 	        		success : function (response, stutas, xhr) {
 	        			if(response.requestResult=="success"){
 	        				alert("修改成功");
 	        				//转到个人信息
 	        				window.location.href=<% out.print("'UpdateUserAction.action?user.id="+session.getAttribute("USERID")+"'"); %>; 
 	        			}else{
 	        				alert("系统错误!");
 	        			}
 	        		}
 	      	});
		});
	})
	</script>
  </head>
  <body>
  	<%
		//禁止页面缓存
		response.addHeader("Cache-Control", "no-store, must-revalidate");
		response.addHeader("Expires", "Thu, 01 Jan 1970 00:00:01 GMT");
	%>
  <nav class="navbar navbar-default navbar-fixed-top navbar-inverse" >
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><img src="./logo/logo-white.png" style="margin-top: -15px;width: 50px;height:50px" /></a>
          <a class="navbar-brand" href="#" style="color:ivory">新闻</a>
        </div>
      </div>
    </nav>
  </div>
  <div style="width:50px;height:80px"></div>
  
   <div class="container">
    <div class="row">
      <div class="col-md-9">
        <!-- <h3 class="page-header">Demo:</h3> -->
        <div class="img-container">
          <img src="uploadAvatar/${sessionScope.USERNAME}.jpg?rand=<%=Math.random()%>" alt="Picture">
        	<a style="display:none"  id="PUserName" href="#"><% out.print(session.getAttribute("USERNAME")); %></a>
        </div>
      </div>
      <div class="col-md-3">
        <!-- <h3 class="page-header">Preview:</h3> -->
        <div class="docs-preview clearfix">
          <div class="img-preview preview-lg"></div>
          <div class="img-preview preview-md"></div>
          <div class="img-preview preview-sm"></div>
          <div class="img-preview preview-xs"></div>
        </div>

        <div class="docs-data">
          <div class="input-group">
            <label class="input-group-addon" for="dataX">X</label>
            <input class="form-control" id="dataX" type="text" placeholder="x">
            <span class="input-group-addon">px</span>
          </div>
          <div class="input-group">
            <label class="input-group-addon" for="dataY">Y</label>
            <input class="form-control" id="dataY" type="text" placeholder="y">
            <span class="input-group-addon">px</span>
          </div>
          <div class="input-group">
            <label class="input-group-addon" for="dataWidth">Width</label>
            <input class="form-control" id="dataWidth" type="text" placeholder="width">
            <span class="input-group-addon">px</span>
          </div>
          <div class="input-group">
            <label class="input-group-addon" for="dataHeight">Height</label>
            <input class="form-control" id="dataHeight" type="text" placeholder="height">
            <span class="input-group-addon">px</span>
          </div>
          <div class="input-group">
            <button class="btn btn-default submitdata" style="margin-top:50px;margin-left:100px">确认修改</button>
          </div>
        </div>
      </div>
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
  </body>
</html>
