<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="icon" href="${pageContext.request.contextPath}/image/house-icon.svg">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/join.css" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="${pageContext.request.contextPath}/js/jquery-3.7.1.js"></script>
<script>
	$(function(){
		let checkid = false; // 아이디 정규식 체크하기 위한 변수로 기본값 false, 규칙에 맞게 입력하면 true로
		let checkmail = false; // 이메일 정규식 체크하기 위한 변수로 기본값 false, 규칙에 맞게 입력하면 true로
		
		$('input[name=id]').on('keyup', function(){
			const pattern = /^\w{5,12}$/; // [A-Za-z0-9_] 의미가 \w
			const id = $(this).val();
			
			if(!pattern.test(id)) {
				$('#id-message').css('color', 'red').html('영문자 숫자 _ 로 5~12자 입력 가능합니다.');
				
				checkid = false;
				return;
			}
			
			$.ajax({
				url : "idcheck",
				data : {"id" : id},
				success : function(resp) {
					if (resp != '-1') { // db 에 해당 id가 없는 경우
						$('#id-message').css('color', 'green').html('사용가능한 아이디 입니다.');
						checkid = true;
					} else { // db 에 해당 id 가 있는 경우 '-1'
						$('#id-message').css('color', 'red').html('사용 중인 아이디 입니다.');
						checkid = false;
					}
				}
			});
		});
		
		$('input[name=email]').on('keyup', function(){
			// [A-Za-z0-9_] 와 동일한 것이 \w
			// +는 1회 이상 반복을 의미하고 {1,} 와 동일하다.
			// \w+ 는 [A-Za-z0-9_] 를 1개 이상 사용하라는 의미이다.
			const pattern = /^\w+@\w+[.][A-Za-z0-9]{3}$/;
			const email_value = $(this).val();
			
			if (!pattern.test(email_value)) {
				$('#email-message').css('color', 'red').html('이메일 형식이 맞지 않습니다.');
				checkemail = false;
			} else {
				$('#email-message').css('color', 'green').html('이메일 형식에 맞습니다.');
				checkemail = true;				
			}
		});
		
		$('form[action="joinProcess"]').submit(function(){
			if (!$.isNumeric($('input[name=age]').val())) {
				alert('나이는 숫자를 입력하세요');
				$('input[name="age"]').val('').focus();
				return false;
			}
			
			if (!checkid) {
				alert('사용가능한 id로 입력하세요');
				$('input[name=id]').val('').focus();
				$('#id-message').text('');
				return false;
			}
			
			if(!checkemail){
				alert('email 형식을 확인하세요');
				$('input[name=email]').focus();
				return false;
			}
		});
	});
</script>
</head>
<body>
	<form name="joinform" action="joinProcess" method="post">
		<h1>회원가입</h1>
		<hr>
		<b>아이디</b>
		<input type="text" name="id" placeholder="Enter id" maxLength="12" required>
		<span id="id-message"></span>
		
		<b>비밀번호</b>
		<input type="password" name="pass" placeholder="Enter password" required>
		
		<b>이름</b>
		<input type="text" name="name" placeholder="Enter name" maxLength="5" required>
		
		<b>나이</b>
		<input type="text" name="age" placeholder="Enter age" maxLength="2" required>
		
		<b>성별</b>
		<div>
			<input type="radio" name="gender" value="남" checked><span>남자</span>
			<input type="radio" name="gender" value="여"><span>여자</span>
		</div>
		
		<b>이메일 주소</b>
		<input type="text" name="email" placeholder="Enter email" maxLength="30" required>
		<span id="email-message"></span>
		<div class="clearfix">
			<button type="submit" class="submitbtn">회원가입</button>
			<button type="reset" class="cancelbtn">다시작성</button>
		</div>
	</form>
</body>
</html>