package boj;

import java.io.*;

public class String_Char_27866 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int i = Integer.parseInt(br.readLine());
		
		System.out.println(str.charAt(i-1));
		
	}
}
