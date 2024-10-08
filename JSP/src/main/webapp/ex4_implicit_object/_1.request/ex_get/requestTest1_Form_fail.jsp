<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>request example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<script>
	$(function(){
		$('$form[action="request
		
		
		
	});
</script>
<body>
	<div class="container">
		<h3>Request 예제 입니다.</h3>
		<form action="requestTest1.jsp" method="get">
			<table class="table">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" class="form-control" required></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><label>
						<input type="radio" name="gender" value="male">남자
						</label>
						<label>						
						<input type="radio" name="gender" value="female">여자
						</label>
					</td>
				</tr>
				<tr>
					<td>취미</td>
					<td><label>
						<input type="checkbox" value="독서" name="hobby">독서
						</label>	
						<label>
						<input type="checkbox" value="게임" name="hobby">게임
						</label>
						<label>
						<input type="checkbox" value="TV시청" name="hobby">TV시청
						</label>
						<label>
						<input type="checkbox" value="축구" name="hobby">축구
						</label>
						<label>
						<input type="checkbox" value="기타" name="hobby">기타
						</label>
					</td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit" class="btn btn-success">전송</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>