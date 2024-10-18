<%-- sample1.txt 파일 -> properties -> utf-8로 작성 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서버의 데이터를 대상 엘리먼트에 삽입하기</title>
<link href="../css/ex1.css" rel="stylesheet" type="text/css">
<script src="../js/jquery-3.7.1.js"></script>
<script>
	$(function(){
		$("button").click(function(){ // 변경 버튼을 클릭하면
			$("button").text('로딩완료').css('color','red');
			// <p>태그 영역에 "resource1.html" 의 내용을 불러온다.
			$("#container").load("resource1.html");
		});
	});
</script>
</head>
<body>
	<button>서버로부터 데이터 가져오기</button>
	<div id="container">데이터 가져오기 전</div>
	<!-- 
	변경 후  
	<div id="container">
	  <b>안녕하세요~ </b>
	</div>
	-->
</body>
</html>