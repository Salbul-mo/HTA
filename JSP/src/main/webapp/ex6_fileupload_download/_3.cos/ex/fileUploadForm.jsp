<%--
	webapp 폴더 아래 upload 폴더 생성 후 실행한다.
	
	일반 파라미터를 전송할 때 사용하는 인코딩과 파일을 업로드 할 때 사용하는 인코딩은 다르다.
	POST 방식은 다음의 두 가지 인코딩 방식에 따라서 전송하는 데이터 형식이 달라진다.
	
	1. application/x-www-form-urlencoded
	2. multipart/form-data
	
		(1) 지금까지의 예제들은 1번 인코딩을 사용해서 데이터를 전송했다.
			우리가 보내는 데이터가 application/x-www-form-urlencoded 라는 형식으로 전송하게 되고
			이러한 값들은 request.getParameter() 메서드를 통해서 쉽게 접근했다.
			
			application/x-www-form-urlencoded 형식은 
			id=hta&password=1234 의 형식의 text 데이터이다.
			
		(2) 첨부파일의 데이터는 바이너리 데이터(2진) 이므로 기존 인코딩 방식이 아닌 multipart/form-data 를 통해 가져와야 한다.
			하지만 바이너리 데이터는 복잡한 과정으로 데이터를 추출해야 해서 Part API(cos2024.jar) 를 사용해서 처리한다.
			multipart/form-data 의미는 여러 파트로 여러 종류의 데이터를 가져올 수 있도록한다는 뜻이다.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
	.container {
		width:500px;
		margin-top:3em;
	}
	
	.input-group-text {
		width:74px;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%-- 파일을 업로드하기 위해서 enctype 속성을 "multipart/form-data" 로 설정한다 --%>
		<form action="<%=request.getContextPath() %>/fileUpload" method="post" enctype="multipart/form-data">
			<p class="h4 mb-4 text-center">파일 업로드 폼</p>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">작성자</span>
				</div>
				<input type="text" class="form-control" name="name">			
			</div>
			
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">제 목</span>
				</div>
			<input type="text" class="form-control" name="subject">
			</div>
			
			<div class="form-group">
				<input type="file" class="form-control-file border" name="fileName1">
				<!-- 파일을 선택하여 전송할 수 있도록 type 속성을 file로 설정한다. -->
			</div>
			
			<div class="form-group">
				<input type="file" class="form-control-file border" name="fileName2">
			</div>
						
			<button type="submit" class="btn btn-info my-4 btn-block">Submit</button>
		</form>
	</div>
</body>
</html>