package net.template.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.Action;
import net.common.action.ActionForward;

public class LoginAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String go = request.getParameter("page");
		// page 속성 값을 가져온다.

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		request.setAttribute("pagefile", go);
		forward.setPath("/template/login.jsp");
		return forward;
	}
	
}
