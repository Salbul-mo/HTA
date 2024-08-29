package ex20_4.server;

import java.net.*;
//무한 루프를 돌면서 요청을 기다리다가 요청이 오면 소켓을 생성해서 연결하고
//해당 연결 정보를 저장 및 관리하는 다인 채팅 프로그램의 서버 프로그램
public class SeverExample {

	public static void main(String[] args) {
		System.out.println("여기는 서버 입니다.");
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(9002);
			//서버 소켓은 딱 하나만 사용하므로 while 문 안에 넣지 않는다.
			
			while (true) {
				// 연결 요청이 오면 소켓을 생성한다.
				// accept() 메서드 : 서버 소켓으로 연결 요청이 들어오면 연결을 맺고 
				// 클라이언트 소켓을 생성해서 리턴하는 메서드
				Socket socket = serverSocket.accept();
				
				// 요청이 오고 소켓이 생성될 때마다 스레드 생성
				Thread thread = new PerClientThread(socket); //socket 
				 thread.start();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
