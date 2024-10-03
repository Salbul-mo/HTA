<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link href="../../css/ch03-1.css" type="text/css" rel="stylesheet">
</head>
<body>
	<form action="login_ok" method="post">
		<b>아이디 :</b>
		<input type="text" name="id">
		<b>비밀번호 :</b>
		<input type="text" name="passwd"><br>
		<div class="clearfix">
		<button type="submit" class="submitbtn">전송</button>
		<button type="reset" class="cancelbtn">취소</button>
		</div>
	</form>
</body>
</html>