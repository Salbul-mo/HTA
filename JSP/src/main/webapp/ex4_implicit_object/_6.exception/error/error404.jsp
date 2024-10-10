<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
    	body, html {
    	text-align:center;
    	background:beige;
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
<title>404 오류</title>
</head>
<body>
		<span>404 error</span><br>
		<strong>요청한 페이지는 존재하지 않습니다.</strong>
		<br>
		<br> 주소를 올바르게 입력했는지 확인해 보시기 바랍니다.
</body>
</html>