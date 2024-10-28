$(function() {
	$("button").click(function() {
		location.href = "write";
	});

	function go(page) {
		const limit = $('#viewcount').val();
		// const data = `limit=${limit}&state=ajax&page=${page}`;
		const data = { limit: limit, state: "ajax", page: page } // 오브젝트 형태로 생성
		ajax(data);
	};

	$("#viewcount").change(function() { // 페이지 limit 바꿀 때 1페이지로 이동
		go(1); // 보여줄 페이지를 1페이지로 변경한다.
	}); // change end
	
	function setPaging(href, digit, isActive = false) {
		const gray = (href === '' && isNaN(digit)) ? "gray" : "";
		const active = isActive ? "active" : "";
		const anchor = `<a class="page-link ${gray}" ${href}>${digit}</a>`;
		return `<li class="page-item ${active}"> ${anchor}</li>`;
	}
	
	function generratePagination(data) {
		let output = "";
		
		// 이전 버튼
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

})