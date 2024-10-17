package net.template.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.common.action.*;
import net.template.db.*;

public class InfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("id");
		ActionForward forward = new ActionForward();
		
		if (id != null && id.equals("admin")) {
			
			DAO dao = new DAO();
			TemplateJoin temp = dao.selectInfo(request.getParameter("id"));
		
			forward.setRedirect(false);
			forward.setPath("/template/info.jsp");
			request.setAttribute("temp", temp);
		} else if (id == null) {
			forward.setRedirect(true);
			forward.setPath("login.net");
		} else {
			forward.setRedirect(true);
			forward.setPath("forbidden.net");
		}
		return forward;
	}

}
