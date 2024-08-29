package ex20_3.server;

import java.io.*;
import java.net.*;

//입력한 문자열을 송신하는 스레드
public class SenderThread extends Thread {

	private Socket socket = null;

	SenderThread(Socket socket) {
		this.socket = socket;
	}
	/*
	 * public void run() 완성하세요 기능 : 키보드로 부터 문자열을 입력받습니다. "bye"를 입력하면 반복문을 빠져나갑니다.
	 * 키보드로 부터 입력받은 문자열을 클라이언트로 전송합니다.
	 */

	public void run() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter writer = new PrintWriter(socket.getOutputStream());) 
		{

			while (!socket.isClosed()) {
				// 키보드로부터 문자열을 입력받습니다.
				String str = reader.readLine();

				// 사용자가 "bye"라고 입력하면 반복문을 빠져나갑니다.
				if (str.equals("bye")) {
					break;
				}
				// 입력된 문자열을 송신합니다.
				writer.println(str);
				writer.flush();
				// 입력한 문자열 바로 송신하려면 flush 를 해주어야 한다.
			}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		
		} 
		
	}

}
/*
 * public void run() { PrintWriter writer = null; BufferedReader reader = null;
 * try { reader = new BufferedReader(new InputStreamReader(System.in)); writer =
 * new PrintWriter(socket.getOutputStream());
 * 
 * while (!socket.isClosed()) { // 키보드로부터 문자열을 입력받습니다. String str =
 * reader.readLine();
 * 
 * // 사용자가 "bye"라고 입력하면 반복문을 빠져나갑니다. if (str.equals("bye")) { break; } // 입력된
 * 문자열을 송신합니다. writer.println(str); writer.flush() //문자열 바로 송신하려면 flush 해주어야 한다. } } catch (Exception e) {
 * System.out.println(e.getMessage()); } finally { try { // writer-close(); }
 * catch (Exception e) { e.printStackTrace(); } try { // reader-close(); } catch
 * (Exception e) { e.printStackTrace(); }
 * 
 * } }
 */