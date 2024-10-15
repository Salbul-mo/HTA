<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--
	EL 블록(${}) 에서 사용할 수 있는 값은 문자열, 정수, 부동소수점, boolean, null 이다.
--%>
<title>리터럴 표현식</title>
</head>
<body>
	<%-- 
		"/" 를 출력하려면 두 개 사용한다. 
	--%>
	문자열 : ${'\\test'}<br>
	정수 : ${20} <br>
	부동소숫점 : ${3.14} <br>
	boolean : ${true}<br>
	null : ${null}<br> <%-- ${null} 은 아무 값도 출력되지 않는다 --%>
	
	문자열 : ${"test"}<br>
	문자열 : ${'test'}<br>
</body>
</html>