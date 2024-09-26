package ex18_10_file;

import java.io.*;

public class FileExample2_3 {

	public static void main(String[] args) {

		String dir = "D:\\newDirectory\\newFile.txt"; // 디렉토리 문자열

		File f3 = new File(dir); // 디렉토리로 파일 객체 생성
		if(f3.exists()) { // f3 객체가 존재하면
			if(f3.delete()) { // 객체 파일 삭제 
				// 삭제 성공하면 true, 실패하면 false 반환
				System.out.println(f3.getPath() + " 삭제했습니다.");
			} else {
				System.out.println(f3.getPath() + " 삭제 하지 못했습니다.");
			} 
		} else { // f3 객체 파일이 없으면
			System.out.println(f3.getPath()+ "에 삭제하고자 하는 파일이 없습니다.");
		}

	}
}
/*
첫번째 실행
D:\newDirectory\newFile.txt 삭제했습니다.
두번째 실행
D:\newDirectory\newFile.txt에 삭제하고자 하는 파일이 없습니다.
*/