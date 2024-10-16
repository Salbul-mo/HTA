package net.template.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import net.common.action.*;
import net.template.db.*;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DAO dao = new DAO();
		ArrayList<TemplateJoin> list = dao.selectAll();
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		request.setAttribute("list", list);
		forward.setPath("/template/list.jsp");
		return forward;
	}

}
