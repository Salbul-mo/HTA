$(function() {
	$("button").click(function() {
		location.href = "write";
	});

	$("#viewcount").change(function() { // 페이지 limit 바꿀 때 1페이지로 이동
		go(1); // 보여줄 페이지를 1페이지로 변경한다.
	}); // change end
});

	function go(page) {
		const limit = $('#viewcount').val();
		// const data = `limit=${limit}&state=ajax&page=${page}`;
		const data = { limit: limit, state: "ajax", page: page } // 오브젝트 형태로 생성
		ajax(data);
	};
	
	function setPaging(href, digit, isActive = false) { // isActive 가 안넘어오면 default로 false
		const gray = (href === '' && isNaN(digit)) ? "gray" : ""; 
		// href 변수가 null 이고 digit 변수가 숫자가 아니면 gray 클래스 추가
		const active = isActive ? "active" : "";
		// isActive 값에 따라 active 클래스 추가 default 는 false
		const anchor = `<a class="page-link ${gray}" ${href}>${digit}</a>`;
		return `<li class="page-item ${active}">${anchor}</li>`;
	};
	
	function generatePagenation(data) {
		let output = "";
		
		// 이전 버튼
		let prevHref = data.page > 1 ? `href=javascript:go(${data.page - 1 })` : ""; 
		// 현재 페이지가 1보다 크면 현재 페이지-1 한 값으로 go 함수 호출 => ajax 함수 실행 => 출력 
		output += setPaging(prevHref, '이전&nbsp;');
		// 이전 버튼
		
		for (let i = data.startPage; i <= data.endPage; i++) {
			const isActive = (i === data.page); // 현재 페이지 값과 같은지 true false
			let pageHref = !isActive ? `href=javascript:go(${i})` : ""; // 백틱 안에 i(page-item)
			output += setPaging(pageHref, i, isActive);
			
		}
		
		let nextHref = (data.page < data.maxPage) ? `href=javascript:go(${data.page + 1})` : "";
		output += setPaging(nextHref, '&nbsp;다음&nbsp;')
		
		$('.pagination').empty().append(output); // pagination 클래스 객체 비우고 append
		
	}
	
	function updateBoardList(data) {
		let num = data.listCount - (data.page - 1) * data.limit; // 페이지에 따른 번호 차감
		let output = "<tbody>";

		$(data.boardList).each(function(index, item) {
			const blank = '&nbsp;&nbsp;'.repeat(item.board_re_lev * 2); // 답변이면 공백 들여쓰기
			const img = item.board_re_lev > 0 ? "<img src='../image/line.gif'>" : "";
			const subject = item.board_subject.length >= 20 // 제목 길면 중략
				? item.board_subject.substr(0, 20) + "..." : item.board_subject;
			const changeSubject = subject.replace(/</g, '&lt;').replace(/>/g, '&gt;');
			// 제목 안의 <> 특수 기호 html 문자에 맞게 변경 

			output += `
					<tr>
						<td>${num--}</td>
						<td><div>${blank}${img}<a href='detail?num=${item.board_num}'>${changeSubject}</a>[${item.cnt}]</div></td>
						<td><div>${item.board_name}</div></td>
						<td><div>${item.board_date}</div></td>
						<td><div>${item.board_readCount}</div></td>
					</tr>
					`;
		});
		output += "</tbody>";
		$('table').append(output);
	};
	
	function ajax(sdata) {
		console.log(sdata);
		$.ajax({
			data: sdata, // 보내는 데이터
			url: "list",
			dataType: "json", // 받는 데이터 타입
			cache: false,
			success: function(data) { // 받은 데이터로 실행
				$("#viewcount").val(data.limit);
				$("thead").find("span").text("글 개수 : " + data.listCount); // 총 게시물 수 출력

				if (data.listCount > 0) {
					$("tbody").remove();
					updateBoardList(data); // 게시판 내용 업데이트 함수
					generatePagenation(data); // 페이지네이션 생성 함수
				}
			},
			error: function() {
				console.log("에러");
			}
		});
	};
