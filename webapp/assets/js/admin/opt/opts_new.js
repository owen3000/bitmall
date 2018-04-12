
//load 
$(function(){

	$("#opts-form").submit(function() {
		
		var newOptsvalue = $("#opts-value").val();
		if( newOptsvalue == "" ){
			alert("소옵션명을 입력하세요!");
			$("#opts-value").focus();
			event.preventDefault();
			return;
		}
		
		
	});
	
});//$(function()