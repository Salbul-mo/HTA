package boj;

import java.io.*;

public class Star_2438 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int i = Integer.parseInt(br.readLine());
		
		for (int cnt = 1; cnt <= i ; cnt++) {
			String star ="";
			for (int j = 1; j <= cnt; j++) {
				star += "*";
			}
			star += "\n";
			bw.write(star);
	
		}
		bw.flush();
	}
}
