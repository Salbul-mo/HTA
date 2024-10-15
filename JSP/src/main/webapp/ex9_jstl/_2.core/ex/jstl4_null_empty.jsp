<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empty 연산자</title>
<style>
	.true {
		color:red;
	}
	
	.false {
		color:green;
	}
</style>
</head>
<body>
	<%--
		empty 연산자
			형식) empty 값
				① 값이 비어있거나 null 인지를 조사할 때 사용하는 연산자이다.
				② 값이 null 이면 true 를 반환한다.
				③ 문자열과 배열의 크기가 0인 경우에도 true 를 반환한다.
	 --%>
	 <%
	 	session.setAttribute("loginId","hong");
	 	//session.invalidate();
	 %>
	 <c:out value="${loginId}"/>
	 <hr>
	
	 <c:if test="${empty loginId}">
	 	<h3 class="true">아이디가 존재하지 않습니다.</h3>
	 </c:if>
	 <c:if test="${!(empty loginId)}">
	 	<h3 class="false">아이디가 존재합니다.</h3>
	 </c:if>
</body>
</html>