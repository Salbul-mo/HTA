package ex18_10_file;

import java.io.*;

public class FileExample2_4 {

	public static void main(String[] args) {


		File f4 = new File("D:\\newDirectory"); 
		//디렉토리에 파일이 존재할 때 삭제 시도
		//D:\newDirectory 삭제 하지 못했습니다.
		if(f4.exists()) {
			if(f4.delete()) { 
				
				System.out.println(f4.getPath() + " 삭제했습니다.");
			} else {
				System.out.println(f4.getPath() + " 삭제 하지 못했습니다.");
			} 
		} else { 
			System.out.println(f4.getPath()+ "에 삭제하고자 하는 파일이 없습니다.");
		}

	}
}
