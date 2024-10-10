<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 테스트</title>
<style>
	body {
		margin:0px;
	}
	
	span {
		background:yellow;
	}
	
	footer {
		position:fixed;
		bottom:0px;
		width:100%
	}
	
	body>footer>h3 {
		background:lightgray;
		text-align:center;
		margin:0px;
		height:3rem;
		line-height:3rem;
	}
	
	header div {
		padding:1%;
		text-align:right;
		background:green;
		color:white;
	}
	
	a {
		text-decoration:none;
		color:white;
	}
	
	a:hober {
		font-weight:bold;
	}

</style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<h1>template.jsp 파일 입니다.</h1>
	<span>header.jsp의 id 값 입니다 : <%=id %></span>
	<%@ include file="footer.jsp" %>
</body>
</html>