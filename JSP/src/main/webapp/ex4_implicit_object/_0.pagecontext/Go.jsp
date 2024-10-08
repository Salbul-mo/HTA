<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Go.jsp</title>
</head>
<body>
	<h3>Go.jsp 입니다.</h3>
	<p><%=pageContext.getAttribute("name") %></p>
	<p><%=request.getAttribute("name") %></p>
	<p><%=session.getAttribute("name") %></p>
	<p><%=application.getAttribute("name") %></p>
</body>
</html>