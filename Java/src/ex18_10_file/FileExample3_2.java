package ex18_10_file;

import java.io.*;
import java.util.*;

public class FileExample3_2 {

	public static void main(String[] args) {

		String directoryPath = "D:" + File.separator + "test_java" + File.separator + "image";
		// The system-dependent default name-separator character,
		// represented as a string for convenience.
		// This string contains a single character, namely separatorChar.
		// 윈도우에서는 D:\\test_java\\image 가 되겠다.

		createDirectory(directoryPath);
		// 디렉토리 문자열을 받아 디렉토리를 생성하는 메서드

		fileDBName("imsi.png", directoryPath);
		// 파일 이름과 디렉토리 문자열을 받아 파일을 생성하는 메서드
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

	private static String fileDBName(String fileName, String saveFolder) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); // 오늘의 년도
		int month = c.get(Calendar.MONTH) + 1; // 오늘의 월 => Calendar.Month는 +1 을 해줘야 한다.
		int date = c.get(Calendar.DATE); // 오늘의 일

		String homedir = saveFolder + File.separator + year + "-" + month + "-" + date;
		System.out.println(homedir);
		//D:\test_java\image\2024-8-28
		File path1 = new File(homedir);
		if (!path1.exists()) { // 디렉토리가 없으면
			path1.mkdirs(); // 새로운 디렉토리를 생성
		}

		Random r = new Random();
		int random = r.nextInt(100000000); // 1~100000000 까지 임의의 정수 생성

		int index = fileName.lastIndexOf("."); 
		// fileName 문자열에서 . 의 마지막 위치
		System.out.println("index  = " + index);
		//index  = 4

		String fileExtension = fileName.substring(index + 1);
		// 마지막 .의 위치를 이용해서 파일 확장자 분리
		System.out.println("fileExtension = " + fileExtension);
		//fileExtension = png
		
		String refileName = "bbs" + year + month + date + random + "." + fileExtension;
		//임의의 문자와 날짜 추가해서 새로운 파일 이름 생성
		System.out.println("refileName = " + refileName);
		//refileName = bbs202482877630745.png

		String fileDBName = File.separator + year + "-" + month + "-" + date + File.separator + refileName;
		//데이터 베이스에 들어갈 디렉토리와 파일이름을 합친 파일 이름 오라클에 저장될 파일 이름이다.
		System.out.println("fileDBName = " + fileDBName);
		//fileDBName = \2024-8-28\bbs202482877630745.png
		return fileDBName;
	}
}
