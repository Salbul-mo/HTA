package ex18_03_1_fileinputstream_fileoutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExample1 {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("파일명을 Arguments탭에 output1.dat 입력해 주세요.");
			return;
		}
		FileInputStream in = null;
		try {
			in = new FileInputStream(args[0]);// 파일을 연다.
			// Run -> Run Configurations 에서 매개변수 값으로 output1.dat입력

			byte arr[] = new byte[21]; // 바이트 단위로 데이터를 읽기 때문에 byte 형 사용
			while (true) {
				int num = in.read(arr);
				// int java.io.FileInputStream.read(byte[] b) throws IOException

				if (num == -1) // 읽어온 데이터가 -1이면 반복 중단
					break;
				// 읽어들인 바이트 데이터를 16진수로 출력한다.
				System.out.println("\n16진수 출력");
				for (int cnt = 0; cnt < num; cnt++) {
					System.out.printf("%02X ", arr[cnt]);
					// %02X : 2자리 16진수(%X)를 출력하되, 대문자(X가 대문자)로 출력하면서
					// 한 자리 숫자면 0을 채움
				}
				System.out.println("\n\n10진수 출력");
				for (int cnt = 0; cnt < num; cnt++) {
					System.out.printf("%02d ", arr[cnt]);
				}

				System.out.println("\n\n8진수 출력");
				for (int cnt = 0; cnt < num; cnt++) {
					System.out.printf("%02o ", arr[cnt]);
				}
			}
		} catch (FileNotFoundException e2) { // 파일 열 때 예외 처리
			System.out.println(e2.getMessage());
		} catch (IOException e) { // 파일 읽을 때 또는 파일 닫을 떄 예외 처리
			System.out.println(e.getMessage());
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e1) { // 예외처리하고 finally 에서 파일 닫을 때 예외 처리
				System.out.println(e1.getMessage());
			}
		}
	}
	/*
	 * 
	 * 16진수 출력 00 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F 10 11 12 13 14
	 * 
	 * 10진수 출력 00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20
	 * 
	 * 8진수 출력 00 01 02 03 04 05 06 07 10 11 12 13 14 15 16 17 20 21 22 23 24
	 */
}
