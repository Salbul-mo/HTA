<%-- sample1.txt 파일 -> properties -> utf-8로 작성 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample1</title>
<link rel="icon" href="${pageContext.request.contextPath}/image/house-icon.svg">
<link href="../css/ex1.css" rel="stylesheet" type="text/css">
<script src="../js/jquery-3.7.1.js"></script>
</head>
<body>
	<button>변경</button>
	<p>변경 전 : 줄이 안바뀌어요</p>
	<br>
	<pre>변경 전: 줄이 바뀝니다.(입력한 대로 출력됩니다.)</pre>
</body>
</html>