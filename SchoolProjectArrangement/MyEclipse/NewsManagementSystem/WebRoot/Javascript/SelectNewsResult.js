$(document).ready(function(){
    	
		$(".UserLoginButton").click(function(){
		 $.ajax({
 	        type : 'GET',
 	        url : 'LoginAction.action',
 	        data : {
 	        	username:$("#inputusername").val(),
 	        	password:$("#inputpassword").val()
 	            },
 	        success : function (response, stutas, xhr) {
 	        	if(response.requestResult=="success"){
 	        		$("#closeModel").click();
 	        		alert("登录成功");
 	        		location.reload();
 	        	}else{
 	        		$("#errormessage").prepend("<img src='Image/alarm.png' style='margin-top: -3px'>用户名或密码错误,请重新输入!");
 	        	}
 	        }
 	      });
      });
      
      $(".exit").click(function(){
 		 $.ajax({
  	        type : 'GET',
  	        url : 'ExitAction.action',
  	        data : {},
  	        success : function (response, stutas, xhr) {
  	        	if(response.requestResult=="success"){
  	        		window.location.href="index.jsp"; 
  	        	}else{
  	        		alert("退出异常!");
  	        	}
  	        }
  	      });
       });
    });