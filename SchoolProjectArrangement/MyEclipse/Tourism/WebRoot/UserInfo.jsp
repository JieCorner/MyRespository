<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <title>Personal Center</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="CSS/bootstrap.min.css">
  <link rel="stylesheet" href="CSS/index.css">
  <link rel="stylesheet" href="CSS/jquery-ui.css">
  <link rel="shortcut icon" type="image/x-icon" href="image/logo.png"/>
  <script type="text/javascript" src="Javascript/jquery1.2.0.js"></script>
  <script src="Javascript/bootstrap.min.js" type="text/javascript"></script>
  <script src="Javascript/jquery-ui.js" type="text/javascript"></script>
  <script type="text/javascript" src="Javascript/personInfo.js"></script>
  <style>
    [class*="col-"]{
      padding-top: 15px;
      padding-bottom: 15px;
      /*background-color: #eee;*/
      border: 1px solid #ddd;
    }
     .deleteorder{
      width: 100px;
      margin-left: 350px;
    }
    .ordercolhead{
    	padding-top: 5px;
    	padding-bottom: 5px;
    }
    .ordercom{
  		padding-bottom: 10px;
  		margin-left:390px;
  	}
  </style>
</head>
<body>
	 <%
			//禁止页面缓存
			response.addHeader("Cache-Control", "no-store, must-revalidate");
			response.addHeader("Expires", "Thu, 01 Jan 1970 00:00:01 GMT");
	%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">Tourism</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">basic Information <span class="sr-only">(current)</span></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Message
            <span class="badge reply" style="background:#FF3030"></span>
            <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">System Message&nbsp;</a></li>
            <li><a href="#" id="showproblem">Administrator reply&nbsp;<span class="badge reply" style="background:#FF3030"></span></a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
		<% 
        	if(session.getAttribute("USERNAME")==null)
 		  	{
 			   response.sendRedirect("Login.html");      //关键
 		  	}else{
 		   	   out.print(session.getAttribute("USERNAME"));
 		    }
         %>
		 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#" data-toggle="modal" data-target="#myModal">Change avatar</a></li>
            <li><a href="#" id="modifyinfo">Modify information</a></li>
            <li><a href="#" id="infomation">See information</a></li>
          </ul>
          <li><a href="#" id="userexit">Exit</a></li>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<div id="login_main">
  <div id="login_centext_main">
  <div style="width: 1200px;margin: auto;margin-top: -10px;">
    <div style="width:250px;float: left">
      <div class="panel panel-default" style="width: 250px;float: left" >
        <div class="panel-heading" style="background: black;color: white">User Avater</div>
        <div class="panel-body ">
          <img src="UserUploadPhoto/${sessionScope.USERNAME}.jpg?rand=<%=Math.random()%>" style="margin-left: 35px" height="150px" width="150px" class="img-rounded user-avater">
        </div>
      </div>
      <div class="list-group" style="width: 250px;float: left;">
        <a href="#" class="list-group-item active" style="background: black;color: white">More</a>
        <a href="#" class="list-group-item">My Orders</a>
        <a href="#" class="list-group-item">My Problems<span class="badge reply" style="background:#FF3030"></span></a>
      </div>
    </div>
      <div class="panel panel-default" style="width: 900px;margin-left: 270px">
        <div class="panel-heading" style="background: black;color: white">User Basic Information</div>
         <div class="panel-body showform" style="display:none">
         <form action="#" role="form" method="post" style="margin-left:300px"><!--表单-->
         	<label>Username&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.USERNAME}</label>
              <div class="form-group form-inline" style="margin-top: 30px;">
                <label>Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                <input type="email" name="email" id="Modify_email" class="form-control" placeholder="email address">
                <p></p>
              </div><!--Email-->
              <div class="form-group form-inline" style="margin-top: 30px;">
                  <label>Phone&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                <input type="email" name="email" id="Modify_phone" class="form-control" placeholder="phone">
                <p></p>
              </div><!--Email-->
              <div class="form-group form-inline" style="margin-top: 30px;">
                <label>Previous password:</label>
               		<input type="password" name="prepassword" class="form-control" placeholder="prepassword">
                <p></p>
              </div><!--Password-->
              <div class="form-group form-inline" style="margin-top: 30px;">
                <label>New password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>
                <input type="password" name="newpassword" class="form-control Modify_password" placeholder="repassword">
                <p></p>
              </div><!--Repassword-->
              <a href="#" class="btn btn-default btn-lg submit_button">Submit</a>
          </form>
           
        </div>
        <div class="panel-body showinfo">
          <div class="row" style="height: 100px;margin-top: -15px">
            <div class="col-md-5"><b>Username:</b><span id="info_username">user</span></div>
            <div class="col-md-7"><b>Phone:</b><span id="info_phone">phone</span></div>
            <div class="col-md-5"><b>Email:</b><span id="info_email">email</span></div>
            <div class="col-md-7"><b>Sex:</b><span id="info_sex">sex</span></div>
          </div>
          <hr>
            <div class="showtrendsmes" style="margin: auto 0;">
             <div class="panel panel-default order" >
                <img src="image/loading.gif" style="margin-left:350px"/>
              </div>
              <div class="panel panel-default  problem"  style="display:none">

              </div>
            </div>
        </div>
      </div>

  </div><!--login_centext_main-->
</div><!--login_main-->
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
        <img src="image/twitter.png" class="society_web" >
        <img src="image/youtube.png" class="society_web">
        <img src="image/facebook.png" class="society_web">
        <br>
        <img src="image/vimeo.png" class="society_web">
        <img src="image/linkedin.png" class="society_web">
        <img src="image/googleplus.png" class="society_web">
      </div>
      <div style="float: right;padding-top: 70px">
        Guangzhou University huaruan Software College ---Zheng
      </div>
    </div><!--version-->
  </div><!--tail-->
	<div id="deletedio">
    	Are you sure you want to cancel this order?
  	</div>
  	<div id="reg">
  		Are you sure you want to quit?
	</div>
	<!-- 模态框（Modal） -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
       aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close"
                  data-dismiss="modal" aria-hidden="true">
            &times;
          </button>
          Please select the picture you want to upload
        </div>
        <div class="modal-body">
          <form id="uploadphoto" action="UploadServlet" method="post" enctype="multipart/form-data">
        	<input id="myfile" name="myfile" type="file"  />
			<button id="uploadbt" class="btn btn-default" style="margin-left:500px">Submit</button>
    	  </form>
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</body>
</html>

