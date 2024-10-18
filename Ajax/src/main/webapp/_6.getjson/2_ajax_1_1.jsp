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
  <script>
  	/*
  		$.ajax(object)
  			① url : 요청 전송 url,
  			② type : 전송 방식 (get(기본) 또는 post),
  			③ data : 전송할 자료들,
  			④ cache : false 를 설정하면 jQuery는 Ajax 요청에 대해 브라우저의 캐시를 사용하지 않도록 한다.
  					  이렇게 하면 매번 서버로부터 최신 데이터를 가져오며, 캐시된 응답을 사용하지 않는다.
  			⑤ dataType : return data 의 Type (에이잭스 성공 후 돌려받은 자료의 형을 정의 - "json", "xml", "html"),
  			⑥ success : HTTP 요청이 성공한 경우 실행할 함수 정의,
  			⑦ error : HTTP 요청이 실패한 경우 실행할 함수 정의,
  			⑧ complete : 요청의 실패, 성공과 관계 없이 완료될 경우 실행할 함수 정의
  	*/
	$(function() {
		$('button').click(function() {
			$("table").remove(); // 테이블이 존재하면 제거 반복 실행시 중복을 방지한다.
			$(".container div").remove() // div 요소 제거 반복 실행 시 중복을 방지한다.
    		  		
			$.ajax({
				url : "item.json", // 요청 전송 url
				dataType : "json",	// return data 의 Type (에이잭스 성공 후 돌려받은 자료형을 정의)
				cache : false,
				success : function(rdata) { // HTTP 요청이 성공한 경우 실행할 함수 정의(이벤트 핸들러)
											// rdata 는 서버에서 보낸 데이터이다.
  					let str = '<table class="table">' 
  							+ '<thead><tr><th>id</th><th>name</th><th>price</th>'
  						  	+ '<th>description</th></tr></thead><tbody>';
  					
  					$(rdata).each(function(index, item) {
  						  str += '<tr>';
  					 
  						  for (var p in item) {
  							  str += '<td>' + item[p] + '</td>';
  						  }
  						  
  						  str += '</tr>';
  					 });
  				
  					str += '</tbody> </table>';
  				
  				  	$('button').after(str);
  				  	// append 또는 after 는 잘못 사용하면 계속해서 생성되므로 유의한다.
				},
				error : function(request, status, error) {
					$('.container').append('<div id="error">code :'
							+ request.status + '<br>'
							+ '받은 데이터 : ' + request.responseText + '<br>'
							+ 'error status : ' + status + '<br>'
							+ 'error 메시지 : ' + error + '</div>');
					/*
					에러 함수 출력
					code :200
					받은 데이터 : [ { "id": "1", "name": "레몬", "price": " 3000", "description": "레몬에 포함되어 있는 홍정원은 피로회복에 좋다.비타민C도 풍부하다." }
					{ "id": "2", "name": "키위", "price": " 2000", "description": "비타민C가 매우 풍부하다. 다이어트와 미용에도 매우 좋다." }, 
					{ "id": "3", "name": "블루베리", "price": " 5000", "description": "블루베리에 포함된 anthocyanin(안토시아닌)은 눈피로에 효과가 있다." }, 
					{ "id": "4", "name": "체리", "price": " 5000", "description": "체리는 맛이 단 성분이 많고 피로회복에 잘 듣는다." }, 
					{ "id": "5", "name": "메론", "price": " 5000", "description": "메론에는 비타민A와 칼륨이 많이 포함되어 있다." }, 
					{ "id": "6", "name": "수박", "price": "15000", "description": "수분이 풍부한 과일이다." } ]
					error status : parsererror
					error 메시지 : SyntaxError: Expected ',' or ']' after array element in JSON at position 133 (line 8 column 3)
					Ajax가 완료되었습니다.
					*/
				},
				complete : function() { // 요청이 실패, 성공 상관없이 완료될 경우 호출
					$('.container').append('<div id="com">Ajax가 완료되었습니다.</div>');
					console.log('ajax() - complete');
				}
		});
		
		console.log('ajax() 뒤');
		/*
		ajax() 뒤
		2_ajax_1_1.jsp:64 ajax() - complete
		*/ 
	});
	});
  </script>
  <style>
  	#com {
  		color:blue;
  	}
  	#error {
  		color:green;
  	}
  </style>
<title>ajax 메서드</title>
</head>
<body>
	<div class="container">
	<button class="btn btn-info">데이터 불러오기</button>
  	</div>
</body>
</html>