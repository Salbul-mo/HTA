package net.template.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.template.db.*;

public class IdcheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		DAO dao = new DAO();
		
		// result 가 0인 경우는 아이디가 존재하지 않는 경우
		// result 가 -1 인 경우는 아이디가 존재하는 경우
		
		int result = dao.isId(id);
		request.setAttribute("result", result);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/template/idcheck.jsp");
		return forward;
	}

}
