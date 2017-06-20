<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'JavaBean.jsp' starting page</title>
    
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
	<jsp:useBean id="person" class="com.Web.Bean.Person"></jsp:useBean>
	<jsp:getProperty property="name" name="person"/><br>
	<jsp:getProperty property="age" name="person"/><br>
	<jsp:getProperty property="address" name="person"/><br>
  	<jsp:setProperty property="name" name="person" value="lisi"/>
  	<jsp:getProperty property="name" name="person"/><br>
	<% out.println(person.getName()); %><br>
	
  	上面是person对象，下面是person2对象：
  	
  	<% com.Web.Bean.Person person2=new com.Web.Bean.Person(); 
  		person2.setName("王五");%>
  		<br>
  		<%out.println("person2:"+person2.getName());%><br><br><br>
  	
  	动态设置value的值：<br>
  	
  	<jsp:setProperty property="age" name="person" param="helloworld"/><br>
  	<jsp:getProperty property="age" name="person"/><br>
 	<br>
 	日期Date的JavaBean测试：
 	<jsp:useBean id="date" class="java.util.Date" scope="session"></jsp:useBean>
 	<%= date %><br>
 	<%=date.toLocaleString() %>
  </body>
</html>
