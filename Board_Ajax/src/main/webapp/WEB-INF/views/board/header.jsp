<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/js/jquery-3.7.1.js"></script>
<link rel="icon" href="${pageContext.request.contextPath}/image/home.png">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>

<style>
	body > nav.navbar {
		justify-content: flex-end; /* 오른쪽 정렬 */
	}
	
	.dropdown-menu {
		min-width: 0rem;
	}
	
	.navbar {
		background: #096988;
		margin-bottom: 3em;
		padding-right: 3em;
	}
	
	.navbar-dark .navbar-nav .nav-link {
		color: rgb(255, 255, 255);
	}
	
	textarea {
		resize: none;
	}
</style>
<%-- 필터가 없는 경우 필요 --%>

<c:if test="${empty id}">
	<script>
		location.href = "${pageContext.request.contextPath}/members/login";
	</script>
</c:if>

<c:if test="${!empty id}">
	<nav class="navbar navbar-expand-sm right-block navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/members/logout">${id}님 (로그아웃)</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/members/update">정보수정</a>
			</li>
		<c:if test="${id=='admin'}">
			<%-- Drop down --%>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">관리자</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${pageContext.request.contextPath}/members/list">회원정보</a>
					<a class="dropdown-item" href="${pageContext.request.contextPath}/boards/list">게시판</a>
				</div>
			</li>
		</c:if>	
		</ul>
	</nav>
</c:if>