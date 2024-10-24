<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="header.jsp"/>
  <script src="${pageContext.request.contextPath}/js/modifyform.js"></script>
  <style>
  	h1 {
  		font-size: 1.5rem;
  		text-align: center;
  		color: #1a92b9;
  	}
  	
  	.container {
  		width: 60%;
  	}
  	
  	label {
  		font-weight: bold;
  	}
  	
  	#upfile {
  		display: none;
  	}
  	
  	img {
  		width: 20px;
  	}
  	
  	.remove {
  		width: 8px;
  		cursor: pointer;
  	}
  </style>
</head>
<body>
  <div class='container'>
  	<form action='modifyProcess' method='post' enctype='multipart/form-data' name='modifyform'>
  	  <input type='hidden' name='board_num' value='${boardData.board_num}'>
  	  <h1>MVC 게시판 - 수정</h1>
  	  <div class='form-group'>
  	    <label for='board_name'>글쓴이</label>
  	    <input name='board_name' id='board_name' value='${boardData.board_name}' readOnly type='text' class='form-control'>
  	  </div>
  	  <div class='form-group'>
  	  	<label for='board_subject'>제목</label>
  	  	<input name='board_subject' id='board_subject' type='text' value='${boardData.board_subject}'  maxlength='100' class='form-control'>
  	  </div>
  	  <div class='form-group'>
  	  	<label for='board_content'>내용</label>
  	  	<textarea name='board_content' id='board_content' rows="10" class='form-control'>${boardData.board_content}</textarea>
  	  </div>
  	  <%-- 원문글인 경우에만 파일 첨부 수정 가능하다. --%>
  	  <c:if test="${boardData.board_re_lev == 0}">
  	  <div class='form-group'>
  	  	<label>
  	  	  파일 첨부
		  <img src='${pageContext.request.contextPath}/image/file.png' alt="파일첨부">
		  <input type='file' id='upfile' name='board_file'>
  	  	</label>
  	  	<span id='filevalue'>${boardData.board_file}</span><img class="remove align-top m-1" src='${pageContext.request.contextPath}/image/x.png' alt="파일삭제">
  	  </div>
  	  </c:if>
  	  
  	  <div class='form-group'>
  	  	<label for='board_pass'>비밀번호</label>
  	  	<input name='board_pass' id='board_pass' type='password' maxlength='30' class='form-control' placeholder='Enter board_pass'>
  	  </div>
  	  <div class='form-group'>
  	  	<button type='submit' class='btn btn-primary'>수정</button>
  	  	<button type='reset' class='btn btn-danger' onClick="history.go(-1)">취소</button>
  	  </div>
  	</form>
  </div>
</body>
</html>