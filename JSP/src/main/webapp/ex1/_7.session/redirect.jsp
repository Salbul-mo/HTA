<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect.jsp</title>
</head>
<body>
	request 속성 food 값 : <%=request.getAttribute("food") %><br>
	session 속성 food 값 : <%=session.getAttribute("food") %>
	<!-- 
		 redirect 로 요청을 넘겨받은 jsp 페이지 
		 request 객체에는 접근할 수 없지만 
		 session 객체에는 접근할 수 있다.
		 (session 객체에 데이터를 넣어주어야 한다.)
		
		 request 속성 food 값 : null
		 session 속성 food 값 : 치킨 
	-->
</body>
</html>