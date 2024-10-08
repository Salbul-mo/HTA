<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="../../../../js/jquery-3.7.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = application.getInitParameter("id");
	String password = application.getInitParameter("password");
	String inputId = request.getParameter("id");
	String inputPassword = request.getParameter("passwd");

	String message = null;
	String next = "location.href=`template.jsp';";

	if (inputId.equals(id) && inputPassword.equals(password)) {
		session.setAttribute("id", id);
		message = id + "님 환영합니다.";
	} else {
		next = "history.back();";
		if (!id.equals(inputId)) {
			message = "아이디를 확인하세요.";
		} else {
			message = "비밀번호를 확인하세요.";
		}
	}
	%>
	<script>
	alert("<%=message%>");
	<%=next%>
	</script>
</body>
</html>