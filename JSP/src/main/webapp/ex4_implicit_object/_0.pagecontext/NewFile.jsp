<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체의 영역</title>
</head>
<body>
	<%
		pageContext.setAttribute("name", "pageContext");
		request.setAttribute("name", "request");
		session.setAttribute("name", "session");
		application.setAttribute("name", "application");
	%>
	
	<p><%=pageContext.getAttribute("name") %></p>
	<p><%=request.getAttribute("name") %></p>
	<p><%=session.getAttribute("name") %></p>
	<p><%=application.getAttribute("name") %></p>
	
	<a href="Go.jsp">다른 페이지로 이동합니다.</a>
</body>
</html>