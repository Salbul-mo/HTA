package ex18_06_bufferd;

import java.io.*;

public class BufferdWriterExample1_write {

	public static void main(String[] args) {
		String message = "하하입니다.\n오늘도 화이팅입니다.";
		/*
		 * BufferedWriter writer = null; try { writer = new BufferedWriter(new FileWriter("파일경로/파일이름.확장자"));
		 * 
		 */
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/ex18_06_bufferd/output2.dat"))) {
			/*
			 * Writes text to a character-output stream, buffering characters so as
			 * to provide for the efficient writing of single characters, arrays, and strings.
			 * 
			 * The buffer size may be specified, or the default size may be accepted.
			 * The default is large enough for most purposes.
			 */
			writer.write(message);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
