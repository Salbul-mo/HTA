$(document).ready(function() {
  let check = 0;
  
  // submit 버튼 클릭할 때 이벤트 관리
  $('form[name=modifyform]').submit(function() {
	  const $boardPass = $('#board_pass');
	  if ($boardPass.val().trim() == '') {
		  alert('비밀번호를 입력하세요');
		  $boardPass.focus();
		  return false;
	  }
	  
	  const $boardSubject = $('#board_subject');
	  if ($boardSubject.val().trim() == '') {
		  alert('제목을 입력하세요');
		  $boardSubject.focus();
		  return false;
	  }
	  
	  const $boardContent = $('#board_content');
	  if ($boardContent.val().trim() == '') {
		  alert('내용을 입력하세요');
		  $boardContent.focus();
		  return false;
	  }
	  
	  // 파일 첨부를 변경하지 않으면 $('#filevalue').text() 의 파일명을 
	  // 파라미터 check 라는 이름으로 hidden input에 추가하여 전송한다.
	  if (check == 0) {
		  const value = $('#filevalue').text();
		  const html = `<input type='hidden' value='${value}' name='check'>`;
		  console.log(html);
		  $(this).append(html);
	  }
	
  });
	// 첨부파일 없으면 x 이미지 삭제하는 함수  
  function showRemove() {
	  $('.remove').css('display', $('#filevalue').text() ? 'inline-block' : 'none')
  }
  showRemove();
  
  $('#upfile').change(function() {
	  check++;
	  const maxSizeInBytes = 5 * 1024 * 1024; // 5MB
	  const file = this.files[0]; // 선택된 파일
	 
	  if (file.size > maxSizeInBytes) {
		  alert("5MB 이하 크기로 업로드하세요");
		  $(this).val('');
	  } else {
		  $('#filevalue').text(file.name); // 파일 이름
	  }
	  
	  $('.remove').show(); // x 버튼 출현
	  
	  /*
	  파일 이름 추출하는 로직
	  console.log($(this).val()) // c:\fakepath\upload.png <- 자체적으로 관리하는 경로, paper path
	  const inputfile = $(this).val().split('\\'); // \ 기준으로 분할
	  
	  
	  $('#filevalue').text(inputfile[inputfile.length - 1]);
	  
	  // 분할된 배열에서 마지막 인덱스 선택하여 <span>에 text 노드 추가
	  */
  });
  
  
  $('.remove').click(function(){
	  $('#filevalue').text('');
	  $(this).hide();	  
  });	
	
});


