
//load 
$(function(){

	$("#btn-new-opts").click(function() {
		
		var name = $(this).data("name");
		$(location).attr('href',"/bitmall/admin/opts_new?name="+name);
		
	});//$("#btn-new-opts").click
	
	
});//$(function()