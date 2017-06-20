$(document).ready(function(){

      $(".exit").click(function(){
 		 $.ajax({
  	        type : 'GET',
  	        url : 'ExitAction.action',
  	        data : {},
  	        success : function (response, stutas, xhr) {
  	        	if(response.requestResult=="success"){
  	        		alert("退出成功");
  	        		window.location.href="index.jsp"; 
  	        	}else{
  	        		alert("退出异常!");
  	        	}
  	        }
  	      });
       });
      
    });