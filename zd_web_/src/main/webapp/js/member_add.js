function adduser(){
	
  alert(test);
    var c=$("#company").find("option:selected").text();
    
     var r= $('input:radio[name=gender]:checked').val();
  
      var number= $("#cellphonenumber").val();
   
       $.ajax({
  	     url:'http://localhost:8080/zd_web_/member/member_adds',
  	     dataType:"json",
  	     data :{

  	                    	  customername :$("#customername").val(),
  	    	            	  gender:r,
  	    	            	  cellphonenumber:number.parseInt(),
  	    	            	  staff:$("#staff").val(),
  	    	            	  company:c,
  	    	            	  mailbox:$("#mailbox").val(),
  	     },
  	     
  	     success :function(data){
  	    	   if(data.msg !=" ")
  	    		   alert(data.msg);
  	    	   else
  	    		   alert("ok");
  	     }
  	   }) ;
}