<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>MVC 게시판 - view</title>
<jsp:include page="header.jsp" />
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/js/view.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/view.css" type="text/css">
</head>
<body>
  <input type="hidden" id="loginid" value="${id}" name="loginid"><%-- view.js 에서 사용하기 위해 추가 --%>
  <div class="container">
	<table class="table">
	  <tr>
	  	<th colspan="2">MVC 게시판 -view 페이지</th>
	  </tr>
	  <tr>
	  	<td><div>글쓴이</div></td>
	  	<td><div>${boardData.board_name}</div></td>
	  </tr>
	  <tr>
	  	<td><div>제목</div></td>	
	  	<td><c:out value="${boardData.board_subject}"/></td>
	  </tr>
	  <tr>
	  	<td><div>내용</div></td>
	  	<td style="padding-right: 0px">
	  	  <textarea class="form-control" rows="5" readOnly>${boardData.board_content}</textarea>
	  	</td>
	  </tr>	
	  <c:if test="${boardData.board_re_lev == 0}">
	  <%-- 원문글인 경우에만 첨부파일을 추가 할 수 있다. --%>
	  <tr>
	  	<td><div>첨부파일</div></td>
	  	
	  	<%-- 파일을 첨부한 경우 --%>
	  	<c:if test="${!empty boardData.board_file}">
	  	  <td><img src="${pageContext.request.contextPath}/image/download.png" width="10px">
	  		<a href="down?filename=${boardData.board_file}">${boardData.board_file}</a></td>
	  	</c:if>
	  	
	  	<%-- 파일을 첨부하지 않은 경우 --%>
	  	<c:if test="${empty boardData.board_file}">
	  	  <td></td>
	  	</c:if>
	  </tr>
	  </c:if> <%-- board_re_lev == 0 end --%>
	  
	  <tr>
	  	<td colspan="2" class="center">
	  	  <c:if test="${boardData.board_name == id || id == 'admin'}">
	  	    <a href="modify?num=${boardData.board_num}">
	  	   	  <button class="btn btn-info">수정</button>
	  	    </a>
	  	  <%-- href 의 주소를 #으로 설정한다. --%>
	  	    <a href="#">
	  	      <button class="btn btn-danger" data-toggle="modal" data-target="#myModal">삭제</button>
	  	    </a>
	  	  </c:if>
	  	    <a href="list">
	  	      <button class="btn btn-warning">목록</button>
	  	    </a>
	  	    <a href="reply?num=${boardData.board_num}">
	  	      <button class="btn btn-success">답변</button>
	  	    </a>
	  	</td>
	  </tr>
	</table>
	<%-- 게시판 view end --%>
	<%-- modal 시작 --%>
	<div class="modal" id="myModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-body">
	       <form name="deleteForm" action="delete" method="post">
	       <%-- http://localhost:8088/Board_Ajax/boards/detail?num=22
	       		주소를 보면 num을 파라미터로 넘기고 있다.
	       		이 값을 가져와서 ${param.num} 사용 또는 ${boardData.board_num} 
	        --%>
	         <input type="hidden" name="num" value="${param.num}" id="comment_board_num">
	         <%-- board_num 을 받고 댓글 일괄 삭제를 위해 comment_board_num 으로 데이터 추가로 전송한다. --%>
	         <div class="form-group">
	           <label for="board_pass">비밀번호</label>
	           <input type="password" class="form-control" placeholder="Enter password" name="board_pass" id="board_pass">
	         </div>
	         <button type="submit" class="btn btn-primary">전송</button>
	         <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
	       </form>
	      </div>
	    </div>
	  </div>
	</div>
  </div>
  <div class="container">
    <div class="comment-area">
	  <div class="comment-head">
		<h3 class="comment-count"> 댓글 
		  <sup id="count"></sup>
		</h3>
		<div class="comment-order">
			<ul class="comment-order-list">
			<%--
                <li class="comment-order-item red">   
                     <a href="javascript:getList(1)" class="comment-order-button">등록순 </a>
                </li>
                <li class="comment-order-item gray">   
                     <a href="javascript:getList(2)" class="comment-order-button">최신순</a>
                </li>
			--%>
            </ul>
		</div>
	  </div><!-- comment-head end-->
	  <ul class="comment-list">
	  <%-- 댓글 출력 --%>
	  </ul>
	  <div class="comment-write">
	    <div class="comment-write-area">
		  <b class="comment-write-area-name">${id}</b>  
		  <span class="comment-write-area-count">0/200</span>
		  <textarea placeholder="댓글을 남겨보세요" rows="1" class="comment-write-area-text" maxlength="200"></textarea>
					
		</div>
		<div class="register-box">
		  <div class="button btn-cancel">취소</div>
		  <div class="button btn-register">등록</div>
		</div>
	  </div>
	</div>
  </div>
		
		
</body>
</html>