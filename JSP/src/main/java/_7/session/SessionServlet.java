package _7.session;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ex1/_7.session/SessionServlet")
public class SessionServlet extends HttpServlet {

	private static final long serialVersionUID = -4023622754150500839L;
	
	public SessionServlet() {
		super();
	}
	
	/*
		페이지 이동 방법
		Redirect 방식 : 이동될 때 브라우저의 주소 표시줄의 URL이 변경되므로 요청이 바뀌게 된다.
		이동한 jsp 페이지에서는 서블릿의 request 영역의 속성 값에 접근할 수 없다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		String value = request.getParameter("food");
		
		request.setAttribute("food", value); // request 객체에 값을 저장한다.
		session.setAttribute("food", value); // session 객체에 값을 저장한다.
		
		response.sendRedirect("redirect.jsp");
	}
}
