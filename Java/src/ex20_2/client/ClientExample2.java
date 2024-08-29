package ex20_2.client;
//클라이언트 프로그램

import java.io.*;
import java.net.*;

public class ClientExample2 {

	public static void main(String[] args) {

		System.out.println("여기는 클라이언트 입니다.");

		Socket socket = null;

		try {
			// 생성자를 호출하면 이 생성자 안에서 서버 프로그램으로(파라미터로 준 IP주소와 포트로) 연결 요청이 전송되고
			// 그 결과 클라이언트 프로그램과 서버 프로그램의 연결이 맺어지게 된다. (서버 프로그램의 소켓과 연결)
			// 소켓을 생성한다.
			// 127.0.0.1 은 예약된 IP 주소로 localhost 또는 루프백(loopback) 주소 라고 하며 자신의 컴퓨터를 의미한다.
			socket = new Socket("127.0.0.1", 9001);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			// 데이터를 송신한다.
			// println 메서드 호출 즉시 네트워크로 송신되는 것이 아니라 버퍼가 다 찰때까지 모아졌다가 한꺼번에 송신된다.
			// 해당 문자열을 바로 송신하려면 flush 메서드를 호출해야 한다.
			
			writer.println("Hello, Server2");
			writer.flush();
			
			// 데이터를 수신한다.
			String str = reader.readLine();
			// 수신된 데이터를 출력한다.
			System.out.println(str);
			


		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception ignored) {
				System.out.println("소켓을 닫는 중 에러 발생했습니다.");
			}
		}
	}
}
