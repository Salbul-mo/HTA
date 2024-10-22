package net.member.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.member.db.*;
import com.google.gson.*;

public class MemberIdcheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		
		// result 가 0인 경우는 아이디가 존재하지 않는 경우
		// result 가 -1 인 경우는 아이디가 존재하는 경우
		
		int result = dao.isId(id);
		response.getWriter().print(result);
		System.out.println(result);
		
		return null;
	}

}
