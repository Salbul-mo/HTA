<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX</title>
</head>
<style>
	.gray {
		font-weight:bold;
		color:gray;
	}
</style>
<body>
	<%--
		pageContext 에 page 속성값을 4
		pageContext 에 maxPage 속성값을 3 으로 설정한다.
		
		page >= MaxPage 인 경우 <a class="page-link gray">&nbsp;다음</a>
		page < MaxPage 인 경우 <a class="page-link">&nbsp;다음</a>
		
		gray 클래스가 적용되면 회색의 굵은 글자가 되도록 한다.
	 --%>
	 <%
	 	pageContext.setAttribute("page", 4);
	 	pageContext.setAttribute("maxPage", 3);
	 %>
	 
	 <a class='page-link ${param.page >= param.maxPage ? "gray" : ""}'>&nbsp;다음</a>
	 <hr>
	 <a class='${param.page >= param.maxPage ? "page-link gray" : "page-link"}'>&nbsp;다음</a>
	
</body>
</html>