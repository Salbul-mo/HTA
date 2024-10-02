<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dispatcher.jsp</title>
<style>
	body {background:pink;}
	
	div {color:red;}
	
	p {color:green;}
</style>
</head>
<body>
	<!-- dispatch 를 통해 전달 받은 request 객체의 getParameter() 메서드를 이용해서 파라미터 "food" 의 값을 가져온다. -->
	<%-- jsp 에서 <%=값 또는 수식 또는 변수 %> 는 '값 또는 수식 또는 변수' 를 출력하라는 의미이다. --%> 
	<!-- dispatcher.jsp 그냥 실행 
		 request 파라미터 값 : null <- 넘겨 받은 값이 없으면 null
		 보여주는 페이지 주소 : http://localhost:8088/JSP/ex1/_5.dispatcher/dispatcher.jsp -->
	<div>
		request 파라미터 값 : <%=request.getParameter("food") %>
	</div>
	<p>
		보여주는 페이지 주소 : <%=request.getRequestURL() %>
	</p>
</body>
</html>