/**
 * Created by jie on 2016/5/4.
 */
$(document).ready(function(){
	$("#navbar ul li").eq(0).click(function(event){
    	if($.trim(event.target.text)=="Login"){
    		window.location.href="../Login.html"; 
    	}else{
    		window.location.href="../UserInfo.jsp"; 
    	}
    });   
    $("#navbar ul li").eq(1).click(function(event){
    	if($.trim(event.target.text)=="Register"){
    		window.location.href="../Register.html"; 
    	}
    	else if($.trim(event.target.text)=="Exit"){
    		$(window).scrollTop(0);
    		$('#reg').dialog('open');
    	}
    });    
    $('#reg').dialog({
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