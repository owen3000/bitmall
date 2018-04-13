
//load 
$(function(){
	
	// 할인율 갱신
	$( ".checkbox-event" ).on( "change", function() {
		
		var checkBoxs = $( ".checkbox-event:checked" );
		var discount = 0.0;
		$.each(checkBoxs, function(i, elt) {
			var rate = $(elt).data("rate");
			discount += parseFloat(rate);
		});
		
		$("#product-new-discount").val(discount.toString());
		 
	});//$( ".checkbox-event" ).on
	
	
	// form-product-new vaild 
	$("#form-product-new").on("submit", function() {
		
		var allData = {};
		$.each( $(this).serializeArray(), function(index, o) {
			allData[ o.name ] = o.value;
		});//$.each
		
		if( allData["category"] == 0 ){
			alert("카테고리를 선택하세요!");
			//$('#product-new-category option:contains("상품분류를 선택하세요")').prop('selected', true);
			event.preventDefault();
			return;
		}
		
		if( allData["code"] == "" ){
			alert("코드를 입력하세요!");
			$("#product-new-code").focus();
			event.preventDefault();
			return;
		}
		
		if( allData["name"] == "" ){
			alert("상품명을 입력하세요!");
			$("#product-new-name").focus();
			event.preventDefault();
			return;
		}
		
		if( allData["manufacturer"] == "" ){
			alert("제조사를 입력하세요!");
			$("#product-new-manufacturer").focus();
			event.preventDefault();
			return;
		}
		
		if( allData["price"] == "" ){
			alert("가격을 입력하세요!");
			$("#product-new-price").focus();
			event.preventDefault();
			return;
		}
		
		if( allData["opt"] == undefined ){
			alert("옵션을 선택하세요!");
			event.preventDefault();
			return;
		}
		
		if( allData["description"] == "" ){
			alert("제품 설명을 입력 하세요!");
			$("#product-new-description").focus();
			event.preventDefault();
			return;
		}
		
		if( allData["status"] == undefined ){
			alert("상품 상태를 선택하세요!");
			event.preventDefault();
			return;
		}
		
		if( allData["event"] == undefined ){
			alert("아이콘을 선택하세요!");
			event.preventDefault();
			return;
		}
		
		var temp = $(".product-new-file");
		var fileEmpty = true;
		$.each(temp, function(i, elt) {
			if( $(elt).val() != "" ){
				fileEmpty = false;
				return false;
			}
		});
		if( fileEmpty == true){
			alert("이미지가 없습니다!");
			event.preventDefault();
			return;
		}
		
	});//$("#form-product-new").on
	

});//$(function()