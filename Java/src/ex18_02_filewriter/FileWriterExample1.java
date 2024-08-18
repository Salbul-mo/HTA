package ex18_02_filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample1 {
	public static void main(String[] args) {

		FileWriter writer = null;

		try {
			/*
			 * 생성자의 매개변수가 열 파일의 이름을 의미한다. output.txt파일이 없는 경우에는 파일을 직접 생성 후 파일이 열린다. 만약 이름이
			 * 있는 경우 기존의 파일 내용이 지워진다.
			 */
			writer = new FileWriter("output.txt");
			/*
			 * public FileWriter(String fileName) throws IOException FileWriter 생성자는
			 * IOException에러를 발생하기 때문에 예외처리 해주어야 한다.
			 */

			char arr[] = { '내', '꺼', '인', ' ', '듯', ' ', '내', '꺼', ' ', '아', '닌', ' ', '내', '꺼', ' ', '같', '은', ' ',
					'너' };

			// 파일에 반복해서 문자들을 쓴다.
			for (int cnt = 0; cnt < arr.length; cnt++) {
				writer.write(arr[cnt]);
			}
			// -> 프로젝트 폴더에 output.txt 로 파일이 생성된다. 
			
			// writer.wrtie(arr);
		} catch (IOException e) {
			System.out.println("파일로 출력할 수 없습니다.");
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				System.out.println("파일 닫는 중 오류입니다.");
			}
		}

	}
}
