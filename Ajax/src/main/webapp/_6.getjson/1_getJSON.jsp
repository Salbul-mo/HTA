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
    	1. JSON 은 JavaScript Object Notation 의 약어로 XML 데이터를 대신하기 위해서 사용한다.
    	2. JSON 은 키와 값을 쌍으로 가지는 구조이다.
    	3. 배열을 사용할 때는 대괄호([ ]) 안에 중괄호({ }) 를 사용하여 조합한다.
    	4. jQuery 에서는 JSON 으로 표현한 데이터를 파일에 저장해 두었다가 필요할 때 이를 로드할 수 있는
    		$.getJSON() 메서드를 제공한다.
    	5. 서버로부터 get 방식의 요청을 하고, 응답을 JSON 형식으로 받기 위해
    		$.getJSON() 메서드를 사용한다.
    		(1) $.getJSON() 메서드의 첫 번째 매개변수는 서버의 URL 주소를 지정한다.
    		(2) 서버로 요청이 성공적으로 완료되면, 두 번째 매개변수로 기술한 콜백함수가 호출된다.
    			형식) function(data, textStatus)
    				① 콜백함수의 첫 번째 매개변수인 data 는 서버에서 돌려받은 JSON 객체 형식의 데이터이다.
    				② 두 번째 매개변수인 textStatus 는 성공일 때 "success" 라는 문자열이 전달된다.
    		(3) 자바스크립트의 JSON 객체는 JSON 데이터를 자바스크립트 객체로 변환할 수 있다.
    			또한 자바스크립트 객체를 문자열로 변환하기도 한다.
    			① JSON.stringify() 메서드
    				: 자바스크립트 객체를 JSON 형식의 문자열로 변환한다.
    				  이를 이용해서 자바스크립트 객체를 브라우저로부터 다른 애플리케이션으로 전송할 수 있다.
    			② JSON.parse() 메서드
    				: JSON 데이터를 브라우저가 사용할 수 있는 자바스크립트 객체로 변환한다.
    */
    $(function() {
    	$('button').click(function() {
    		$.getJSON('item.json', function(data, textStatus) {
    			console.log('data='+data);
    			console.log('textStatus='+textStatus);
    			console.log('JSON.stringfy(data)='+JSON.stringify(data));
    			if (data.length>0) {
    				$("table").remove(); // 테이블이 존재하면 제거
    		  		
    				  let str = '<table class="table">' 
    						  + '<thead><tr><th>id</th><th>name</th><th>price</th>'
    					  	  + '<th>description</th></tr></thead><tbody>';
    				  $(data).each(function(index, item) {
    					  str += '<tr>';
    					 
    					  for (var p in item) {
    						  str += '<td>' + item[p] + '</td>';
    					  }
    					  
    					  str += '</tr>';
    				  });
    				
    				  str += '</tbody> </table>';
    				
    				  $('button').after(str);
    				  // append 또는 after 는 잘못 사용하면 계속해서 생성되므로 유의한다.
    			} else {
    				$('button').after("<div>데이터가 존재하지 않습니다.</div>");
    			}
    		});
    	});
    });
    			/*
    			콘솔 출력 결과
				data=[object Object],[object Object],[object Object],[object Object],[object Object],[object Object]  1_getJSON.jsp:38 
				textStatus=success 1_getJSON.jsp:39 
				JSON.stringfy(data)=[
					{"id":"1","name":"레몬","price":" 3000","description":"레몬에 포함되어 있는 쿠엔산은 피로회복에 좋다.비타민C도 풍부하다."},
					{"id":"2","name":"키위","price":" 2000","description":"비타민C가 매우 풍부하다. 다이어트와 미용에도 매우 좋다."},
					{"id":"3","name":"블루베리","price":" 5000","description":"블루베리에 포함된 anthocyanin(안토시아닌)은 눈피로에 효과가 있다."},
					{"id":"4","name":"체리","price":" 5000","description":"체리는 맛이 단 성분이 많고 피로회복에 잘 듣는다."},
					{"id":"5","name":"메론","price":" 5000","description":"메론에는 비타민A와 칼륨이 많이 포함되어 있다."},
					{"id":"6","name":"수박","price":"15000","description":"수분이 풍부한 과일이다."}] 1_getJSON.jsp:40 
    			*/
  </script>
  <title>JSON 예제</title>
</head>
<body>
  <div class="container">
	<button class="btn btn-info my-3">데이터 불러오기</button>
  </div>
</body>
</html>