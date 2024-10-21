package _6.getJSON;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import com.google.gson.*;

@WebServlet("/dept_lib_search")
public class DeptGet_lib_search extends HttpServlet {

	private static final long serialVersionUID = -9058747347974983782L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		
		DAO dao = new DAO();
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		JsonArray array = dao.getList_lib_search(deptno);
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(array);
		System.out.println(array);
	}
}
