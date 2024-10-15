<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX</title>
</head>
<body>
	<%--
		4>=3 인 경우 <a class="page-link gray">&nbsp;다음</a>
		4>=3 아닌 경우 <a class="page-link">&nbsp;다음</a>
	 --%>
	 
	 <a class="page-link ${4 >= 3 ? 'gray' : ''}">&nbsp;다음</a>
	
	<%--또는--%> 	
	
	 <a class="${4 >= 3 ? 'page-link gray' : 'page-link'}">&nbsp;다음</a>
	 
	 <%--
	 	JSP가 가장 먼저 해석이 되기 때문에 ${}은 EL로 해석이 된다.
	 	따라서 JSP 에서는 백틱을 사용해서는 안된다. js 에서만 사용한다.
	  --%>
	
</body>
</html>