$(document).ready(function(){
	$("#select_member").dataTable({
		 "processing":true,
		 "serverSide":true,
		 "bServerSave":true,
		 "paginationType":"full_numbers",
		 "ajax":"http://localhost:8080/zd_web_/member/select_member",
		 
		 "contentType":"application/json",
		 "columns":[
                    {"data":"id"},
		            {"data":"customername"},
		            {"data":"gender"},
		            {"data":"cellphonenumber"},
		            {"data":"staff"},
		            {"data":"company"},
		            {"data":"mailbox"}
		           ]
	}); 
	
});


