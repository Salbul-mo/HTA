package net.member.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.member.db.*;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO memberDAO = new MemberDAO();
		
		String id = request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int result = memberDAO.delete(id);
		if (result == 1) {
			out.print("<script>");
			out.print("alert('삭제 성공입니다.');");
			out.print("location.href='list'");
			out.print("</script>");
		} else {
			out.print("<script>");
			out.print("alert('삭제 실패입니다.');");
			out.print("history.back()");
			out.print("</script>");
		}
		out.close();
		return null;
	}

}
