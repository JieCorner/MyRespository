<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'Register.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	.tdErrorMessage{
		color:red;
		text-align:center
	}
	</style>
  </head>
  <body>
  	<s:form action="Register" namespace="/user">
  		<s:textfield name="name" label="用户名"/>
  		<s:password name="password1" label="密码"/>
  		<s:password name="password2" label="确认密码"/>
  		<s:textfield name="age" label="年龄"/>
  		<s:textfield name="birthday" label="生日"/>
  		<s:textfield name="email" label="email"/>
  		<s:submit value="提交"/>
  	</s:form>
  </body>
</html>
