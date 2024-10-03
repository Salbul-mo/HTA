package _4.check_values;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/ex1/_4.check_values/choiceFruit")
public class ChoiceFruit extends HttpServlet {

	private static final long serialVersionUID = 7004442554201876389L;
	
	public ChoiceFruit() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/*
		 1. getParameterValeus()
		 	예) fruit=apple.png&fruit=grape.png&fruit=straw.png&fruit=water.png
		 		하나의 파라미터 이름(fruit) 으로 값이 여러 개 전송되어 올 경우에 사용하는 메서드
		 		체크 박스의 이름은 공통적으로 fruit 로 지정되어 있으므로 각 체크 박스의 값으로
		 		과일 이미지 파일명을 지정하여 파라미터 값으로 과일 이미지 이름이 전송되도록 하고 있다.
		 		
		 2. getParameter() : 하나의 파라미터로 하나의 값만 오는 경우 사용하는 메서드
		 		하나의 파라미터 이름(fruit) 으로 값이 여러 개 전송되어 올 경우 이 메서드를 사용하면 
		 		처음에 선택한 값만 알 수 있다.
		 	예) fruit=apple.png&fruit=grape.png&fruit=straw.png&fruit=water.png
		 		에서 fruit=apple.png 값만 가져온다.
		 */
		
		String[] fruit = request.getParameterValues("fruit");
		
		out.println("<html><head> " 
				   +"<style> "
				   +"body {background:black;} "
				   +"table {background:yellow; margin:0 auto; top:30%; position:relative}"
				   +"td {color:red; font-size:20px; text-align:center; border:1px solid black"
				   + "		height:2em; width:200px}"
				   +"</style>"
				   +"</head><body><table><tbody><tr> ");

		for (int cnt = 0; cnt < fruit.length; cnt++) {
			out.println("<td>" + fruit[cnt] + "</td>");
		}
		
		out.println("</tr><tr>");
		/*
				1. 상대 경로 - 현재 경로를 기준으로 이동해야 한다.
					현재 브라우저 주소) http://localhost:8088/JSP/ex1/_4.check_values/choiceFruit
					이미지 주소) http://localhost:8088/JSP/image/apple.png
					이미지 경로를 맞추기 위해 '../../image/' 로 이동한다.
					
				2. 절대 경로 - http://localhost:8088/JSP/image/apple.png
					out.println("<td> <img width=128 height=128 src='/JSP/image/" + fruit[cnt] + "'></td>");
					
					절대 경로를 사용하면 사용자가 소스 파일 구조를 알 수 있으므로 상대경로를 사용하는게 좋다.
		 */
		
		for (int cnt = 0; cnt < fruit.length; cnt++) {
			out.println("<td> <img width=128 height=128 src='../../image/" + fruit[cnt] + "'></td>");
		}
		out.println("</div></body></html> ");
	}
	
}
