package net.template.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.common.action.*;
import net.template.db.*;

public class InfoAction2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DAO dao = new DAO();
		TemplateJoin temp = dao.selectInfo(request.getParameter("id"));
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/template/info.jsp");
		request.setAttribute("temp", temp);
		
		return forward;
	}

}
