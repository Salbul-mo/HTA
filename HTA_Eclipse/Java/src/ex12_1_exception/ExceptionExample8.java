package ex12_1_exception;

import java.io.*;
//익셉션 파라미터의 다형성을 보여주는 예
//익셉션을 처리하지 않아서 컴파일 오류가 발생한다.
//java.lang.Throwable
//	java.lang.Exception
//		java.io.IOException
//			java.io.FileNotFoundException
public class ExceptionExample8 {

	public static void main(String[] a) {

		FileReader reader = null;

		try {
			reader = new FileReader("some.txt");
			// java.io.FileReader.FileReader(String fileName)
			// throws FileNotFoundException -> IOException 을 상속한다.
			// 해당 블럭에서만 사용할 수 있다.
		} catch (IOException e) {
			System.out.println("입출력 오류 입니다.");
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
			}
		}
	
	
	}
	
}