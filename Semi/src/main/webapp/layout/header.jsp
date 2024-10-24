<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="${pageContext.request.contextPath}/js/jquery-3.7.1.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>

	<nav class="navbar sticky-top navbar-expand-sm d-flex navbar-light bg-info">
			<div class='nav-item'><a class="navbar-brand text-white" href="#">Logo</a></div>
				<form class="form-inline" action="/action_page.php">
    				<input class="form-control mr-sm-2" type="text" placeholder="Search">
    				<button class="btn btn-success" type="submit">Search</button>
  				</form>
			<div class="nav-item"><a class="nav-link text-white">넣고 싶은거 추가</a></div>
			<div class="nav-item ml-auto">
				<a class="nav-link text-white">${id}님 (로그아웃)</a>
			</div>
			<div class="nav-item">
				<a class="nav-link text-white">정보수정</a>
			</div>
			<%-- Drop down --%>
			<div class="nav-item dropdown">
				<a class="nav-link dropdown-toggle text-white" href="#" id="navbardrop" data-toggle="dropdown">관리자</a>
				<div class="dropdown-menu">
					<a class="dropdown-item text-white">회원정보</a>
					<a class="dropdown-item text-white">게시판</a>
				</div>
			</div>
	</nav>
