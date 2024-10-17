<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>
<%@ page import="net.template.db.*"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
	h2 {
		color:gray;
	}
	table, h4 {
		text-align: center;
	}
</style>
<title>회원 정보 조회</title>
</head>
<body>
	<nav>
		<jsp:include page="top.jsp"/><br><br>
	</nav>
	<div class="container mt-2">
	<div class="container d-flex justify-content-center mx-auto mt-0 mb-3">
			<h2>${temp.id}의 상세 정보</h2>
	</div>
		<c:choose>
			<c:when test="${!empty temp}">
				<table class="table table-striped">
					<tbody>
						<tr>
							<th>아이디</th>
							<td>${temp.id}</td>
						</tr>
						<tr>
							<th>주민번호</th>
							<td>${temp.jumin}</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>${temp.email}</td>
						</tr>
						<tr>
							<th>성별</th>
							<td>${temp.gender == "m" ? "남자" : "여자"}</td>
						</tr>
						<tr>
							<th>취미</th>
							<td>${temp.hobby}</td>
						</tr>
						<tr>
							<th>우편번호</th>
							<td>${temp.post}</td>
						</tr>
						<tr>
							<th>주소</th>
							<td><c:out value="${temp.address}"/></td>
						</tr>
						<tr>
							<th>자기소개</th>
							<td><c:out value="${temp.intro}"/></td>
						</tr>
						<tr>
							<th>가입 일</th>
							<td>${temp.register_date}</td>
						</tr>
						<tr>
							<th>삭제</th>
							<td><input type="button" name="${temp.id}" class="btn btn-sm btn-danger" value="삭제">
						</tr>
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
					$('input:button').on("click", (e) => {
								let id = $(e.target).attr("name");
								// e.target 으로 이벤트 발생시킨 객체를 찾는다.
								alert(id + " 회원을 삭제합니다.");
								// event.stopImmediatePropagation(); 상위 뿐만 아니라 같은 레벨에서의 전파 방지
								// return false; 제이쿼리에서 전파 방지
					});
		})
	</script>
</body>
</html>