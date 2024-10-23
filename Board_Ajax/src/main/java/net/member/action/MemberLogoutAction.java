package net.member.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;

public class MemberLogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("../members/login"); 
		// Board_Ajax/boards/list 에서 logout 수행하므로 .. 으로 contextPath(Board_Ajax)로 올라간 후 login 으로 간다. 
		return forward;
	}

}
