package ex20_4.client;

import java.net.*;

public class ClientExample {

	public static void main(String[] args) {
		// args를 파라미터로 실행한다. args 에 입력된 문자열 배열의 크기가 1이 아니면 종료.
		// 대화명 등록을 위한 문자열 하나만 입력 받는다.
		if (args.length != 1) { 
			System.out.print("대화명을 입력하세요>");
			return;
		}
		
		try {
			System.out.println("=======================================");
			System.out.println("나의 대화명은 " + args[0] + "입니다.");
			System.out.println("=======================================");
			
			// 서버와 연결을 맺는다.
			Socket socket = new Socket("127.0.0.1", 9002);
			
			// 메시지 송신 스레드 생성
			Thread thread1 = new SenderThread(socket, args[0]);
			
			// 메시지 수신 스레드 생성
			Thread thread2 = new ReceiverThread(socket);
			
			// 스레드 시작
			thread1.start();
			thread2.start();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
