package ex18_10_file;

import java.io.File;

public class FileExample3_1 {
	public static void main(String[] args) {

		String dir = "D:\\newDirectory\\test"; // 디렉토리 경로

		File f2 = new File(dir);
		if (!f2.exists()) {
			if (f2.mkdirs()) {
				// mkdirs() 메서느는 디렉토리를 생성하면서 부모 디렉토리가 없는 경우 부모 디렉토리까지 생성한다.
				// 새로 만든 디렉토리 이름 : D:\newDirectory\test
				System.out.println("새로 만든 디렉토리 이름 : " + f2.getPath());
			} else {
				System.out.println("디렉토리 생성에 실패했습니다.");
			}
		} else {
			System.out.println("이미 있는 디렉토리 이름 : " + f2.getPath());
		}

	}
}
