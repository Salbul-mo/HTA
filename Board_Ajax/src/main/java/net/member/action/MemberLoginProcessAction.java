package net.member.action;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.common.action.*;
import net.member.db.*;

public class MemberLoginProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("passwd");
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
	
		MemberDAO dao = new MemberDAO();
		System.out.println(id + password);
		int result = dao.isId(id, password);
		
		System.out.println("결과는 " + result);
		
		if (result == 1) { // 아이디 비밀번호 일치
			session.setAttribute("id", id);
			
			String IDStore = request.getParameter("remember");
			Cookie cookie = new Cookie("id", id);
			
			// id 기억하기를 체크한 경우
			if (IDStore != null && IDStore.equals("store")) {
				cookie.setMaxAge(60 * 60 * 24); // 쿠키의 유효시간을 24시간으로 설정한다.
				System.out.println("쿠키 확인");
			} else {
				cookie.setMaxAge(0);
			}
			
			response.addCookie(cookie);
			forward.setRedirect(true);
			forward.setPath("../boards/list");
			return forward;
		} else {
			String message = "비밀번호가 일치하지 않습니다.";
			if (result == 0) {
				message = "아이디가 존재하지 않습니다.";
			}
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('" + message + "');"); // html 직접 작성할 때는 따옴표 체크를 잘하자.
			//out.print("location.href='../members/login';"); href 를 이용해 이동 시 객체의 데이터 날아감
			out.print("history.back();"); // history.back() 을 이용하면 데이터 유지된 체로 뒤로 이동한다.
			out.print("</script>");
			out.close();
			return null;
		}
	}
}
