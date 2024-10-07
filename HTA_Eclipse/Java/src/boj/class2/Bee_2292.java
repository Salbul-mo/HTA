package boj.class2;

import java.util.*;

public class Bee_2292 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.nextLine());
		if(n == 1) {
			System.out.println(1);
			sc.close();
			return;
		}
		
		long result = 1;
		long num = 1; 
		for (long cnt = 1; ; cnt++) {
			num += cnt * 6;
			
			if(num >= n) {
				System.out.println(result + cnt);
				sc.close();
				return;
			}
		}
	}
}
