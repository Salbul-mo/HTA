<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=request.getContextPath() %>/css/ch03-5.css" type="text/css" rel="stylesheet">
<title>부서번호 검색</title>
</head>
<body>
	<form action="search">
		<b>검색할 부서 번호를 입력하세요</b><br>
			<input type="text" name="deptno"
						required pattern="[0-9]{2}">
			<input type="submit" value="전송">
	</form>
</body>
</html>