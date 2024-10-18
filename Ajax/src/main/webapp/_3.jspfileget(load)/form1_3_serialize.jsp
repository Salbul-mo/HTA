<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax 사용하기</title>
<link href="../css/form.css" rel="stylesheet" type="text/css">
<script src="../js/jquery-3.7.1.js"></script>
<script>
	$(function(){
		$('form').submit(function(e) {
			e.preventDefault(); // 기본 이벤트 제거
			// 서버로 보낼 데이터를 폼에서 얻어온다.
			// 입력 양식에 적힌 값을 serialize 메서드를 통해 쿼리스트링으로 바꾼다.
			const data=$('form').serialize();
				console.log(data); // 예) name=love&age=21&address=Seoul 
			
				$('div').load('process.jsp', data);
			/*
			load( url [,data] [, complete] )
					① url : 정보를 요청할 URL
					② data : 서버에 보낼 데이터
						=> 	submit 시 페이지 이동을 preventDefault() 메서드로 막고
							ajax 로 요청을 전달할 때
							s
							process.jsp 가 처리되면 div 태그에 process.jsp를 로드한다. 
			*/
		});
	});

</script>
</head>
<body>
  <form>
  <%--
  	form 태그의 action 속성이 없다. 이 상태에서 전송을 클릭하면 현재 URL을 다시 불러온다.
   --%>
	<span>이름</span><input type="text" placeholder="이름을 입력하세요" id="name" name="name" required> <br>
	<span>나이</span><input type="text" placeholder="나이를 입력하세요" id="age" name="age" required> <br>
	<span>주소</span><input type="text" placeholder="주소를 입력하세요" id="address" name="address" required> <br>
	<input type="submit" value="전송">
  </form>
  <div></div>
</body>
</html>