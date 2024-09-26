package ex18_10_file;
//File 클래스를 이용해 디렉토리 생성
//실행 한 번 후 : 새로 만든 디렉토리 이름 출력
//실행 두 번 후 : 이미 있는 디렉토리 이름 출력
import java.io.*;

public class FileExample2_1 {

	public static void main(String[] args) {
		
		String dir = "D:\\newDirectory"; // 디렉토리 이름
		
		File f2 = new File(dir); // 디렉토리 객체 생성
		if(!f2.exists()) { //D:\\newDirectory 디렉토리가 없는 경우
			if(f2.mkdir()) { // 디렉토리 생성 - 생성하면 true, 실패하면 false
				System.out.println("새로 만든 디렉토리 이름 : " + f2.getPath()); // 디렉토리 경로 출력
			} else {
				System.out.println("디렉토리 생성에 실패했습니다.");
			}
		} else { // D:\\newDirectory 디렉토리가 이미 있는 경우
			System.out.println("이미 있는 디렉토리 이름 : " + f2.getPath()); // 디렉토리 경로 출력
		}
		
		
	}
}
/*
처음 실행
새로 만든 디렉토리 이름 : D:\newDirectory

두번째 실행
이미 있는 디렉토리 이름 : D:\newDirectory
*/