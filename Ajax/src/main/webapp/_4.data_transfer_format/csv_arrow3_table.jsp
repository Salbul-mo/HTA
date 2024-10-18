<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSV(Comma Separated Values) 예제</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/jquery-3.7.1.js"></script>
</head>
<script>
/*
	jQuery.get() = $.get()
	- 서버에 데이터를 HTTP GET 방식으로 요청한다.
	- $.get() 함수를 이용해서 data.csv 파일을 불러온다.
	- $.get() 함수의 첫 번째 매개변수에는 서버의 URL 주소를 지정한다.
	- $.get() 함수의 두 번째 매개변수에는 콜백함수를 이용해서 서버에서 보내온 csv 형식의 데이터를 매개변수(input)로 받는다.
*/
	$(function(){
		$('button').click(function(){
			let output = '';
			$.get("data.csv", function(input) { // URL, 콜백 함수
				output += '<table class="table">';
				output += '<thead></thaed>';
				output += '<tbody>';
				output += '<tr> <th>이름</th> <th>지역</th> <th>나이</th> </tr>'
				
				input.split('\n').forEach(line => {
					
					output += '<tr>';
					
					line.split(',').forEach(item => {
						output += '<td>' + item.trim() + '</td>';
					});
					
					output += '</tr>'
				});
			
				output += '</tbody> </table>';
			
				$('pre').html(output);
			});
		});
	});
</script>
<body>
	<div class="container">
		<button class="btn btn-primary my-3">데이터 불러오기</button>
		<pre>변경 전</pre>
	</div>
</body>
</html>