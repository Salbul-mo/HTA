package boj;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stok = new StringTokenizer(br.readLine());
		int a = 0;
		int b = 0;
		int c = 0;
		
		while (stok.hasMoreTokens()) {
			a = Integer.valueOf(stok.nextToken());
			b = Integer.valueOf(stok.nextToken());
			c = Integer.valueOf(stok.nextToken());
		}
		System.out.println((a+b)%c);
		System.out.println(((a%c)+(b%c))%c);
		System.out.println((a*b)%c);
		System.out.println(((a%c)*(b%c))%c);
		
	}
}
