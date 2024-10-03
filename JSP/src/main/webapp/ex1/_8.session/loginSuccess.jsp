<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<%=session.getAttribute("id")%>님 로그인에 성공하셨습니다.<a href="logout.jsp">로그아웃</a>
</body>
</html>