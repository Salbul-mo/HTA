package _5.dispatcher;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
	페이지 이동 방식
	
	Dispatcher 방식
	- 클라이언트로부터 요청 받은 Servlet 프로그램이 응답을 하지 않고 다른 서블릿이나 JSP 페이지 등에 요청을 전달한다.
		(요청 재지정)
	
	- 이 방식으로 이동하면 주소 표시줄의 주소가 변경되지 않는다.
		dispatch 로 넘겨진 jsp 경로가 아니라 
		http://localhost:8088/JSP/ex1/_5.dispatcher/DispatcherServlet?food=치킨 으로 이동한다.
	
	- request 영역을 공유하게 된다.
		=> 해당 서블릿 또는 JSP 에 request 객체를 보내고 서블릿 또는 JSP 객체가 response로 리턴된다?.
	
	- 방법 : RequestDispatcher 에서 제공하는 메서드(forward()) 를 사용하여 요청을 재지정한다.
 */
@WebServlet("/ex1/_5.dispatcher/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 478591686593294999L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		System.out.println("요청 방식 : " + request.getMethod());
		System.out.println("파라미터 food의 값 : " + request.getParameter("food"));
		
		// dispatcher.jsp : 이동할 페이지 주소
		// http://localhost:8088/JSP/dispatcher.jsp 의미
		// RequestDispatcher dispatcher = request.getRequestDispatcher("/dispatcher.jsp");
		// => 절대경로로 JSP (context-path)/dispatcher.jsp 에 요청을 던진다.
		
		// http://localhost:8088/JSP/ex1/_5.dispatcher/dispatcher.jsp
		// => 상대경로로 현재 URL 뒤에 dispatcher.jsp 를 붙인다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("dispatcher.jsp");
		// 이동한다.
		dispatcher.forward(request, response);
		// => dispatcher 객체를 생성해서 request 객체와 response 객체를 해당 jsp 에 전달한다.
	}
	


}
