package net.member.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.member.db.*;


public class MemberUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO memberDAO = new MemberDAO();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		Member mem = memberDAO.getMember(id);
		
		request.setAttribute("mem", mem);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/member/updateForm.jsp");
		return forward;
		
	}

}
