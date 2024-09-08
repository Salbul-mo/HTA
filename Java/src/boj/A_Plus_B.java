package boj;

import java.io.*;
import java.util.*;

public class A_Plus_B {

	public static void main(String agrs[]) throws IOException {
		BufferedReader rs = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(rs.readLine());
		
		for (int i = 0 ; i < cnt ; i++) {
			StringTokenizer stok = new StringTokenizer(rs.readLine());
			while (stok.hasMoreTokens()) {
				int a = Integer.parseInt(stok.nextToken());
				int b = Integer.parseInt(stok.nextToken());
				System.out.println(a+b);
			}
		}
	}
}
