package _6.getJSON;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import com.google.gson.*;

@WebServlet("/get_array_lib")
public class Get_array_lib extends HttpServlet {

	private static final long serialVersionUID = -824757558345330574L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=utf-8");
		
		JsonObject json = new JsonObject();
		json.addProperty("name", "홍길동");
		
		JsonObject json2 = new JsonObject();
		json2.addProperty("name", "홍길동2");
		
		JsonArray array = new JsonArray();
		array.add(json);
		array.add(json2);
		
		System.out.println(array);
		// [{"name":"홍길동"},{"name":"홍길동2"}]
		response.getWriter().print(array);
	}

}
