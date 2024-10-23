$(document).ready(function(){

  $('#upfile').change(function(){
	  console.log($(this).val()) // c:\fakepath\upload.png <- 자체적으로 관리하는 경로, paper path
	  const inputfile = $(this).val().split('\\'); // \ 기준으로 분할
	  $('#filevalue').text(inputfile[inputfile.length - 1]); 
	  // 분할된 배열에서 마지막 인덱스 선택하여 <span>에 text 노드 추가
  });
	
  // submit 버튼 클릭할 때 이벤트 관리
  $('form[name=boardform]').submit(function(){
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
  });
});


