$("#submit").click(function(){
	 alert("test");
	 var t; 
	 if($('#commrnt').is(':checked'))
		 t="true";
	 else
		 t="false";

	 var s=$("#drug_type").find("option:selected").text();
	 
	   $.ajax({
	     url:'http://localhost:8080/zd_web_/product_list/product_value',
	     dataType:"json",
	     type:"post",
	     data :{
	    	 drug_name: $('#drug_name').val(),
	    		 drug_type: s,
	    		 commrnt :t,
	    		 drug_field:$('#drug_field').val(),
	    		 company:$('#company').val(),
	    		 weight: $('#weight').val(),
	    		 wholesale: $('#wholesale').val(),
	    		 market_price:$('#market_price').val(),
	    		 const_price: $('#const_price').val(),
	    		 supplier: $('#supplier').val(),
	    		 drug_intro:$('#drug_intro').val(),
	    		 detailedcontrnt:$('#detailedcontrnt').val(),
	     },
	     
	     success :function(data){
	    	   if(data.msg !=" ")
	    		   alert(data.msg);
	    	   else
	    		   alert("ok");
	     }
	   }) ;
});