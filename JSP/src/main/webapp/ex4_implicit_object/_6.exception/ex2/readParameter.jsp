<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 에러가 발생할 경우 errorPage 속성에 지정한 페이지를 보여준다. 
	 web.xml 에 추가하지 않고도 Page 지시어로 에러페이지를 설정할 수 있다.
--%>
<%@ page errorPage = "../error/viewErrorMessage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 출력</title>
</head>
<body>
	name 파라미터 값 :
	<%-- name 파라미터의 값을 대문자로 변환하여 출력한다. --%>
	<%=request.getParameter("name").toUpperCase() %>
	<%-- NullPointer 오류 발생 --%>
</body>
</html>