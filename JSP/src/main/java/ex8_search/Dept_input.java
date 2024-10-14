package ex8_search;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/departments/input")
public class Dept_input extends HttpServlet {

	private static final long serialVersionUID = -6364998122772182926L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ex8_db/_3.search/input.jsp");
	
		dispatcher.forward(request, response);
	
	}
	
	

}
