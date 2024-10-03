package test_attr_post;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ex1/test_attr_post/CheckServlet")
public class CheckServlet extends HttpServlet {

	private static final long serialVersionUID = -6436496779317721823L;
	
	public CheckServlet() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String jumin1 = request.getParameter("jumin1");
		String jumin2 = request.getParameter("jumin2");
		String email = request.getParameter("email");
		String domain = request.getParameter("domain");
		String gender = request.getParameter("gender");
		String post1 = request.getParameter("post1");
		String address = request.getParameter("address");
		String intro = request.getParameter("intro");
		String[] hobbys = request.getParameterValues("hobby");

		request.setAttribute("id", id);
		request.setAttribute("pass", pass);
		request.setAttribute("jumin1", jumin1);
		request.setAttribute("jumin2", jumin2);
		request.setAttribute("email", email);
		request.setAttribute("domain", domain);
		request.setAttribute("gender", gender.equals("m") ? "남자" : "여자");
		request.setAttribute("hobbys", String.join(" ", hobbys));
		request.setAttribute("post1", post1);
		request.setAttribute("address", address);
		request.setAttribute("intro", intro);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("dispatcher.jsp");

		dispatcher.forward(request, response);
	}

}
