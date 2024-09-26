package boj.class1;

import java.util.*;

public class Number_Count_2577 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		sc.nextLine();
		int b = sc.nextInt();
		sc.nextLine();
		int c = sc.nextInt();
		
		long mul = a * b * c;
		
		String str = Long.toString(mul);
		char[] arr = str.toCharArray();
		int cnt = 0;
		String result = "";
		for (int i = 0; i < 10 ; i++ ) {
			for (int j = 0; j < arr.length; j++) {
				if (Character.getNumericValue(arr[j]) == i) {
					cnt++;
				}
			}
			result += cnt + "\n";
			cnt = 0;
		}
		
		System.out.println(result);
		sc.close();
		
	}
}
