package _1.login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// http://localhost:8088/JSP/ex1/_1.login/LifeCycleTest => html 파일의 경로와 urlPatterns 를 맞춰준다.
// http://localhost:8088/JSP/ex1/_1.login/LifeCycleTest 에서 submit 시 
// http://localhost:8088/JSP/ex1/_1.login/LifeCycleTest?id=입력값&passwd=입력값 으로 URL 요청이 이루어진다.
@WebServlet("/ex1/_1.login/LifeCycleTest2")
public class LifeCycleTest_post extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// HttpServlet 클래스의 doGet 메서드를 오버라이드한다. get 방식의 요청에 대해 실행되는 메서드이다.
	protected void doPost(HttpServletRequest request,
							HttpServletResponse response) throws ServletException, IOException {
		// HttpServletRequest request 와 HttpServletResponse response 의 객체는 서블릿 컨테이너에서 자동으로 생성한다.
		// 이렇게 컨테이너에서 자동으로 생성되는 객체가 많으므로 살펴보자.
		
		// 응답하는 데이터 타입이 "text/html" 타입이고
		// "charset=utf-8" 로 지정하면서 응답되는 데이터들의 한글 처리를 한 부분이다.
		response.setContentType("text/html;charset=utf-8");
		
		// getParameter() 메서드 :
		// html 의 태그 속성 중에서 "name=id,name=passwd" 인 곳에서 입력한 후 전송되어 온
		// 쿼리 스트링을 파라미터 값으로 반환해 주는 메서드 이다.
		// 클라이언트에서 전송되어 오는 id 라는 이름의 파라미터 값과
		// passwd 라는 이름의 파라미터 값을 받는 부분이다.
		// id=hiksyksyksy&passwd=1234
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		// 문자열 단위로 response 객체에 내용을 출력할 수 있는 출력 스트림 객체를 생성한다.
		PrintWriter out = response.getWriter();
		
		// URL 에서 포트번호와 슬래시 다음이 웹 애플리케이션 이름을 의미하며 이 값을 추출한다.
		// getContextPath() : 웹 애플리케이션 경로 정보를 반환한다. /프로젝트 폴더 이름
		out.println("웹 애플리케이션 경로 정보: " + request.getContextPath());
		// response 객체 타입이 html 이므로 생성하지 않은 <html><head></head><body> </body></html> 태그들 자동으로 생성된다.
		
		// 응답에 id 변수 값과 passwd 변수 값을 출력하는 부분
		out.println("<br>" + "아이디=" + id + "<br>");
		out.println("비밀번호=" + passwd + "<br>");
		out.close();
	}
}
