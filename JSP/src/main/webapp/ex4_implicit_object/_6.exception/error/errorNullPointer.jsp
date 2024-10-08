<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
    	body, html {
    	text-align:center;
    	background:mistyrose;
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
    	
    	h1 {animation:textColor 3s infinite;
    		color:yellow;
    	}
    </style>
<meta charset="UTF-8">
<title>Null 오류</title>
</head>
<body>
		<div>
			<h1>서비스 처리 과정에서 널(NullPointerException) 오류가 발생했습니다.</h1>
		</div>
</body>
</html>