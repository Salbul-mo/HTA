package ex18_01_filereader;

import java.io.*;

public class FileReaderExample1 {

	public static void main(String[] args) {
		/*
		 * 1.파일을 연다. 
		 * 생성자 인자값으로 파일의 위치를 지정한다.
		 *  지정 방법 : 상대 경로와 절대 경로 이용
		 * 
		 */
		//FileReader reader = new FileReader("poem.txt");
		//-> 이건 상대경로이다. 현재 프로젝트가 있는 폴더의 poem.txt 라는 의미.
		//exception type FileNotFoundException
		/*
		 *절대 경로는 드라이브명부터 차례대로 파일의 위치를 지정해야한다
		 *ex) D:/작업폴더/프로젝트/poem.txt 의미 
		 */
		FileReader reader = new FileReader("poem.txt");
		
		
		// 2. 파일을 읽어서 처리한다.
		while(true) {
			//read() : 파일에 있는 문자 하나를 읽어서 리턴하는 메서드
			int data = reader.read();
			if(data == -1) //더 이상 읽을 데이터가 없으면 -1이 반환된다.
				break;
			char ch = (char) data;
			System.out.print(ch);
		}
		
		// 3. 파일을 닫는다.
		reader.close();
	}

}
