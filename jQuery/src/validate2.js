/**
 * 
 */
$(document).ready(function() {

	$('#myform').submit(function() {

		// id 공백 검사
		const id = $('#id');
		if (id.val().trim() == "") {
			alert('id를 입력하세요');
			id.focus();
			return false;
		}

		// 비밀번호 공백 검사
		const pass = $('pass');
		if (pass.val().trim() == "") {
			alert('비밀번호를 입력하세요');
			pass.focus();
			return false;
		}

		// 주민번호 앞자리 공백 검사
		const jumin1 = $('#jumin1');
		if (jumin1.val().trim() == "") {
			alert('주민번호 앞자리를 입력하세요');
			jumin1.focus();
			return false;
		}

		// 주민번호 앞 6자리 검사
		if (jumin1.val().trim().length != 6) {
			alert('주민번호 앞 6자리를 입력하세요');
			jumin1.val('');
			jumin1.focus();
			return false;
		}

		// 주민번호 뒷자리 공백 검사
		const jumin2 = $('#jumin2');
		if (jumin2.val().trim() == "") {
			alert('주민번호 뒷자리를 입력하세요');
			jumin2.focus();
			return false;
		}

		// 주민번호 뒷 7자리 검사
		if (jumin2.val().trim().length != 7) {
			alert('주민번호 뒷 7자리를 입력하세요');
			jumin2.val('');
			jumin2.focus();
			return false;
		}

		// 이메일 아이디 공백 검사
		const email = document.getElementById('email');
		if (email.value.trim() == '') {
			alert("E-mail 아이디를 입력하세요");
			email.focus();
			return false;
		}

		// 이메일 도메인 공백 검사
		const domain = document.getElementById('domain');
		if (domain.value.trim() == '') {
			alert('E-mail 도메인을 입력하세요');
			domain.focus();
			return false;
		}

		// 라디오 버튼 선택 유효성 체크
		const genders = document.querySelectorAll("input[type=radio]:checked");
		if (genders.length == 0) {
			alert("남, 여 중 1개를 선택하세요");
			return false;
		}

		const hobbys = document.querySelectorAll("input[type=checkbox]:checked");
		const hobby_count = hobbys.length;

		if (hobby_count < 2) {
			alert('2개 이상의 취미를 선택하세요')
			return false;
		}

		// 우편번호 공백 유효성 검사
		const post1 = document.getElementById('post1');
		if (post1.value.trim() == "") {
			alert('우편번호를 입력하세요');
			post1.focus();
			return false;
		}

		// 주소 공백 유효성 검사
		const address = document.getElementById('address');
		if (address.value.trim() == "") {
			alert('주소를 입력하세요');
			address.focus();
			return false;
		}

		// 자기 소개 공백 유효성 검사
		const intro = document.getElementById('intro');
		if (intro.value.trim() == '') {
			alert('자기 소개를 입력하세요');
			intro.focus();
			return false;
		}
		
		alert(`id = ${id.val()}`);

	});



	$('input:button[value="ID중복검사"]').click(function() {
		const id_value = document.getElementById('id').value;

		const reg_id = new RegExp("^[A-Z][A-Za-z0-9_]{3,}$");

		if (id_value.trim() == "") {
			alert('ID를 입력하세요');
			document.getElementById('id').focus();
			return false;
		} else if (!reg_id.test(id_value.trim())) {
			alert('첫글자는 대문자이고 두번째부터는 대소문자, 숫자, _로 총 4개 이상이어야 합니다.');
			document.getElementById('id').value = "";
			document.getElementById('id').focus();
			return false;
		} else {
			window.open(`idcheck.html?id=${id_value.trim()}`, '_blank', 'width=300, height=250');
		}
	});

	$('input#jumin1, input#jumin2').keyup(function() {

		const jumin_front = document.getElementById('jumin1');
		const jumin_rear = document.getElementById('jumin2');
		const reg_front = new RegExp("^[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$"); // 더 간결하게
		const reg_rear = new RegExp("^[1-4][0-9]{6}$")

		if (jumin_front.value.trim().length == 6) {
			if (reg_front.test(jumin_front.value.trim())) {
				jumin_rear.focus();
			} else {
				alert('주민번호 형식에 맞게 입력하세요');
				jumin_front.value = "";
				jumin_front.focus();
			}
		}

		if (jumin_rear.value.trim().length == 7) {
			if (!reg_rear.test(jumin_rear.value.trim())) {
				alert('주민번호 형식에 맞게 입력하세요');
				jumin_rear.value = "";
				jumin_rear.focus();
			} else {
				var gender = "" + jumin_rear.value;
				gender = gender.charAt(0);
				if (gender === '1' || gender === '3') {
					document.getElementById('gender1').disabled = false;
					document.getElementById('gender1').checked = true;
					document.getElementById('gender2').disabled = true;
				} else if (gender === '2' || gender === '4') {
					document.getElementById('gender2').disabled = false;
					document.getElementById('gender2').checked = true;
					document.getElementById('gender1').disabled = true;
				}
			}
		}
		/*
		// 더 간결한 코딩.
		// const index = (c - 1) % 2; ID 값과 규칙으로 설정할 수 있다.
		if (jumin_rear.value.trim().length == 7) {
			const pattern = /^[1-4][0-9]{6}$/;
			if (pattern.test(jumin_rear.value.trim())) {
				
				const c = Number(jumin2.value.trim().substring(0,1));
				
				const index = (c - 1) % 2;  // c 가 1 또는 3이면 index = 0 => 1 => gender1
											// c 가 2 또는 4이면 index = 1 => 2 => gender2
				document.getElementById("gender" + (index+1)).checked = true;
			} else {
				alert("형식에 맞게 입력하세요");
				jumin2.value = '';
				jumin2.focus();
			}
		} else {
			document.getElementById("gender1").checked = false;
			document.getElementById("gender2").checked = false;
		}
				
		
		*/
	});

	$('#sel').change(function(){
		
		const sel = document.getElementById('sel');
		
		const domain_value = document.getElementById('domain');
		
		if (sel.value) {
			domain_value.readOnly = true;
			domain_value.value = sel.value;
		} else {
			domain_value.readOnly = false;
			domain_value.value = "";
			domain_value.focus();
		}
	});

	$('#postcode').click(function(){
		
		window.open("post.html", "", 'width=400, height=500');
		
	});






});