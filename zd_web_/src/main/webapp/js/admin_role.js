/*管理员-角色-添加*/
function admin_add(){

	var params={};
	/*
	if($('#user-Character-0').is(':checked'))
	alert("true");
	else
    alert("false");	
    */	
 var u=$("#userName").val();
 var s=$("#password").val()

	 alert(u);
    alert(s);
	$.ajax({
	     url:'http://localhost:8080/zd_web_/admin/admin_add',
	     data:{
	    	 userName:$("#userName").val(),
	    	 password:$("#password").val()
	     },
	    dataType: 'json',
	    
	     success:function(data){
	    	  if(data.msg!=" ")
	    		  alert(data.msg);
	    	  else
	    		 alert("ok");  
	     }
	});
}