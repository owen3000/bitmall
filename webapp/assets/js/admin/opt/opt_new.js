
//load 
$(function(){

	$("#opt-form").submit(function() {
		
		var newOptName = $("#opt-name").val();
		if( newOptName == "" ){
			alert("옵션명을 입력하세요!");
			$("#opt-name").focus();
			event.preventDefault();
			return;
		}
		
		
	});
	
});//$(function()