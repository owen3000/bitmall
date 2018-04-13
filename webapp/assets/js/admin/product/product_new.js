
//load 
$(function(){
	
	
	$( ".checkbox-event" ).on( "change", function() {
		
		var checkBoxs = $( ".checkbox-event:checked" );
		var discount = 0.0;
		$.each(checkBoxs, function(i, elt) {
			var rate = $(elt).data("rate");
			discount += parseFloat(rate);
		});
		
		$("#product-discount").val(discount.toString());
		 
	});

});//$(function()