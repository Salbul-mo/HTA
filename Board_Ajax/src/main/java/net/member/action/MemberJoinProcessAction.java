package net.member.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.member.db.*;

public class MemberJoinProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id =  request.getParameter("id");
		String password =  request.getParameter("pass");
		int age = Integer.parseInt(request.getParameter("age"));
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		Member m = new Member();
		m.setAge(age); m.setEmail(email); m.setGender(gender);
		m.setId(id); m.setName(name); m.setPassword(password);
		
		MemberDAO dao = new MemberDAO();
		
		int result = dao.insert(m);
		
		// result 결과에 따라 
		if(result == 0) {
			System.out.println("회원 가입 실패입니다.");
			ActionForward forward = new ActionForward();
			request.setAttribute("message", "회원 가입 실패입니다.");
			forward.setRedirect(false);
			forward.setPath("/error/error.jsp");
			return forward;
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('회원가입을 축하합니다.');");
		out.print("location.href='../members/login';");
		out.print("</script>");
		out.close();
		return null;
	}

}
