<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
<script src="../../js/jquery-3.7.1.js"></script>
<script>
	$(document).ready(function(){
		let message = `<%=request.getAttribute("message")%>`;
		alert(message);
		location.href="login.jsp";
	});
</script>
</head>
<body>
	
</body>
</html>