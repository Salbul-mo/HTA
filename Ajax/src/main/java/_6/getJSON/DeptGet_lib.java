package _6.getJSON;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import com.google.gson.*;

@WebServlet("/dept_lib")
public class DeptGet_lib extends HttpServlet {

	private static final long serialVersionUID = -9058747347974983782L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		
		DAO dao = new DAO();
		JsonArray array = dao.getList_lib();
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(array);
		System.out.println(array);
		/*
		[
		 {"deptno":10,"dname":"ACCOUNTING","loc":"NEW YORK"},
		 {"deptno":20,"dname":"RESEARCH","loc":"DALLAS"},
		 {"deptno":30,"dname":"SALES","loc":"CHICAGO"},
		 {"deptno":40,"dname":"OPERATIONS","loc":"BOSTON"}
		]
		*/
	}
}
