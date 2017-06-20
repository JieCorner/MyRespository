/**
 * Created by jie on 2016/4/20.
 */
var OrderID;
var isLogin=false;
function getIDaLogin(id,login){
	OrderID=id;
	isLogin=login;
}
$(document).ready(function(){
	
    $(".group_date").val("");
    $(":input[disabled]").eq(1).val(1021);
    $('.group_date').datepicker({
        yearRange: '2016:2020',
        minDate : 0,
        maxDate : 10000,
        slide:true,
        defaultDate : -1,
        hideIfNoPrevNext : true,
        gotoCurrent : false
    });
    $(".sm_picture").click(function(){
        $(".sm_picture").css({
            border:"0px",
            padding:"0px 0px"
        });
        $(this).css({
            border:"2px solid #000000",
            padding:"2px 2px"
        });
        var path=$(this).attr('src');
        $(".big_show").attr("src",path);
    });

    $("#reset").click(function(){
        $(".prompt").css("display","none");
        $(":input:not(':first')").val("");
        $(".select_Number").eq(1).val("1");
        $(".select_Number:last").val("0");
        $("#sumcost").text($("#cost").text());
    });
    $("#problemsub").click(function(){
    		if(isLogin==false){
        		alert("Please login first");
        		return false;
        	}else{
        		if($("#inputproblem").val()==""){
            		alert("please input your question");
            	}else{
        		$.ajax({
                    type : 'Get',
                    url : '../InsertProblem',
                    data : {
                        username:$("#navbar ul li:first").text().trim(),
                        productID:OrderID
                    },
                    success : function (response, stutas, xhr) {
                        if(response=="true"){
                        	alert("You have submitted questions, please be patient for answer");
                        }else{
                        	$.ajax({
                                type : 'POST',
                                url : '../InsertProblem',
                                data : {
                                    problem : $("#inputproblem").val(),
                                    username:$("#navbar ul li:first").text().trim(),
                                    productID:OrderID
                                },
                                success : function (response, stutas, xhr) {
                                    if(response){
                                    	alert("publish success,Please be patient and wait for the administrator to reply");
                                    	 $("#userproblem").load("../UserProblem",{odernumberid:OrderID});
                                    }else{
                                    	alert("publish fail,please try again");
                                    }
                                }
                            });
                        }
                    }
                });
        	}
    	}
    })
     $(document).on("click",".submitanswer",function(){ 
    	 var user=$(this).parent().parent().children(0).children("span").text();
    	 var answer=$(this).parent().children(".form-control").val();
    	 var productID=OrderID;
    	 $.ajax({
 	        type : 'GET',
 	        url : '../UserProblem',
 	        data : {
 	        	username:user,
 	        	answer:answer,
 	        	productID:productID
 	            },
 	        success : function (response, stutas, xhr) {
 	        	if(response=="success"){
 	        		alert("Submit successfully");
 	        	}else{
 	        		alert("error");
 	        	}
 	        }
 	      });
	})  
    $("#submit").click(function(){
    	if(isLogin==false){
    		alert("Please login first");
    		return false;
    	}else{
    		$.ajax({
    	        type : 'Get',
    	        url : '../AddOrder',
    	        data : {
    	        	ProductID:OrderID,
    	        	username:$("#navbar ul li:first").text().trim()
    	            },
    	        success : function (response, stutas, xhr) {
    	        	if(response=='true'){
    	        		alert("You have already reserved this service. Please do not repeat the operation.");
    	        		return false;
    	        	}else{
    	        		$.ajax({
    	        	        type : 'POST',
    	        	        url : '../AddOrder',
    	        	        data : {
    	        	        	ProductID:OrderID,
    	        	        	username:$("#navbar ul li:first").text().trim(),
    	        	        	staringplace:$(".startplace").val(),
    	        	        	phone:$(".phone").val(),
    	        	        	startdate:$(".startdate").val(),
    	        	        	Adult:$(".select_Number").eq(1).val(),
    	        	        	Children:$(".select_Number").eq(2).val(),
    	        	        	Remark:$(".remark").val(),
    	        	        	Cost:$("#sumcost").text().substring(1,$("#sumcost").text().length)
    	        	            },
    	        	        success : function (response, stutas, xhr) {
    	        	        	if(response=='true'){
    	        	        		alert("Submit successfully,please timely preparation of travel products");
    	        	        	}else{
    	        	        		alert("error,please submit again");
    	        	        	}
    	        	        }
    	        	      });
    	        	}
    	        }
    	      });
    	}
    });

    $(".recommend").hover(function(){
        $(this).children(1).stop().slideUp();
    },function(){
        $(this).children(1).stop().slideDown();
    })
    
    $(".select_Number").eq(1).change(function(){
        var adultnum=$(this).val();
        var cost=$("#cost").text();
        cost=cost.substring(1,cost.length);
        var childnum=$(".select_Number:last").val();
        $("#sumcost").text("$"+(cost*adultnum+childnum*cost/2));
    });
    $(".select_Number:last").change(function(){
        var childnum=$(this).val();
        var adultnum=$(".select_Number").eq(1).val();
        var cost=$("#cost").text();
        cost=cost.substring(1,cost.length);
        $("#sumcost").text("$"+(cost*adultnum+childnum*cost/2));
    });
});
//�첽����
function getajaxinfo(index){
	$(".usercom").html("<img src='../image/loading2.gif' width='60px' height='60px' style='margin-left:450px' />");
	$(".usercom").load("../ProductCom",{pagenum:index,odernumberid:OrderID});
}
function ajaxOrderinfo(thisOrderID){
	 $.ajax({
	        type : 'GET',
	        url : '../OrderInformation',
	        data : {
	                odernumberid:thisOrderID
	            },
	        success : function (response, stutas, xhr) {
	        	var obj = jQuery.parseJSON(response);
	        	if(obj.sORf=='true'){
	            	$("#cost").text("$"+obj.cost);
	            	$("#sumcost").text("$"+obj.cost);
	            	$("#evaluate").text(obj.evaluate);
	            	var str=obj.place;
	            	var ss=str.split(",");
	            	for(var i=0;i<ss.length;i++){
	    				$(".startplace").append("<option>"+ss[i]+"</option>");
						 }
	            	if(obj.admin=="true"){
	            		$(".userproblem").hide();
	            	}
	            }else{
	            	window.location.href="../Register.jsp"; 
	            }
	        }
	      });
   }
