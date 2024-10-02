<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect.jsp</title>
<style>
	body {background:skyblue;}
	div {color:white;}
	p {color:green;}
</style>
</head>
<body>
	<!-- redirect 는 넘긴 서블릿 클래스의 request 객체에 접근할 수 없다. -->
	<%-- jsp 에서 <%=값 또는 수식 또는 변수 %> 는 '값 또는 수식 또는 변수' 를 출력하라는 의미이다. --%> 
	<!-- request 파라미터 값 : null <- 넘겨 받은 값이 없으면 null
		 보여주는 페이지 주소 : http://localhost:8088/JSP/ex1/_6.redirect/redirect.jsp
		 	=> 자신의 디렉토리에서 발생한 requestURL 반환 -->
	<div>
		request 파라미터 값 : <%=request.getParameter("food") %>
	</div>
	<p>
		보여주는 페이지 주소 : <%=request.getRequestURL() %>
	</p>
</body>
</html>