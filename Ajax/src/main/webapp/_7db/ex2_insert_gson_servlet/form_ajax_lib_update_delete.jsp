<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <link rel="icon" href="${pageContext.request.contextPath}/image/house_icon.svg">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <script src="../../js/jquery-3.7.1.js"></script>

  <style>
  	.container {
  		width:50%;
  	}
  </style>
  <title>DB Basic</title>
</head>
<body>
  <div class="container">
	<form id="insert-form">
	  <fieldset>
		<legend>데이터 추가/삭제/수정</legend>
		  <table class="table">
			<tr>
			  <th><label>데이터 추가/삭제/수정</label></th>
			  <td><input type="text" name="name" class="form-control" id="name" required></td>
			</tr>
			<tr>
			  <th><label>가격</label></th>
			  <td><input type="text" name="price" class="form-control" id="price" required pattern="[0-9]+"></td><%--숫자 1개 이상 --%>
			</tr>
			<tr>
			  <th><label>메이커</label></th>
			  <td><input type="text" name="maker" class="form-control" id="maker" required></td>
			</tr>
			<tr>
			  <td colspan=2>
			    <button type="submit" class="btn btn-primary btn-block">추가</button>
			  </td>
			</tr>
		 </table>
	  </fieldset>
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
  	
  	// get 방식 전송 시 데이터 가져오기, post 방식 전송 시 삽입 삭제 또는 수정과 데이터 가져오기
	function selectData(method, label) {
		$("#result").remove();
    	
		let senddata = "";
    	
		if (label == '추가' || label == '수정완료'){
    		senddata = $('#insert-form').serialize() + "&label=" + label;
    	} else if (label == '삭제') {
    		senddata = {id : $('input:hidden').val(), label : label};
    	}
		
    	$.ajax({
			url : "${pageContext.request.contextPath}/product2",// 요청 전송 url
			type : method, // get or post
			data : senddata, // 보낼 데이터 없으면 undefined
			dataType : "json",	// return data 의 Type (에이잭스 성공 후 돌려받은 자료형을 정의)
			cache : false,
			success : function(rdata) { // HTTP 요청이 성공한 경우 실행할 함수 정의(이벤트 핸들러)
										// rdata 는 서버에서 보낸 데이터이다.
				if(rdata.length > 0) {						
					
					let str = "<div id='result'><table class='table'><thead><tr><th>아이디</th><th>제품명</th><th>가격</th><th>제조사</th><th>수정</th><th>삭제</th></tr></thead><tbody>";
					
					$(rdata).each(function(index, item) {
						str += "<tr>";
						str += "<td>" + item.id + "</td>";
						str += "<td>" + item.name + "</td>";
						str += "<td>" + item.price + "</td>";
						str += "<td>" + item.maker + "</td>";
						str += "<td><button type='button' id='update' class='btn btn-warning btn-sm'>수정</button></td>";
						str += "<td><button type='button' id='delete' class='btn btn-danger btn-sm'>삭제</button></td>";
						str += "</tr>";
					});
					
					str += "</tbody></table></div>";
					
					$('.container').append(str);
					$('input').val(''); // form 초기화
					
				} else {
					$('.container').append('<div id="result">데이터가 존재하지 않습니다.</div>');
				}
			},
			error : function(request, status, error) {
				$('.container').append('<div id="result"> code :'
						+ request.status + '<br>'
						+ '받은 데이터 : ' + request.responseText + '<br>'
						+ 'error status : ' + status + '<br>'
						+ 'error 메시지 : ' + error + '</div>');
			},
			complete : function() { // 요청이 실패, 성공 상관없이 완료될 경우 호출
				console.log('complete');
				$('input[type=hidden]').remove();
				// 생성된 hidden input 삭제
			}
		});
	};
	
	selectData("get"); // get 방식으로 조회 실행
	
	$('#insert-form').submit(function(e) {
		e.preventDefault();
		
		const label = $(this).find('button').text();
		selectData("post", label);
		
		if (label == '수정완료') {
			$('button:submit').text('추가').removeClass('btn-success').addClass('btn-primary');
			// 수정완료 버튼 추가로 바꾸기.
			$('button.btn-danger').prop('disabled', false);
			// 수정완료 클릭하면 삭제 버튼 사용 가능하게
		}
	});
		
	// $('#update').on("click", function(e) 작동 안한다. => 로드된 이후 에이잭스로 생성된 객체는 인식 안됨.
	$('body').on('click', '.btn.btn-warning', function() {
	// .on( events [, selector ] [, data ], handler ) selector 를 통해 에이잭스로 생성된 객체 인식할 수 있다.
		
		const tr = $(this).parent().parent();
		const id = tr.find('td:nth-child(1)').text();
		const name = tr.find('td:nth-child(2)').text();
		const price = tr.find('td:nth-child(3)').text();
		const maker = tr.find('td:nth-child(4)').text();
			
		$('#name').val(name);
		$('#price').val(price.replace(/,/g , "")); // 가격에서 콤마를 없애준다.
		$('#maker').val(maker);
			
		$('button:submit').text('수정완료').removeClass('btn-primary').addClass('btn-success');
			
		$('input:hidden').remove();
		// 복수 생성 방지를 위해 삭제.
			
		$('button:submit').after('<input type="hidden" name="id" value="' + id + '">');
		// 업데이트 시 필요한 값 전달 위해 숨겨놓은 input 에 id 값 저장.
			
		$('button.btn-danger').prop("disabled", true);
	});
	
	$('body').on('click', '.btn.btn-danger', function(){
		
		let check = confirm('정말 삭제하시겠습니까?');
		
		if (check) {
			const tr = $(this).parent().parent();
			const id = tr.find('td:nth-child(1)').text();
			
			$('input:hidden').remove();

			$('button:submit').after('<input type="hidden" name="id" value="' + id + '">');
			// 삭제를 위한 id 값 저장.
			
			selectData("post", '삭제');
		} 
	});
  </script>
</body>
</html>