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
  <script src="../../js/jquery-3.7.1.js"></script>

  <style>
  	span {
  		color:red;
  	}
  
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
  	</div>
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
	function getData() {
    		  		
			$.ajax({
				url : "${pageContext.request.contextPath}/dept_lib", // 요청 전송 url
				type : "post",
				dataType : "json",	// return data 의 Type (에이잭스 성공 후 돌려받은 자료형을 정의)
				cache : false,
				success : function(rdata) { // HTTP 요청이 성공한 경우 실행할 함수 정의(이벤트 핸들러)
											// rdata 는 서버에서 보낸 데이터이다.
					$("button+div").remove();
					
					let str = "<table class='table'><thead><tr><th>부서번호</th><th>부서명</th><th>지역</th></tr></thead><tbody>";
					
					$(rdata).each(function(index, item) {
						str += "<tr>";
						str += "<td>" + item.deptno + "</td>";
						str += "<td>" + item.dname + "</td>";
						str += "<td>" + item.loc + "</td>";
						str += "</tr>";
					});
					str += "</tbody></table>";
					$('.container').append(str);
				},
				error : function(request, status, error) {
					$('.container').append('<div id="error">code :'
							+ request.status + '<br>'
							+ '받은 데이터 : ' + request.responseText + '<br>'
							+ 'error status : ' + status + '<br>'
							+ 'error 메시지 : ' + error + '</div>');
				},
				complete : function() { // 요청이 실패, 성공 상관없이 완료될 경우 호출
					$('.container').append('<div id="com">Ajax가 완료되었습니다.</div>');
				}
		});
		
	};
	
	getData();
  </script>
</body>
</html>