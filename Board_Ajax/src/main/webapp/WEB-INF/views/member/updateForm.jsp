<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"/>
<meta charset="UTF-8">
<title>회원 정보 수정 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/join.css" type="text/css">
<script>
	$(function(){
		let checkmail = true; // 이메일 정규식 체크하기 위한 변수로 기본값 false, 규칙에 맞게 입력하면 true로
		
		$('input:radio').click(function(){
			return false;
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
		
		$('form[action="updateProcess"]').submit(function(){
			if (!$.isNumeric($('input[name=age]').val())) {
				alert('나이는 숫자를 입력하세요');
				$('input[name="age"]').val('').focus();
				return false;
			}
			
			if(!checkemail){
				alert('email 형식을 확인하세요');
				$('input[name=email]').focus();
				return false;
			}
		});
		
		$('input:file').change(function(e){
			const file = e.target.files[0]; // 이벤트 발생 객체에서 가져올 수도 있다.
			
			const maxSizeInBytes = 5 * 1024 * 1024; 
			if (file.size > maxSizeInBytes) {
				alert("5MB 이하 크기로 업로드 하세요");
				$(this).val('');
				return;
			}
			const pattern = /(gif|jpg|jpeg|png)$/i; // i(ignore case) 는 대소문자를 무시한다.
			if (pattern.test(file.name)) {
				$('#filename').text(file.name);
				
				// createObjectURL() 을 통해 파일을 서버에 업로드하지 않고도 브라우저에서 미리보기를 할 수 있다.
				const fileURL = URL.createObjectURL(file);
				$('#showImage > img').attr('src', fileURL);
				
			} else {
				alert('이미지 파일(gif,jpg,jpeg,png)이 아닌 경우는 무시됩니다.');
				$('#filename').text('');
				$('#showImage > img').attr('src', '../image/profile.png');
				$(this).val('');
				$('input[name=check]').val('');
			}
		});
	});
</script>
<style>
	h3 {
		text-align: center;
		color: #1a92b9;
	}
	
	input[type=file] {
		display: none;
	}
</style>
</head>
<body>
	<form name="updateform" action="updateProcess" method="post" enctype="multipart/form-data">
		<h3>회원 정보 수정</h3>
		<hr>
		<b>아이디</b>
		<input type="text" name="id" value="${mem.id}" readOnly>
		
		<b>비밀번호</b>
		<input type="password" name="pass" value="${mem.password}" readOnly>
		
		<b>이름</b>
		<input type="text" name="name" value="${mem.name}" maxLength="5" required>
		
		<b>나이</b>
		<input type="text" name="age" value="${mem.age}" maxLength="2" required>
		
		<b>성별</b>
		<c:choose>
			<c:when test="${mem.gender == '남'}">
		<div>
			<input type="radio" name="gender" value="남" checked><span>남자</span>
			<input type="radio" name="gender" value="여"><span>여자</span>
		</div>
		</c:when>
		<c:otherwise>
		<div>
			<input type="radio" name="gender" value="남"><span>남자</span>
			<input type="radio" name="gender" value="여" checked><span>여자</span>
		</div>
		</c:otherwise>
		</c:choose>
		
		<b>이메일 주소</b>
		<input type="text" name="email" value="${mem.email}" maxLength="30" required>
		<span id="email-message"></span>
		
		<b>프로필 사진</b>
		<label>
		<img class="m-auto" src="${pageContext.request.contextPath}/image/file.png" width="20px">
		
		<span id="showImage">
		  <c:if test='${empty mem.memberfile}'>
			<c:set var='src' value="image/profile.png"/>
		  </c:if>
		  <c:if test="${!empty mem.memberfile}">
		    <c:set var='src' value='${"memberupload/"}${mem.memberfile}'/>
		    <input type="hidden" name="check" value='${mem.memberfile}'> 
		    <%-- 파일 있는데 바꾼 경우 체크 --%>
		  </c:if>
		  <img class="m-auto"src="${pageContext.request.contextPath}/${src}" width="40px" alt="profile">
		<span id="filename">${mem.memberfile}</span>
		</span>
		<%--
			accept: 업로드할 파일 타입을 설정한다.
			<input type="file" accept="파일 확장자 | audio/* | video/* | image.*">
				(1) 파일 확장자는 .png .jpg .pdf .hwp 처럼 (.) 로 시작하는 파일 확장자를 의미한다.
					예) accept=".png, .jpg, .pdf, .hwp"
					
				(2) audio/* : 모든 타입의 오디오 파일
				(3) image/* : 모든 타입의 이미지 파일
		 --%>
		  <input type="file" name="memberfile" accept="image/*">
		</label>
		<div class="clearfix">
			<button type="submit" class="submitbtn">수정하기</button>
			<button type="reset" class="cancelbtn" onclick="history.go(-1)">취소</button>
		</div>
	</form>
</body>
</html>