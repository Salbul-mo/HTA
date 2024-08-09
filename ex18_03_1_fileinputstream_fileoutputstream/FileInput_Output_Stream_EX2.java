package ex18_03_1_fileinputstream_fileoutputstream;

import java.io.*;

public class FileInput_Output_Stream_EX2 {

	public static void main(String[] args) {
		// try - with - resource 문을 사용하기
		try (FileInputStream in = new FileInputStream("D:/temp/Koala.jpg");
				FileOutputStream out = new FileOutputStream("D:/temp2/Koala_copy.jpg");) {

			byte[] readByte = new byte[1024];
			// 1Kb 씩 전송

			while (in.read(readByte) != -1) { // 읽어들어온 데이터가 -1이 아니면

				out.write(readByte); // 출력

			}

		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage()); // 파일 열때 에러
		} catch (IOException e2) {
			System.out.println(e2.getMessage()); // 읽을 때 에러
		}
	}

}
