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
<script>
	$(function(){
		
		function error(responseTxt, status, xhr){ // 콜백 함수
			if (status == "success") {
				alert("status == success\n" + responseTxt);
			} else if (status == "error") { // 없는 파일 sample2.txt 
				alert("xhr.status : " + xhr.status // 404
				+ "\n xhr.statusText : " + xhr.statusText); 
			}
		}
		
		$("button").click(function(){ // 변경 버튼을 클릭하면
			$("button").text('로딩완료').css('color','red');
			
			// <p>태그 영역에 "sample2.txt" 의 내용을 불러온다.
			$("p").load("sample2.txt", error); // error를  콜백 함수 파라미터로 넣는다.
		});
	});
</script>
</head>
<body>
	<button>변경</button>
	<p>변경 전 : 줄이 안바뀌어요</p>
</body>
<!-- 
alert 창
xhr.status :  404
xhr.statusText : error 
 -->
</html>
