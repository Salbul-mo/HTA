<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/js/jquery-3.7.1.js"></script>
<title>Idcheck.jsp</title>
</head>
<body>
	<div id="message"></div>
	
	<script>
		const message = ["사용 중인 아이디 입니다.", "사용 가능한 아이디입니다"];
		const color = ["red", "green"];
		const index = ${result + 1}; // 아이디가 없으면 1, 있으면 0
		$("#message").text(message[index]).css('color', color[index]);
	
		// 2초 후 자동으로 창을 닫는다.
		setTimeout(function() {
			// opener : 현재 창(자식창)을 열어준 창(부모창)
			$(opener.document).find("#opener_message").text(message[index]).css('color',color[index]);
			$(opener.document).find("#result").val('${result}'); // 아이디가 존재하지만 비밀번호가 틀리면 -1
			window.close();
		}, 2000);
	
	</script>
<%--
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
 --%>
</body>
</html>