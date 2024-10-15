<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>
<%@ page import="ex8_emp.Emp"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
.container {
	margin-top: 3em;
}

table, h4 {
	text-align: center;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="form-group">
			<label for="usr">검색어를 입력하세요</label> <input type="text"
				class="form-control" id="search" placeholder="Search..."
				name="search">
		</div>
		<c:choose>
			<c:when test="${!empty list}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>사원번호</th>
							<th>사원이름</th>
							<th>직급</th>
							<th>매니저</th>
							<th>입사일자</th>
							<th>급여</th>
							<th>커미션</th>
							<th>부서번호</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="emp" items="${list}">
						<tr>
							<td>${emp.empno}</td>
							<td>${emp.ename}</td>
							<td>${emp.job}</td>
							<td>${emp.mgr}</td>
							<td>${emp.hiredate}</td>
							<td>${emp.sal}</td>
							<td>${emp.comm}</td>
							<td>${emp.deptno}</td>
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
	<script>
		$(document).ready(function() {
					$('input').keyup(function() {
						let search = $('input').val().trim();
							if (search != null && search != "") {
								$('table tbody tr').hide();
								$('table tbody tr td:contains(' + '"' + search + '"' + ')')
																	.parent().show();
							} else {
								$('table tbody tr').show();
							}
					});
		});
	</script>
</body>
</html>