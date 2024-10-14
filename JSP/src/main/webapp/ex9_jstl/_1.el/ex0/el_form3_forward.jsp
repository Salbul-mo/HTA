<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("id", "pageContext");
	request.setAttribute("id", "request");
	session.setAttribute("id", "session");
	application.setAttribute("id", "application");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>EL 내장객체 사용 예제</title>
<style>
	.container {
		width:500px;
	}
</style>
</head>
<body>
	<div class="container mt-5">
		<jsp:forward page="el_result1.jsp"/>
	</div>
</body>
<!--
dispatch 처럼 request 를 넘기는 <jsp:forward> 는 request 객체가 유지된다. 
page영역의 속성 id의 값 :
request영역의 속성 id의 값 : request
session영역의 속성 id의 값 : session
application영역의 속성 id의 값 : application
page -> request -> session -> application 영역에서 속성 id 의 값을 찾는다. : request 
-->
</html>