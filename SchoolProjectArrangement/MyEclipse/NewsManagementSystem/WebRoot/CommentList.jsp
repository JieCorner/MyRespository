<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <title></title>
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
  	<script type="text/javascript" src="Javascript/CommentList.js"></script>
  </head>
  
  <body>
    <!-- 评论-->
      <s:iterator value="commentpojolist" var="commentpojo" status="stu">
     	<div class="media" style="margin-top: 20px">
          <a class="pull-left" href="">
            <img class="media-object" src="uploadAvatar/<s:property value='#commentpojo.comment.user.username' />.jpg?rand=<%=Math.random()%>" style="width: 70px;height: 70px">
          </a>
          <div class="media-body">
            <h4 class="media-heading"><s:property value="#commentpojo.comment.user.username" /></h4>
  			<s:property value="#commentpojo.comment.context" />
            <span style="float: right;margin-top: -25px;">
            	<span style="color:#CDC5BF;margin-right:20px">#<s:property value="#commentpojo.index+1" /></span><img src="Image/weizan.png" class="Userup"  width="20" height="20"/><span style="font-size: medium;margin-left: 5px;"><s:property value="#commentpojo.comment.Uptimes" /></span><span style="display:none"><s:property value="#commentpojo.comment.id" /></span>
            </span>
          </div>
        </div>
        <hr/>
      </s:iterator>
     
    <!-- 评论-->
  </body>
</html>
