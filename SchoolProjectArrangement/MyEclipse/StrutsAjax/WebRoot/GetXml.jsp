<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
  <head>
   <title>My JSP 'GetXml.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="jquery1.2.0.js"></script>
	<script type="text/javascript">
 	function getInfo(){
 		$.post("getXMLAction.action",{
 			name:$("#name").val()
 		},function(returnedData,status){
 			var id=$(returnedData).find("id").text();
 			var name=$(returnedData).find("name").text();
 			var age=$(returnedData).find("age").text();
 			var address=$(returnedData).find("address").text();
 			
 			var html="<table width='60%' border='1' align='center'><tr><th>id</th><th>name</th><th>age</th><th>address</th></tr>"+
 			"<tr align='center'><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+address+"</td></tr></table>";
 			
 			$("#theBody table:eq(0)").remove();
 			$("#theBody").append(html);
 		});
 	}
 </script>
 </head>

  <body id="theBody">
    <select id="name">
    	<option value="zhangsan">zhangsan</option>
    	<option value="lisi">lisi</option>
    </select>
    <input type="button" value="get information" onclick="getInfo()">
     
  </body>
</html>
