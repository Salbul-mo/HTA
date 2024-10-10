<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<!-- 
			로그아웃 시 반드시 session 객체에 남은 속성값을 제거해야 한다.
			
				=>  session.invalidate() 메서드로 속성값 일괄 삭제
					session.removeAttribute() 메서드는 속성값 선택 삭제.
	 -->
	 <script>
		alert('<%=session.getAttribute("id")%>님 로그아웃 되셨습니다.');
		<% session.invalidate(); %>
		location.href="template.jsp";
	 </script>
</body>
</html>