<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'JSPTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
  你好，今天是
  	<%
  	Date today=new Date();
  	  %>
  	  <%=
  	  today.getDate()
  	   %>号，星期
  	   <% System.out.println("asd"); %>
  	   <!-- <%= new java.util.Date() %> -->
  	   <%= today.getDay() %>
  	   <%! int a=3; %>
  	   <% int b=3; %><br>
  	   <%= a-- %><br>
  	   <%= b-- %>
  </body>
</html>
