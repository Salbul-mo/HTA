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
			<tbody>
			<c:set var="num" value="${listCount-(page-1)*limit}"/> <%-- 총 글 수에서 페이지 * limit 빼기 --%>
			<c:forEach var="b" items="${boardList}">
				<tr>
					<td> <%-- 번호 --%>
						<c:out value="${num}"/><%-- num 출력 해당 페이지의 글 번호 끝부터 시작 --%> 
						<c:set var="num" value="${num-1}"/> <%-- num = num -1  --%>
					</td>
					<td> <%-- 제목 --%>
						<div>
							<%-- 답변글 제목앞에 여백 처리 부분 --%>
							<c:if test="${b.board_re_lev > 0}"> <%-- 답글인 경우 lev 만큼 공백 추가 --%>
								<c:forEach var="a" begin="0" end="${b.board_re_lev*2}" step="1">
									&nbsp;
								</c:forEach>
								<img src="${pageContext.request.contextPath}/image/line.gif"> <%-- 댓글 표시 --%>
							</c:if>
							
							<a href="detail?num=${b.board_num}"> <%-- 클릭하면 게시글 페이지로 이동 --%>
								<c:if test="${b.board_subject.length() >= 20}"> <%-- 제목이 길 경우 축약 --%>
									<c:out value="${b.board_subject.substring(0, 20)}..."/>
								</c:if>
								<c:if test="${b.board_subject.length() < 20}">
									<c:out value="${b.board_subject}"/>
								</c:if>
							</a>[${b.cnt}] <%-- 댓글 수 표시 --%>
						</div>
					</td>
					<td><div>${b.board_name}</div></td> <%-- 작성자 --%>
					<td><div>${b.board_date}</div></td>
					<td><div>${b.board_readCount}</div></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<div class="center-block">
			<ul class="pagination justify-content-center">
				<li class="page-item">
					<a ${page > 1 ? 'href=list?page=' += (page - 1) : ''} 
						<%-- 페이지가 1보다 작으면 회색 & 링크 없음
							크면 page-1 하고 get 방식으로 list 요청하는 링크 추가
						 --%>
						class="page-link ${page <= 1 ? 'gray' : ''}">
						이전&nbsp;
					</a>
				</li>
				<c:forEach var="a" begin="${startPage}" end="${endPage}">
				<%-- 해당 페이지 그룹 중 시작부터 끝까지 for 문 --%>
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