 $(document).ready(function(){
    	 $(".Userup").click(function(){
    	  var pname=this.src.split("/");
    	  var uptime=$(this);
          if(pname[pname.length-1]=="weizan.png"){
            this.src="Image/yizan.png";
            $.ajax({
      	        type : 'GET',
      	        url : 'markUpforCommentAction.action',
      	        data : {
      	        	"comment.id":$(this).next().next().text()
      	        },
      	        success : function (response, stutas, xhr) {
      	        	if(response.requestUp=="success"){
      	        		uptime.next().text(response.requestUptimes);
      	        	}else{
      	        		
      	        	}
      	        }
      	      });
          }
        });
    });