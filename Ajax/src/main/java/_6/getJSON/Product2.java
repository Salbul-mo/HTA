package _6.getJSON;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import com.google.gson.*;

@WebServlet("/product2")
public class Product2 extends HttpServlet {

	private static final long serialVersionUID = -1398833900821897316L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO_Product dao = new DAO_Product();
		JsonArray arr = dao.getList();
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(arr);
		System.out.println(arr);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int result = 0;
		DAO_Product dao = new DAO_Product();
		String label = request.getParameter("label");
		DTO product = new DTO();
		
		switch(label) {
			case "삭제" : result = dao.delete(Integer.parseInt(request.getParameter("id")));
						 break;
		
			case "추가" :
				product.setName(request.getParameter("name"));
				product.setPrice(Integer.parseInt(request.getParameter("price")));
				product.setMaker(request.getParameter("maker"));
				
				result = dao.insert(product);
				
				if (result == 1) {
					System.out.println("DB에 행이 추가되었습니다."); 
				} else {
					System.out.println("DB에 행 추가 실패했습니다.");
				}
				
				doGet(request, response);
				break;
			
			case "수정완료" :
				product.setName(request.getParameter("name"));
				product.setPrice(Integer.parseInt(request.getParameter("price")));
				product.setMaker(request.getParameter("maker"));
				if (label.equals("수정완료")) {
					product.setId(Integer.parseInt(request.getParameter("id")));
					result = dao.update(product);
				} else {
					result = dao.insert(product);
				}
				break;
		}
		
		if (result == 1) {
			System.out.println(label + "성공");
			doGet(request, response);
		} else {
			System.out.println(label + "실패");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(label + "실패");
		}
	}
	
}
