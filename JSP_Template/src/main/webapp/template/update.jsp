<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
  <body>
  	<nav>
		<jsp:include page="top.jsp"/><br><br>
	</nav>
	<div class='container'>
		<form name="myform" method="post" action="updateProcess.net" id='myform' >
			<fieldset>
				<legend>회원 정보 수정</legend>
			<div class="form-group">
				<label for='id'>ID</label>
				<div>
					<input class="form-control" type='text' placeholder='Enter id' name='id' id='id' readOnly value="${temp.id}" 
																						style="background:#ccc; width:100%">
				</div>
				<label for='pass'>Password</label>
				<input class="form-control" type='text' placeholder='Enter Password' name='pass' id='pass' value="${temp.password}">
			</div>
				
			<div class="form-group">
				<label for='jumin1'>주민번호</label>
			<div class="container row">
				<input class="form-control col" type='text' placeholder='주민번호 앞자리' maxLength='6'
						name='jumin1' id='jumin1' value="${temp.jumin.substring(0,6)}">
					<span> - </span>
				<input class="form-control col" type='text' placeholder='주민번호 뒷자리' maxLength='7'
						name='jumin2' id='jumin2' value="${temp.jumin.substring(7)}">
				</div>
			</div>								
				
			<div class="form-group">
				<label for='email'>E-Mail</label>
			<div class="container row">
				<input class="form-control col" type='text' name='email' id='email' value="${temp.email.substring(0,temp.email.indexOf('@'))}"> @
				<input class="form-control col-4" type='text' name='domain' id='domain' value="${temp.email.substring(temp.email.indexOf('@')+1)}">
		<%--	
				<input type='text' name='email' id='email' value="${temp.email.split('@')[0]}"> @
				<input type='text' name='domain' id='domain'value="${temp.email.split('@')[1]}"> 
		--%>
				<select name='sel' id='sel'>
					<option value="">직접입력</option>
					<option value="naver.com">naver.com</option>
					<option value='daum.net'>daum.net</option>
					<option value='nate.com'>nate.com</option>
					<option value='gmail.com'>gmail.com</option>
				</select>
			</div>
			</div>
			
				<label>성별</label>
				<div class='container2'> <!-- 외부에서 체크할 수 없도록 하는 onclick="return false" -->
				<c:choose>
				<c:when test="${temp.gender == 'm'}">
					<input type='radio' name='gender' value='m' id='gender1' checked>남자
					<input type='radio' name='gender' value='f' id='gender2'>여자
				</c:when>
				<c:otherwise>
					<input type='radio' name='gender' value='m' id='gender1'>남자
					<input type='radio' name='gender' value='f' id='gender2' checked>여자
				</c:otherwise>
				</c:choose>
				</div>			
				
				<label>취미</label>
				<div class='container2'>
					<c:if test="${temp.hobby.indexOf('공부') != -1}">
						<input type='checkbox' name='hobby' id='hobby1' value='공부' checked>공부
					</c:if>
						<input type='checkbox' name='hobby' id='hobby1' value='공부'>공부
					<c:if test="${temp.hobby.indexOf('게임') != -1}">
						<input type='checkbox' name='hobby' id='hobby2' value='게임' checked>게임
					</c:if>
						<input type='checkbox' name='hobby' id='hobby2' value='게임'>게임
					<c:if test="${temp.hobby.indexOf('운동') != -1}">
						<input type='checkbox' name='hobby' id='hobby3' value='운동' checked>운동
					</c:if>
						<input type='checkbox' name='hobby' id='hobby3' value='운동'>운동
					<c:if test="${temp.hobby.indexOf('등산') != -1}">
						<input type='checkbox' name='hobby' id='hobby4' value='등산' checked>등산
					</c:if>
						<input type='checkbox' name='hobby' id='hobby4' value='등산'>등산
					<c:if test="${temp.hobby.indexOf('낚시') != -1}">
						<input type='checkbox' name='hobby' id='hobby5' value='낚시' checked>낚시
					</c:if>
						<input type='checkbox' name='hobby' id='hobby5' value='낚시'>낚시
				</div>
				<label for='post1'>우편번호</label>
				<input type='text' size='5' maxLength='5' name='post1' id='post1' value="${temp.post}" readOnly>
				<input type='button' value='우편검색' id="postcode">
				
				<label for='address'>주소</label>
				<input type='text' size='50' name='address' id='address' value="${temp.address}" readOnly>
				
				<label for='intro'>자기소개</label>
				<textarea rows='10' name='intro' id='intro' maxLength="100" >${temp.intro}</textarea>
				
				<div class='clearfix'>
					<button type='submit' class='signupbtn'>수정하기</button>
				</div>
			</fieldset>
			<a href="templatetest.net">templatetest.jsp 이동하기</a>
			<a href="javascript:history.back();">이전페이지로 이동하기</a>	
		</form>
	</div>
	<%-- 
	<script>
		const gender = '${temp.gender}';
		$("input[value=" + gender + "]").prop("checked", true); // 성별 체크
		
		const hobbys = '${temp.hobby}'.split(','); // 배열로 변수 선언. 배열 항목 마다 함수 실행.
		hobbys.forEach(hobby => $("input[value=" + hobby + "]").prop("checked", true));		
	</script>
	--%>
  </body>
</html>