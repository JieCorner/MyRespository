<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Login</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
  	ActionErrors:<s:actionerror cssStyle="list-style:none"/>
  	<s:property value="actionErrors[0]"/>
    <form action="UserLogin/login.action">
    	用户名:<input type="text" name="username"/><s:property value="fieldErrors.username[0]"/><br/>
    	密&nbsp;码:<input type="password" name="password"/><s:property value="fieldErrors.password[0]"/><br/>
    	<input type="submit" value="登录"/>
    </form>
    <br/><br/>
    TokenSubmitTest:
  	<form action="UserLogin/token.action">
    	用户名:<input type="text" name="username"/><s:property value="fieldErrors.username[0]"/><br/>
    	密&nbsp;码:<input type="password" name="password"/><s:property value="fieldErrors.password[0]"/><br/>
    	<s:token></s:token>
    	<input type="submit" value="登录"/>
    </form>
    <br/><br/>
    Single FileUpload:
    	<form action="UserLogin/fileupload.action" method="post" enctype="multipart/form-data">
    		用户名::<input type="text" name="username"/><br/>
    		文件:<input type="file" name="file"/><br/>
    		<input type="submit" value="提交"/>
    	</form>
  	<br/><br/>
  	Many FileUpload:
    	<form action="UserLogin/manyfileupload.action" method="post" enctype="multipart/form-data">
    		用户名::<input type="text" name="username"/><br/>
    		文件1:<input type="file" name="files"/><br/>
    		文件2:<input type="file" name="files"/><br/>
    		<input type="submit" value="提交"/>
    	</form>
    <br/><br/>
    <br/><br/>
    	<a href="UserLogin/downloadFile.action?number=1">下载文件</a>
  	<br/><br/>
  Annotation Action:
    	<form action="loginAnno.action" method="post">
    		<input type="submit" value="提交"/>
    	</form>
  	<br/><br/>
    <s:form action="login" namespace="/UserLogin" theme="simple">
    	用户名:<s:textfield name="username" label="用户名"/><br/>
    	密&nbsp;码:<s:password name="password" label="密码" /><br/>
    	<s:submit value="登录"/>
    </s:form>

  </body>
</html>
