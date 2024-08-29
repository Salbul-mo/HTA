package ex20_4.server;

import java.io.*;
import java.util.*;
import java.net.*;

// 각 클라이언트 접속에 대해 하나씩 작동하는 스레드 클래스
public class PerClientThread extends Thread {

	// ArrayList 객체를 여러 스레드가 동시에 사용하게 되면 문제가 발생할 수 있어 안전하게 공유할 수 있는 동기화된 리스트로 만든다
	// 동기화된 리스트로 만들기 위해 java.util.Collections 클래스의 synchronizedList 메서드를 시용한다.
	// 클래스 단위에서 사용하므로 정적 변수로 선언한다.
	private static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());

	private Socket socket;
	private PrintWriter writer;

	PerClientThread(Socket socket) {
		this.socket = socket;
		try {
			this.writer = new PrintWriter(socket.getOutputStream());
			list.add(writer); // 리스트에 소켓의 출력 스트림을 등록한다.
		} catch (IOException e) { // PrintWriter 를 생성할때 생기는 오류 예외 처리
			e.printStackTrace();
		}
	}

	public void run() {
		String name = null;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 수신된 첫번째 문자열을 대화명으로 사용하기 위해 저장합니다.
			/*
			 * SenderThread.java 에서 writer.println(name); writer.flush(); 로 보낸 name을 아래의
			 * 문장에서 읽어들인다.
			 */
			name = reader.readLine();
			// 수신한 문장을 이름으로 사용
			sendAll("#" + name + "님이 들어오셨습니다");

			while (!socket.isClosed()) {
				String str = reader.readLine();

				// 소켓의 연결이 끊어지면 null을 리턴합니다.
				if (str == null)
					break;

				// 수신된 메시지 앞에 대화명을 붙여서 모든 클라이언트로 송신합니다.
				sendAll(name + ">" + str);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			list.remove(writer); // list 에서 해당 writer 정보 제거
			// 사용자가 채팅을 종료했다는 메시지를 모든 클라이언트로 보냅니다.
			sendAll("#" + name + "님이 나가셨습니다");

			try {
				reader.close();
			} catch (Exception ignored) {
				System.out.println("소켓 닫는 중에 에러 발생했습니다.");
			}
		}
	}

	synchronized private void sendAll(String message) { // 해당 스레드에서만 사용하는 메서드이므로 private 처리
		System.out.println(message); // <- 서버에게 출력하게 줄 추가.

		for (PrintWriter writer : list) {
			if (this.writer != writer) // 추가하면 자신에게 보내지 않는다.
				writer.println(message);
			writer.flush();
		}
	}
}
