package ex20_3.client;

import java.net.*;
import java.io.*;

//수신한 문자열을 출력하는 스레드
public class ReceiverThread extends Thread {

	private Socket socket = null;

	ReceiverThread(Socket socket) {
		this.socket = socket;
	}

	/*
	 * public void run() 기능 : 클라이언트로부터 메시지를 수신(reader.readLine())해서 모니터로 출력합니다. 소켓의
	 * 연결이 끊어지면 수신된 문자열은 null입니다. null이면 반복문을 벗어납니다. 출력문)System.out.println("수신>" +
	 * str);
	 */
	public void run() {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

			while (!socket.isClosed()) { // 소켓이 열려 있는 동안 반복 

				String str = reader.readLine();

				// 소켓의 연결이 끊어지면 null을 리턴합니다.
				if (str == null) {
					System.out.println("연결이 끊어졌습니다.");
					break;
				} else {
					// 수신된 메시지를 모니터로 출력합니다.
					System.out.println("수신>" + str);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}
/*
BufferedReader reader = null;
try {
	reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	while (!socket.isClosed()) {
		
		String str = reader.readLine();

		 //소켓의 연결이 끊어지면 null을 리턴합니다.
		if(str == null)
			break;
		
		else
		// 수신된 메시지를 모니터로 출력합니다.
		System.out.println("수신>" + str);
	}
	
} catch (Exception e) {			
	System.out.println(e.getMessage());
} finally {
try{
   reader.close();
} catch (Exception ignored) {
	System.out.println("BufferedReader를 닫는 중 오류가 일어났습니다.");
}
}

*/