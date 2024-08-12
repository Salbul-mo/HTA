package ex18_02_filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample2_String {
	public static void main(String[] args) {

		FileWriter writer = null;

		try {
			writer = new FileWriter("output.txt", true);
			// true : append(원래 있던 파일에 추가로 쓴다)
			// false : overwrite(덮어쓰기 한다)
			String message = "맛점하세요";
			/*
			String message = "감기 조심하세요~";
			String message = "감기 조심하세요~2";
			String message = "감기 조심하세요~3";
			String message = "감기 조심하세요~4";
			String message = "감기 조심하세요~5";
			*/
			writer.write(message);
			writer.write("\n");// 줄 바꾸는 문자 추가
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
/*
내꺼인 듯 내꺼 아닌 내꺼 같은 너감기 조심하세요~
감기 조심하세요~2
감기 조심하세요~3
감기 조심하세요~4
감기 조심하세요~5
맛점하세요
*/
