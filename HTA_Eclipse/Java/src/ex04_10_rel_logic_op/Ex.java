package ex04_10_rel_logic_op;

import java.util.Scanner;

public class Ex {
	// 입력 받은 수가 1~10사이면 "1~10 사이의 수 입니다." 출력
	// 아니면 "1~10 사이의 수가 아닙니다." 출력
	public static void main(String[] v) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요>");
		int x = sc.nextInt();
		
		sc.close(); 
		// Scanner로 입력받으면 종료되었을때 닫아야 메모리 누수를 막을 수 있다.
		
		if (1 <= x && x <= 10) {
			System.out.println("1~10 사이의 수 입니다.");
		} else {
			System.out.println("1~10 사이의 수가 아닙니다.");
		}
	}
	
}
