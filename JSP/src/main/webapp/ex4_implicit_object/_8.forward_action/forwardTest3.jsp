<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%--
	액션태그란 JSP 페이지 내에서 어떤 동작을 하도록 지시하는 태그이다.
	forward 액션은 현재 페이지를 다른 페이지로 전환할 때 사용한다.
	param 을 이용해서 
 --%>
<meta charset="UTF-8">
<title>after</title>
</head>
<body>
	<h1>forward 후 입니다.</h1>
	<h3><%=request.getAttribute("food")%></h3>
	<jsp:forward page="forwardTest4.jsp">
		<jsp:param name="id" value="admin" />
		</jsp:forward>
	<!-- 
		jsp:forward 태그를 닫지 않으면 
		/ex4_implicit_object/_8.forward_action/forwardTest.jsp 
		(행: [18], 열: [1]) "name"과 "value" 속성들을 포함한 "jsp:param" 표준 액션이 요구됩니다. 
		라는 오류가 발생한다.
	-->
</body>
</html>