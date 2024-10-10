package boj.class2;

import java.io.*;

public class Palindrome_1259 {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
		while (true) {
			String input = br.readLine();
			if(input.equals("0"))
				break;
			
			boolean check = true;
			
			if(input.length() % 2 == 0) {
				for(int cnt = 0; cnt < input.length() / 2; cnt++) {
						if(input.charAt(cnt) != input.charAt(input.length()-1-cnt)) {
							check = false;
							break;
						}
				}
			} else {
				for(int cnt = 0; cnt < input.length()-1 / 2; cnt++) {
					if(input.charAt(cnt) != input.charAt(input.length()-1-cnt)) {
						check = false;
						break;
					}
					
				}
			}
			
			if (check)
				bw.write("yes" + "\n");
			else
				bw.write("no" + "\n");
		}
		bw.flush();
		return;
		} catch (EOFException e) {
			e.getMessage();
		}
	}
}
