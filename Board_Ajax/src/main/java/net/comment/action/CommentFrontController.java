package net.comment.action;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import net.common.action.*;

@WebServlet("/comments/*")
public class CommentFrontController extends HttpServlet {

	
	private static final long serialVersionUID = 77927715160639744L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String RequestURI = request.getRequestURI();
		System.out.println("RequestURI = " + RequestURI);
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath = " + contextPath);
		
		String command = RequestURI.substring(contextPath.length() + "/comments".length());
		System.out.println("command = " + command);
		
		ActionForward forward = null;
		Action action = null;
		
		switch (command) {
			case "/add" : 
				action = new CommentAddAction();
				break;
			case "/list" :
				action = new CommentListAction();
				break;
			case "/delete" :
				action = new CommentDeleteAction();
				break;
			case "/reply" :
				action = new CommentReplyAction();
				break;
			case "/update" :
				action = new CommentUpdateAction();
				break;
			default :
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/error/error404.jsp");
				dispatcher.forward(request, response);
				return;
		}
		
		forward = action.execute(request, response);
		
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
