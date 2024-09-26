package ex18_10_file;

import java.io.*;

public class FileExample3_3_transferTo {

	public static void main(String[] args) {
		String originalFileName = "D:/temp/koala.jpg";

		String targetFileName = "D:/temp2/test/koala_copy.jpg";
		
		//createDirectory(targetFileName.substring(0,targetFileName.lastIndexOf("/")));
		// 저장할 파일이름의 마지막 / 이전까지를 잘라서 createDirectory 메서드에 바로 넘길 수 있다..
		
		String createDirectory = "D:" + File.separator + "temp2" + File.separator + "test";
		//새롭게 저장할 파일의 디렉토리를 생성하기 위해 디렉토리 문자열 생성.
		createDirectory(createDirectory);
		// D:\\temp2\\test 디렉토리 생성하는 메서드
		
		copy(originalFileName, targetFileName);
		// FileInputStream FileOutputStream 사용해서 파일 전송하는 메서드

	}

	private static void copy(String originalFileName, String targetFileName) {
		try (FileInputStream in = new FileInputStream(originalFileName);
				FileOutputStream out = new FileOutputStream(targetFileName);)
		//try with resource 사용해서 FileInputStream(읽어올 파일 위치) 과 FileOutputStream(전송할 파일 위치) 객체 생성
		{
		
			in.transferTo(out);
			//jdk 9 버전 이상부터 사용할 수 있는 파일 전송 메서드이다.
			
		} catch (FileNotFoundException e1) { 
			// in = new FileInputStream 과 out = new FileOutputStream 객체 생성할 때 일어나는 FileNotFoundException 예외 처리 
			System.out.println(e1.getMessage());
		} catch (IOException e2) {
			// in.read(readByte)와 out.write(readByte) 수행 시 일어나는 IOException 예외 처리
			System.out.println(e2.getMessage());
		}
	}

	private static void createDirectory(String createDirectory) {

		File f = new File(createDirectory); // 디렉토리 주소로 파일 객체 생성
		if (!f.exists()) { // 디렉토리 없으면
			if (f.mkdirs()) { // 디렉토리 생성
				System.out.println("디렉토리를 생성했습니다.");
			} else {
				System.out.println("디렉토리 생성에 실패했습니다.");
			}
		} else {
			System.out.println("이미 존재하는 디렉토리 입니다.");
		}

	}
}
