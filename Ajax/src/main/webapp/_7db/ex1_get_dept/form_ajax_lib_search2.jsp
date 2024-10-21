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
		<h3 class="mt-5">검색할 부서 번호를 입력하세요</h3>
		<form class="mb-3">
			<div class="row">
				<input type="search" name="deptno" required pattern="[0-9]{2}" class="form-control col-8 ml-3">
				<button class="btn btn-info">검색</button>
			</div>
		</form>
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
	function getData(go, senddata) {
  		console.log(senddata);		
    		  		
		$.ajax({
			url : "${pageContext.request.contextPath}/" + go, // 요청 전송 url
			type : "post",
			data : {"deptno" : senddata},
			dataType : "json",	// return data 의 Type (에이잭스 성공 후 돌려받은 자료형을 정의)
			cache : false,
			success : function(rdata) { // HTTP 요청이 성공한 경우 실행할 함수 정의(이벤트 핸들러)
										// rdata 는 서버에서 보낸 데이터이다.
				$("div table").remove();
				
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
			}
		});
	};
	
	getData('dept_lib'); // 매개변수 하나
	
	$('button').on("click", function(e){
		
		e.preventDefault();
		const senddata = $('input').val().trim();
		
		if (senddata != null && senddata == "") {
			getData('dept_lib');
			
		} else {
			getData('dept_lib_search', senddata); // 매개변수 둘
			
		}
	});
		
  </script>
</body>
</html>