package net.template.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import net.common.action.*;
import net.template.db.*;

public class ListAction3 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
				
		if (id != null && id.equals("admin")) {
			DAO dao = new DAO();
			ArrayList<TemplateJoin> list = dao.selectAll();
			forward.setRedirect(false);
			request.setAttribute("list", list);
			forward.setPath("/template/list.jsp");
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
