/**
 * 
 */
$(document).ready(function() {
	
	// submit 클릭 시 양식 검사하고 넘길 데이터 취합
	$('#myform').submit(function() {

		// id 공백 검사
		const id = $('#id');
		if (id.val().trim() == "") {
			alert('id를 입력하세요');
			id.focus();
			return false;
		}

		// 비밀번호 공백 검사
		const pass = $('#pass');
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
		
		if (!$.isNumeric(jumin1.val().trim())){
			// isNaN 은 숫자형이면 false, 숫자형이 아니면 true
			// isNumeric 은 숫자형이면 true, 숫자형이 아니면 false 
			alert("주민번호 앞자리 6자리는 숫자만 입력 가능합니다.");
			jumin1.val('').focus();
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
		
		if (!$.isNumeric(jumin2.val().trim())){
			// isNaN 은 숫자형이면 false, 숫자형이 아니면 true
			// isNumeric 은 숫자형이면 true, 숫자형이 아니면 false 
			alert("주민번호 뒷 7자리는 숫자만 입력 가능합니다.");
			jumin2.val('').focus();
			return false;
		}

		// 이메일 아이디 공백 검사
		const email = $('#email');
		if (email.val().trim() == '') {
			alert("E-mail 아이디를 입력하세요");
			email.focus();
			return false;
		}

		// 이메일 도메인 공백 검사
		const domain = $('#domain');
		if (domain.val().trim() == '') {
			alert('E-mail 도메인을 입력하세요');
			domain.focus();
			return false;
		}

		// 라디오 버튼 선택 유효성 체크
		const genders = $("input:radio:checked");
		if (genders.length == 0) {
			alert("남, 여 중 1개를 선택하세요");
			return false;
		}
		
		// 취미 체크 갯수 검사
		const hobbys = $("input:checkbox:checked");
		if (hobbys.length < 2) {
			alert('2개 이상의 취미를 선택하세요')
			return false;
		}

		// 우편번호 공백 유효성 검사
		const post1 = $('#post1');
		if (post1.val().trim() == "") {
			alert('우편번호를 입력하세요');
			post1.focus();
			return false;
		}
		
		if (!$.isNumeric(post1.val())) {
			alert('우편번호는 숫자만 입력 가능 합니다.');
			post1.val('').focus();
			return false;
		}

		// 주소 공백 유효성 검사
		const address = $('#address');
		if (address.val().trim() == "") {
			alert('주소를 입력하세요');
			address.focus();
			return false;
		}

		// 자기 소개 공백 유효성 검사
		const intro = $('#intro');
		if (intro.val().trim() == '') {
			alert('자기 소개를 입력하세요');
			intro.focus();
			return false;
		}
	});

	// Id 중복검사 및 양식 검사
	$('#myform > fieldset > div:nth-child(3) > input[type=button]:nth-child(2)').click(function() {
		// #myform > fieldset > div:nth-child(3) > input[type=button]:nth-child(2) f12 ctrl shift c 누르고 
		// 해당 태그에 마우스 오른쪽 클릭하여 copy > copy selector 하면 선택자를 복사할 수 있다.
		const id_value = $('#id').val();

		const reg_id = new RegExp("^[A-Z][A-Za-z0-9_]{3,}$");

		if (id_value.trim() == "") {
			alert('ID를 입력하세요');
			$('#id').focus();
			return false;
		} else if (!reg_id.test(id_value.trim())) {
			alert('첫글자는 대문자이고 두번째부터는 대소문자, 숫자, _로 총 4개 이상이어야 합니다.');
			$('#id').val('').focus();
			return false;
		} else {
			window.open(`idcheck.html?id=${id_value.trim()}`, '_blank', 'width=300, height=250');
		}
	});
	
	// 성별 임의로 선택하지 못하게 막는다.
	$('input[name="gender"]').click(function(){
		return false;
	});
	
	// 주민번호 유효성 검사 및 성별 체크박스 자동 체크
	$('input#jumin1, input#jumin2').keyup(function() {

		const jumin1 = $('#jumin1');
		const jumin2 = $('#jumin2');
		const reg_front = new RegExp("^[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$");
		const reg_rear = new RegExp("^[1-4][0-9]{6}$")

		if (jumin1.val().trim().length == 6) {
			if (reg_front.test(jumin1.val().trim())) {
				jumin2.focus();
			} else {
				alert('주민번호 형식에 맞게 입력하세요');
				jumin1.val('').focus();
			}
		}

		if (jumin2.val().trim().length == 7) {

			if (reg_rear.test(jumin2.val().trim())) {

				const c = Number(jumin2.val().trim().substring(0, 1));

				const index = (c - 1) % 2;  // c 가 1 또는 3이면 index = 0 => 1 => gender1
				// c 가 2 또는 4이면 index = 1 => 2 => gender2
				$(`#gender${(index + 1)}`).prop('checked', true);
				//$('input[name=gender]').eq(index).prop('checked',true); 남자 0 , 여자 1
			} else {
				alert("형식에 맞게 입력하세요");
				jumin2.val('').focus();
			}
		} else {
			$("#gender1, #gender2").prop('checked', false);
		}
	});

	// 이메일 도메인 주소 입력창 
	$('#sel').change(function() {

		const sel = $('#sel');

		const domain = $('#domain');

		if (sel.val()) {
			domain.prop('readOnly', true);
			domain.val(sel.val());
		} else {
			domain.prop('readOnly', false);
			domain.val('');
			domain.focus();
		}
	});
	
	// 우편 번호 검색창
	$('#postcode').click(function() {

		window.open("post.html", "post", 'width=400, height=500');

	});
});