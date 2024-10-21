package _6.getJSON;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/get_name")
public class Get_name extends HttpServlet {

	private static final long serialVersionUID = -542254358063528771L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=utf-8"); 
		// JSON 타입으로 응답. 한글 안깨지게 utf-8
		
		String message = "{\"name\" : \"홍길동\"}";
		// 
		
		System.out.println(message);
		response.getWriter().print(message);
		// String 타입으로 반환하면 끝.
		
	}

}
