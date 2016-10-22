function logins(){
	 location.href="http://localhost:8080/zd_web_/logins.jsp";
}    


function admin(){
	location.href="http://localhost:8080/zd_web_/admin";
}
function captcha(){

 var forms=document.forms[1];
  forms.action="http://localhost:8080/zd_web_/validateImage";
  forms.submit();
}

function addUser() { 
	//captcha();
    	/*
    	 *     	             
        var form = document.forms[0];  
       
        forms.method="POST";
       forms.submit();
       
        form.action = "${pageContext.request.contextPath}/user/login";
        
        
        form.method = "POST";  
        form.submit(); 
        */

    	
    	$.ajax({
    	        	type:'post',
    	        	url:'http://localhost:8080/zd_web_/user/login',
    	        	dataType:'json',
    	             data:{
    	            	 userName:$("#userName").val(),
    	    	    	 password:$("#password").val() 
    	             },
    	         success:function(data){
    	       
    	        
    	        		    	  if(data.errormsg!=null)
    	        		    		  alert(data.errormsg);
    	        		    	  else
    	        		    	 
    	        		    		  location.href="http://localhost:8080/zd_web_/user/staff";
    	        		    	  
    	          }	
    	});
    } 
    

    
    