<%--2. 현재 페이지를 실행하면 error500.jsp 가 실행된다.
	11번 라인에서 자바 코드 오류를 발생시켜 500번 에러 확인한다.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>파라미터 출력</title>
</head>
<body>
	<!-- ; 를 추가한다. -->
	name 파라미터 값: <%=request.getParameter("name").toUpperCase()/* ; 추가하면 에러 */  %>
	<%-- name 파라미터의 값을 대문자로 변환하여 출력한다. --%>
</body>
</html>