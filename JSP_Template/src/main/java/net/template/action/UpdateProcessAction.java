package net.template.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.template.db.*;

public class UpdateProcessAction extends TemplateJoinProcess implements Action {

	private static final long serialVersionUID = -5222242140751081676L;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TemplateJoin join = getTemplateJoin(request);
		
		DAO dao = new DAO();
		
		int result = dao.update(join);
		String message = "회원정보 수정 실패입니다.";
		
		if (result == 1)
			message = "회원정보 수정 성공입니다.";
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		request.getSession().setAttribute("message", message);
		forward.setPath("templatetest.net");
		return forward;
	}

}
