<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scope.jsp</title>
</head>
<body>
	request 속성 food 값 : <%=request.getAttribute("food") %><br>
	session 속성 food 값 : <%=session.getAttribute("food") %><br>
	ServletContext 속성 food 값 : <%=application.getAttribute("food") %>
	<!-- 
		 redirect 로 요청을 넘겨받은 jsp 페이지 
		 request 객체에는 접근할 수 없지만 
		 session 객체에는 접근할 수 있다.
		 (session 객체에 데이터를 넣어주어야 한다.)
		 
		 session 객체를 통해 만들어지는 ServletContext
		 (ServletContext 객체에 데이터를 넣어주어야 한다.) 
		 => 웹 애플리케이션이 종료될 때까지 해당 객체가 계속 유지된다. 
		 ServletContext 객체에도 접근할 수 있다.
		
		 request 속성 food 값 : null
		 session 속성 food 값 : 치킨
		 ServletContext 속성 food 값 : 치킨
	-->
</body>
</html>