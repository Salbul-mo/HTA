package boj.class1;

import java.io.*;
import java.util.*;

public class String_Loop_2675 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());

		for (int cnt = 1; cnt <= t; cnt++) {
			StringTokenizer stok = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stok.nextToken());
			String s = stok.nextToken();
			String result = "";
			for (int i = 0; i < s.length(); i++) {
				for (int j = 1; j <= r; j++) {
					result += s.charAt(i);
				}
			}
			bw.write(result + "\n");
		}
		
		bw.flush();
	}
}
