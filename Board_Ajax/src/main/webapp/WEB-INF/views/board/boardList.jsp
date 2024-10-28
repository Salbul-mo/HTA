<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="header.jsp"/>
  <style>
  	select.form-control {
  	  width: auto;
  	  margin-bottom: 2em;
  	  display: inline-block;
  	}
  	
  	.rows {
  		text-align: right;
  	}
  	
  	.gray {
  		color: gray;
  	}
  	
  	body > div > table > thead > tr:nth-child(2) > th:nth-child(1){width: 8%}
  	body > div > table > thead > tr:nth-child(2) > th:nth-child(2){width: 50%}
  	body > div > table > thead > tr:nth-child(2) > th:nth-child(3){width: 14%}
  	body > div > table > thead > tr:nth-child(2) > th:nth-child(4){width: 17%}
  	body > div > table > thead > tr:nth-child(2) > th:nth-child(5){width: 11%}
  </style>
  <script src="${pageContext.request.contextPath}/js/list.js"></script>
  <title>MVC 게시판</title>
</head>
<body>
	<div class="container">
	<%-- 게시글이 있는 경우 --%>
	<c:if test="${listCount > 0}">
		<div class="rows">
			<span>줄보기</span>
			<select class="form-control" id="viewcount">
				<option value="1">1</option>
				<option value="3">3</option>
				<option value="5">5</option>
				<option value="7">7</option>
				<option value="10" selected>10</option>
			</select>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th colspan="3">MVC 게시판 - list</th>
					<th colspan="2"><span>글 개수 : ${listCount}</span></th>
				</tr>
				<tr>
					<th><div>번호</div></th>
					<th><div>제목</div></th>
					<th><div>작성자</div></th>
					<th><div>날짜</div></th>
					<th><div>조회수</div></th>
				</tr>
			</thead>
		</table>
		<%-- pagination --%>
		<div class="center-block">
			<ul class="pagination justify-content-center">
				<li class="page-item">
					<a ${page > 1 ? 'href=list?page=' += (page - 1) : ''} 
						<%-- 
							현재 페이지가 1보다 크면 page-1 하고 get 방식으로 list 요청하는 링크 추가
							현재 페이지가 1보다 같거나 작으면 회색 & 링크 없음
						 --%>
						class="page-link ${page <= 1 ? 'gray' : ''}">
						이전&nbsp;
					</a>
				</li>
				<c:forEach var="a" begin="${startPage}" end="${endPage}">
				<%-- 해당 페이지의 페이지 그룹 시작(1, 11, 21 , . . .)부터 끝까지(10, 20, 30, . . . MaxPage) for 문 --%>
					<li class="page-item ${a == page ? 'active' : '' }">
					<%-- 해당 page 표시가 현재 page와 같으면 active 클래스 추가 --%>
						<a ${a == page ? '' : 'href=list?page=' += a} class="page-link">${a}</a>
					<%-- 해당 page 표시가 현재 page 와 같으면 링크 없음 아니면 해당 page 값으로 get 방식 list 요청하는 링크 추가 --%>
					</li> 
				</c:forEach>
				<li class="page-item">
					<a ${page < maxPage ? 'href=list?page=' += (page + 1) : ''} class="page-link ${page >= maxPage ? 'gray' : ''}">
						&nbsp;다음</a>
				<%-- 현재 페이지가 maxPage 보다 작으면 현재 페이지 +1 해서 get 방식으로 list 요청하는 링크 추가 아니면 회색, 링크 없음 --%>
				</li>
			</ul>
		</div>
	</c:if> <%-- <c:if test="${listCount > 0}"> end --%>
	
	<%-- 게시글이 없는 경우 --%>
	<c:if test="${listCount == 0}">
		<h3 style="text-align:center">등록된 글이 없습니다.</h3>
	</c:if>
	
	<button type="button" class="btn btn-info float-right">글 쓰 기</button>
	</div> <%-- <div class='container'> end --%>
</body>
</html>

<%--
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
--%>