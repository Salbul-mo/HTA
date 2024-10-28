<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table table-bordered text-center">
			<tr>
				<th>아이디</th>
				<td>${m.id}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${m.name}</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>${m.age}</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>${m.gender}</td>
			</tr>
			<tr>
				<th>이메일 주소</th>
				<td>${m.email}</td>
			</tr>
			<tr>
				<td colspan="2"><a href="javascript:window.history.back();" >리스트로 돌아가기</a></td>
			</tr>
		</table>
	</div>
</body>
</html>