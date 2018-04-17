
//load 
$(function(){
	
	// 검색시  nowPage 초기화 
	$( "#jumun-search" ).submit(function() {
		$("#nowPage").val("1");
		
	});//$( "#.product-search" ).submit
	
	// state selected 설정
	$(".select-state option").each(function(){
		var data = $(".select-state").data("state");
		if( data == $(this).text() ){
			$(this).attr('selected', true);
		}
	    
	});
	
	// authUser 에서 - 붙은 값 가져오기
	var day1 = $("#day1_y").data("day1");
	var day2 = $("#day2_y").data("day2");
	if( day1 == ""){
		$("#day1_y").val("2000");
		$("#day2_y").val("2018");
	}else{
		// - split
		var day1s = day1.split("-");
		$("#day1_y").val(day1s[0]);
		$("#day1_m option[value="+day1s[1]+"]").attr('selected', true);
		$("#day1_d option[value="+day1s[2]+"]").attr('selected', true);

		var day2s = day2.split("-");
		$("#day2_y").val(day2s[0]);
		$("#day2_m option[value="+day2s[1]+"]").attr('selected', true);
		$("#day2_d option[value="+day2s[2]+"]").attr('selected', true);
	}

	
	/*$(".modify-state").click(function() {

		var state = $(".select-state option:selected").text();
		alert(state);
		
	});//$(".modify-state").click
*/	
	
	// 주문 검색
	$("#jumun-search").submit(function() {
	
		// 일자 체크 
		var day1 = $("#day1_y").val()+'-'+
					$("#day1_m").val()+'-'+
					$("#day1_d").val();
		var day2 = $("#day2_y").val()+'-'+
					$("#day2_m").val()+'-'+
					$("#day2_d").val();
		console.log(day1);
		console.log(day2);
		
		// 정규표현식 체크
		var dayReg = /^[1-2]{1}[0-9]{3}[-][0-1]{0,1}[0-9]{1}[-][0-3]{1}[0-9]{1}$/;
		if( !dayReg.test(day1) ){
			alert('일자를 정확히 입력해주세요');
			$('#day1_y').focus();
			event.preventDefault();
			return false;
		}
		
		if( !dayReg.test(day2) ){
			alert('일자를 정확히 입력해주세요');
			$('#day2_y').focus();
			event.preventDefault();
			return false;
		}
		
		$("#day1").val(day1);
		$("#day2").val(day2);
		
	});//$("#jumun-search").submit
	
	
});//$(function()