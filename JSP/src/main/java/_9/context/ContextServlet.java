package _9.context;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ex1/_9.context/Context")
public class ContextServlet extends HttpServlet {

	private static final long serialVersionUID = 6580863249762211602L;
	
	public ContextServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String value = request.getParameter("food");
		request.setAttribute("food", value); // request 객체에 값을 저장한다.
		
		HttpSession session = request.getSession();
		session.setAttribute("food", value); // session 객체에 값을 저장한다.
		
		/*
			웹 애플리케이션이 서비스되고 있는 동안 유지하는 것을 의미한다.
			생명주기가 웹 애플리케이션과 같은 객체는 ServletContext 라고 한다.
			ServletContext 는 웹 애플리케이션 서비스가 시작될 때 생성되고 종료될 때 소멸한다.
		 */
		ServletContext sc = request.getSession().getServletContext();
		sc.setAttribute("food", value);
		
		response.sendRedirect("scope.jsp");
	}
}
