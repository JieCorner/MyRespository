<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>Tourism</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<link rel="stylesheet" href="CSS/bootstrap.min.css">
  	<link rel="stylesheet" href="CSS/index.css">
  	<link rel="stylesheet" href="CSS/jquery-ui.css">
  	<link rel="shortcut icon" type="image/x-icon" href="image/logo.png"/>
  	<script type="text/javascript" src="Javascript/jquery1.2.0.js"></script>
  	<script src="Javascript/bootstrap.min.js" type="text/javascript"></script>
  	<script src="Javascript/jquery-ui.js" type="text/javascript"></script>
  	<script src="Javascript/index.js" type="text/javascript"></script>
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
        <li><a href="index.jsp">Home</a></li>
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
 			out.print("<a href='#'>Login");
 		  }else{
 		  	if("0".equals(session.getAttribute("COUNTREPLY").toString())){
 		  		out.print("<a href='UserInfo.jsp'>"+session.getAttribute("USERNAME")+"<span class='badge reply' style='background:#FF3030'></span>");
 		  	}else{
 		  		out.print("<a href='UserInfo.jsp'>"+session.getAttribute("USERNAME")+"<span class='badge reply' style='background:#FF3030'>"+session.getAttribute("COUNTREPLY")+"</span>");
 		    }
 		   }
         %>
        </a></li>
        <li><a href="#">
        <% 
        if(session.getAttribute("USERNAME")==null)
 		  {
 			out.print("Register");
 		  }else{
 		    out.print("Exit");
 		    }
         %>
        </a></li>
      </ul>
    </div>
  </div>
</nav><!--navbar-->
<div style="width: 1100px;height: 50px;margin: 0 auto;background: aliceblue"></div><!--占高-->
<div class="jumbotron"><!--巨幕-->
  <div class="container">
    <h1>Hello, where would you like to travel?</h1>
    <p>Welcome to Tourism network, we hope that you can find a place for the tourist destination here, and then give it to us.</p>
    <p><a class="btn btn-info btn-lg thanks" href="#">Thanks</a></p>
  </div>
