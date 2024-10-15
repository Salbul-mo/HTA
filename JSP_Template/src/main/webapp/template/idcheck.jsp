<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String id = application.getInitParameter("id");
		String password = application.getInitParameter("password");
		String inputId = request.getParameter("id");
		String inputPassword = request.getParameter("passwd");
		String remember = request.getParameter("remember");
		
		if(!inputId.equals(id)) { 
	%>			
		<script>
			alert("아이디가 일치하지 않습니다.");
			location.href="login.jsp";
		</script>
	<%	} else if(!inputPassword.equals(password)) { 
	%>
		<script>
			alert("비밀번호가 일치하지 않습니다.");
			location.href="login.jsp";
		</script>
	<%	
		} else {
		session.setAttribute("id", id);
		if(remember.equals("store")) {
			Cookie cookie = new Cookie("id", request.getParameter("id"));
			cookie.setMaxAge(60*60*24); // 쿠키의 유효 시간을 24시간으로 설정한다(단위는 초)
			response.addCookie(cookie);
		}
	%>
		<script>
			alert("<%=id%> 님 환영합니다.");
			location.href="templatetest.jsp";
		</script>
	<%	
		} 
	%>
</body>
</html>