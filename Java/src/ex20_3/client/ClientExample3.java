package ex20_3.client;

import java.net.*;
// 연결된 소켓을 닫으면 안된다.
public class ClientExample3 {

	public static void main (String[] args) {
		
		System.out.println("여기는 클라이언트 입니다.");
		
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 9002);
			
			// 두 개의 스레드 생성
			Thread thread1 = new ReceiverThread(socket);
			Thread thread2 = new SenderThread(socket);
			
			// 두 개의 스레드를 시작
			thread1.start();
			thread2.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
