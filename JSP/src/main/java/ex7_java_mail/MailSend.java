package ex7_java_mail;

import java.io.*;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/mailSend")
public class MailSend extends HttpServlet {

	private static final long serialVersionUID = 4981936721073969588L;

	public MailSend() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String sender = request.getParameter("sender");
		String receiver = request.getParameter("receiver");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		String server = "smtp.naver.com";
		
		int port = 587;
		
		try {
			
			// 서버 정보를 Properties 객체에 저장한다.
			Properties properties = new Properties();
			
			// SMTP 서버 정보 설정
			// 네이버일 경우 smtp.naver.com
			properties.put("mail.smtp.host", server);
			properties.put("mail.smtp.port", port);
			
			// 이메일 전송 시 보안을 위해 사용하는 SSL 프로토콜을 설정한다. 여기서는 TLS 1.2 를 사용하도록 지정한다.
			properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
			
			// 위에서 설정한 SMTP 서버 정보를 기반으로 세션을 생성한다.
			Session s = Session.getInstance(properties);
			
			// 보내는 메일과 받는 주소를 설정한다.
			Address senderAddress = new InternetAddress(sender);
			Address receiverAddress = new InternetAddress(receiver);
			
			// 메일을 보내기 위한 정보를 입력하기 위해 Message 객체를 생성한다.
			Message message = new MimeMessage(s);
			
			// 보내는 메일의 내용이 한글일 경우 깨지지 않도록 content-type을 지정한다.
			message.setHeader("content-type", "text/html;charset=UTF-8");
			
			// 보내는 메일 주소 정보를 설정한다.
			message.setFrom(senderAddress);
			
			// 수신자 추가한다.
			message.addRecipient(Message.RecipientType.TO, receiverAddress);
			
			// 제목 정보를 설정한다.
			message.setSubject(subject);
			
			// 내용의 정보를 설정한다.
			message.setContent(content, "text/html;charset=UTF-8");
			
			// 보내는 날짜를 설정한다.
			message.setSentDate(new java.util.Date());
			
			// SMTP 서버에 연결하기 위한 Transport 객체를 생성한다.
			Transport transport = s.getTransport("smtp");
			
			// 발신자의 이메일 아이디와 비밀번호로 연결한다.
			transport.connect(server, MyInfo.naverid, MyInfo.naverpass);
			
			transport.sendMessage(message, message.getAllRecipients());
			
			transport.close();
			
			out.println("<h3>메일이 정상적으로 전송되었습니다.</h3>");
		} catch (Exception e) {
			out.println("SMTP 서버가 잘못 설정되었거나, 서비스에 문제가 있습니다.");
			e.printStackTrace();
		}
	}
}
