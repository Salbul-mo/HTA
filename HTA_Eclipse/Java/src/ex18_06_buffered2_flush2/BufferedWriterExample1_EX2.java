package ex18_06_buffered2_flush2;

import java.io.*;

public class BufferedWriterExample1_EX2 {

	public static void main(String[] args) {

		FileWriter fw = null;
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
			bw.flush();
			//버퍼에 있는 데이터를 파일에 즉시 출력하도록 하는 메서드이다.
			//내꺼인1듯2내꺼3아닌4내꺼5같은6너 
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

	}
}
