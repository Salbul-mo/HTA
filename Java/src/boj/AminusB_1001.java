package boj;

import java.io.*;

import java.util.*;

public class AminusB_1001 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stok = new StringTokenizer(br.readLine());
		int a = 0;
		int b = 0;
		while (stok.hasMoreTokens()) {
			a = Integer.valueOf(stok.nextToken());
			b = Integer.valueOf(stok.nextToken());
		}
		
		System.out.println(a + b);
	}

}
