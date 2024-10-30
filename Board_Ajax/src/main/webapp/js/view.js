let option = 1; // 등록순 최신순을 수정, 삭제, 추가 후에도 유지되도록 하기 위한 변수로 사용된다.
let reply_isRun = false;
function getList(state) {
	console.log(state);
	option = state;
	$.ajax({
		type: "get",
		url: "../comments/list",
		data: {
				"comment_board_num" : $("#comment_board_num").val(),
				state: state
		},
		dataType: "json",
		success: function(rdata) {
			$('#count').text(rdata.listCount).css('font-family', 'arial,sans-serif'); // 댓글 수 출력
			let red1 = (state == 1) ? 'red' : 'gray'; // 선택된 기준이 빨간색
			let red2 = (state == 2) ? 'red' : 'gray';
			
			let output = `
				<li class='comment-order-item ${red1}'>
					<a href='javascript:getList(1)' class='comment-order-button'>등록순</a>
				</li>
				<li class='comment-order-item ${red2}'>
					<a href='javascript:getList(2)' class='comment-order-button'>최신순</a>
				</li>`; // state 값을 바꿔 getList 호출
				
			$('.comment-order-list').html(output);
			
			output = ''; // 초기화
			if (rdata.commentList.length) {
				rdata.commentList.forEach(comment => {
					let lev = comment.comment_re_lev;
					let replyClass = (lev == 1)
					? 'comment-list-item--reply lev1' : (lev == 2) ? 'comment-list-item--reply lev2' : '';
					
					let src = comment.memberfile
					? `../memberupload/${comment.memberfile}` : '../image/profile.png';
					
					let replyButton = (lev < 2)
					? `<a href='javascript:replyform(${comment.num},${lev},${comment.comment_re_seq},${comment.comment_re_ref})' class='comment-info-button'>답글쓰기</a>` : '';
					
					// 로그인 한 사람이 댓글 작성자인 경우
					let toolButtons = $("#loginid").val() == comment.id ? `
						<div class='comment-tool'>
							<div title='더보기' class='comment-tool-button'>
								<div>&#46;&#46;&#46;</div>
							</div>
							<div id='comment-list-item-layer${comment.num}' class='LayerMore'>
								<ul class='layer-list'>
									<li class='layer-item'>
										<a href='javascript:updateForm(${comment.num})' class='layer-button'>수정</a>
										<a href='javascript:del(${comment.num})' class='layer-button'>삭제</a>
									</li>
								</ul>
							</div>
						</div>` : '';
					// div title => 마우스 올렸을 때 툴팁에 출력될 내용 &#46;&#46;&#46; => 세로 점 세개
					// .comment-tool-button div {transform: rotate(90deg); color: #979797}
					output += `
						<li id='${comment.num}' class='comment-list-item ${replyClass}'>
							<div class='comment-nick-area'>
								<img src='${src}' alt='프로필 사진' width='36' height='36'>
								<div class='comment-box'>
									<div class='comment-nick-box'>
										<div class='comment-nick-info'>
											<div class='comment-nickname'>${comment.id}</div>
										</div>
									</div>
									<div class='comment-text-box'>
										<p class='comment-text-view'>
											<span class='text-comment'>${comment.content}</span>
										</p>
									</div>
									<div class='comment-info-box'>
										<span class='comment-info-date'>${comment.reg_date}</span>
										${replyButton}
									</div>
									${toolButtons}
								</div>
							</div>
							</li>`;
				});
				
				$('.comment-list').html(output);
			}
			
			if (!rdata.commentList.length) { // 0이면 false
				$('.comment-list, .comment-order-list').empty(); // 서식 비우기
			}
		} // success end
	}); // ajax() end
}; //function getList end

