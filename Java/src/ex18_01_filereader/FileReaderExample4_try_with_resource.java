package ex18_01_filereader;

import java.io.*;

public class FileReaderExample4_try_with_resource {

	public static void main(String[] args) {
		char arr[] = new char[64]; // 파일에 있는 문자를 담을 char 배열

		/*
		 * 1. try - with -resource 문으로 try() 안에 선언된 자원은 
		 * try 문이 끝날 때 자동으로 close()메서드를 호출한다.
		 * 
		 * 2. try - with -resource문에 의해 자동으로 객체의 close()가 호출될 수 있으려면 
		 * 클래스가 AutoCloseable이라는 인터페이스를 구현한 것이어야 한다.
		 * 
		 */
		try (FileReader reader = new FileReader("poem.txt")) {

			while (true) {

				int num = reader.read(arr); // (cbuf Destination buffer 매개 변수)
				//char arr 에 64개의 문자가 담길 때까지 또는 파일이 끝날 때까지 데이터를 배열에 집어넣고 
				// 집어넣은 데이터 갯수를 int로 반환
				if (num == -1) // 반환 받은 숫자가 -1이 아니면
					break;
				for (int cnt = 0; cnt < num; cnt++) { 
					// arr배열에 담긴 데이터를 num 숫자만큼 출력하는 반복문
					System.out.printf("%c", arr[cnt]);
				}
			}
			//while end. reader.read(arr)이 -1을 반환할 때까지 반복한다.
		} catch (FileNotFoundException e1) {
			System.out.println("파일 열 때");
		} catch (IOException e) {
			System.out.println("파일 읽을 때 & 닫힐 때");
		} finally {
			System.out.println("final 입니다.");

		}
	}

}

/*
 * <별을 헤는 밤>
 * 
 * 지은이 : 윤 동주
 * 
 * 계절이 지나가는 하늘에는 가을로 가득 차 있습니다.
 * 
 * 나는 아무 걱정도 없이 가을 속의 별들을 다 헤일 듯 합니다.
 * 
 * 가슴속에 하나 둘 새겨지는 별을 이제 다 못 헤는 것은 쉬이 아침이 오는 까닭이요, 내일 밤이 남은 까닭이요, 아직 나의 청춘이 다하지
 * 않은 까닭입니다.
 * 
 * 별 하나에 추억과 별 하나에 사랑과 별 하나에 쓸쓸함과 별 하나에 동경과 별 하나에 시와 별 하나에 어머니, 어머니, 어머님, 나는 별
 * 하나에 아름다운 말 한 마디씩 불러 봅니다.
 */