package boj.class1;

import java.io.*;

public class Star_2439 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int i = Integer.parseInt(br.readLine());
		
		for (int cnt = 1; cnt <= i ; cnt++) {
			String star ="";
			
			for (int j = 1; j <= i - cnt; j++) {
				star += " ";
			}
			
			for (int q = 1; q <= cnt ; q++) {
				star += "*";
			}
			
			star += "\n";
			bw.write(star);
	
		}
		bw.flush();
	}
}
