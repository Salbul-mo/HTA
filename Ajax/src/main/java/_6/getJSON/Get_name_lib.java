package _6.getJSON;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import com.google.gson.JsonObject;

@WebServlet("/get_name_lib")
public class Get_name_lib extends HttpServlet {

	private static final long serialVersionUID = -1878884819316254615L;

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=utf-8"); 
		// JSON 타입으로 응답. 한글 안깨지게 utf-8
		
		JsonObject json = new JsonObject();
		json.addProperty("name","홍길동2");
		// 
		
		System.out.println(json.toString());
		response.getWriter().print(json.toString());
		// String 타입으로 반환하면 끝.
		
	}

}
