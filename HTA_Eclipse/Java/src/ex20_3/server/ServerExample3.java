package ex20_3.server;

import java.net.ServerSocket;
import java.net.Socket;

//서버와 클라이언트 간 1:1 대화 프로그램. 연결된 후 서버 소켓만 닫아야한다. 통신용 클라이언트 소켓까지 닫으면 안된다는 점 명심

public class ServerExample3 {
	
	public static void main(String[] args) {
		
		System.out.println("여기는 서버입니다.");
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(9003);
/*
java.net.ServerSocket.ServerSocket(int port) throws IOException
Creates a server socket, bound to the specified port. 
A port number of 0 means that the port number is automatically allocated, typically from an ephemeral port range. 

This port number can then be retrieved by calling getLocalPort. 

The maximum queue length for incoming connection indications(are quest to connect) is set to 50.
If a connection indication arrives when the queue is full, the connection is refused. 

If the application has specified a server socket implementation factory,
that factory's create Socket method is called to create the actual socket implementation.
Otherwise a system-default socket implementation is created. 

If there is a security manager, its checkListen method is called with the port argument 
as its argument to ensure the operation is allowed. This could result in a SecurityException.
Parameters: port the port number, or 0 to use a port number that is automatically allocated.
*/
			socket = serverSocket.accept();
/*
Socket java.net.ServerSocket.accept() throws IOException
Listens for a connection to be made to this socket and accepts it. 
The method blocks until a connection is made. 
A new Socket s is created and, if there is a security manager,
the security manager's checkAccept method is called with s.getInetAddress().getHostAddress() and s.getPort()
as its arguments to ensure the operation is allowed. This could result in a SecurityException.
Returns:the new Socket
*/
			
			System.out.println("================접속정보==================");
			System.out.println(socket.getInetAddress().getHostAddress() + " 에서 접속하였습니다.");
			//socket 이 연결된 IP주소를 받아오는 메서드와 IP주소를 문자열로 바꿔주는 메서드를 사용하여 출력
			System.out.println("========================================");
/*
InetAddress java.net.Socket.getInetAddress() 
IP 주소를 리턴한다. 연결된 후 소켓이 닫혀도 연결된 IP주소를 리턴한다. 소켓이 연결되지 않았을 때만 null을 리턴한다.
Returns the address to which the socket is connected. 

If the socket was connected prior to being closed, 
then this method will continue to return the connected address after the socket is closed.
Returns: the remote IP address to which this socket is connected, or null if the socket is not connected.


String java.net.InetAddress.getHostAddress()
IP주소를 문자열화 시켜서 리턴한다.
Returns the IP address string in textual presentation.
Returns: the raw IP address in a string format.
*/
			
			// 두 스레드를 생성한다
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			
			// 두 스레드를 시작한다
			thread1.start();
			thread2.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				serverSocket.close(); // 서버 소켓만 닫는다.
			} catch (Exception ignored) {
				System.out.println("서버 소켓을 닫는 중 에러가 발생했습니다.");
			}
		}
	}

}
