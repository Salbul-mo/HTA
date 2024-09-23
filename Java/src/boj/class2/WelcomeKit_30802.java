package boj.class2;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class WelcomeKit_30802 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		StringTokenizer stok = new StringTokenizer(br.readLine());
		long s = 0;
		long m = 0;
		long l = 0;
		long xl = 0;
		long xxl = 0;
		long xxxl = 0;
		
		while(stok.hasMoreTokens()) {
			s = Long.parseLong(stok.nextToken());
			m = Long.parseLong(stok.nextToken());
			l = Long.parseLong(stok.nextToken());
			xl = Long.parseLong(stok.nextToken());
			xxl = Long.parseLong(stok.nextToken());
			xxxl = Long.parseLong(stok.nextToken());
		}
		
		String[] arr = br.readLine().split(" ");
		long t = Long.parseLong(arr[0]);
		long p = Long.parseLong(arr[1]);
		
		Stream<Long> stream = Stream.of(s,m,l,xl,xxl,xxxl);
		
		Iterator<Long> it = stream.filter(i -> i != 0).map(i -> i%t == 0 ? i/t : i/t + 1).iterator();
		
		long sum = 0;
		while(it.hasNext())
			sum += it.next();
		
		System.out.println(sum + "\n" + n/p + " " + n%p);
	}
}
