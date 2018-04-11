
// load
$(function(){
	
	// join시 값 체크
	$("#join-form").submit(function() {
		
		var allData = {};
		$.each($(this).serializeArray(), function(index, o) {
			allData[ o.name ] = o.value;
		});
		if( allData["id"] == ''){
			alert("이름이 비어있습니다.");
			$('#join-id').focus();
			event.preventDefault();
			return;
		}
		if( allData["password"] == ''){
			alert("비밀번호가 비어있습니다.");
			$('#join-password').focus();
			event.preventDefault();
			return;
		}
		if( allData["password2"] == ''){
			alert("비밀번호 확인이 비어있습니다.");
			$('#join-password2').focus();
			event.preventDefault();
			return;
		}
		if( allData["password2"] != allData["password"] ){
			alert("비밀번호가 같지 않습니다.");
			$('#join-password').val("");
			$('#join-password2').val("");
			$('#join-password').focus();
			event.preventDefault();
			return;
		}
		if( allData["name"] == ''){
			alert("이름이 비어있습니다.");
			$('#join-name').focus();
			event.preventDefault();
			return;
		}
		if( allData["year"] == ''){
			alert("년도가 비어있습니다.");
			$('#join-year').focus();
			event.preventDefault();
			return;
		}
		if( allData["month"] == ''){
			alert("월이 비어있습니다.");
			$('#join-month').focus();
			event.preventDefault();
			return;
		}
		if( allData["day"] == ''){
			alert("일이 비어있습니다.");
			$('#join-day').focus();
			event.preventDefault();
			return;
		}
		if( allData["tel1"] == ''){
			alert("전화 번호 입력란이 비어있습니다.");
			$('#join-tel1').focus();
			event.preventDefault();
			return;
		}
		if( allData["tel2"] == ''){
			alert("전화 번호 입력란이 비어있습니다.");
			$('#join-tel2').focus();
			event.preventDefault();
			return;
		}
		if( allData["tel3"] == ''){
			alert("전화 번호 입력란이 비어있습니다.");
			$('#join-tel3').focus();
			event.preventDefault();
			return;
		}
		if( allData["phone1"] == ''){
			alert("핸드폰 번호 입력란이 비어있습니다.");
			$('#join-phone1').focus();
			event.preventDefault();
			return;
		}
		if( allData["phone2"] == ''){
			alert("핸드폰 번호 입력란이 비어있습니다.");
			$('#join-phone2').focus();
			event.preventDefault();
			return;
		}
		if( allData["phone3"] == ''){
			alert("핸드폰 번호 입력란이 비어있습니다.");
			$('#join-phone3').focus();
			event.preventDefault();
			return;
		}
		if( allData["zip1"] == ''){
			alert("우편번호 입력란이 비어있습니다.");
			$('#join-zip1').focus();
			event.preventDefault();
			return;
		}
		if( allData["zip2"] == ''){
			alert("우편번호 입력란이 비어있습니다.");
			$('#join-zip2').focus();
			event.preventDefault();
			return;
		}
		if( allData["address"] == ''){
			alert("주소가 비어있습니다.");
			$('#join-address').focus();
			event.preventDefault();
			return;
		}
		if( allData["email"] == ''){
			alert("이메일 입력란이 비어있습니다.");
			$('#join-email').focus();
			event.preventDefault();
			return;
		}
		
		// 생년월일, 전화번호, 핸드폰번호, 우편번호 합치기
		var birth = $("#join-year").val()+'-'+
					$("#join-month").val()+'-'+
					$("#join-day").val();
		var tel = $("#join-tel1").val()+'-'+
					$("#join-tel2").val()+'-'+
					$("#join-tel3").val();
		var phone = $("#join-phone1").val()+'-'+
					$("#join-phone2").val()+'-'+
					$("#join-phone3").val();	
		var zipcode = $("#join-zip1").val()+'-'+
					$("#join-zip2").val();
		// 정규표현식 체크
		var birthReg = /^[1-2]{1}[0-9]{3}[-][0-1]{0,1}[0-9]{1}[-][0-3]{1}[0-9]{1}$/;
		if( !birthReg.test(birth) ){
			alert('생년월일을 정확히 입력해주세요');
			$('#join-year').focus();
			event.preventDefault();
			return;
		}
		var telReg = /^[0]{1}[0-9]{1,2}[-][0-9]{3,4}[-][0-9]{4}$/;
		if( !telReg.test(tel) ){
			alert('전화번호를 정확히 입력해주세요');
			$('#join-tel1').focus();
			event.preventDefault();
			return;
		}
		var phoneReg = /^[0]{1}[0-9]{2}[-][0-9]{4}[-][0-9]{4}$/;
		if( !phoneReg.test(phone) ){
			alert('핸드폰 번호를 정확히 입력해주세요');
			$('#join-phone1').focus();
			event.preventDefault();
			return;
		}
		var zipcodeReg = /^[0-9]{2,4}[-][0-9]{2,4}$/;
		if( !zipcodeReg.test(zipcode) ){
			alert('핸드폰 번호를 정확히 입력해주세요');
			$('#join-zip1').focus();
			event.preventDefault();
			return;
		}
		var emailReg =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
		var email = $("#join-email").val();
		if( !emailReg.test(email) ){
			alert('이메일을 정확히 입력해주세요');
			$('#join-email').focus();
			event.preventDefault();
			return;
		}		
		
		$("#join-birth").val(birth);
		$("#join-tel").val(tel);
		$("#join-phone").val(phone);
		$("#join-zipcode").val(zipcode);
		
	});//join-form
	
	
	//ajax로 중복 아이디 체크
	$("#join-id").keyup(function() {
		
		var id = $(this).val();

		$.ajax({
			url: "/bitmall/api/user/checkId?id="+id,
			type:'get',
			dataType:'json',
			success: function(response){
				console.log(response);
				if( response.result == "fail" ){
					console.log(response.message);
					$("#img-checkid").hide();
					return;
				}
				
				if( response.data == "exist" ){
					$("#img-checkid").hide();
					return;
				}
				if( response.data == "none" ){
					$("#img-checkid").show();
					return;
				}
				return;
			}
		});//$.ajax
		
	});//$("#join-id").keyup
	
	// Reset join form 
	$("#join-reset").click(function() {
		document.getElementById("join-form").reset();
		
	});//$("#join-reset").click
	
});

