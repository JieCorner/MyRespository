<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
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
  	<h3>${Controller}</h3>
    <form action="${pageContext.request.contextPath }/item/queryItem.action" method="post">
	查询条件：
	<table width="100%" border=1>
		<tr>
			<td><input type="submit" value="查询"/></td>
		</tr>
	</table>
	商品列表：
	<table width="100%" border=1>
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>生产日期</td>
			<td>商品描述</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${itemsList }" var="item">
		<tr>
			<td>${item.name }</td>
			<td>${item.price }</td>
			<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>${item.detail }</td>
			<td><a href="${pageContext.request.contextPath }/item/editItem.action?id=${item.id}">修改</a></td>
		</tr>
	</c:forEach>
	</table>
	</form>
  </body>
</html>
