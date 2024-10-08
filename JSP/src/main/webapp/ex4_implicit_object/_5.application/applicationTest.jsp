<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<title>application test</title>
</head>
<body>
	<%-- application 객체는 웹 어플리케이션 전반에 걸쳐서 사용되는 정보를 담고 있다. --%>
	<div class="container">
		<h2>application 테스트</h2>
		<table class="table table-striped">
			<tr>
				<td>Servlet API 스펙의 버전</td>
				<td><%=application.getMajorVersion() %>.
					<%=application.getMinorVersion() %></td>
			</tr>
			<tr>
				<td>컨테이너 이름과 버전</td>
				<td><%=application.getServerInfo() %></td>
			</tr>
			<tr>
				<td>웹 어플리케이션의 context 경로</td>
				<td><%=application.getContextPath() %></td>
			</tr>
			<tr>
				<td>웹 어플리케이션의 실제 파일시스템 경로</td>
				<td><%=application.getRealPath("/") %></td>
			</tr>
		</table>
		<%--
				getRealPath("/") : / 는 context 경로 이다.
					즉, 웹 어플리케이션 context 경로까지 구하라는 의미이다.
					위의 경우 ~~~~/JSP 까지 구한다.
		 --%>
	
	</div>
</body>
</html>