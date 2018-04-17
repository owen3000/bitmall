
// load
$(function(){
	
	$("#b-order").click(function() {
		
			if( $("#opt-color").val() == ''){
				if( $("#opt-color").children().length != 1){
					alert("색상을 선택하세요.");
					event.preventDefault();
					return;
				}
			}
			if( $("#opt-size").val() == ''){
				if( $("#opt-size").children().length != 1){
					alert("사이즈를 선택하세요.");
					event.preventDefault();
					return;
				}
			}
			if( $("#num").val() < 1){
				alert("수량을 정확히 입력하세요");
				$("#num").val("1").focus();
				event.preventDefault();
				return;
			}
			$("#form-product-detail").submit();
	
	});//$("#b-order").click
	
	$("#b-cart").click(function() {
		if( $("#opt-color").val() == ''){
			if( $("#opt-color").children().length != 1){
				alert("색상을 선택하세요.");
				event.preventDefault();
				return;
			}
		}
		if( $("#opt-size").val() == ''){
			if( $("#opt-size").children().length != 1){
				alert("사이즈를 선택하세요.");
				event.preventDefault();
				return;
			}
		}
		if( $("#num").val() < 1){
			alert("수량을 정확히 입력하세요");
			$("#num").val("1").focus();
			event.preventDefault();
			return;
		}
		$("#form-product-detail").submit();
		
	});//$("#b-order").click
	

	
	
});//load

