<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출력</title>
<script src="../js/jquery-3.7.1.js"></script>
<script>
	$(document).ready(function(){
		$('#name').load('form0.jsp', 
				function(){
					$('#name').text('넘어온 이름은 ' + ${param.name}+ '입니다.'); 
		});
		
		$('#age').load('form0.jsp',
				function(){
					$('#name').text('넘어온 나이는 ' + ${param.age} + '입니다.'); 
		});
		
		$('#address').load('form0.jsp', 
			function(){
					$('#name').text('넘어온 주소는 ' + ${param.address} + '입니다.'); 
		});
	});


</script>
</head>
<body>
	<div id="container">
		<p id="name"></p>
		<p id="age"></p>
		<p id="address"></p>
	</div>
</body>
</html>