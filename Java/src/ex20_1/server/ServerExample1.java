package ex20_1.server;
//서버 프로그램을 먼저 실행하고 클라이언트 프로그램을 실행한다.

import java.net.*;
import java.io.*;

public class ServerExample1 {

	public static void main(String[] args) {
		
		System.out.println("여기는 서버입니다.");
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			// 서버 소켓은 연결 요청을 기다리다가
			// 연결 요청이 오면 연결을 맺고 또 다른 소켓을 생성한다.
			serverSocket = new ServerSocket(9000); //서버 소켓을 생성한다.
			
			// accept() 메서드 : 서버 소켓으로 연결 요청이 들어오면 연결을 맺고
			// 클라이언트 소켓을 생성해서 리턴하는 메서드
			socket = serverSocket.accept();
			
			// 데이터 수신에 사용할 입력 스트림 객체를 리턴하는 메서드
			InputStream in = socket.getInputStream();
		}
	}
}
