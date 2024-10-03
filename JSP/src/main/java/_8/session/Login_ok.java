package _8.session;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ex1/_8.session/login_ok")
public class Login_ok extends HttpServlet {

	private static final long serialVersionUID = 1870829536491551081L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatch = request.getRequestDispatcher("dispatcher.jsp");
		
		session.setAttribute("id", id);
		session.setAttribute("passwd", passwd);
		
		if(id.equals("java") && passwd.equals("java")) {
			response.sendRedirect("loginSuccess.jsp");
		} else if (!id.equals("java") && !passwd.equals("java")) {
			request.setAttribute("message", "아이디와 비밀번호가 일치하지 않습니다.");
			dispatch.forward(request, response);
		} else if (!id.equals("java")) {
			request.setAttribute("message", "아이디가 일치하지 않습니다.");
			dispatch.forward(request, response);
		} else {
			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
			dispatch.forward(request, response);
		}
	}
}


