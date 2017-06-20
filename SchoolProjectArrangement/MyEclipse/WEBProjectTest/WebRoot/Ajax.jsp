<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Ajax.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <script>
    var xmlHttpRequest=null;
  	function ajaxSubmit(){
  		if(window.ActiveXObject)//IE浏览器
  		{
  			xmlHttpRequest=new ActiveXObject("Microsoft.XMLHttp");
	  	}
	  	else if(window.XMLHttpRequest)//除IE外的其他浏览器实现
	  	{
	  		xmlHttpRequest=new XMLHttpRequest();
	  	}
	  if(null!=xmlHttpRequest){
	  //发出的是get请求，2是请求的资源，3true表示以异步发出请求
	  	xmlHttpRequest.open("GET","AjaxServlet",true);
	  	xmlHttpRequest.onreadystatechange=ajaxCallback;
	  	xmlHttpRequest.send(null);
	  }
  	}
  	function ajaxCallback(){
  		if(xmlHttpRequest.readyState==4){
  			if(xmlHttpRequest.status==200){
  			//获得服务器端响应发送过来的文本信息
  			var responseText=xmlHttpRequest.responseText;
  			document.getElementById("div1").innerHTML=responseText;
  			}
  		}
  		
  	}
  </script>
  <body>
  	<input type="button" value="get content form server" onclick="ajaxSubmit()">
  	<div id="div1"></div>
  </body>
</html>
