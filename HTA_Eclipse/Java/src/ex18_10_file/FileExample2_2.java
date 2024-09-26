package ex18_10_file;

//File 클래스를 이용해 디렉토리 생성
//실행 한 번 후 : 새로 만든 디렉토리 이름 출력
//실행 두 번 후 : 이미 있는 디렉토리 이름 출력
import java.io.*;

public class FileExample2_2 {

	public static void main(String[] args) {

		String dir = "D:\\newDirectory"; // 디렉토리 이름

		File f2 = new File(dir); // 디렉토리 객체 생성
		if (!f2.exists()) { // D:\\newDirectory 디렉토리가 없는 경우
			if (f2.mkdir()) { // 디렉토리 생성 - 생성하면 true, 실패하면 false
				System.out.println("새로 만든 디렉토리 이름 : " + f2.getPath()); // 디렉토리 경로 출력
			} else {
				System.out.println("디렉토리 생성에 실패했습니다.");
			}
		} else { // D:\\newDirectory 디렉토리가 이미 있는 경우
			System.out.println("이미 있는 디렉토리 이름 : " + f2.getPath()); // 디렉토리 경로 출력
		}

		File f = new File(dir + "\\newFile.txt");
		// D:\\newDirectory\\newFile.txt 절대경로로 파일 객체 생성
		if (f.exists()) { // 이미 존재하는 경우 객체의 경로와 이름 출력
			System.out.println(f.getPath() + "경로에 " + f.getName() + "파일이 있습니다.");
		} else {
			// 없는 경우 해당 객체를 파일로 생성
			// createNewFile > IOException 을 발생시키므로 try catch 로 감싸준다.
			try {

				if (f.createNewFile()) { // 파일 생성
					// boolean java.io.File.createNewFile() throws IOException
					// IOException 발생시킨다.
					System.out.println(f.getPath() + "에 새로운 파일을 만들었습니다.");
					// 경로에 파일생성
				}

			} catch (IOException e) {
				System.out.println("IOException 발생했습니다.");
			}
		}

	}
}
/*
이미 있는 디렉토리 이름 : D:\newDirectory
D:\newDirectory\newFile.txt에 새로운 파일을 만들었습니다.

이미 있는 디렉토리 이름 : D:\newDirectory
D:\newDirectory\newFile.txt경로에 newFile.txt파일이 있습니다.
*/
