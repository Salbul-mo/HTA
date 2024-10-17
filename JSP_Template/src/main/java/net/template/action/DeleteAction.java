package net.template.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.template.db.*;

public class DeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 

			String id = request.getParameter("id");
			
			DAO dao = new DAO(); 
			int result = dao.delete(id);
			
			String message = "삭제 실패입니다.";
			if (result == 1) 
				message = "삭제 성공입니다.";
			
			System.out.println(message);
			HttpSession session = request.getSession();
			session.setAttribute("message", message);
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("list.net");
			return forward;
	}

}
