<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>test</title>

  </head>
   	<!-- 注意后面别忘了“/”,jsp:include也可以有jsp:param属
  	性（将页面包含进来（通过jsp:param传递参数）） -->
  <body>
  	
  	<jsp:forward page="forwardTo.jsp">
  		<jsp:param name="userName" value="riso"/>
  	</jsp:forward>
  	
  </body>
</html>
