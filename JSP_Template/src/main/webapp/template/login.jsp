<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.js"></script>
  <style>
  	.container {
  		margin:3em auto;
  		box-shadow:3px 3px 30px gray;
  		width:500px;
  	}
  </style>
  <script>
  	$(function(){
  		const result = '${message}';
  		if (result != '') {
  			alert(result);
  			<%session.removeAttribute("message");%>
  		}
		
  		const id = '${cookieId}';
  		if (id) {
  			$("#id").val(id).css('font-weight','bold');
  			$("#remember").prop('checked',true);
  		}
  	})
  </script>
</head>
<body>
	<div class="container">
	<form action="loginProcess.net" method="post" class="border border-light p-5">
		<p class="h4 mb-4 text-center">login</p>
		<div class="form-group">
			<label for="id">ID</label>
			<input type="text" class="form-control" id="id" name="id" placeholder="Enter id" required>
		</div>
		<div class="form-group">
			<label for="pass">Password</label>
			<input type="password" name="passwd" class="form-control" id="pass" placeholder="Enter password" required>
		</div>
		<div class="form-group custom-control custom-checkbox">
			<input type="checkbox" class="custom-control-input" id="remember" name="remember" value="store">
			<label class="custom-control-label" for="remember">아이디 기억하기</label>
		</div>
			<button type="submit" class="btn btn-info my-4 btn-block">전송</button>
	</form>
	</div>
</body>
</html>