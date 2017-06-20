$(document).ready(function(){
    	$(".sureOper").click(function(){
    		if(confirm("确认要删除该新闻类别吗?")){
    		return true;
    	}else{ 
    		return false;
    	}
    	})
    });