function ajaxProductCom(thisOrderID){
    var num=0;
    var pagination=$(".pagination");  
	$.ajax({
        type : 'GET',
        url : '../ProductCom',
        data : {
                odernumberid:thisOrderID
            },
        success : function (response, stutas, xhr) {
        	if(response%10==0){
        		num=response/10;
        	}else{
        		num=parseInt(response/10)+1;
        	}
            if(num==1){
                pagination.append("<li ><a href='javascript:void(0)' >&laquo</a></li>"+
               "<li class='active'><a href='javascript:void(0)'>1</a></li>"+
               "<li ><a href='javascript:void(0)'>&raquo</a></li>");
            }else if(num <=8){
                pagination.append("<li ><a href='javascript:void(0)' >&laquo</a></li>"+
                    "<li class='active'><a href='javascript:void(0)'>1</a></li>");
                for(var i=2;i<=num;i++){
                    pagination.append("<li ><a href='javascript:void(0)'>"+i+"</a></li>");
                }
                pagination.append("<li ><a href='javascript:void(0)'>&raquo</a></li>");
            }else if(num>8){
                pagination.append("<li ><a href='javascript:void(0)' >&laquo</a></li>"+
                    "<li class='active'><a href='javascript:void(0)'>1</a></li>");
                for(var i=2;i<=7;i++){
                    pagination.append("<li ><a href='javascript:void(0)'>"+i+"</a></li>");
                }
                pagination.append("<li ><a href='javascript:void(0)'>...</a></li>"+"<li ><a href='javascript:void(0)'>&raquo</a></li>");
            }
            $(".pagination li").click(function(){
                var li=$(".pagination li");
                if($(this).text()!="..."){
                    if($(this).get(0)== $(".pagination li:first").get(0)){
                        var a=$(".pagination .active").index();
                        if($(".pagination li").eq(a-1).get(0)!=$(this).get(0)){
                            if(li.eq(a-1).get(0)!=$(this).get(0)) {
                                if (li.eq(a - 1).text() == "...") {
                                    var i=3;
                                    for(i=3;i<=7;i++){
                                        var text=li.eq(i).children("a").text();
                                        li.eq(i).children("a").text(parseInt(text)-1);
                                        if(parseInt(li.eq(i).text())==3){
                                            li.eq(a-1).children("a").text(2);
                                        }
                                    }
                                    getajaxinfo(li.eq(a).text());
                                    li.eq(8).children("a").text("...");
                                } else {
                                    $(".pagination .active").removeClass("active");
                                    getajaxinfo(li.eq(a-1).text());
                                    li.eq(a - 1).addClass("active");
                                    $(window).scrollTop(1350);
                                }
                            }
                        }
                    }else if($(this).get(0)== $(".pagination li:last").get(0)){
                        var a=$(".pagination .active").index();
                        if(li.eq(a+1).get(0)!=$(this).get(0)){
                            if(li.eq(a+1).text()=="..."){
                                if(parseInt(li.eq(a).text())<num-1){
                                    li.eq(2).children("a").text("...");
                                    var i=3;
                                    for(i=3;i<=7;i++){
                                        var text=li.eq(i).children("a").text();
                                        li.eq(i).children("a").text(parseInt(text)+1);
                                        if(parseInt(li.eq(i).text())==num-1){
                                            li.eq(a+1).children("a").text(num);
                                        }
                                    }
                                    getajaxinfo(li.eq(i-1).text());
                                }
                            }else {
                                $(".pagination .active").removeClass("active");
                                getajaxinfo(li.eq(a+1).text());
                                li.eq(a+1).addClass("active");
                                $(window).scrollTop(1350);
                            }
                        }
                    }else{
                        $(".pagination .active").removeClass("active");
                        getajaxinfo($(this).text());
                        $(window).scrollTop(1350);//asd
                        $(this).addClass("active");
                    }
                }
            })
            var username=$("#navbar ul li:first").text().trim();
            $(".usercom").load("../ProductCom",{odernumberid:thisOrderID,pagenum:1});
            $("#userproblem").load("../UserProblem",{islogin:isLogin,username:username,odernumberid:thisOrderID});
        }
      });
}