
// load
$(function(){
	
	// authUser 에서 - 붙은 값 가져오기
	var birth = $("#modify-birth").val();
	var tel = $("#modify-tel").val();
	var phone = $("#modify-phone").val();
	var zipcode = $("#modify-zipcode").val();
	
	// - split
	var births = birth.split("-");
	$.each(births,function(index,data){
		$("#modify-birth"+(index+1)).val(data);
	});
	
	var tels = tel.split("-");
	$.each(tels,function(index,data){
		$("#modify-tel"+(index+1)).val(data);
	});
	
	var phones = phone.split("-");
	$.each(phones,function(index,data){
		$("#modify-phone"+(index+1)).val(data);
	});
	
	var zipcodes = zipcode.split("-");
	$.each(zipcodes,function(index,data){
		$("#modify-zip"+(index+1)).val(data);
	});
	
	
	// update form 제출 시
	// join시 값 체크
	$("#modify-form").submit(function() {
		var allData = {};
		$.each($(this).serializeArray(), function(index, o) {
			allData[ o.name ] = o.value;
		});
		if( allData["id"] == ''){
			alert("이름이 비어있습니다.");
			$('#modify-id').focus();
			event.preventDefault();
			return;
		}
		if( allData["password"] == ''){
			alert("비밀번호가 비어있습니다.");
			$('#modify-password1').focus();
			event.preventDefault();
			return;
		}
		if( allData["password2"] == ''){
			alert("비밀번호 확인이 비어있습니다.");
			$('#modify-password2').focus();
			event.preventDefault();
			return;
		}
		if( allData["password2"] != allData["password"] ){
			alert("비밀번호가 같지 않습니다.");
			$('#modify-password1').val("");
			$('#modify-password2').val("");
			$('#modify-password1').focus();
			event.preventDefault();
			return;
		}
		if( allData["name"] == ''){
			alert("이름이 비어있습니다.");
			$('#modify-name').focus();
			event.preventDefault();
			return;
		}
		if( allData["birth1"] == ''){
			alert("년도가 비어있습니다.");
			$('#modify-year').focus();
			event.preventDefault();
			return;
		}
		if( allData["birth2"] == ''){
			alert("월이 비어있습니다.");
			$('#modify-month').focus();
			event.preventDefault();
			return;
		}
		if( allData["birth3"] == ''){
			alert("일이 비어있습니다.");
			$('#modify-day').focus();
			event.preventDefault();
			return;
		}
		if( allData["tel1"] == ''){
			alert("전화 번호 입력란이 비어있습니다.");
			$('#modify-tel1').focus();
			event.preventDefault();
			return;
		}
		if( allData["tel2"] == ''){
			alert("전화 번호 입력란이 비어있습니다.");
			$('#modify-tel2').focus();
			event.preventDefault();
			return;
		}
		if( allData["tel3"] == ''){
			alert("전화 번호 입력란이 비어있습니다.");
			$('#modify-tel3').focus();
			event.preventDefault();
			return;
		}
		if( allData["phone1"] == ''){
			alert("핸드폰 번호 입력란이 비어있습니다.");
			$('#modify-phone1').focus();
			event.preventDefault();
			return;
		}
		if( allData["phone2"] == ''){
			alert("핸드폰 번호 입력란이 비어있습니다.");
			$('#modify-phone2').focus();
			event.preventDefault();
			return;
		}
		if( allData["phone3"] == ''){
			alert("핸드폰 번호 입력란이 비어있습니다.");
			$('#modify-phone3').focus();
			event.preventDefault();
			return;
		}
		if( allData["zip1"] == ''){
			alert("우편번호 입력란이 비어있습니다.");
			$('#modify-zip1').focus();
			event.preventDefault();
			return;
		}
		if( allData["zip2"] == ''){
			alert("우편번호 입력란이 비어있습니다.");
			$('#modify-zip2').focus();
			event.preventDefault();
			return;
		}
		if( allData["address"] == ''){
			alert("주소가 비어있습니다.");
			$('#modify-address').focus();
			event.preventDefault();
			return;
		}
		if( allData["email"] == ''){
			alert("이메일 입력란이 비어있습니다.");
			$('#modify-email').focus();
			event.preventDefault();
			return;
		}
		
		// 생년월일, 전화번호, 핸드폰번호, 우편번호 합치기
		var birth = $("#modify-birth1").val()+'-'+
					$("#modify-birth2").val()+'-'+
					$("#modify-birth3").val();
		var tel = $("#modify-tel1").val()+'-'+
					$("#modify-tel2").val()+'-'+
					$("#modify-tel3").val();
		var phone = $("#modify-phone1").val()+'-'+
					$("#modify-phone2").val()+'-'+
					$("#modify-phone3").val();	
		var zipcode = $("#modify-zip1").val()+'-'+
					$("#modify-zip2").val();
		// 정규표현식 체크
		var birthReg = /^[1-2]{1}[0-9]{3}[-][0-1]{0,1}[0-9]{1}[-][0-3]{1}[0-9]{1}$/;
		if( !birthReg.test(birth) ){
			alert('생년월일을 정확히 입력해주세요'+birth);
			$('#modify-birth1').focus();
			event.preventDefault();
			return;
		}
		var telReg = /^[0]{1}[0-9]{1,2}[-][0-9]{3,4}[-][0-9]{4}$/;
		if( !telReg.test(tel) ){
			alert('전화번호를 정확히 입력해주세요');
			$('#modify-tel1').focus();
			event.preventDefault();
			return;
		}
		var phoneReg = /^[0]{1}[0-9]{2}[-][0-9]{4}[-][0-9]{4}$/;
		if( !phoneReg.test(phone) ){
			alert('핸드폰 번호를 정확히 입력해주세요');
			$('#modify-phone1').focus();
			event.preventDefault();
			return;
		}
		var zipcodeReg = /^[0-9]{2,4}[-][0-9]{2,4}$/;
		if( !zipcodeReg.test(zipcode) ){
			alert('우편번호를 정확히 입력해주세요');
			$('#modify-zip1').focus();
			event.preventDefault();
			return;
		}
		var emailReg =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
		var email = $("#modify-email").val();
		if( !emailReg.test(email) ){
			alert('이메일을 정확히 입력해주세요');
			$('#modify-email').focus();
			event.preventDefault();
			return;
		}		
		
		$("#modify-birth").val(birth);
		$("#modify-tel").val(tel);
		$("#modify-phone").val(phone);
		$("#modify-zipcode").val(zipcode);
		
	});//join-form
});//load

