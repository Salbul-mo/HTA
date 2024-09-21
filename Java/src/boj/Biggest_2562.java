package boj;

import java.util.*;

public class Biggest_2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int big = -1;
		int nth = -1;
		
		for (int cnt = 1; cnt <= 9 ; cnt++) {
			int num = sc.nextInt();
			sc.nextLine();
			if (num > big) {
				big = num;
				nth = cnt;
			}
		} 
		sc.close();
		System.out.println(big + "\n" + nth);
		
	}
}
