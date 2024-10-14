package boj.class2;

import java.io.*;

public class Common_2609 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] arr = br.readLine().split(" ");
		
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		
		int large = 0;
		int small = 0;
		
		for (int cnt = 1; cnt <= a && cnt <= b; cnt++) {
			if (a % cnt == 0 && b % cnt == 0) 
				large = large < cnt ? cnt : large;
		}
		
		for (int cnt = 1; ; cnt++) {
			if ((a * cnt) % b == 0) {
				small = a * cnt;
				break;
			}
		}
		
		bw.write(large + "\n");
		bw.write(""+small);
		
		bw.flush(); 
		
	}
}
