<%@ page language="java" import="java.util.*,org.apache.struts2.*" pageEncoding="UTF-8"%>
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
  	<style type="text/css">
  	body{
      margin:0 auto;
    }
  	</style>
  </head>
  <body>
  <div style="width:1024px;margin-top: 40px;" class="center-block">
    <h1 align="center"><s:property value="%{news.title}"/></h1></br>
    <div style="float: right;color: #999999"><span>来源:<s:property value="%{news.NewsSource}"/></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><s:property value="%{news.time}"/></span></div>
    </br>
    <hr/>
    <%
    	out.print(ServletActionContext.getRequest().getAttribute("NEWSCONTENT"));
     %>
  </div>
  </body>
</html>
