package net.common.action;
/*
	Action 인터페이스를 구현한 클래스에서 명령 수행 후 다음 페이지로 이동하기 위한 정보를 담을 클래스이다.
	redirect 는 redirect 여부, path 에는 페이지 정보가 저장된다.
	
	1. redirect 가 true 이면
		response.sendRedirect(forward.getPath()); 문장을 실행한다.
	
	2. redirect 가 false 이면
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
		dispatcher.forward(request, response); 문장을 실행한다.
 */

public class ActionForward {
	
	private boolean redirect = false;
	private String path = null;
	
	
	// property redirect 의 is 메서드
	public boolean isRedirect() {
		// 프로퍼티 타입이 boolean 일 경우 get 대신 is를 앞에 붙일 수 있다.
		return redirect;
	}

	// property redirect 의 set 메서드
	public void setRedirect(boolean b) {
		redirect = b;
	}
	
	// property path 의 get 메서드
	public String getPath() {
		return path;
	}
	
	// property path 의 set 메서드
	public void setPath(String string) {
		path = string; 
	}
}
