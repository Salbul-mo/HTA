package ex04_10_rel_logic_op;

import java.util.Scanner;

public class Ex2 {
	
	public static void main(String[] v) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요>");
		int x = sc.nextInt();
		if (1 <= x && x <= 9) {
			System.out.println("10세 미만");
		} 
		if (10 <= x && x <= 19) {
			System.out.println("10대");
		} 
		if (20 <= x && x <= 29) {
			System.out.println("20대");
		}
		if (30 <= x && x <= 39) {
			System.out.println("30대");
		} 
		if (40 <= x && x <= 49) {
			System.out.println("40대");
		}
		
		sc.close();
	}

}
