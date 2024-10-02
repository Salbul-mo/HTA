package _6.redirect;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/ex1/_6.redirect/RedirectServlet")
public class RedirectServlet extends HttpServlet {

	private static final long serialVersionUID = -256011992724775975L;
	
	public RedirectServlet() {
		super();
	}
	
	/* 
	 	페이지 이동
	 	- Redirect 방식 : 이동될 때 브라우저의 주소 표시줄의 URL 이 변경되므로 요청이 바뀌게 된다.
	 	- 이동한 jsp 페이지에서는 넘긴 서블릿에서의 request 영역의 속성 값에 접근할 수 없다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException {
		
		System.out.println("요청 방식 : " + request.getMethod());
		System.out.println("파라미터 food의 값 : " + request.getParameter("food"));
		response.sendRedirect("redirect.jsp");
		// response 객체로 응답을 한것이다. 이 서블릿 클래스의 응답은 여기서 끝난다.
		
	}

}
