package boj.class1;

import java.io.*;
import java.util.*;

public class A_Plus_B_zero_10952 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean check = true;
		do {
			StringTokenizer stok = new StringTokenizer(br.readLine());
			while (stok.hasMoreTokens()) {
				int a = Integer.parseInt(stok.nextToken());
				int b = Integer.parseInt(stok.nextToken());
				if ( a == 0 && b == 0) {
					check =false;
					break;
				}
				
				bw.write(Integer.toString(a+b)+"\n");
			}
		} while(check);
		
		bw.flush();
	}
}
