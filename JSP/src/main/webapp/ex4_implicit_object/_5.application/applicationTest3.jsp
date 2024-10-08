<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>applicationTest - 초기화 파라미터 읽어오기</title>
</head>
<body>
	<h2>web.xml 에서 설정한 색상으로 스타일 지정</h2>
	<%
		String color = application.getInitParameter("color");
	%>
	<div style="background:<%=color %>">나는 무슨 색 인가요?</div>
	<%-- 큰 따옴표 안에 jsp 익스프레션 사용할 수 있다. --%>
</body>
</html>