</div><!--jumbotron-->
  <div id="center">
    <div id="turn"><!--轮播-->
      <div id="myCarousel" class="carousel slide">
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="item active">
            <img src="image/2.jpg" alt="First slide">
          </div>
          <div class="item">
            <img src="image/3.jpg" alt="Second slide">
          </div>
          <div class="item">
            <img src="image/4.jpg" alt="Third slide">
          </div>
        </div>
        <a class="carousel-control left" href="#myCarousel"
           data-slide="prev"><div style="margin-top: 250px">&lsaquo;</div></a>
        <a class="carousel-control right" href="#myCarousel"
           data-slide="next"><div style="margin-top: 250px">&rsaquo;</div></a>
      </div>
    </div><!--turn-->
  <div id="main_centext">
    <div id="mian_left"><!--左边-->
      <div class="list-group">
        <a href="#" class=" list-group-item" style="background: black">
          <h4 class="list-group-item-heading" style="color: white;">
            Asia
          </h4>
        </a>
        <a href="#" class="list-group-item">
          <h4 class="list-group-item-heading">
           China
          </h4>
          <p class="list-group-item-text">
            Here is your favorite experience.
          </p>
        </a>
        <a href="#" class="list-group-item">
          <h4 class="list-group-item-heading">
            Other
          </h4>
          <p class="list-group-item-text">
           You will feel the exotic Nanyang.
          </p>
        </a>
      </div>
      <div class="list-group">
        <a href="#" class="list-group-item" style="background: black">
          <h4 class="list-group-item-heading" style="color: white;">
         Europe
          </h4>
        </a>
        <a href="#" class="list-group-item">
          <h4 class="list-group-item-heading">
           central Europe
          </h4>
          <p class="list-group-item-text">
          With the mission of the European tour, recommended for the first time you go to Europe
          </p>
        </a>
        <a href="#" class="list-group-item">
          <h4 class="list-group-item-heading">European Coast</h4>
          <p class="list-group-item-text">The European line comprehensive arrangement of Shiquan landscape, make you comfortable travel</p>
        </a>
      </div>
      <div class="list-group">
        <a href="#" class="list-group-item" style="background: black">
          <h4 class="list-group-item-heading" style="color: white;">America</h4>
        </a>
        <a href="#" class="list-group-item">
          <h4 class="list-group-item-heading">
            North America
          </h4>
          <p class="list-group-item-text">
         Tour of the United States in the classic city - Washington, New York, Losangeles, San Francisco, Las vegas
          </p>
        </a>
        <a href="#" class="list-group-item">
          <h4 class="list-group-item-heading">South America</h4>
          <p class="list-group-item-text">
            Experience the passion of the Amazon and Chile
          </p>
        </a>
      </div>
    </div><!--mian_left-->
    <div id="mian_right" style="overflow: hidden">
      <h3 style="margin-left:10px ">Popular tourism</h3>
      <div class="show_view">
        <div class="panel panel-default" style="padding-right: 10px">
          <div class="panel-body" style="padding-right: 10px">
            <img src="image/1.1.jpg" width="103%" height="100%">
                <h4>Sanya<span class="badge" style="background:#FF3030">hot</span></h4>
                <p>describe：Sanya&nbsp;&nbsp;&nbsp;4 days 5 night tour</p>
                <a href="JoinD/JoinGroup_SY.jsp" class="btn btn-primary" style="background: black">Join</a>
          </div>
        </div>
      </div>
      <div class="show_view">
        <div class="panel panel-default" style="padding-right: 10px">
          <div class="panel-body" style="padding-right: 10px">
            <img src="image/1.2.jpg" width="103%" height="100%">
            <h4>Paris Triumphal Arch<span class="badge" style="background:#FF3030">hot</span></h4>
            <p>describe：Sanya&nbsp;&nbsp;&nbsp;11 days 10 night tour</p>
            <a href="JoinD/JoinGroup_KXM.jsp" class="btn btn-primary" style="background: black">Join</a>
          </div>
        </div>
      </div>

      <div class="show_view">
        <div class="panel panel-default" style="padding-right: 10px;">
          <div class="panel-body" style="padding-right: 10px">
            <img src="image/1.4.jpg" width="103%" height="100%">
            <h4>Colosseum<span class="badge" style="background:#FF3030">hot</span></h4>
            <p>describe：Sanya&nbsp;&nbsp;&nbsp;7 days 6 night tour</p>
            <a href="JoinD/JoinGroup_DSC.jsp" class="btn btn-primary" style="background: black">Join</a>
          </div>
        </div>
      </div>
      
       <div class="show_view">
        <div class="panel panel-default" style="padding-right: 10px">
          <div class="panel-body" style="padding-right: 10px">
            <img src="image/1.6.jpg" width="103%" height="100%">
            <h4>Maldives</h4>
            <p>describe：Sanya&nbsp;&nbsp;&nbsp;9 days 8 night tour</p>
            <a href="JoinD/JoinGroup_MEDF.jsp" class="btn btn-primary" style="background: black">Join</a>
          </div>
        </div>
      </div>
      <div class="show_view">
        <div class="panel panel-default" style="padding-right: 10px">
          <div class="panel-body" style="padding-right: 10px">
            <img src="image/1.3.jpg" width="103%" height="100%">
            <h4>Charles Bridge<span class="badge" style="background:#FF3030">hot</span></h4>
            <p>describe：Sanya&nbsp;&nbsp;&nbsp;9 days 8 night tour</p>
            <a href="#" class="btn btn-primary" style="background: black">Join</a>
          </div>
        </div>
      </div>
      <div class="show_view">
        <div class="panel panel-default" style="padding-right: 10px">
          <div class="panel-body" style="padding-right: 10px">
            <img src="image/1.5.jpg" width="103%" height="100%">
            <h4>Highclere Castle</h4>
            <p>describe：Sanya&nbsp;&nbsp;&nbsp;9 days 8 night tour</p>
            <a href="#" class="btn btn-primary" style="background: black">Join</a>
          </div>
        </div>
      </div>
      <div class="show_view">
        <div class="panel panel-default" style="padding-right: 10px">
          <div class="panel-body" style="padding-right: 10px">
            <img src="image/1.7.jpg" width="103%" height="100%">
            <h4>Hotel Prag</h4>
            <p>describe：Sanya&nbsp;&nbsp;&nbsp;8 days 7 night tour</p>
            <a href="#" class="btn btn-primary" style="background: black">Join</a>
          </div>
        </div>
      </div>

     

    </div><!--mian_right-->
  </div><!--main_centext-->
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
<div id="reg">
  Are you sure you want to quit?
</div>
  </body>
</html>
