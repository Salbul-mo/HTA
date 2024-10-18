<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 예제</title>
<link rel="icon" href="${pageContext.request.contextPath}/image/house-icon.svg">
</head>
<body>
	<script>
		console.log("1");
		
		// 비동기 처리 : 아래의 코드가 실행 중이지만 다음 명령의 코드가 실행
		setTimeout(function(){
			console.log("2");
		}, 3000);
		
		console.log("3");
	</script>
	<!-- 
		1 1_0_Asyn.jsp:18 
		3 1_0_Asyn.jsp:15 
		2 1_0_Asyn.jsp:15 
	 -->
</body>
</html>