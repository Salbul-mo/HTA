package ex18_06_bufferd;

import java.io.*;

public class BufferdReaderExample {

	public static void main(String[] args) {
		String message = null;
		try (BufferedReader reader = new BufferedReader(new FileReader("src/ex18_06_bufferd/output2.dat"))) {
			while ((message = reader.readLine()) != null) {
				/*
				 * Reads a line of text. A line is considered to be terminated by 
				 * any one of a line feed ('\n'), a carriage return ('\r'), a carriage return followed
				 * immediately by a line feed, or by reaching the end-of-file(EOF). 
				 * Returns:A String containing the contents of the line, 
				 * not including any line-termination characters, or null 
				 * if the end of the stream has been reached without reading any characters
				 */
				System.out.println(message);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
