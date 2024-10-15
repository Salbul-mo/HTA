package net.template.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.Action;
import net.common.action.ActionForward;

public class JoinAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/template/join.jsp");
		return forward;
	}
	
}
