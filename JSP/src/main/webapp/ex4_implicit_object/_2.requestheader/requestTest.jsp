<%--
	세션은 기본적으로 컨테이너 내부에 정보를 저장 및 관리하고 저장된 정보에 접근하기 위해서 세션 ID 라는 것을 사용한다.
	세션 ID는 쿠키를 사용해서 유지되며 이 때의 쿠키 이름은 JSESSIONID 이다.
	
	(1) 기존 브라우저를 종료한다.
	(2) 실행
	(3) 새로고침
		JSESSIONID 가 추가로 보이는지 확인한다.
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request test</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>헤더 정보 예제</h1>
		<table class="table table-striped">
			<tr>
				<td>헤더 이름</td>
				<td>헤더 값</td>
			</tr>
			<%
				// getHeaderNames() 메서드 : HTTP 요청 헤더에 포함된 모든 헤더 이름을 
				// Enumeration 객체로 리턴한다.
				Enumeration<String> e = request.getHeaderNames();
				
				while (e.hasMoreElements()) {
					String headerName = e.nextElement(); 	
			%>
			<tr>
				<td><%=headerName %></td>
				<td>
					<%-- getHeader() : 매개변수로 지정된 이름으로 할당된 값을
										리턴한다. 없는 경우 null 을 리턴한다.
										
					 --%>
					 <%=request.getHeader(headerName) %>
				</td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>