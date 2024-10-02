package _1.mem;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/ex1/_2.mem/memReg")
public class MemReg extends HttpServlet {

	private static final long serialVersionUID = -3139495669917832851L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		
		String addr = request.getParameter("addr");
	
		String tel = request.getParameter("tel");
		
		String hobby = request.getParameter("hobby");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>"
				  + "<head>"
				  + "<title>memReg.html</title>");
		out.println("<style> "
				  + "table {border-collapse:collapse; width:50%; margin:0 auto} "
				  + "tr {border-bottom:1px solid black} "
				  + "td {width:60%}"
				  + "</style>");
		out.println("</head><body>");
		out.println("<table> <thead></thead> <tbody>");
		out.println("<tr> <td> 회원명 </td> <td>" + name + "</td> </tr>");
		out.println("<tr> <td> 주소 </td> <td>" + addr + "</td> </tr>");
		out.println("<tr> <td> 전화번호 </td> <td>" + tel + "</td> </tr>");
		out.println("<tr> <td> 취미 </td> <td>" + hobby + "</td> </tr>");
		out.println("</tbody> </table>");
		out.println("</body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
