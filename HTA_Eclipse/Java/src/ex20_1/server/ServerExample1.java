package ex20_1.server;
//서버 프로그램을 먼저 실행하고 클라이언트 프로그램을 실행한다.

import java.net.*;
import java.io.*;

public class ServerExample1 {

	public static void main(String[] args) {
		
		System.out.println("여기는 서버입니다.");
		
		ServerSocket serverSocket = null; // 요청 받는 서버 소켓 생성. 참조값 null
		Socket socket = null; // 스트림용 클라이언트 소켓 생성. 참조값 null
		
		try {
			// 서버 소켓은 연결 요청을 기다리다가
			// 연결 요청이 오면 연결을 맺고 또 다른 소켓을 생성한다.
			serverSocket = new ServerSocket(9000); //서버 소켓을 생성한다.
			
			// accept() 메서드 : 서버 소켓으로 연결 요청이 들어오면 연결을 맺고
			// 통신용 클라이언트 소켓을 생성해서 리턴하는 메서드
			socket = serverSocket.accept();
			
			// 데이터 수신에 사용할 입력 스트림 객체를 리턴하는 메서드
			InputStream in = socket.getInputStream();
			
			// 데이터 송신에 사용할 출력 스트림 객체를 리턴하는 메서드
			OutputStream out = socket.getOutputStream();
			
			byte arr[] = new byte[128]; // byte 단위를 사용하기 때문에 byte 배열 생성
			in.read(arr); // byte 배열 사용해서 데이터 수신
			
			//수신된 데이터를 출력
			System.out.println(new String(arr));
			
			String str = "Hello, Client";
			
			//getBytes() 메서드는 문자열을 바이트 배열로 만드는 메서드이다.
			out.write(str.getBytes()); // 데이터를 송신한다.
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 일단 예외처리 한방에 
		} finally {
			try {
				socket.close(); // 소켓 닫기
			} catch (Exception ignored) { // 소켓 닫는 중 생기는 예외처리  
				System.out.println("소켓 닫는 중 에러입니다.");
			}
			try {
				serverSocket.close(); // 서버 소켓 닫기
			} catch (Exception ignored) {
				System.out.println("서버 소켓을 닫는 중 에러입니다.");
			}
		}
	}
}
