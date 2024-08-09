package ex18_01_filereader;

import java.io.*;

public class FileReaderExample2 {

	public static void main(String[] args) {

		// FileReader reader = new FileReader("poem.txt");
		// -> 이건 상대경로이다. 현재 프로젝트가 있는 폴더의 poem.txt 라는 의미.
		// exception type FileNotFoundException
		/*
		 * 절대 경로는 드라이브명부터 차례대로 파일의 위치를 지정해야한다 ex) D:/작업폴더/프로젝트/poem.txt 의미
		 */
		
		
		FileReader reader = null;
		/*
		 * Reads text from character files using a default buffer size. 
		 * Decoding from bytes to characters uses either a specified charset or the platform's default charset. 
		 * The FileReader is meant for reading streams of characters. 
		 * For reading streams of raw bytes, consider using a FileInputStream.
		 */
		// 참조형의 기본값은 null로 준다.
		
		try {
			
			// 1.파일을 연다. 생성자 인자값으로 파일의 위치를 지정한다. 지정 방법 : 상대 경로와 절대 경로 이용
			reader = new FileReader("poem2.txt");

			// 2. 파일을 읽어서 처리한다.
			while (true) {
				// read() : 파일에 있는 문자 하나를 읽어서 리턴하는 메서드
				int data = reader.read(); // 정수 반환. Reader의 read() 메서드 오버라이딩 된 메서드이다.
				                          //IOException 던진다.
				if (data == -1) // 더 이상 읽을 데이터가 없으면 -1이 반환된다.
					break;
				char ch = (char) data;
				System.out.print(ch);
			}

		} catch (FileNotFoundException e1) { // 파일 열 때 일어나는 예외 처리
			//This exception will be thrown by 
			//the FileInputStream, FileOutputStream, and RandomAccessFile 
			//constructors when a file with the specified pathname does not exist
			System.out.println("파일 열 때");
		} catch (IOException e) {
			System.out.println("파일 읽을 때"); // 파일 읽을 때 일어나는 예외 처리
		} finally {
			try {
				// 3. 파일을 닫는다
				if(reader != null) // 앞선 try 에서 예외 발생해서 finally로 넘어온 경우 reader의 상태 체크 
				reader.close();
				//Closes the stream and releases any system resources associated with it. 
				//Once the stream has been closed further read(), ready(),mark(), reset(), or skip() 
				//invocations will throw an IOException
				//Closing a previously closed stream has no effect.
			} catch (IOException e) { // 파일 닫을 때 일어나는 예외 처리
				System.out.println("파일 닫을 떄");
				
			}
		}

	}
	/*
	<별을 헤는 밤>
    
    지은이 : 윤 동주

계절이 지나가는 하늘에는
가을로 가득 차 있습니다.

나는 아무 걱정도 없이
가을 속의 별들을 다 헤일 듯 합니다.

가슴속에 하나 둘 새겨지는 별을
이제 다 못 헤는 것은
쉬이 아침이 오는 까닭이요,
내일 밤이 남은 까닭이요,
아직 나의 청춘이 다하지 않은 까닭입니다.

별 하나에 추억과
별 하나에 사랑과
별 하나에 쓸쓸함과
별 하나에 동경과
별 하나에 시와
별 하나에 어머니, 어머니,
어머님, 나는 별 하나에
아름다운 말 한 마디씩 불러 봅니다.
*/
}