package ex20_4.server;

import java.net.*;
import java.io.*;

//수신한 문자열을 출력하는 스레드
public class ReceiverThread extends Thread {

	private Socket socket;

	ReceiverThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (!socket.isClosed()) {

				String str = reader.readLine();

				// 소켓의 연결이 끊어지면 null을 리턴합니다.
				if (str == null)
					break;

				else
					// 수신된 메시지를 모니터로 출력합니다.
					System.out.println(str);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				reader.close();
			} catch (Exception ignored) {
				System.out.println("BufferedReader를 닫는 중 오류가 일어났습니다.");
			}
		}
	}
}
