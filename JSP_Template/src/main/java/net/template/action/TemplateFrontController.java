package net.template.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("*.net") //.net 으로 끝나는 모든 요청을 이 서블릿에서 받는다.
public class TemplateFrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// doProcess (request, response) 메서드를 구현하여 요청 방식이 get 이든 post 이든 같은 메서드에서 처리한다.
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청 주소: " + request.getRequestURL());
		
		/*
			요청된 전체 URL 중 포트 번호 다음부터 마지막 문자열까지 반환된다.
			=> URL로 어떤 종류의 요청인지 받아서 다른 페이지로 넘긴다.
			
			예) http://localhost:8088/JSP_Template/templatetest.net 인 경우
				"/JSP_Template/template.net" 반환한다.
		 */
		String RequestURI = request.getRequestURI();
		System.out.println("RequestURI = " + RequestURI);
		
		// getContextPath() : 컨텍스트 경로 반환
		String contextPath = request.getContextPath();
		System.out.println("contextPath = " + contextPath);
		
		// RequestURI 에서 컨텍스트 경로 길이 값의 인덱스 위치부터 마지막 위치 문자까지 추출
		// command 는 "/templatetest.net" 반환된다.
		String command = RequestURI.substring(contextPath.length());
		System.out.println("command = " + command);
		
		/*
		index.jsp 에서 실행
		요청 주소: http://localhost:8088/JSP_Template/tamplatetest.net
		RequestURI = /JSP_Template/tamplatetest.net
		contextPath = /JSP_Template
		command = /tamplatetest.net
		 */
		// 객체 초기화
		ActionForward forward = null;
		Action action = null;
		
		switch (command) {
		case "/templatetest.net":
			action = new TemplateTestAction(); // Action 인터페이스를 구현한 객체 생성. 
			break;
		case "/login.net":
			action = new LoginAction();
			break;
		case "/join.net":
			action = new JoinAction();
			break;
		}
		
		forward = action.execute(request, response);
		// action 인터페이스를 구현한 TemplateTestAction 객체의 execute 메서드를 통해 ActionForward 객체를 얻는다.
		
		// ActionForward 객체의 필드인 redirect 와 path 를 이용해 리다이렉트를 할지 dispatch 를 할 지 결정한다.
		if (forward != null) {
			if (forward.isRedirect()) { // 리다이렉트 된다.
				response.sendRedirect(forward.getPath());
			} else { // 포워딩 된다.
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
