package _6.getJSON;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import com.google.gson.*;

@WebServlet("/product")
public class Product extends HttpServlet {

	private static final long serialVersionUID = -1398833900821897316L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO_Product dao = new DAO_Product();
		JsonArray arr = dao.getList();
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(arr);
		System.out.println(arr);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DTO product = new DTO();
		
		product.setName(request.getParameter("name"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setMaker(request.getParameter("maker"));
		
		DAO_Product dao = new DAO_Product();
		int result = dao.insert(product);
		
		if (result == 1) {
			System.out.println("DB에 행이 추가되었습니다."); 
		} else {
			System.out.println("DB에 행 추가 실패했습니다.");
		}
		
		doGet(request, response);
	}
	
}
