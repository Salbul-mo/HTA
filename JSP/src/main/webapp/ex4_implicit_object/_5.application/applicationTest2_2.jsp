<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>applicationTest - 초기화 파라미터 읽어오기</title>
</head>
<%--
		- 초기화 파라미터는 web.xml 에 작성한다.
		1. getInitParameterNames() : 웹 어플리케이션 초기화 파라미터의 이름 목록을 리턴한다.
		
		2. getInitParameter(Name) : 이름이 Name 인 웹 어플리케이션 초기화 파라미터의 값을 읽어온다.
									존재하지 않을 경우 null 을 리턴한다.
 --%>
<body>
	<h2>초기화 파라미터 목록</h2>
	<!-- 초기화 파라미터의 이름을 알고 있는 경우에는 바로 접근해서 출력할 수 있다. -->
	<ul>
		<li>
			logEnabled = <%=application.getInitParameter("logEnabled") %>
		</li>
		<li>
			logLevel = <%=application.getInitParameter("logLevel") %>
		</li>
	</ul>
</body>
</html>