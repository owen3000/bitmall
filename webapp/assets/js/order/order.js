
// load
$(function(){
	
	$("#image-submit").click(function() {
		$("#form-order").submit();
	});//$("#image-submit").click
	
	// authUser 에서 - 붙은 값 가져오기
	var birth = $("#order-birth").val();
	var tel = $("#order-tel").val();
	var phone = $("#order-phone").val();
	var zipcode = $("#order-zipcode").val();
	
	// - split
	var births = birth.split("-");
	$.each(births,function(index,data){
		$("#order-birth"+(index+1)).val(data);
	});
	
	var tels = tel.split("-");
	$.each(tels,function(index,data){
		$("#order-tel"+(index+1)).val(data);
	});
	
	var phones = phone.split("-");
	$.each(phones,function(index,data){
		$("#order-phone"+(index+1)).val(data);
	});
	
	var zipcodes = zipcode.split("-");
	$.each(zipcodes,function(index,data){
		$("#order-zipcode"+(index+1)).val(data);
	});
	
	
	// update form 제출 시
	// join시 값 체크
	$("#form-order").submit(function() {

		if( $("#r-name").val() == ''){
			alert("받는분 성명이 비어있습니다.");
			$('#r-name').focus();
			event.preventDefault();
			return false;
		}
		if( $("#r-tel1").val() == ''){
			alert("전화번호가 비어있습니다.");
			$('#r-tel1').focus();
			event.preventDefault();
			return false;
		}
		if( $("#r-tel2").val() == ''){
			alert("전화번호가 비어있습니다.");
			$('#r-tel2').focus();
			event.preventDefault();
			return false;
		}
		if( $("#r-tel3").val() == ''){
			alert("전화번호가 비어있습니다.");
			$('#r-tel3').focus();
			event.preventDefault();
			return false;
		}
		if( $("#r-phone1").val() == ''){
			alert("휴대폰 번호가 비어있습니다.");
			$('#r-phone1').focus();
			event.preventDefault();
			return false;
		}
		if( $("#r-phone2").val() == ''){
			alert("휴대폰 번호가 비어있습니다.");
			$('#r-phone2').focus();
			event.preventDefault();
			return false;
		}
		if( $("#r-phone3").val() == ''){
			alert("휴대폰 번호가 비어있습니다.");
			$('#r-phone3').focus();
			event.preventDefault();
			return false;
		}
		if( $("#r-email").val() == ''){
			alert("이메일 주소가 비어있습니다.");
			$('#r-email').focus();
			event.preventDefault();
			return false;
		}
		if( $("#r-zip1").val() == ''){
			alert("우편 번호가 비어있습니다.");
			$('#r-zip1').focus();
			event.preventDefault();
			return false;
		}
		if( $("#r-zip2").val() == ''){
			alert("우편 번호가 비어있습니다.");
			$('#r-zip2').focus();
			event.preventDefault();
			return false;
		}
		if( $("#r-address").val() == ''){
			alert("배송 주소가 비어있습니다.");
			$('#r-address').focus();
			event.preventDefault();
			return false;
		}
		if( $("#r-req").val() == ''){
			alert("요구사항이 비어있습니다.");
			$('#r-req').focus();
			event.preventDefault();
			return false;
		}
		
		
		//  전화번호, 핸드폰번호, 우편번호 합치기

		var tel = $("#r-tel1").val()+'-'+
					$("#r-tel2").val()+'-'+
					$("#r-tel3").val();
		var phone = $("#r-phone1").val()+'-'+
					$("#r-phone2").val()+'-'+
					$("#r-phone3").val();	
		var zipcode = $("#r-zip1").val()+'-'+
					$("#r-zip2").val();
		
		var telReg = /^[0]{1}[0-9]{1,2}[-][0-9]{3,4}[-][0-9]{4}$/;
		if( !telReg.test(tel) ){
			alert('전화번호를 정확히 입력해주세요');
			$('#r-tel1').focus();
			event.preventDefault();
			return false;
		}
		var phoneReg = /^[0]{1}[0-9]{2}[-][0-9]{4}[-][0-9]{4}$/;
		if( !phoneReg.test(phone) ){
			alert('핸드폰 번호를 정확히 입력해주세요');
			$('#r-phone1').focus();
			event.preventDefault();
			return false;
		}
		var zipcodeReg = /^[0-9]{2,4}[-][0-9]{2,4}$/;
		if( !zipcodeReg.test(zipcode) ){
			alert('우편번호를 정확히 입력해주세요');
			$('#r-zip1').focus();
			event.preventDefault();
			return false;
		}
		var emailReg =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
		var email = $("#r-email").val();
		if( !emailReg.test(email) ){
			alert('이메일을 정확히 입력해주세요');
			$('#r-email').focus();
			event.preventDefault();
			return false;
		}		
		
		$("#rs-name").val($("#r-name").val());
		$("#rs-tel").val(tel);
		$("#rs-phone").val(phone);
		$("#rs-zipcode").val(zipcode);
		$("#rs-email").val($("#r-email").val());
		$("#rs-address").val($("#r-address").val());
		$("#rs-requirements").val($("#r-req").val());
		
	});//order-form
});//load

