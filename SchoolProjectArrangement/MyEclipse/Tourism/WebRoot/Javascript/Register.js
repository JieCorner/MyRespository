/**
 * Created by jie on 2016/4/18.
 */
$(document).ready(function(){

    $(".Reset").click(function(){
        $(":input").val("");
        $("p").text("");
        $("#Register_Username").parent().removeClass("has-warning");
        $("#Register_email").parent().removeClass("has-warning");
        $(":input[placeholder='password']").parent().removeClass("has-warning");
        $(":input[placeholder='repassword']").parent().removeClass("has-warning");
    });

    $(".Register").click(function(){
        var reg = /\w+[@]{1}\w+[.]\w+/;
        var reg_pwd=/^[0-9a-zA-Z_]{6,15}$/;
        var reg_phone=/^1[3|4|5|8]\d{9}$/;
        var tap_user=true;
        var tap_phone=true;
        var tap_email=true;
        var tap_password=true;
        var tap_repassword=true;
        var Username=$("#Register_Username");
        var Email=$("#Register_email");
        var Phone=$("#Register_phone");
        var Password=$(":input[placeholder='password']");
        var Repassword=$(":input[placeholder='repassword']");
        var str_username;
        var str_email;
        var str_phone;
        var str_sex=$(".optionsRadios:checked").val();
        var str_password;
        var str_repassword;
        if(Username.val()==""){
        	Username.next().text("/*User name can not be empty*/").css('color','lightslategrey');
        	Username.parent().addClass("has-warning");
            tap_user=false;
        }else if(Username.val().length<4||$("#Register_Username").val().length>16){
        	Username.next().text("/*The user name you entered does not meet the requirements, please re-enter*/").css('color','lightslategrey');
        	Username.parent().addClass("has-warning");
            tap_user=false;
        }else{
        	Username.next().text("");
        	Username.parent().removeClass("has-warning");
            str_username=Username.val();
            tap_user=true;
        }
        if(Email.val()==""){
        	Email.next().text("/*Mailbox cannot be empty*/").css('color','lightslategrey');
        	Email.parent().addClass("has-warning");
            tap_email=false;
        }else if(!reg.test(Email.val())){
        	Email.next().text("/*The mailbox you entered is not valid.*/").css('color','lightslategrey');
        	Email.parent().addClass("has-warning");
            tap_email=false;
        }else{
        	Email.next().text("");
        	Email.parent().removeClass("has-warning");
            str_email=Email.val();
            tap_email=true;
        }
        if(Phone.val()==""){
        	Phone.next().text("/*Phone can not be empty*/").css('color','lightslategrey');
        	Phone.parent().addClass("has-warning");
        	tap_phone=false;
        }else if(!reg_phone.test(Phone.val())){
        	Phone.next().text("/*The number you entered is not valid.*/").css('color','lightslategrey');
        	Phone.parent().addClass("has-warning");
        	tap_phone=false;
        }else{
        	Phone.next().text("");
        	Phone.parent().removeClass("has-warning");
            str_phone=Phone.val();
            tap_phone=true;
        }
        if(Password.val()==""){
        	Password.next().text("/*Password can not be empty*/").css('color','lightslategrey');
        	Password.parent().addClass("has-warning");
            tap_password=false;
        }else if(!reg_pwd.test(Password.val())){
        	Password.next().text("/*The passwords you entered do not meet the requirements.*/").css('color','lightslategrey');
        	Password.parent().addClass("has-warning");
            tap_password=false;
        }else{
        	Password.next().text("");
            str_password=Password.val();
            tap_password=true;
        }
        if(!(Password.val()== Repassword.val())){
        	Repassword.next().text("/*Two input passwords are not consistent*/").css('color','lightslategrey');
        	Repassword.parent().addClass("has-warning");
            tap_repassword=false;
        }else{
        	Repassword.next().text("");
            str_repassword= Repassword.val();
            tap_repassword=true;
        }
        if(tap_user&&tap_email&&tap_password&&tap_repassword&&tap_phone){
            $.ajax({
                type : 'POST',
                url : 'RegisterDeal',
                data : {
                    username : str_username,
                    email:str_email,
                    phone:str_phone,
                    password:str_password,
                    repassword:str_repassword,
                    sex:str_sex
                },
                success : function (response, stutas, xhr) {
                	var obj = jQuery.parseJSON(response);
                	if(obj.sORf=='true'){
                		alert("Register Success");
                		window.location.href="Login.html"; 
                	}else{
                		if(obj.UserExist=='false'){
                			Username.next().text("/*The user name already exists. Please re-enter it.*/").css('color','red');
                        	Username.parent().addClass("has-warning");
                		}
                		if(obj.PhoneExist=='false'){
                			Phone.next().text("/*The number already exists. Please re-enter it.*/").css('color','red');
                			Phone.parent().addClass("has-warning");
                		}
                		if(obj.EmailExist=='false'){
                			Email.next().text("/*The mailbox has been registered, please re-enter*/").css('color','red');
                        	Email.parent().addClass("has-warning");
                		}
                		if(obj.UserExist=='true'&&obj.EmailExist=='true'&&obj.PhoneExist=='true'){
                    		window.location.href="Register.html"; 		
                		}
                	}
                }
            });
        }
    });

   $("#Register_Username").tooltip({
       position:{
           my : 'left center',
           at:'right+10 '
       }
   });

    $(":input[placeholder='password']").tooltip({
        position:{
            my : 'left center',
            at:'right+10 '
        }
    });

    $('#Register_email').autocomplete({
        autoFocus : true,
        delay : 0,
        source : function (request, response) {
            var hosts = ['qq.com','163.com', 'sina.com', 'yahoo.com','gmail.com'], //��ʼ
                term = request.term, //��ȡ����ֵ
                ix = term.indexOf('@'), //@
                name = term, //�û���
                host = '', //����
                result = []; //���
            //����һ�����Լ�����
            result.push(term);
            if (ix > -1) { //�����@��ʱ��
                name = term.slice(0, ix); //�õ��û���
                host = term.slice(ix + 1); //�õ�����
            }
            if (name) {
                //�õ��ҵ�������
                var findedHosts = (host ? $.grep(hosts, function (value, index) {
                        return value.indexOf(host) > -1;
                    }) : hosts),
                //�����б������
                    findedResults = $.map(findedHosts, function (value, index) {
                        return name + '@' + value;
                    });
                //����һ����������
                result = result.concat(findedResults);
            }
            response(result);
        }
    });


})