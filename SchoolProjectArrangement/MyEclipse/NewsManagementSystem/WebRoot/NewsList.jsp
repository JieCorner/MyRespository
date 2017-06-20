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
	<script type="text/javascript" src="Javascript/jquery1.2.0.js"></script>
  	<script src="Javascript/bootstrap.min.js" type="text/javascript"></script>
  	<script type="text/javascript" src="Javascript/NewsList.js"></script>
  	<style type="text/css">
	body{
      	margin:0 auto;
    }
	#main{
		width:1050px;
		height:100px;
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
     <div id="main">
     <h3>按分类查询新闻:</h3>
     	<s:form action="getNewListByCategoryIdAction.action">
     		<s:select name="selectedcategoryID" class="form-control" list="%{categorylist}" listKey="CategoryId" listValue="newsCategoryName"/>
     		<s:submit class="btn btn-default center-block" style="width:150px;color:ivory;margin-top:10px" value="查询"/>
     	</s:form>
     <h3>查看全部新闻:</h3>
    	<div style="width:1050px;height: 50px;margin-top:0px" class="center-block">
    	<table class="table table-striped">
        	<tr align="center">
          		<td><strong>序号</strong></td>
          		<td><strong>分类</strong></td>
          		<td><strong>新闻标题</strong></td>
          		<td><strong>操作</strong></td>
        	</tr>
       		<s:iterator value="newslist" var="news" status="stu">
     		<tr align="center">
     			<td><s:property value="#stu.count" /></td>
     			<td><s:property value="#news.newscategory.newsCategoryName" /></td><!-- 分类 -->
     			<td><s:a style="color:#000000" href="viewNewsAction?news.NumberId=%{#news.NumberId}"><s:property value="#news.title" /></s:a></td><!-- 标题 -->
     			<td><s:a href="getUpdateNewAction?news.NumberId=%{#news.NumberId}">修改</s:a>
     				<s:a class="sureOper" href="deleteNewsAction.action?news.NumberId=%{#news.NumberId}">删除</s:a>
     			</td>
     		</tr>
     		</s:iterator>
     	</table>
    	</div>
     </div>
  </body>
</html>
