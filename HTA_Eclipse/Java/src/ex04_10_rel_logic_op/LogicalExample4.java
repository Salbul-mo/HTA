package ex04_10_rel_logic_op;

import java.io.InputStream;
import java.util.Scanner;

public class LogicalExample4 {

	public static void main(String args[]) {
		InputStream in = System.in;
		Scanner sc = new Scanner(in);
		// Scanner(InputStream source) 라는 뜻이다.
		int num;
		
		System.out.println("수를 입력하세요>");
		num = sc.nextInt();
		
		if (num == 1 || num == 11) {
			System.out.println("1 또는 11 입니다.");
		} else {
			System.out.println("1 또는 11이 아닙니다.");
		}
		
		sc.close();
	}
}
