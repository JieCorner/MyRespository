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
    <link rel="stylesheet" href="CSS/bootstrap.min.css">
    <style type="text/css">
    body{
      	margin:0 auto;
    }
    </style>
    <script>
    	$(document).ready(function(){  
 		$("#pform").submit( function () {
 			if($(".form-control:eq(0)").val()==""){
 				alert("请输入新闻标题");
 				return false;
 			}
 			if($(".form-control:eq(1)").val()==""){
 				alert("请输入新闻来源信息");
 				return false;
 			}
 			if(UE.getEditor('editor').getContent()==""){
 				alert("发布新闻内容不能为空");
 				return false;
 			}
  			return true;
		} );
	});  
    </script>
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
 	<h3>发布新闻:</h3>
  	<s:form theme="simple" id="pform" action="AddNewAction.action">
   <table  border="0">
    		<tr>
    			<td align="center"><label>标题:</label></td>
    			<td><s:textfield style="width:300px" id="newstitle" name="news.title"  class="form-control" placeholder="请输入新闻标题"/></td></br>
    		</tr>
    		<tr><td>&nbsp;</td></tr>
    		<tr>
    			<td align="center"><label>来源:</label></td>
    			<td><s:textfield style="width:300px" name="news.NewsSource"  class="form-control" placeholder="请输入新闻来源"/></td>
    		</tr>
    		<tr><td>&nbsp;</td></tr>
    		<tr>
    			<td align="center"><label>选择类别:</label></td>
    			<td><s:select name="selectedcategoryID" class="form-control" list="%{categorylist}" listKey="CategoryId" listValue="newsCategoryName"/></td>
    		</tr>
    		<tr><td>&nbsp;</td></tr>
    		<tr>
    			<td align="center"><label>编辑新闻内容:</label></td>
    		</tr>
    		</table>
    		<script id="editor" name="news.content" type="text/plain" style="width:1024px;height:500px;"></script>
    		
    		<s:submit class="btn btn-default center-block" style="width:150px;color:ivory;margin-top:50px"  value="确认发布"/>
    </s:form>
<script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor', {
    toolbars: [
        ['fullscreen', 'source', '|', 'undo', 'redo', '|',
            'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
            'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
            'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
            'directionalityltr', 'directionalityrtl', 'indent', '|',
            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
            'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
            'simpleupload', 'insertimage', 'emotion', 'scrawl','insertvideo','map', 'gmap', 'insertframe', 'insertcode', 'webapp', 'pagebreak', 'template', 'background', '|',
            'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
            'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
            'print', 'preview', 'searchreplace', 'drafts', 'help']
    ]});
   
    //function setContent() {
    //    UE.getEditor('editor').setContent('<p><img src="http://localhost:8080/NewsManagementSystem/ueditor/jsp/upload/image/20170516/1494946315755006233.png" title="1494946315755006233.png" alt="123.png"/></p>');
    //    alert(arr.join("\n"));
   // }
    
</script>
  </body>
</html>
