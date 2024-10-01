package _1;

import jakarta.servlet.http.*;
import java.io.*;
import java.util.Calendar;

/*
서블릿을 정의한다.
- 서블릿 클래스를 정의하려면 반드시 HttpServlet 클래스를 상속받는다.
- HttpServlet 클래스에 서블릿에 관한 일반적인 기능이 정의되어 있기 때문에
  HttpServlet 클래스를 상속 받은 자식 클래스 또한 서블릿 클래스가 된다.
 */

public class ServletTest extends jakarta.servlet.http.HttpServlet {
	
	private static final long serialVersionUID = 1L;
	// 클래스 동일성 serialUID 지정.
	
	// doGet 메서드를 정의하는 부분이다.
	// 클라이언트에서 요청이 GET 방식으로 전송되어 오면 doGet 메서드가 자동 실행되게 된다.
	public void doGet(HttpServletRequest request, 
						HttpServletResponse response) throws IOException {
		
		// Java Servlet 에서 HTTP 응답 헤더의 Content-Type 값을 설정하는 코드이다.
		// 응답 데이터의 MIME 타입을 HTML 타입의 text 로 지정한다.
		response.setContentType("text/html");
		
		// 응답 타입의 문자 인코딩 타입을 한글이 제대로 출력되도록 "utf-8" 로 지정한다.
		response.setCharacterEncoding("utf-8");
		
		// 위 두 문장을 한 번에 작성하면 다음과 같다.
		// response.setContentType("text/html;charset=utf-8");
		
		// Calendar 객체를 생성하여 객체로부터 시간, 분, 초 값을 얻어온다.
		Calendar c = Calendar.getInstance(); // 현재 시간 데이터 객체
		int hour = c.get(Calendar.HOUR_OF_DAY); // 24시간 형식으로 시간 데이터 얻기
		int minute = c.get(Calendar.MINUTE); // 분 데이터 얻기
		int second = c.get(Calendar.SECOND); // 초 데이터 얻기
		
		// 응답에 내용을 출력할 출력 스트링을 생성한다.
		PrintWriter out = response.getWriter();
		
		// 클라이언트로 응답할 내용을 HTML타입의 데이터로 출력하는 부분이다.
		out.write("<HTML><HEAD><TITLE>ServletTest</TITLE></HEAD>");
		out.write("<BODY style='background:yellow'><H1>");
		out.write("현재시각은 ");
		out.write(Integer.toString(hour));
		out.write("시 ");
		out.write(Integer.toString(minute));
		out.write("분 ");
		out.write(Integer.toString(second));
		out.write("초입니다.");
		out.write("</H1></BODY></HTML>");
		out.close();
	}

}
