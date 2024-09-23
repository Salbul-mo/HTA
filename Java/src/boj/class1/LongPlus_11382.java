package boj.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongPlus_11382 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stok = new StringTokenizer(br.readLine());
		long a = 0L;
		long b = 0L;
		long c = 0L;
		
		while (stok.hasMoreTokens()) {
			a = Long.valueOf(stok.nextToken());
			b = Long.valueOf(stok.nextToken());
			c = Long.valueOf(stok.nextToken());
		}
		
		System.out.println(a+b+c);
	}
}
