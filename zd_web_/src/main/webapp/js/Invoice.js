
$("document").ready(function(){
	
  $("#Invoice-button").bind("click",getInvoice_value);
  $("#invoiceid").change(clearErrorMsg);
}) 

function clearErrorMsg() {
    $("#errorMsg").text("nihaoya");
}

function getInvoice_value(){
 var invoiceid=("#invoiceid").val();
	 alert("测试getIvoice");
	 if(Invoice(invoiceid)){
		  submit();
	 }
}

$("#submit").click(function(){
	  alert("submit");
	  $.ajax({
		  dataType:"json",
		  url:"http://localhost:8080/zd_web_/file/fileUpload",
		  data:{
			  invoiceid:$("#invoiceid").val(),
			  name:$("#name").val(),
			  address:$("#address").val(),
			  banckaccount:$("#banckaccount").val(),
			  accountnumber:$("#accountnumber").val(),
			  salesman:$("#salesman").val(),
			  depart:$("#depart").val()
		  },
		  
		  success:function(data){
	    	   if(data.msg !=" ")
	    		   alert(data.msg);
	    	   else
	    		   alert("error[timeout]");
	     }
	  
	  
	  });
	  
	   }) ;


function Invoice(invoiceid){
	   if(invoice==" ")
		   {
		   ("#errorMsg").text("格式错误");
		   return false;
		   }
	   else
	   return true;
}