package ex8_search;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/departments/search")
public class Search extends HttpServlet {
	
	private static final long serialVersionUID = -8637341144131786761L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deptno = request.getParameter("deptno");
		
		DAO dao = new DAO();
		
		ArrayList<Dept> list = dao.select(deptno);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ex8_db/_3.search/list.jsp");
		request.setAttribute("list", list);
		dispatcher.forward(request, response);
		
	}
	
	
}

