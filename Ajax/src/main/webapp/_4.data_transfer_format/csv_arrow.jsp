<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSV(Comma Separated Values) 예제</title>
<script src="../js/jquery-3.7.1.js"></script>
</head>
<script>
	$(function(){
		const input = '홍 길동, 서울시, 25세\n신사임당, 울산시, 45세';
		
		let output='';
		// 입력을 한 줄씩 자르고 쉼표를 기준으로 분리한 후 출력
		input.split('\n').forEach(line => {
			line.split(',').forEach(item => {
				output += item.trim() + "<br>";
			});
		});
		
		$('body').html(output);
	/*
		홍 길동
		서울시
		25세
		신사임당
		울산시
		45세
	*/
	});
</script>
<body>
	
</body>
</html>