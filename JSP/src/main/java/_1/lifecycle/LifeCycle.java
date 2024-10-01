package _1.lifecycle;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns= {"/LifeCycle","/a"}) // urlPattern 은 여러 개 지정할 수 있다.
public class LifeCycle extends HttpServlet /*jakarta.servlet.http.HttpServlet*/ {
	
	private static final long serialVersionUID = 1284214465161685088L;
	// 클래스 동일성 유지를 위한 serialVersionUID 
	
	public LifeCycle() {
		super();
		System.out.println("저는 생성자 입니다.");
	}
	
	public void init() throws ServletException {
		System.out.println("저는 init() 입니다.");
	}
	
	public void destroy() {
		System.out.println("저는 destroy() 입니다.");
	}

	public void service(HttpServletRequest request, 
							HttpServletResponse response) throws ServletException, IOException {
		System.out.print("저는 service() 입니다.");
		System.out.println("요청 주소" + request.getRequestURL());
	}
}
/*
localhost:8088/JSP/a 로 요청 
저는 생성자 입니다.
저는 init() 입니다.
저는 service() 입니다.요청 주소http://localhost:8088/JSP/a

localhost:8088/JSP/LifeCycle 로 다시 요청
저는 service() 입니다.요청 주소http://localhost:8088/JSP/LifeCycle
 */
