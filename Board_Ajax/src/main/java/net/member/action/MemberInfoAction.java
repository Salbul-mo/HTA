package net.member.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.db.*;

public class MemberInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		ActionForward forward = new ActionForward();
		
		MemberDAO memberDAO = new MemberDAO();
		
		Member m = memberDAO.getMember(id);
		
		if (m == null) {
			forward.setPath("/WEB-INF/views/error/error.jsp");
			request.setAttribute("message", "아이디에 해당하는 정보가 없습니다.");
		} else {
			forward.setPath("/WEB-INF/views/member/memberInfo.jsp");
			request.setAttribute("m", m);
			
		}
		forward.setRedirect(false);
		return forward;
	}

}
