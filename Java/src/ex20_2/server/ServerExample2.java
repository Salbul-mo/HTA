package ex20_2.server;
//서버 프로그램

import java.net.*;
import java.io.*;

public class ServerExample2 {

	public static void main(String[] args) {
		
		System.out.println("여기는 서버입니다.");
		
		ServerSocket serverSocket = null; // 요청 받는 서버 소켓 생성. 참조값 null
		Socket socket = null; // 스트림용 클라이언트 소켓 생성. 참조값 null
		
		try {
			// 서버 소켓은 연결 요청을 기다리다가
			// 연결 요청이 오면 연결을 맺고 또 다른 소켓을 생성한다.
			serverSocket = new ServerSocket(9001); //서버 소켓을 생성한다.
			
			// accept() 메서드 : 서버 소켓으로 연결 요청이 들어오면 연결을 맺고
			// 통신용 클라이언트 소켓을 생성해서 리턴하는 메서드
			socket = serverSocket.accept();
			/*
			 * InputStreamReader클래스:
			 * 바이트 스트림을 문자 스트림으로 바꾸어주는 클래스
			 * 이 클래스이 생성자에 소켓으로부터 얻은 InputStream 객체를 넘겨 주면
			 * 네트워크로 수신된 바이트 데이터를 문자 스트림 형태로 읽을 수 있는 
			 * InputStreamReader 객체가 생성된다.
			 * 
			 * 추가로 BufferedReader 사용한다.
			 */
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			/*
			 * PrintWriter 클래스를 이요하여 문자 스트림을 바이트 스트림으로 바꾸어서 출력하기 위해서는 
			 * 이 클래스의 생성자에 OutputStream 타입의 객체를 파라미터로 넘겨주어야 한다.
			 */
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
/*	
Prints formatted representations of objects to a text-output stream. 
This class implements all of the print methods found in PrintStream. 
It does not contain methods for writing raw bytes, for which a program should use unencoded byte streams. 
Unlike the PrintStream class, if automatic flushing is enabled 
it will be done only when one of the println, printf, or format methods is invoked, 
rather than whenever a newline character happens to be output. 
These methods use the platform's own notion of line separator rather than the newline character. 
Methods in this class never throw I/O exceptions,
although some of its constructors may.
The client may inquire as to whether any errors have occurred by invoking checkError(). 
This class always replaces malformed and unmappable character sequences with the charset's default replacement string.
The java.nio.charset.CharsetEncoder class should be used when more control over the encoding process is required.
*/
			
			// 수신한 문자 스트림 한 줄을 문자열 변수에 대입한다. 
			String str = reader.readLine();
/*
String java.io.BufferedReader.readLine() throws IOException
Reads a line of text. A line is considered to be terminated by any one of a line feed ('\n'), a carriage return ('\r'),
a carriage return followed immediately by a line feed, or by reaching the end-of-file(EOF).
Returns:A String containing the contents of the line, not including any line-termination characters,
or null if the end of the stream has been reached without reading any characters
*/
			// 문자열을 출력한다.
			System.out.println(str);
			
			// 데이터를 송신한다.
			writer.println("Hello, Client2");
/*
void java.io.PrintWriter.println(String x)
Prints a String and then terminates the line. This method behaves as though it invokes print(String) and then println().
Parameters:x the String value to be printed
*/
			writer.flush(); // 버퍼에 남은 데이터 마저 플러시 해준다.
			/*
			 * PrintWriter 클래스의 println() 메서드로 문자열을 출력하면 그 문자열이 메서드 호출 즉시 네트워크로 송신되는 것이 아니라 
			 * 버퍼가 다 찰 때까지 모아졌다가 한꺼번에 송신된다.
			 * 그래서 println() 메서드를 호출한 다음 바로 해당 문자열이 송신되도록 하려면 flush 로 밀어내주어야 한다.
			 */
		
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
