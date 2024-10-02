package test_attr;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ex1/test_attr/CheckServlet")
public class CheckServlet extends HttpServlet {

	private static final long serialVersionUID = 1581130750496571439L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		
		if (gender.equals("m"))
			gender = "남자";
		else
			gender = "여자";

		String[] hobbys = request.getParameterValues("hobby");

		String hobby = "";
		
		for (String str : hobbys)
			hobby += str + " ";

		request.setAttribute("id", id);
		request.setAttribute("pass", pass);
		request.setAttribute("jumin1", jumin1);
		request.setAttribute("jumin2", jumin2);
		request.setAttribute("email", email);
		request.setAttribute("domain", domain);
		request.setAttribute("gender", gender);
		//request.setAttribute("gender", gender.equals("m") ? "남자" : "여자");
		request.setAttribute("hobbys", hobby);
		//request.setAttribute("hobbys", String.join(" ", hobbys));
		request.setAttribute("post1", post1);
		request.setAttribute("address", address);
		request.setAttribute("intro", intro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dispatcher.jsp");

		dispatcher.forward(request, response);
	}
	
	// post 방식 요청을 doGet 으로 보낸다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
