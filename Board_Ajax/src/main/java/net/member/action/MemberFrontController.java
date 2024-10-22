package net.member.action;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import net.common.action.*;

@WebServlet("/members/*")
public class MemberFrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
			요청된 전체 URL 중 포트 번호 다음부터 마지막 문자열까지 반환된다.
			=> URL로 어떤 종류의 요청인지 받아서 다른 페이지로 넘긴다.
			
			예) http://localhost:8088/Board_Ajax/members/login 인 경우
				"/Board_Ajax/members/login" 반환한다.
		 */
		
		String RequestURI = request.getRequestURI();
		System.out.println(RequestURI);
			
		// getContextPath() : 컨텍스트 경로 반환
		// "/Board_Ajax" 반환
		String contextPath = request.getContextPath();
		System.out.println("contextPath = " + contextPath);
			
		// RequestURI 에서 컨텍스트 경로 길이 값의 인덱스 위치부터 마지막 위치 문자까지 추출
		// command 는 "members/login" 반환된다.
		String command = RequestURI.substring(contextPath.length() + "/members".length());
		System.out.println("command = " + command);
			
		// 객체 초기화
		ActionForward forward = null;
		Action action = null;
			
		switch (command) {
		case "/login":
			action = new MemberLoginAction();
			break;
		case "/loginProcess":
			action = new MemberLoginProcessAction();
			break;
		case "/joinProcess":
			action = new MemberJoinProcessAction();
			break;
		case "/join":
			action = new MemberJoinAction();
			break;
		case "/idcheck":
			action = new MemberIdcheckAction();
			break;
	/*
		case "/logout.net":
			action = new LogoutAction();
			break;
		case "/list.net":
			action = new ListAction1();
			break;
		case "/info.net":
			action = new InfoAction();
			break;
		case "/update.net":
			action = new UpdateAction();
			break;
		case "/updateProcess.net":
			action = new UpdateProcessAction();
			break;
		case "/delete.net":
			action = new DeleteAction();
			break;
		case "/forbidden.net":
			action = new ForbiddenAction();
			break;
	*/
		default :
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error/error404.jsp");
			dispatcher.forward(request, response);
			return;
		}
			
		forward = action.execute(request, response);
		// action 인터페이스를 구현한 TemplateTestAction 객체의 execute 메서드를 통해 ActionForward 객체를 얻는다.
		
		// ActionForward 객체의 필드인 redirect 와 path 를 이용해 리다이렉트를 할지 dispatch 를 할 지 결정한다.
		if (forward != null) { // null 이면 아무것도 안한다. ajax 로 처리할 경우 return null
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



