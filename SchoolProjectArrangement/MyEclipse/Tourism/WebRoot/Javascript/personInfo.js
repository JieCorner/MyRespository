/**
 * Created by jie on 2016/6/3.
 */
$(document).ready(function(){
	var target=1;
	$(".order").load("InfoOrder",{username:$(".dropdown-toggle").eq(1).text().trim()});
	$(".problem").load("InfoProblem",{username:$(".dropdown-toggle").eq(1).text().trim()});
	
	
	 $.ajax({
         type : 'GET',
         data : {
             username:$(".dropdown-toggle").eq(1).text().trim()
         },
         url : 'PersonInfo',
         success : function (response, stutas, xhr) {
        	 var obj = jQuery.parseJSON(response);
        	 $("#info_username").html("&nbsp;&nbsp;"+obj.username);
        	 $("#info_phone").html("&nbsp;&nbsp;"+obj.phone);
        	 $("#info_email").html("&nbsp;&nbsp;"+obj.email);
        	 $("#info_sex").html("&nbsp;&nbsp;"+obj.sex);
         }
     });
	 
	 
	 $.ajax({
         type : 'POST',
         data : {
             username:$(".dropdown-toggle").eq(1).text().trim()
         },
         url : 'ProblemReply',
         success : function (response, stutas, xhr) {
        	 if(response!=""){
        		 if(response=="0"){
        			 $(".reply").text("");
        		 }else{
            		 $(".reply").text(response); 
        		 }
        	 }else{
        		 alert("error");
        	 }
         }
     });
	 
	 $(".submit_button").click(function(){
		 var reg = /\w+[@]{1}\w+[.]\w+/;
	        var reg_pwd=/^[0-9a-zA-Z_]{6,15}$/;
	        var reg_phone=/^1[3|4|5|8]\d{9}$/;
	        var tap_phone=true;
	        var tap_email=true;
	        var tap_repassword=true;
	        var Email=$("#Modify_email");
	        var Phone=$("#Modify_phone");
	        var Repassword=$(".Modify_password");
	        var str_email;
	        var str_phone;
	        var str_repassword;
	        if(Email.val()==""){
	        	Email.next().text("/*Email not allowed to be null*/").css('color','lightslategrey');
	        	Email.parent().addClass("has-warning");
	            tap_email=false;
	        }else if(!reg.test(Email.val())){
	        	Email.next().text("/*The mailbox account you entered is not valid.*/").css('color','lightslategrey');
	        	Email.parent().addClass("has-warning");
	            tap_email=false;
	        }else{
	        	Email.next().text("");
	        	Email.parent().removeClass("has-warning");
	            str_email=Email.val();
	            tap_email=true;
	        }
	        if(Phone.val()==""){
	        	Phone.next().text("/*Phone not allowed to be null*/").css('color','lightslategrey');
	        	Phone.parent().addClass("has-warning");
	        	tap_phone=false;
	        }else if(!reg_phone.test(Phone.val())){
	        	Phone.next().text("/*The phonenumber account you entered is not valid.*/").css('color','lightslategrey');
	        	Phone.parent().addClass("has-warning");
	        	tap_phone=false;
	        }else{
	        	Phone.next().text("");
	        	Phone.parent().removeClass("has-warning");
	            str_phone=Phone.val();
	            tap_phone=true;
	        }
	        if(Repassword.val()==""){
	        	Repassword.next().text("/*The passwords not allowed to be null*/").css('color','lightslategrey');
	        	Repassword.parent().addClass("has-warning");
	            tap_password=false;
	        }else if(!reg_pwd.test(Repassword.val())){
	        	Repassword.next().text("/*The passwords you entered do not meet the requirements.*/").css('color','lightslategrey');
	        	Repassword.parent().addClass("has-warning");
	            tap_password=false;
	        }else{
	        	Repassword.next().text("");
	            str_repassword= Repassword.val();
	            tap_repassword=true;
	        }
	        if(tap_email&&tap_repassword&&tap_phone){
	        	 $.ajax({
	                 type : 'Post',
	                 data : {
	                     username:$(".dropdown-toggle").eq(1).text().trim(),
	                     email:str_email,
	                     phone:str_phone,
	                     password:str_repassword
	                 },
	                 url : 'ModifyInfo',
	                 success : function (response, stutas, xhr) {
	                	if(response=="true"){
	                		alert("Modify Success");
	                		$.ajax({
	                	         type : 'GET',
	                	         data : {
	                	             username:$(".dropdown-toggle").eq(1).text().trim()
	                	         },
	                	         url : 'PersonInfo',
	                	         success : function (response, stutas, xhr) {
	                	        	 var obj = jQuery.parseJSON(response);
	                	        	 $("#info_username").html("&nbsp;&nbsp;"+obj.username);
	                	        	 $("#info_phone").html("&nbsp;&nbsp;"+obj.phone);
	                	        	 $("#info_email").html("&nbsp;&nbsp;"+obj.email);
	                	        	 $("#info_sex").html("&nbsp;&nbsp;"+obj.sex);
	                	         }
	                	     });
	                		$(".showinfo").fadeIn();
	                	    $(".showform").attr('style','display:none');
	                	}else{
	                		alert("error");
	                		window.location.href="Login.html"; 
	                	}
	                 }
	             });
	        }
		 
	
	 })
	 
	 $("#uploadbt").click(function(){
		 if($("#myfile").val().split(".")[1]!="jpg"){
			 alert("please upload a .jpg file");
		 }else{
			 $("#uploadphoto").submit();
		 }
			return false;
		})
	  $("#infomation").click(function(){
        $(".showinfo").fadeIn();
        $(".showform").attr('style','display:none');
      })
    $("#modifyinfo").click(function(){
      $(".showinfo").attr('style','display:none');
      $(".showform").fadeIn();
    })
	
     $(document).on("click",".ordercom",function(){ 
    	 $(this).next().slideToggle();
	})  
    
	$("#showproblem").click(function(){
		myproblem();
	})
	 
    $(".list-group .list-group-item").eq(2).click(function(){
    	myproblem();
    })
    $(".list-group .list-group-item").eq(1).click(function(){
        $(".order").stop().slideDown();
        $(".problem").stop().slideUp();
        $(".order").insertBefore($(".problem"));
    })   
    
    $("#userexit").click(function(){
    	 $(window).scrollTop(0);
    	$('#reg').dialog('open');
    })

    $(document).on("click",".deleteorder",function(){ 
    	target=$(this);
		$('#deletedio').dialog('open');
	})  
    
	 $(document).on("click",".sub_com",function(){ 
		 $.ajax({
	         type : 'POST',
	         data : {
	             username:$(".dropdown-toggle").eq(1).text().trim(),
	             comment:$(this).prev().val(),
	             productID:$(this).parent().parent().children(".col-sm-1").eq(4).html()
	         },
	         url : 'PublishCom',
	         success : function (response, stutas, xhr) {
	        	if(response=="success"){
	        		alert("publish success");
	        		$(this).prev().val("");
	        	}else{
	        		alert("error");
	        	}
	         }
	     });
	})  
	
	$('#reg').dialog({
        title : 'Are you sure?',
        buttons : {
            'Yes' : function () {
            	 $.ajax({
                     type : 'POST',
                     url : 'DispleSession',
                     success : function (response, stutas, xhr) {
                    	 if(response=="success"){
                    		 history.length=0;
                    		 window.location.href="Login.html"; 
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
	
    $('#deletedio').dialog({
        title : 'Are you sure?',
        buttons : {
        	 'Yes' : function () {
        		 $.ajax({
        	         type : 'GET',
        	         data : {
        	             username:$("#info_username").text().trim(),
        	             productID:$(target).parent().children(".col-sm-1").eq(4).text()
        	         },
        	         url : 'InfoOrder',
        	         success : function (response, stutas, xhr) {
        	        	 if(response=="true"){
        	        		 $(target).parent().fadeOut(500,function(){
        	                     $(target).parent().remove();
        	                     if($(".order").children(1).next().size()==0){
        	                         $(".order").append("<span style='margin-left:250px;font-size: 20px'>You do not have any travel plans!</span>");
        	                     }
        	                 });
        	        	 }else{
        	        		 alert(error);
        	        	 }
        	         }
        	     });
        		 $(this).dialog('close');
             },
            'No' : function () {
                $(this).dialog('close');
            }
        },
      autoOpen : false,
        modal : true
    });
})

function myproblem(){
	$.ajax({
        type : 'GET',
        data : {
            username:$(".dropdown-toggle").eq(1).text().trim()
        },
        url : 'ProblemReply',
        success : function (response, stutas, xhr) {
       	if(response=="true"){
       		$(".reply").text("");
       	}else{
       		//alert("error");
       	}
      }
    });
	 $(".problem").insertBefore($(".order"));
     $(".problem").stop().slideDown();
     $(".order").stop().slideUp();
}