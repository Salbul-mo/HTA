package ex18_06_buffered2_flush2;

import java.io.*;

public class BufferedWriterExample1_EX {

	public static void main(String[] args) {

		FileWriter fw= null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter("src/ex18_06_buffered2_flush2/output.txt");

			bw = new BufferedWriter(fw, 5);
			// 두 번째 인자는 버퍼 사이즈를 의미 - 버퍼에 5개의 문자를 저장할 수 있다.
			// 두 번째 인자가 생략된 경우는 defaultCharBufferSize = 8192로 설정되어 있다.                     
			char arr[] = { '내', '꺼', '인', '1', '듯', '2', '내', '꺼', '3', '아', '닌', '4', '내', '꺼', '5', '같', '은', '6',
					'너' };

			for (int cnt = 0; cnt < arr.length; cnt++) {
				bw.write(arr[cnt]);
			}
			/*
			 * 버퍼가 다 차기 전까지는 실제로 파일에 데이터를 쓰지 않는다.
			 */

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fw != null)
					fw.close(); // 아직 버퍼에 데이터가 남아 있는데 출력 스트림을 닫는다.
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		//출력 결과
		//내꺼인1듯2내꺼3아닌4내꺼5
		//15까지 출력하고 fw가 닫힌다.
		//버퍼사이즈 5가 다 차지 않은 4개의 데이터는 bw에 저장되어있고 대기중이었다.
	}
}
