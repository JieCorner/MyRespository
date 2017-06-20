<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <title>Tourism</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../CSS/bootstrap.min.css">
  <link rel="stylesheet" href="../CSS/index.css">
  <link rel="stylesheet" href="../CSS/jquery-ui.css">
  <link href="cropper.css" rel="stylesheet"><!--矩形框-->
  <link href="main.css" rel="stylesheet">
  <link rel="shortcut icon" type="image/x-icon" href="../image/logo.png"/>
  <script type="text/javascript" src="../Javascript/jquery1.2.0.js"></script>
  <script src="../Javascript/bootstrap.min.js" type="text/javascript"></script>
  <script src="../Javascript/jquery-ui.js" type="text/javascript"></script>
  <script type="text/javascript" src="cropper.js"></script>
  <script type="text/javascript" src="main.js"></script><!--矩形框-->
  <script type="text/javascript" src="Upload.js"></script>
  <style>
  .input-group-addon{
	background-color:#000000;
	color:#ffffff;	
}
  </style>
</head>
<body>
 	<%
		//禁止页面缓存
		response.addHeader("Cache-Control", "no-store, must-revalidate");
		response.addHeader("Expires", "Thu, 01 Jan 1970 00:00:01 GMT");
	%>
 <nav class="navbar navbar-inverse navbar-fixed-top my"><!--导航栏-->
  <div class="container">
    <div class="navbar-header">
      <a href="#" class="navbar-brand">Tourism</a>
      <ul class="nav navbar-nav ">
        <li><a href="../index.jsp">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Contant</a></li>
        <li><a href="#">More</a></li>
      </ul>
    </div>
    <div id="navbar" class="collapse navbar-collapse pull-right">
      <ul class="nav navbar-nav ">
        <li>
        <% 
        if(session.getAttribute("USERNAME")==null)
 		  {
 			response.sendRedirect("../Login.html");
 		  }else{
 		  	if("0".equals(session.getAttribute("COUNTREPLY").toString())){
 		  		out.print("<a href='../UserInfo.jsp'>"+session.getAttribute("USERNAME")+"<span class='badge reply' style='background:#FF3030'></span>");
 		  	}else{
 		  		out.print("<a href='../UserInfo.jsp'>"+session.getAttribute("USERNAME")+"<span class='badge reply' style='background:#FF3030'>"+session.getAttribute("COUNTREPLY")+"</span>");
 		    }
 		   }
         %>
        </a></li>
        <li><a href="#">Exit</a></li>
      </ul>
    </div>
  </div>
</nav><!--navbar-->
<div style="width: 1100px;height: 50px;margin: 0 auto;background: aliceblue"></div>
  <div id="center">
  	<div class="container" style="margin-left:-80px;margin-top:20px">
    <div class="row">
      <div class="col-md-9">
        <!-- <h3 class="page-header">Demo:</h3> -->
        <div class="img-container">
          <img id="cutphotosrc" src="../UserUploadPhoto/${sessionScope.USERNAME}.jpg?rand=<%=Math.random()%>" alt="Picture">
        </div>
      </div>
      <div class="col-md-3">
        <!-- <h3 class="page-header">Preview:</h3> -->
        <div class="docs-preview clearfix">
          <div class="img-preview preview-lg"></div>
          <div class="img-preview preview-md"></div>
          <div class="img-preview preview-sm"></div>
          <div class="img-preview preview-xs"></div>
        </div>

        <!-- <h3 class="page-header">Data:</h3> -->
        <div class="docs-data">
          <div class="input-group">
            <label class="input-group-addon" for="dataX">X</label>
            <input class="form-control" id="dataX" type="text" placeholder="x">
            <span class="input-group-addon">px</span>
          </div>
          <div class="input-group">
            <label class="input-group-addon" for="dataY">Y</label>
            <input class="form-control" id="dataY" type="text" placeholder="y">
            <span class="input-group-addon">px</span>
          </div>
          <div class="input-group">
            <label class="input-group-addon" for="dataWidth">Width</label>
            <input class="form-control" id="dataWidth" type="text" placeholder="width">
            <span class="input-group-addon">px</span>
          </div>
          <div class="input-group">
            <label class="input-group-addon" for="dataHeight">Height</label>
            <input class="form-control" id="dataHeight" type="text" placeholder="height">
            <span class="input-group-addon">px</span>
          </div>
          <button class="btn btn-default submitdata" style="margin-top:50px;margin-left:100px">determine</button>
        </div>
      </div>
    </div>
  </div>
</div><!--center-->
<div id="tail">
  <div id="version">
      <div class="version_tap">
        Our Services:<br>
        <a href="#">Organize group tours</a><br>
        <a href="#">Tourism navigation</a><br>
        <a href="#">Travel Tips</a><br>
        <a href="#">More</a>
      </div><!--version_tap-->
    <div class="version_tap">
      Find us:<br>
      60 Paya Lebar Road<br>
      Paya Lebar Square # 10-15<br>
      Singapore, 409051<br>
      +(65) 9649 6587<br>
      asia@perfectproductions.asia<br>
      pictureperfectproductions<br>
    </div><!--version_tap-->
    <div class="version_tap">
      Connect Us:<br>
      <a href="#">Our Twitter</a><br>
      <a href="#">Our Youtube<br>
      <a href="#">Our Google+</a><br>
      <a href="#">Our Vimeo</a><br>
      <a href="#"> Our Facebook</a><br>
      <a href="#"> Our Email</a><br>
    </div><!--version_tap-->
    <div style="float:left;width: 500px">
      Get social with us<br>
      <img src="../image/twitter.png" class="society_web" >
      <img src="../image/youtube.png" class="society_web">
      <img src="../image/facebook.png" class="society_web">
      <br>
      <img src="../image/vimeo.png" class="society_web">
      <img src="../image/linkedin.png" class="society_web">
      <img src="../image/googleplus.png" class="society_web">
    </div>
    <div style="float: right;padding-top: 70px">
      Guangzhou University huaruan Software College ---Zheng
    </div>
  </div><!--version-->
</div><!--tail-->
<div id="uploadreg">
  Are you sure you want to quit?
</div>
</body>
</html>
