<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="ex8.Dept" %>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <style>
	.container {
		width:500px;
		margin-top:3em;
	}
	
	table, h4 {
		text-align:center;
	}
</style>
<title>테이블 내용을 EL 로 나타낸다.</title>
</head>
<body>
 <div class="container">
	<%--
		ArrayList<Dept> list = (ArrayList<Dept>) request.getAttribute("list");
		EL 이 객체를 순서대로 찾으므로 request 나 session 객체에서 바로 가져올 수 있다. 
	--%>
	<c:choose>
		<c:when test="${!empty list}">
		<table class="table">
			<thead>
				<tr>
					<th>DEPTNO</th>
					<th>DNAME</th>
					<th>LOC</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="dept" items="${list}">
				<tr>
					<td>${dept.deptno}</td>
					<td>${dept.dname}</td>
					<td>${dept.loc}</td>
				</tr>
		  	</c:forEach>
			</tbody>	
		</table>
		</c:when>
		
		<c:otherwise>
			<h4>조회된 데이터가 없습니다.</h4>
		</c:otherwise>
	</c:choose>
 </div>
</body>
</html>