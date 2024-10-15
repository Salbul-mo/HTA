<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
	<form action="idcheck.jsp" method="post" class="border-light p-5">
		<p class="h4 mb-4 text-center">login</p>
		<div class="form-group">
			<label for="id">ID</label>
			<input type="text" class="form-control" id="id" name="id" placeholder="Enter id" required>
		</div>
		<div class="form-group">
			<label for="pass">
			<input type="password" name="passwd" class="form-control" id="pass" placeholder="Enter password" required>
			</label>
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