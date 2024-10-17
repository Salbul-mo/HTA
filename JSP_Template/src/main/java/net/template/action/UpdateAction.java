package net.template.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.template.db.*;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		ActionForward forward = new ActionForward();
		System.out.println("update id= " + id);
		
		DAO dao = new DAO();
		TemplateJoin temp = dao.selectInfo(id);
		forward.setRedirect(false);
		forward.setPath("/template/update.jsp");
		request.setAttribute("temp", temp);
		
		return forward;
	}

}
