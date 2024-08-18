package ex18_06_buffered2_flush2;

import java.io.*;

public class BufferedWriterExample1_EX3 {

	public static void main(String[] args) {

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter("src/ex18_06_buffered2_flush2/output.txt");

			bw = new BufferedWriter(fw, 5);
			char arr[] = { '내', '꺼', '인', '1', '듯', '2', '내', '꺼', '3', '아', '닌', '4', '내', '꺼', '5', '같', '은', '6',
					'너' };

			for (int cnt = 0; cnt < arr.length; cnt++) {
				bw.write(arr[cnt]);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (bw != null)
					bw.close(); // 보조 기반 스트림이 정상적으로 닫힐 때
								// 자동적으로 flush()메서드가 호출된다.
								// flush()후 FileWriter의 close()메서드도 호출된다.
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
