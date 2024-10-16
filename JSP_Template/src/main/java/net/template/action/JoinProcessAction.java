package net.template.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.template.db.*;

public class JoinProcessAction extends TemplateJoinProcess implements Action {

	private static final long serialVersionUID = 8199528097951524887L;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TemplateJoin join = getTemplateJoin(request);
		
		DAO dao = new DAO();
		int result = dao.insert(join);
		
		HttpSession session = request.getSession();
		String message = "회원 가입 성공입니다.";
		if(result != 1) 
			message = "회원 가입 실패입니다.";
		
		// request 객체에 담긴 정보 모두 삭제시키기 위해 메세지 출력할 속성을 session 에 담아주고 리다이렉트
		// 메세지 출력하고 바로 세션 정보를 삭제한다.
		session.setAttribute("message", message);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("templatetest.net");
		return forward;
	}

}
