function check() {
	var inputs = document.querySelectorAll('input');
	/*
	0 아이디
	2 비밀번호
	3 주민 앞
	4 주민 뒤
	5 이메일 앞
	6 이메일 도메인
	7,8 성별
	9 10 11 12 13 취미
	14 우편번호
	16 주소
	*/
	var hobby = 0;
	var cnts = [0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16];
	for (var cnt = 0; cnt < cnts.length; cnt++) {
		var check = inputs[cnts[cnt]].value;
		if (check.trim() == "") {
			alert('항목을 모두 입력하세요');
			inputs[cnts[cnt]].focus();
			return false;
		} else if (!inputs[7].checked && !inputs[8].checked) {
			alert('성별을 선택하세요');
			return false;
		} else if (9 <= cnt <= 13 && inputs[cnts[cnt]].checked == true)
			hobby++;
	}


	if (hobby <= 1) {
		alert('취미는 반드시 2개 이상 체크하세요');
		return false;
	}

	return true;
}

function idcheck() {
	// id 있는지 체크, 입력하세요 메시지 출력 너비300 높이250 팝업창 띄우기
	// id 페이지는 idcheck.html 이며 주소창에 id 를 입력한 값이 표시되도록 한다

	var id = document.querySelector('#id');

	if (id.value != '')
		window.open(`idcheck.html?id=${id.value}`);
	else
		alert('ID 를 입력하세요');
}
