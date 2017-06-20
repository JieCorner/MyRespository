<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="../CSS/bootstrap.min.css">
  	<link rel="stylesheet" href="../CSS/index.css">
  	<link rel="stylesheet" href="../CSS/jquery-ui.css">
  	<link rel="stylesheet" href="../CSS/Order.css">
  	<link rel="shortcut icon" type="image/x-icon" href="../image/logo.png"/>
  	<script type="text/javascript" src="../Javascript/jquery1.2.0.js"></script>
  	<script src="../Javascript/JoinD.js" type="text/javascript"></script>
  	<script type="text/javascript" src="../Javascript/jquery-ui.js"></script>
  	<script src="../Javascript/bootstrap.min.js" type="text/javascript"></script>
  	<script src="../Javascript/Order_JS.js" type="text/javascript"></script>
  	<script type="text/javascript">
  	$(document).ready(function(){
  	var thisOrderID="136102";
  	var isLogin;
  	<%
  		if(session.getAttribute("USERNAME")!=null)
 		{
 			out.print("isLogin=true;");
 		 }else{
 		 	out.print("isLogin=false;");
 		 }
  	%>
  		getIDaLogin(thisOrderID,isLogin);
  	  	ajaxOrderinfo(thisOrderID);
  		ajaxProductCom(thisOrderID);
  	});
  	</script>
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
        <li><a href='#'>
        <% 
          if(session.getAttribute("USERNAME")==null)
 		  {
 			out.print("Login");
 		  }else{
 		    out.print(session.getAttribute("USERNAME"));
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
  <div id="main_centext">
    <div id="join_mian_left"><!--左边-->
        <img class="big_show" src="../image/1.6.jpg" style="width: 400px;height: 400px;border:1px solid #e4e4e4;padding: 3px 3px;"><br>
          <a><img class="sm_picture" style="border:2px solid #000000;padding:2px 2px" src="../image/1.6.jpg"></a>
          <a><img class="sm_picture" src="../image/Order/640.jpe"></a>
          <a><img class="sm_picture" src="../image/Order/1010150938015c969899ac1c86.jpg"></a>
    </div><!--mian_left-->
   <div id="join_mian_right" style="overflow: hidden">
      <div class="panel panel-default">
        <div class="panel-heading" style="background: #000000;color: white">
          <h3 class="panel-title">
            Order information：
          </h3>
        </div>
        <div class="panel-body">
          <form action="#" role="form" method="post"><!--表单-->
            <div class="form-group form-inline" style="margin-top: 0px;">
              <label>Cost&nbsp;&nbsp;&nbsp;&nbsp;：</label>
              <font size="6px"><label id="cost"><img src="../image/loading.gif" width="40px" height="40px" /></label></font>
            </div>
            <div class="form-group form-inline" style="margin-top: 0px;">
              <label>StaringPlace：</label>
              <select class="form-control select_Number startplace">
                
              </select>
            </div>
            <div class="form-group form-inline" style="margin-top: 30px;">
              <label>Phone&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</label>
              <input type="text" class="form-control phone" placeholder="Phone">
            </div>
            <div class="form-group form-inline" style="margin-top: 30px;width: 450px">
              <label>Start Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</label>
              <input type="text" name="rili" class="group_date startdate" size="8">
            </div>
            <div class="form-group form-inline" style="margin-top: 30px;">
              <label>Adult&nbsp;&nbsp;&nbsp;：</label>
              <select class="form-control select_Number">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
              </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <label>Children&nbsp;&nbsp;&nbsp;：</label>
              <select class="form-control select_Number">
                <option>0</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
              </select>
            </div>
            <div class="form-group form-inline" style="margin-top: 30px;">
              <label>Remark&nbsp;：</label><br>
              <textarea class="form-control remark" rows="3" cols="20" style="margin-left: 100px"></textarea>
            </div>
            <div class="form-group form-inline" style="margin-top: 0px;">
              <label>Sum Cost&nbsp;&nbsp;：</label>
              <font size="6px"><label id="sumcost"><img src="../image/loading.gif" width="40px" height="40px" /></label></font>
            </div>
            <div style="margin-top: 30px;margin-left: 50px">
              <a href="#" id="submit" class="btn btn-default btn-lg join_button">Submit</a>
              <a href="#" id="reset" class="btn btn-default btn-lg join_button">Reset</a>
            </div>
          </form><!--form-->
        </div><!--panel-body-->
      </div><!--panel-->
    </div><!--mian_right-->
    <div style="width: 1000px;">
      <h1 style="color: white">Paris</h1>
      <h3>
        Brief introduction of Maldives
      </h3>
      <p>
        Maldives is located in South Asia, is an island in the ocean of India,
        is the second small countries in Asia, consisting of more than 1200 small
        coral islands, of which 202 islands are inhabited, has developed more than 110 islands.
        See the maldives islands northeast of the official website of the list and Sri Lanka 675 km apart,
        about 113 km distance from the North India with the minicoy Island, island average area of 1-2 square
        kilometers, low and flat, with an average elevation of 1.2 meters, located near the equator, with obvious
        tropical climate characteristics, no points of the four seasons. Maldives is the world's largest coral
        island, is known as "God tossed human necklace", "the Indian Ocean human last paradise."
      </p>
      <h3>
        Maldives tourism must take
      </h3>
      <p>
        Maldives most popular resorts do not take the initiative to provide toothbrush,
        toothpaste and other toiletries, but will provide soap, shampoo and bath lotion. For
        environmental and health considerations, recommend good toiletries prepared in advance.
        That is, razor, skin care products, cosmetics, sun hat, sunglasses, sunscreen, umbrellas,
        watches, pens, small notebook, towel, toothbrush, toothpaste, shampoo and hair care, slippers,
        etc. Please see their own needs to carry.
      </p>
     </div>
   <div class="list-group"><!--点评-->
      <a href="#" class=" list-group-item" style="background: black">
        <h4 class="list-group-item-heading" style="color: white;">
          Tourist evaluation
        </h4>
      </a>
     <div style="width: 1000px;height:78px;background:#ffffff">
       <div style="float: left;width: 200px;text-align: center">
         <font style="font-size: 50px;color:red"><label id="evaluate">96</label>%</font>
       </div>
       <div style="float: left;width: 800px;text-align: center;margin-top: 20px">
         <font style="font-size: 20px;">This website promises to review the real travel experience from all of tourist.</font>
       </div>
     </div>
    </div>
    <div class="list-group"><!--comment-->
      <a class=" list-group-item" style="background: black">
        <h4 class="list-group-item-heading" style="color: white;">
          Tourist comment
        </h4>
      </a>
	<div class="usercom">
		<img src="../image/loading2.gif" width="60px" height="60px" style="margin-left:450px;margin-top:20px" />
    </div>
       <div id="page_turn" style="margin-top: -15px;"><!--pagetrue-->
            <ul class="pagination" style="margin-left: auto;margin-right: auto">
            </ul>
        </div><!--end pagetrue-->
    </div><!--comment-->  
    <hr>
     <div class="problemblock">
      <div class="list-group" style="height: auto"><!--comment-->
        <a class=" list-group-item" style="background: black">
          <h4 class="list-group-item-heading" style="color: white;">
            User Problems
          </h4>
        </a>
        <div id="userproblem">
        
        </div>
      </div>
    </div><!--problem-->
     <div class="userproblem">
      <!--用户问题-->
      <div class="list-group" style="height: auto"><!--comment-->
        <a class=" list-group-item" style="background: black">
          <h4 class="list-group-item-heading" style="color: white;">
            Please input your problems
          </h4>
        </a>
      <div style="width: 1000px;background: white;margin-top: 5px;padding-top:4px;padding-bottom: 5px">
        <h4 style="margin-left: 10px">What's your problem?</h4>
        <textarea id="inputproblem" class="form-control" rows="3" cols="10" style="margin-left: 50px;max-width: 800px;max-height: 100px"></textarea>
        <button type="button" id="problemsub" class="btn btn-default" style="margin-top:-60px;margin-left: 850px">Submit</button>
      </div>
      </div>
    </div><!--userproblem -->
    <div style="width:1000px;height: 200px">
      <p align="center" style="color: #ffffff;font-size: 25px">Related products recommended</p>
        <div class="recommend" style="background-image: url('../image/Order/20140305163838_69224.jpg')">
          <div class="sliderecom">
            China  Sanya,the Oriental Hawaii
          </div>
        </div>
        <div class="recommend" style="background-image: url('../image/Order/640.jpe')">
          <div class="sliderecom">
            Maldives ,the Seaside resort
          </div>
        </div>
        <div class="recommend" style="background-image: url('../image/Order/dsc2.jpg')">
          <div class="sliderecom">
            Italy,the Ancient Rome culture
          </div>
        </div>
    </div><!--main_centext-->
  </div><!--center-->
<div id="tail">
  <div id="version">
      <div class="version_tap">
        Our Services：<br>
        <a href="#">Organize group tours</a><br>
        <a href="#">Tourism navigation</a><br>
        <a href="#">Travel Tips</a><br>
        <a href="#">More</a>
      </div><!--version_tap-->
    <div class="version_tap">
      Find us：<br>
      60 Paya Lebar Road<br>
      Paya Lebar Square # 10-15<br>
      Singapore, 409051<br>
      +(65) 9649 6587<br>
      asia@perfectproductions.asia<br>
      pictureperfectproductions<br>
    </div><!--version_tap-->
    <div class="version_tap">
      Connect Us：<br>
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
<div id="reg">
  Are you sure you want to quit?
</div>
  </body>
</html>
