/**
 * Created by jie on 2016/5/4.
 */
$(document).ready(function(){
	 $(document).on("click",".submitdata",function(){ 
		 $.ajax({
	            type : 'POST',
	            data : {
	                username:$("#navbar ul li:first").text().trim(),
	                dataX:$("#dataX").val(),
	                dataY:$("#dataY").val(),
	                dataWidth:$("#dataWidth").val(),
	                dataHeight:$("#dataHeight").val()
	            },
	            url : '../CutPhotoServlet',
	            success : function (response, stutas, xhr) {
	           	 	if(response=="cutSuccess"){
	           	 		alert("Submit successfully");
	           	 		window.location.href="../UserInfo.jsp"; 
	           	 	}else{
	           	 		alert("error");
	           	 		window.location.href="../Login.jsp"; 
	           	 	}
	            }
	        });
	}) 

	$("#navbar ul li").eq(1).click(function(){  	
    	$(window).scrollTop(0);
    	$('#uploadreg').dialog('open');
    });
	
	 $('#uploadreg').dialog({
	        title : 'Are you sure?',
	        buttons : {
	            'Yes' : function () {
	            	 $.ajax({
	                     type : 'POST',
	                     url : '../DispleSession',
	                     success : function (response, stutas, xhr) {
	                    	 if(response=="success"){
	                    		 window.location.href="../Login.html"; 
	                    	 }
	                     }
	                 });
	            },
	            'No' : function () {
	                $(this).dialog('close');
	            }
	        },
	      autoOpen : false,
	        modal : true
	    });
})