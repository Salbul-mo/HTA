package ex18_10_file;

/*
 * 현재 디렉토리의 서브디렉토리와 파일 목록을 출력하는 프로그램
 * File 클래스 : 파일 관리 기능을 갖는 클래스
 * 디렉토리 관리 기능도 가지고 있다.
 */
import java.io.*;
import java.text.SimpleDateFormat;

public class RecursiveFile {

	public static void main(String[] args) {

		String path = "C:\\Users\\jhta\\git\\HTA_Eclipse\\Java\\src";
		File directory = new File(path);
		if (directory.exists() && directory.isDirectory()) {
			// 디렉토리 및 파일 출력
			listFilesAndFolders(directory);
		} else {
			System.out.println("디렉토리가 존재하지 않거나 유효하지 않습니다.");
		}

	}

	public static void listFilesAndFolders(File file) {
		File arr[] = file.listFiles(); // 서브 디렉토리와 파일 목록을 가져온다.

		for (int cnt = 0; cnt < arr.length; cnt++) {
			String name = arr[cnt].getName(); // 이름을 리턴
			
			if (arr[cnt].isFile()) {// 파일이면 true 아니면 false
				System.out.printf("%-50s%-50s\t", name, "IN "+file.getPath().substring(file.getPath().lastIndexOf("\\")+1));
				long time = arr[cnt].lastModified();// 최종 수정일시를 리턴
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
				System.out.printf("%s\n", sdf.format(time));
			} else {
				System.out.printf("%-50s%-50s\t", name, file.getPath().substring(file.getPath().lastIndexOf("\\")+1)+"'s Folder");
				long time = arr[cnt].lastModified();// 최종 수정일시를 리턴
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
				System.out.printf("%s\n", sdf.format(time));
				String filePath = file.getPath();
				String tempPath = filePath + File.separator + name;
				File temp = new File(tempPath);
				listFilesAndFolders(temp);
			}

		}
		System.out.println();
		return;
	}
}
