$(document).ready(function(){

	 $("#datatable").dataTable({
	 
	        "serverSide":true,
	        "bServerSave":true,
	    
	        "ajax":"http://localhost:8080/zd_web_/sessions/list",
	        "contentType":"application/json",
	         "columns":[
	                    {"data":"当前在线人数"}                
	                  ] 
	 });
});