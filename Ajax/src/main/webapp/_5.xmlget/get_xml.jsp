<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <script src="../js/jquery-3.7.1.js"></script>
<title>xml 사용 예제</title>
<script>
  $(function(){
	$('button').click(function(e) {
	  $.get("item.xml", function(input){ // get 의 콜백 메서드 안에 수행이 완료되어야 한다.
		$("table").remove(); // 테이블이 존재하면 제거
		  		
		  let str = '<table class="table">' 
				  + '<thead><tr><th>id</th><th>name</th><th>price</th>'
			  	  + '<th>description</th></tr></thead><tbody>';
			  	
			  
		  // 객체로 가져온 xml에서 필요한 태그 검색 => 배열로 반환된 객체에 each 메서드로 함수 실행 (for 문)
		  $(input).find('item').each(function(index, selector) {
			str += '<tr>';
			str += '<td>' + $(selector).attr("id").trim() + '</td>';
			str += '<td>' + $(selector).attr("name").trim() + '</td>';
			str += '<td>' + $(selector).find("price").text().trim() + '</td>';
			str += '<td>' + $(selector).find("description").text().trim() + '</td>';
			str += '</tr>';
		  });
		
		str += '</tbody> </table>';
				
		$('.container').append(str);
		// 맨 처음 위치한 container 클래스 마지막 자식으로 추가.
	  });
	});
  });
</script>
</head>
<body>
	<div class="container">
		<button class="btn btn-primary my-3">데이터 불러오기</button>
	</div>
</body>
</html>