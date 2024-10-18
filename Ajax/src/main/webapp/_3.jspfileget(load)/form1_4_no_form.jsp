<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 사용하기</title>
<link href="../css/form.css" rel="stylesheet" type="text/css">
<script src="../js/jquery-3.7.1.js"></script>
<script>
	$(function(){
		$('input:button').click(function(e) {
			// 서버로 보낼 데이터를 폼에서 얻어온다.
			// 입력 양식에 적힌 값을 serialize 메서드를 통해 쿼리스트링으로 바꾼다.
			// 객체 형태로 파라미터 이름과 값을 전달한다.
			const data = {	"name" 		: 	$("input[name='name']").val(),
							"age" 		:	$("input[name='age']").val(),
							"address"	:	$("input[name='address']").val(), };
			
			$('div').load('process.jsp', data);
			/*
			load( url [,data] [, complete] )
					① url : 정보를 요청할 URL
					② data : 서버에 보낼 데이터
			*/
		});
	});

</script>
</head>
<body>
	<span>이름</span><input type="text" placeholder="이름을 입력하세요" id="name" name="name" required> <br>
	<span>나이</span><input type="text" placeholder="나이를 입력하세요" id="age" name="age" required> <br>
	<span>주소</span><input type="text" placeholder="주소를 입력하세요" id="address" name="address" required> <br>
	<input type="button" value="전송">
  <div></div>
</body>
</html>