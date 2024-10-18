<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 사용하기</title>
<link href="../css/form.css" rel="stylesheet" type="text/css">
</head>
<body>
  <form action="process.jsp">
	<span>이름</span><input type="text" placeholder="이름을 입력하세요" id="name" name="name" required> <br>
	<span>나이</span><input type="text" placeholder="나이를 입력하세요" id="age" name="age" required> <br>
	<span>주소</span><input type="text" placeholder="주소를 입력하세요" id="address" name="address" required> <br>
	<input type="submit" value="전송">
  </form>
</body>
</html>