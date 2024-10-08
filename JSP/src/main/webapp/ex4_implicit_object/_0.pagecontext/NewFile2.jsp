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
	
	<%--
		<jsp:forward> 는 JSP 에서 요청을 다른 페이지로 전달(포워딩)하는 데 사용되는 표준 액션 태그이다.
		jsp 태그 주석처리는 <% %> 에서 해야한다. 
	--%>
	<jsp:forward page="Go.jsp"/>
</body>
</html>