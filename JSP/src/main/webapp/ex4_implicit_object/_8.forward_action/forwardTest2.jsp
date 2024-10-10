<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%--
	액션태그란 JSP 페이지 내에서 어떤 동작을 하도록 지시하는 태그이다.
	forward 액션은 현재 페이지를 다른 페이지로 전환할 때 사용한다.
 --%>
<meta charset="UTF-8">
<title>after</title>
</head>
<body>
	<h1>forward 후 입니다.</h1>
	<h3><%=request.getAttribute("food")%></h3>
</body>
</html>