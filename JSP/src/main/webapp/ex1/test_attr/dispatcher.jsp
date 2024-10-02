<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table {border-collapse:collapse; width:50%; margin:0 auto} 
	tr {border-bottom:1px solid black; height:3em;} 
	th {width:30%}
	td {width:60%}
</style>
<title>결과화면</title>
</head>
<body>
	<table>
		<tr><th>아이디</th><td><%=request.getAttribute("id") %></td>
		<tr><th>비밀번호</th><td><%=request.getAttribute("pass") %></td>
		<tr><th>주민번호</th><td><%=request.getAttribute("jumin1") %>-<%=request.getAttribute("jumin2") %></td>
		<tr><th>이메일</th><td><%=request.getAttribute("email") %>@<%=request.getAttribute("domain") %></td>
		<tr><th>성별</th><td><%=request.getAttribute("gender") %></td>
		<tr><th>취미</th><td><%=request.getAttribute("hobbys") %></td>
		<tr><th>우편번호</th><td><%=request.getAttribute("post1") %></td>
		<tr><th>주소</th><td><%=request.getAttribute("address") %></td>
		<tr><th>자기소개</th><td><%=request.getAttribute("intro") %></td>
	</table>
</body>
</html>