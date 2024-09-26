package ex18_03_1_fileinputstream_fileoutputstream;

import java.io.*;

public class FileInput_Output_Stream_EX {

	public static void main(String[] args) {

		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream("D:/temp/Koala.jpg");
			// 절대 경로 슬래시 . 읽어 들어올 파일 "경로/파일이름.확장자"
			// "D:\\temp\\Koala.jpg"도 된다. ??
			out = new FileOutputStream("D:/temp2/Koala_copy.jpg");
			// 절대 경로 출력할 파일 "경로/파일이름.확장자"
			// "D:\\temp2\\Koala_copy.jpg" 도 된다. ??

			byte[] readByte = new byte[1024]; // byte 파일로 전송되므로 byte 배열. 배열 크기는 상관없다.
			// 1Kb 씩 전송

			while (true) {
				int num = in.read(readByte);
				// Reads up to b.length bytes of data from this inputstream into an array of bytes
				// byte[] b => the buffer into which the data is read.
				// 반환 타입 int => the total number of bytes read into the buffer,
				// or -1 if there is no more data because the end of the file has been reached.

				if (num == -1) // 읽을 데이터 없으면 반복문 탎출
					break;

				out.write(readByte); 
				// in.write(readByte, 0, readCount);
				// Writes b.length bytes from the specified byte array to this file outputstream.
				// byte[] b => buffer which the data was input
			}

		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage()); // 파일 열때 에러
		} catch (IOException e2) {
			System.out.println(e2.getMessage()); // 읽을 때 에러
		} finally {
			try { // 따로 따로 try-catch해주어야 한다.
				if (in != null)
					in.close();
			} catch (IOException e3) {
				System.out.println(e3.getMessage()); // 닫을 때 에러
			}
			try { // 따로 따로 try-catch해주어야 한다.
				if (out != null)
					out.close();
			} catch (IOException e3) {
				System.out.println(e3.getMessage()); // 닫을 때 에러
			}
		}

	}
}