// 더보기 - 수정 클릭한 경우에 수정 폼을 보여준다.
function updateForm(num) {
	$(".comment-tool, .LayerMore").hide(); // 더보기 및 수정 삭제 영역 숨김
	let $num = $('#' + num); // 파라미터로 받은 num(comm 테이블 num 칼럼) 을 이용해 아이디를 만들고 문서 객체 선언
	const content = $num.find('.text-comment').text(); // 선택한 댓글 내용
	
	$num.find('.comment-nick-area').hide(); 
	// 댓글 뱍스 역할하는 div hide. 대신 댓글 수정용 form 복사해서 가져온다. 취소하면 다시 show
	$num.append($('.comment-list+.comment-write').clone()); // 기본 글쓰기 폼 복사하여 추가
	
	// 수정 폼의 <textarea> 에 내용을 나타낸다.
	$num.find('.comment-write textarea').val(content);
	
	// '.btn-register' 영역에 수정할 글 번호를 속성 'data-id' 에 나타내고 클래스 'update' 를 추가한다.
	$num.find('.btn-register').attr('data-id', num).addClass('update').text('수정완료');
	
	// 폼에서 취소를 사용할 수 있도록 보이게 한다.
	$num.find('.btn-cancel').show();
	
	// 글자 수 표시
	$num.find('.comment-write-area-count').text(`${content.length}/200`);	
}

function del(num) {
	if (!confirm('정말 삭제하시갰습니까')) {
		$('#comment-list-item-layer' + num).hide(); // '수정 삭제' 영역 숨기기
		return;
	}
	
	$.ajax({
		url: '../comments/delete',
		data: {num: num},
		success: function(rdata) {
			if (rdata == 1) {
				getList(option);
			}
		}
	});
};

function replyform(num, lev, seq, ref) {
	
	if (reply_isRun) {
		return false;
	}
	
	reply_isRun = true;
	
	// 수정 삭제 영역 선택 후 답글 쓰기를 클릭한 경우
	$(".LayerMore").hide(); // 수정 삭제 영역 숨기기
	
	let $num = $('#' + num); // 댓글을 달 대상 객체
	// 답글 폼 추가
	$num.after(`<li class="comment-list-item comment-list-item--reply lev${lev}"></li>`);
	
	// 글쓰기 영역 복사
	 let replyForm = $('.comment-list+.comment-write').clone();
	 
	 // 복사할 폼을 답글 영역에 추가
	 let $num_next = $num.next().html(replyForm);
	 
	 // 답글 폼의 <textarea> 속성 placeholder 를 답글을 남겨보세요로 바꾼다
	 $num_next.find('textarea').attr('placeholder', '답글을 남겨보세요');
	 
	 // 답글 폼의 '.btn-cancel' 을 보여주고 클래스 'reply-cancel' 을 추가한다.
	 $num_next.find('.btn-cancel').show().addClass('reply-cancel');
	 
	 // 답글 폼의 '.btn-register' 에 클래스 reply 추가
	 // 속성 'data-ref' 에 ref, 'data-lev' 에 lev, 'data-seq' 에 seq 값 설정
	 // 등록을 답글 완료로 변경
	 $num_next.find('.btn-register').addClass('reply')
	 					.attr({'data-ref': ref, 'data-lev': lev, 'data-seq': seq})
	 						.text('답글완료');
	 // 원래 댓글 폼 보이지 않게
	 $('body > div > div.comment-area > div.comment-write').hide();
	 //$('.comment-area').off('click', '.comment-info-button',replyform).on('click','.comment-info-button',replyform);
	 //$(".comment-list-item--reply").not(this).next().hide(); 
	}


