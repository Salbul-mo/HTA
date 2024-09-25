/**
 * 
 */
function check() {
	// id 공백 검사
	const id = document.getElementById('id');
	if (id.value.trim() == "") {
		alert('id를 입력하세요');
		id.focus();
		return false;
	}

	// 비밀번호 공백 검사
	const pass = document.getElementById('pass');
	if (pass.value.trim() == "") {
		alert('비밀번호를 입력하세요');
		pass.focus();
		return false;
	}

	// 주민번호 앞자리 공백 검사
	const jumin1 = document.getElementById('jumin1');
	if (jumin1.value.trim() == "") {
		alert('주민번호 앞자리를 입력하세요');
		jumin1.focus();
		return false;
	}

	// 주민번호 앞 6자리 검사
	if (jumin1.value.trim().length != 6) {
		alert('주민번호 앞 6자리를 입력하세요');
		jumin1.value = "";
		jumin1.focus();
		return false;
	}

	// 주민번호 뒷자리 공백 검사
	const jumin2 = document.getElementById('jumin2');
	if (jumin2.value.trim() == "") {
		alert('주민번호 뒷자리를 입력하세요');
		jumin2.focus();
		return false;
	}

	// 주민번호 뒷 7자리 검사
	if (jumin2.value.trim().length != 7) {
		alert('주민번호 뒷 7자리를 입력하세요');
		jumin2.value = "";
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
	const gender1 = document.getElementById('gender1');
	const gender2 = document.getElementById('gender2');
	if (gender1.checked == false && gender2.checked == false) {
		alert("남, 여 중 1개를 선택하세요");
		return false;
	}

	let cnt = 0;
	const hobbys = document.getElementsByName('hobby');
	for (var i = 0; i < hobbys.length; i++) {
		if (hobbys[i].checked)
			cnt++;
	}
	if (cnt < 2) {
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

}

function idcheck() {
	const id_value = document.getElementById('id').value;
	
	if(id_value.trim() == ""){
		alert('ID를 입력하세요');
		return false;
	} else {
		// ID 입력한 경우
		// 사용자가 입력한 방식을 get 방식으로 넘긴다.
		// var ref = `idcheck.html?id=${id.value}`;
		// window.open(ref, "", "width=300, heigtht=250")
		window.open(`idcheck.html?id=${id_value.trim()}`,'_blank', 'width=300, height=250');
	}
}

function move() {
	// 주민번호 앞자리는 6자리 숫자이면 뒷자리로 포커스 옮기고
	// 앞자리 6자리 중 숫자가 아닌 경우 숫자를 입력하세요 메시지 출력과 앞자리에 포커스
	// 뒷자리 7자리 중 숫자가 아닌 경우 숫자를 입력하세요 메시지 출력,뒷자리에 포커스 위치
	const jumin_front = document.getElementById('jumin1');
	const jumin_rear = document.getElementById('jumin2');
	const reg_front = new RegExp("^[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])$");
	const reg_rear = new RegExp("^[0-9]{7}$")
	
	// 앞자리가 6자리가 되면 검사 시작
	if (jumin_front.value.trim().length == 6) {
		if (reg_front.test(jumin_front.value.trim())) {
			jumin_rear.focus();
		} else {
		alert('주민번호 형식에 맞게 입력하세요');
		jumin_front.value="";
		jumin_front.focus();
		}
	} 
	
	// 뒷자리가 7자리가 되면 검사 시작
	if(jumin_rear.value.trim().length == 7) {
		if(!reg_rear.test(jumin_rear.value.trim())) {
			alert('주민번호 형식에 맞게 입력하세요');
			jumin_rear.value="";
			jumin_rear.focus();
		} else {
			var gender = "" + jumin_rear.value;
			gender = gender.charAt(0);
			if (gender === '1' || gender ==='3') {
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
} 
	
function domain1() {
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
}

function post() {
	window.open("post.html","",'width=400, height=500');
}
	
	
	


