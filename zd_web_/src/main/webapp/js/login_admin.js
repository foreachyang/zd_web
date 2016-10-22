function submit(){
	

	$.ajax({
    	type:'post',
    	url:'http://localhost:8080/zd_web_/admin/login',
    	dataType:'json',
         data:{
        	 userName:$("#userName").val(),
	    	 password:$("#password").val() 
         },
     success:function(data){
    	
    		    
    		    		  location.href="http://localhost:8080/zd_web_/admin/user_admin";
    		    	  
      }	
});
}


function error(){
	 alert('error');
	$.ajax({
		url:'http://localhost:8080/zd_web_/exception/un',
		dataType:'json',
		success:function(data){
			 if(data.message!=" ")
				 alert(data.message);
		}
	});
}