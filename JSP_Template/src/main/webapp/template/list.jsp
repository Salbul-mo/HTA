<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>
<%@ page import="net.template.db.*"%>
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
	<nav>
		<jsp:include page="top.jsp"/><br><br>
	</nav>
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
							<th>번호</th>
							<th>아이디</th>
							<th>성별</th>
							<th>취미</th>
							<th>자기소개</th>
							<th>가입 일</th>
							<c:if test="${sessionScope.id == 'admin'}">
							<th>글  삭제</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="temp" items="${list}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${temp.id}</td>
							<td>${temp.gender == "m" ? "남자" : "여자"}</td>
							<td>${temp.hobby}</td>
							<td>${temp.intro}</td>
							<td>${temp.register_date}</td>
						<c:if test="${sessionScope.id == 'admin'}">
							<td><input type="button" name="${temp.id}" class="btn btn-sm btn-danger" value="삭제">
						</c:if>
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
					
					$('input:button').on("click", (e) => {
								let id = $(e.target).attr("name");
								alert(id + " 회원을 삭제합니다.");
					});
		})
	</script>
</body>
</html>