$(function() {
	
	getList(option);
	
	$('form[name="deleteForm"]').submit(function() {
		if($("#board_pass").val() == '') {
			alert("비밀번호를 입력하세요");
			$("#board_pass").focus();
			return false;
		}
	});
	
	$('.comment-area').on('keyup','.comment-write-area-text', function(){
		const length = $(this).val().length;
		$(this).prev().text(length+'/200');
	});
	
	$('ul + .comment-write .btn-register').click(function(){
		const content = $('.comment-write-area-text').val();
		if(!content) {
			alert("댓글을 입력하세요");
			return;
		}
		
		$.ajax({
			url: '../comments/add', // 댓글 원문 등록
			data: {
				id: $('#loginid').val(),
				content: content,
				comment_board_num: $('#comment_board_num').val(),
				comment_re_lev: 0, // 원문은 lev, seq 0
				comment_re_seq: 0
			},
			type: "post",
			success: function(rdata) {
				if (rdata == 1) {
					getList(option);
				}
			}
		});
		
		$('.comment-write-area-text').val(''); // textarea 초기화
		$('.comment-write-area-count').text('0/200'); // 입력한 글 카운트 초기화
		
	}
	); // btn-register end
	
	$(".comment-list").on('click', '.comment-tool-button', function() {
		// 더보기를 클릭하면 수정과 삭제 영역이 나타나고 다시 클릭하면 사라진다.
		$(this).next().toggle();
		
		// 클릭 한 곳만 수정 삭제 영역이 나타나도록한다.
		// 다른 더보기 버튼 클릭 시 다른 수정 삭제 버튼 없어지게.
		$(".comment-tool-button").not(this).next().hide(); 
	});
	
	// 수정 후 수정완료를 클릭한 경우
	/*
	에이잭스로 생성된 객체에 이벤트 핸들러를 붙이려면 
	파라미터 3~4 개를 받는 on( ) 메서드로 해당 이벤트 발생 객체의 선택자를 지정해야 한다.
	(comment-area 클래스 객체의 update 클래스를 가진 객체 클릭 시 이벤트 발생)
	*/
	
	$('.comment-area').on('click','.update', function(){
		const content = $(this).parent().parent().find('textarea').val();
		// 버튼 객체의 부모의 부모 객체가 갖는 textarea 의 value 

		if (!content) {
			alert("수정할 글을 입력하세요");
			return;
		}
		const num = $(this).attr('data-id');
		$.ajax({
			url: '../comments/update',
			data: {num: num, content: content},
			success: function(rdata){
				if (rdata == 1) { // updateAction 서블릿이 반환한 int result
					getList(option);
				}
			}
		});
	});
	
	// 수정 후 취소 버튼 클릭한 경우
	$('.comment-area').on('click', '.btn-cancel', function(){
		// 댓글 번호를 구한다.
		const num = $(this).next().attr('data-id');
		const selector = '#' + num;
		
		// .comment-write 영역 삭제한다.
		$(selector + ' .comment-write').remove();
		
		// 선택자의 자식인 comment-write 객체 삭제
		$(selector + '>.comment-nick-area').css('display', 'block');
		
		// 수정 폼이 있는 상태에서 더보기를 클릭할 수 없도록 더 보기 영역을 숨긴것을 다시 보여준다.
		$('.comment-tool').show();
		
	});
	
	$('.comment-area').on('click', '.reply', function(){
		const content = $(this).parent().parent().find('.comment-write-area-text').val();
		if(!content) { // 내용없이 답글 완료 클릭한 경우
			alert("답글을 입력하세요");
			return;
		}
		
		$.ajax({
			type: 'post',
			url: '../comments/reply',
			data: {
				id: $('#loginid').val(),
				content: content,
				comment_board_num: $('#comment_board_num').val(),
				comment_re_lev: $(this).attr('data-lev'),
				comment_re_ref: $(this).attr('data-ref'),
				comment_re_seq: $(this).attr('data-seq')
			},
			success: function(rdata) {
				if (rdata == 1) {
					getList(option);
				}
			}
		});
		
		// 답글 폼 보여주기
		$('body > div > div.comment-area > div.comment-write').show();
		reply_isRun = false;
	});
	
	$('.comment-area').on('click', '.reply-cancel', function(){
		$(this).parent().parent().parent().remove();
		$('.comment-tool').show(); // 더보기 영역 다시 보이게
		reply_isRun = false;
		
		// 댓글 폼 보여주기
		$('body > div > div.comment-area > div.comment-write').show();
	});
	
	
	$('.comment-area').on('click', '.comment-info-button', function(event){
		// 대댓글 쓰기 폼이 있는 상태에서 더보기를 클릭할 수 없도록 숨긴다.
		$('.comment-tool').hide();
		
		// 대댓글 쓰기 폼의 갯수를 구한다.
		const length = $('.comment-area .btn=register.reply').length;
		if (length == 1) {
			event.preventDefault();
			// 대댓글 쓰기 폼이 있는 상태에서 다른 답글쓰기 버튼이 작동되지 않게 막는다.
			// 또는 이벤트가 실행 중인 상태에서 중복 실행을 막기 위한 변수를 선언하여 변수의 상태를 바꿔가며 실행한다.
		}
	})
});
