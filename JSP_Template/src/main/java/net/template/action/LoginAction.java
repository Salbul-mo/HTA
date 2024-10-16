package net.template.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;

public class LoginAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = "";
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0 ; i < cookies.length ; i++) {
				if (cookies[i].getName().equals("id")) {
					id = cookies[i].getValue();
				}
			}
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		request.setAttribute("cookieId", id);
		forward.setPath("/template/login.jsp");
		return forward;
	}
	
}
