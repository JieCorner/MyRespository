$(document).ready(function(){
      $(".sureUpdate").click(function(){
       	$.ajax({
  	        type : 'GET',
  	        url : 'UpdateSurePasswordAction.action',
  	        data : {
  	            userId:$("#userId").val(),
  	        	password:$("#OldPassword").val()
  	        },
  	        success : function (response, stutas, xhr) {
  	        	if(response.requestResult=="success"){
  	        		$.ajax({
  	        			type : 'GET',
  	        			url : 'UpdateUserInfoAction.action',
  	        			data : {
  	        				userId:$("#userId").val(),
  	        				password:$("#password").val(),
  	        				email:$("#email").val()
  	       				 },
  	        			success : function (response, stutas, xhr) {
  	        			alert("修改成功");
  	        			window.location.href="UpdateUserAction.action?user.id="+$("#userId").val(); 
  	        		}
  	      		});
  	        	}else{
  	        		alert("密码错误!");
  	        	}
  	        }
  	      });
      });
    });