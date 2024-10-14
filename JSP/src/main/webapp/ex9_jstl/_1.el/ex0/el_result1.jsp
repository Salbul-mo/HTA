<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 내장 객체 사용 예제</title>
</head>
<body>
	<h3>page영역의 속성 id의 값 : ${pageScope.id }</h3>
	<h3>request영역의 속성 id의 값 : ${requestScope.id }</h3>
	<h3>session영역의 속성 id의 값 : ${sessionScope.id }</h3>
	<h3>application영역의 속성 id의 값 : ${applicationScope.id }</h3>
	<h3> page -> request -> session -> application 영역에서 속성 id 의 값을 찾는다. : ${id} </h3>
</body>
<!-- 
출력 결과
=> redirect로 요청이 종료되었으므로 session 과 application 만 속성을 유지한다.
 
page영역의 속성 id의 값 :
request영역의 속성 id의 값 :
session영역의 속성 id의 값 : session
application영역의 속성 id의 값 : application
page -> request -> session -> application 영역에서 속성 id 의 값을 찾는다. : session -->
</html>