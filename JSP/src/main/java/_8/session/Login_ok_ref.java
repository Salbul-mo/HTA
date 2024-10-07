package _8.session;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ex1/_8.session/login_ok_ref")
public class Login_ok_ref extends HttpServlet {

	private static final long serialVersionUID = 1870829536491551081L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		PrintWriter writer = response.getWriter();
		
		if (!id.equals("java")) {
			writeRespAndRedirect(writer,"아이디");
			return;
		}
		
		if (!passwd.equals("java")) {
			writeRespAndRedirect(writer,"비밀번호");
			return;
		}
		
		HttpSession session = request.getSession();
		// 입력 값이 설정 값과 일치할 때만 세션에 속성 저장해야한다.
		session.setAttribute("id", id);
		response.sendRedirect("loginSuccess2.jsp");
		
	}
	
	private void writeRespAndRedirect(PrintWriter writer, String errorMsg) {
		writer.write(String.format("""
						<!DOCTYPE html>
						<html>
						<head>
							<meta charset="UTF-8">
							<script>
								alert("%s가 일치하지 않습니다.");
								window.location.href="login_ref.jsp";
							</script>
						</head>
						<body>
						</body>
						</html>
									""", errorMsg));
	}
	/*
	// 자바 15부터 텍스트 블록 """  문자열 블럭  """ => 문자열 입력을 쉽게 할 수 있다. 
	// 들여쓰기 는 최소 공백을 기준으로 입력된다. 큰 따옴표는 따로 이스케이프할 필요 없다.
	// 줄바꾸기는 따로 이스케이프할 필요는 없으나 캐리지 리턴(\r)은 명시적으로 추가해야 한다.
	// 줄 바꿈 후 텍스트 뒤의 공백은 일반적으로 무시된다.
	public String getFormattedText(String parameter) {
    		return """
            		Some parameter: %s
            		""".formatted(parameter);
	}
	// 텍스트 블록에 자체적으로 String.format 을 출력할 수 있는
	// """ 텍스트 블록 """.formatted(parameter); 가 추가되었다.
	 */
}
		
		

