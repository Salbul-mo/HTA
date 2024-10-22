<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <style>
    	body, html {
    	text-align:center;
    	background:skyblue;
    	}
    	
    	div {
    		width:100%;
    		margin:100px auto;
    	}
    			
    	@keyframes textColor {
    		0% {color:yellow;}
    		25% {color:green;}
    		50% {color:blue;}
    		75% {color:magenta;}
    		100% {color:yellow;}
    	}
    	
    	span {
    		animation:textColor 3s infinite;
    		color:yellow;
    		font-size:50px;
    	}
    </style>
<meta charset="UTF-8">
<title>500 오류</title>
</head>
<body>
		<span>500 error</span><br>
		<strong>요청한 페이지에 서버 내부 에러 발생</strong>
</body>
</html>