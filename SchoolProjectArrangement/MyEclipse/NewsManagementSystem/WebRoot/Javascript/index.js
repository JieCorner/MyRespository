 $(document).ready(function(){
    	
    	//获取新闻列表
    	$.ajax({
  	        type : 'GET',
  	        url : 'indexdataAction.action',
  	        data : {},
  	        success : function (response, stutas, xhr) {
  	        	$("#Realtimenewsdiv").prepend(response.requestnewslisthtml);
  	        	$("#categorynav").prepend(response.requestcategoryhtml);
  	        }
  	      });
    	
    	$(document).on("mouseenter",".newCategoryClass",function(){
    		$(this).css("background","#000000");
    	})
    	$(document).on("mouseleave",".newCategoryClass",function(){
    		 $(this).css("background","#222222");
    	})
    	
      


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
 	        		window.location.href="index.jsp"; 
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