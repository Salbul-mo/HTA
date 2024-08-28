package ex18_10_file;

import java.io.*;

public class FileExample2_5 {

	public static void main(String[] args) {
		
		String dir = "D:\\newDirectory\\test"; // 디렉토리 경로
		//부모 디렉토리가 없을 때 mkdir() 로 디렉토리 생성 시도
		//디렉토리 생성에 실패했습니다.
		File f2 = new File(dir); 
		if(!f2.exists()) { 
			if(f2.mkdir()) { 
				System.out.println("새로 만든 디렉토리 이름 : " + f2.getPath()); // 디렉토리 경로 출력
			} else {
				System.out.println("디렉토리 생성에 실패했습니다.");
			}
		} else { 
			System.out.println("이미 있는 디렉토리 이름 : " + f2.getPath()); // 디렉토리 경로 출력
		}
		
		
	}
}
