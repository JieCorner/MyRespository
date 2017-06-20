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
  	<script type="text/javascript" src="Javascript/UpdateNewsCategory.js"></script>
	<style type="text/css">
	body{
      	margin:0 auto;
    }
	#main{
		width:1050px;
		height:100px;
	}
	.label{
    	font-size:15px;
    }
    .errorMessage{
    	color:red;
    	float:right;
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
    	<h3>修改新闻类型:</h3>
    		<div style="width:500px;height: 50px;margin-top:100px" class="center-block">
    			<s:form action="updatedNewsCategoryAction">
    				<s:hidden name="category.CategoryId" value="%{category.CategoryId}" />
        			<s:textfield name="category.newsCategoryName" value="%{category.newsCategoryName}" label="请输入修改类别名称" class="form-control"/>
    				<s:submit class="btn btn-default center-block" style="width:150px;color:ivory;margin-top:50px" value="确认修改"/>
        		</s:form>
    		</div>
    	</div>
  </body>
</html>
