package ex20_1.client;
//클라이언트 프로그램

import java.io.*;
import java.net.*;

public class ClientExample1 {

	public static void main(String[] args) {

		System.out.println("여기는 클라이언트 입니다.");

		Socket socket = null;

		try {
			// 생성자를 호출하면 이 생성자 안에서 서버 프로그램으로(파라미터로 준 IP주소와 포트로) 연결 요청이 전송되고
			// 그 결과 클라이언트 프로그램과 서버 프로그램의 연결이 맺어지게 된다. (서버 프로그램의 소켓과 연결)
			// 소켓을 생성한다.
			// 127.0.0.1 은 예약된 IP 주소로 localhost 또는 루프백(loopback) 주소 라고 하며 자신의 컴퓨터를 의미한다.
			socket = new Socket("127.0.0.1", 9000);

			// 데이터 수신에 사용할 입력 스트림 객체를 리턴하는 메서드
			InputStream in = socket.getInputStream();
/*Returns an input stream for this socket. 
If this socket has an associated channel then the resulting inputstream delegates all of its operations to the channel.
If the channel is in non-blocking mode then the input stream's read operations will throw an java.nio.channels.IllegalBlockingModeException. 
Under abnormal conditions the underlying connection may be broken by the remote host or the network software
(for example a connection reset in the case of TCP connections). 
When a broken connection is detected by the network software the following applies to the returned input stream 

:- 
•The network software may discard bytes that are buffered by the socket. Bytes that aren't discarded by the network software can be read using read. 
•If there are no bytes buffered on the socket, or all buffered bytes have been consumed by read, then all subsequent calls to read will throw an IOException. 
•If there are no bytes buffered on the socket, and the socket has not been closed using close, then available will return 0. 

Closing the returned InputStreamwill close the associated socket.
Returns:an input stream for reading bytes from this socket.
*/

			OutputStream out = socket.getOutputStream();
/*Returns an output stream for this socket. 
If this socket has an associated channel then the resulting outputstream delegates all of its operations to the channel.
If the channel is in non-blocking mode then the output stream's write operations will throw an java.nio.channels.IllegalBlockingModeException. 

Closing the returned OutputStreamwill close the associated socket.
Returns:an output stream for writing bytes to this socket.
*/

			String str = "Hello, Server";
			// gerBytes 메서드는 문자열을 바이트 배열로 만드는 메서드이다.
			// 인자로 넘겨준 데이터를 송신한다.
			out.write(str.getBytes());

			byte arr[] = new byte[128];
			in.read(arr); // 데이터 수신
			System.out.println(new String(arr)); // 수신된 데이터를 출력한다. 바이트를 이용해서 문자열 생성할 수 있다.
			/*
			 * java.lang.String.String(byte[] bytes)
			 * Constructs a new String by decoding the specified array of bytes using the platform's default charset.
			 * The length of the new String is a function of the charset, and hence may not be equal to the length of the byte array.
			 * The behavior of this constructor when the given bytes are not valid in the default charset is unspecified. 
			 * The java.nio.charset.CharsetDecoder class should be used when more control over the decoding process is required.
			 * 
			 */

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
