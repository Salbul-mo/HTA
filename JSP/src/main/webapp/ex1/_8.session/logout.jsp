<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<%=session.getAttribute("id")%>님 로그아웃 되셨습니다.<br>
	<a href="login.jsp">로그인</a>
</body>
</html>