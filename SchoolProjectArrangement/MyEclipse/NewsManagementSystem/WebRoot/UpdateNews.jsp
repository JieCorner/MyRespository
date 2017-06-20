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
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="lang/zh-cn/zh-cn.js"></script>
    <script src="Javascript/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="Javascript/jquery1.2.0.js"></script>
    <script type="text/javascript" src="Javascript/UpdateNews.js"></script>
    <link rel="stylesheet" href="CSS/bootstrap.min.css">
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
   <s:form theme="simple" action="updatedNewAction.action">
   <table  border="0">
    		<tr>
    			<td align="center"><label>标题:</label></td>
    			<td><s:textfield style="width:300px" name="news.title"  class="form-control" value="%{news.title}"/></td></br>
    		</tr>
    		<tr><td>&nbsp;</td></tr>
    		<tr>
    			<td align="center"><label>来源:</label></td>
    			<td><s:textfield style="width:300px" name="news.NewsSource"  class="form-control" value="%{news.NewsSource}"/></td>
    		</tr>
    		<tr><td>&nbsp;</td></tr>
    		<tr>
    			<td align="center"><label>选择类别:</label></td>
    			<td><s:select name="selectedcategoryID" class="form-control" list="%{categorylist}" listKey="CategoryId" listValue="newsCategoryName" value="%{news.newscategory.CategoryId}"/></td>
    		</tr>
    		<tr><td>&nbsp;</td></tr>
    		<tr>
    			<td align="center"><label>编辑新闻内容:</label></td>
    		</tr>
    		</table>
    		<script id="editor" name="news.content" type="text/plain" style="width:1024px;height:500px;"></script>
    		<s:textarea id="udeitorcontent" value="%{news.content}" style="display:none"/>
    		<s:textfield name="news.NumberId"  style="display:none" value="%{news.NumberId}"/>
    		<s:submit class="btn btn-default center-block" style="width:150px;color:ivory;margin-top:50px" value="确认修改"/>
    </s:form>
  </body>
</html>
