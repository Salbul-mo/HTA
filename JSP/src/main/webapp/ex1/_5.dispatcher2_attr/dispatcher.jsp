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
	<!-- request 객체의 getAttribute() 메서드 이용해서 속성 "food" 의 값을 가져온다. -->
	<%-- jsp 에서 <%=값 또는 수식 또는 변수 %> 는 '값 또는 수식 또는 변수' 를 출력하라는 의미이다. --%> 
	<div>
		request 속성 food 값 : <%=request.getAttribute("food") %><br>
		request 속성 name 값 : <%=request.getAttribute("name") %>
	</div>
	<p>
		보여주는 페이지 주소 : <%=request.getRequestURL() %>
	</p>
</body>
</html>