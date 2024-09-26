package ex04_10_rel_logic_op;

import java.util.Scanner;

public class Ex4 {
	
	public static void main(String[] v) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요>");
		int x = sc.nextInt();
		if (1 <= x && x <= 9) {
			System.out.println("10세 미만");
		} else {
			System.out.printf(x/10 +"0대");
		}
		sc.close();
	}

}
