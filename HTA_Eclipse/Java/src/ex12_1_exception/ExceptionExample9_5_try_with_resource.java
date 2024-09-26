package ex12_1_exception;
//상속 관계에 있는 두 종류의 Exception을 처리하는 try 문
//FileNotFoundException - > IOException 상속
import java.io.*;
public class ExceptionExample9_5_try_with_resource {

	public static void main(String[] args) {
		try(FileReader reader = new FileReader("some.txt")) {
			System.out.println("try문 안입니다.");
		} catch (IOException e) {
			System.err.println("입출력 에러가 발생했습니다.");
		}
		
		//오류 처리 한번으로 close(); 까지 한번에 수행된다.
	}
}
