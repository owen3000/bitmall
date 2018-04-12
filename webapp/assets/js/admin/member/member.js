
//load 
$(function(){
	
	// delete ajax
	$(".member-delete").click(function() {
		var element = $(".member-delete").index(this);
		var no = $(this).data("no");
		var arrData = {
				'no': no
		}
		$.ajax({
			type:"post",
			url:"/bitmall/api/admin/member/delete",
			contentType:"application/json",
			dataType:"json",
			data: JSON.stringify(arrData),
			success: function(response){
				
				if( response.result == "fail" ){
					console.log(response.message);
					return;
				}
				
				if( response.data == "fail" ){
					console.log("response.data == fail");
					return;
				}
				
				if( response.data == "success" ){
					console.log("success");
					$(".member-delete:eq("+element+")").parent().parent().remove();
					var totalCount = $("#member-totalCount").text();
					$("#member-totalCount").text(totalCount-1);
					return;
				}
			}
			
		});//$.ajax
		
	});//$("#member-delete").click
	
});//$(function()