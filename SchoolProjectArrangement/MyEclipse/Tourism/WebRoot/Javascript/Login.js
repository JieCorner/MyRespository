/**
 * Created by jie on 2016/5/4.
 */
$(document).ready(function(){
    $(".Login").click(function(){
        var reg = /\w+[@]{1}\w+[.]\w+/;
        var reg_pwd=/^[0-9a-zA-Z_]{6,15}$/;
        var tap_user=true;
        var tap_pwd=true;
        var user=$(":input[name='username']");
        var pwd=$(":input[name='password']");
        if(user.val()==""){
            user.next().text("/*User name not allowed */").css('color','lightslategrey');
            user.parent().addClass("has-warning");
            tap_user=false;
        }else if(user.val().length<4||user.val().length>16){
            user.next().text("/*The user name you entered does not meet the requirements, please re-enter*/").css('color','lightslategrey');
            user.parent().addClass("has-warning");
            tap_user=false;
        }else{
            user.next().text("");
            user.parent().removeClass("has-warning");
            tap_user=true;
        }
        if(pwd.val()==""){
            pwd.next().text("/*Password is not allowed to empty.*/").css('color','lightslategrey');
            pwd.parent().addClass("has-warning");
            tap_pwd=false;
        }else if(!reg_pwd.test($(":input[placeholder='password']").val())){
            pwd.next().text("/*The passwords you entered do not meet the requirements.*/").css('color','lightslategrey');
            pwd.parent().addClass("has-warning");
            tap_pwd=false;
        }else{
            pwd.next().text("");
            pwd.parent().removeClass("has-warning");
            tap_pwd=true;
        }
        if(tap_pwd&&tap_user){
        	 $.ajax({
                 type : 'POST',
                 url : 'LoginDeal',
                 data : {
                	 username : user.val(),
                	 email:user.val(),
                	 password:pwd.val()
                 },
                 success : function (response, stutas, xhr) {
                	 var obj = jQuery.parseJSON(response);
                 	if(obj.sORf=='true'){
                 			alert("Login Success");
                     		window.location.href="index.jsp"; 
                 	}else{
                 		alert("Login Fail");
                 		$(".loginfail").text("User name does not exist or password does not match");
                 	}
                 }
             });
        }
    });

    $(".Reset").click(function(){
        $(":input").val("");
        $(":input[name='username']").next().text("");
        $(":input[name='password']").next().text("");
        $(".loginfail").text("");
        $(":input[name='username']").parent().removeClass("has-warning");
        $(":input[name='password']").parent().removeClass("has-warning");
    });
})