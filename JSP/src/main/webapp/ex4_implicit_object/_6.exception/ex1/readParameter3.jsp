<%--3. 현재 페이지를 실행하면 error404.jsp 가 실행된다.
		요청 URL이 존재하지 않는 경우 실행된다.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>파라미터 출력</title>
</head>
<body>
	<%
		response.sendRedirect("hoho.jsp");
	%>
</body>
</html>