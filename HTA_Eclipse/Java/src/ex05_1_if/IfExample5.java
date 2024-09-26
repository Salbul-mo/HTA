package ex05_1_if;

import java.util.Scanner;

public class IfExample5 {

	public static void main(String[] args) {
		/* 정수형 변수 num을 선언하고 정수 값을 입력받아 저장
		 * 값이 10 미만이면 "num의 값은 10 미만입니다."
		 * 값이 10 이상 100 미만이면  "num의 값은 10 이상, 100 미만입니다"
		 * 값이 100 이상 1000 미만  "num의 값은 100 이상, 1000미만입니다"
		 * 값이 1000 이상이면    "num의 값은 1000 이상입니다."
		 * 
		 * if () {
		 * 
		 * } else if {
		 * 
		 * } else if {
		 * 
		 * } else {
		 * 
		 * }
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요>");
		int num = sc.nextInt();
		
		if (num < 10) {
			System.out.println("num의 값은 10 미만입니다.");
		} else if (num < 100) {
			System.out.println("num의 값은 10 이상, 100 미만입니다");
		} else if (num < 1000) {
			System.out.println("num의 값은 100 이상, 1000미만입니다");
		} else {
			System.out.println("num의 값은 1000 이상입니다.");
		}
		sc.close();
	}
}
