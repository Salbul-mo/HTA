package ex04_06_arithmetic_op;

import java.io.InputStream;
import java.util.Scanner;

public class Oper04_1 {

	public static void main(String[] v) {
	/*	int data = 11;
		int pandan = data % 2;
		System.out.println("data%2의 값은 " + pandan + "입니다."); */
		//산술 연산자 %를 이용해 입력한 정수의 짝수와 홀수를 구별하는 코딩
		InputStream is = System.in;
		Scanner sc = new Scanner(is);
		
		System.out.print("정수를 입력하세요>");
		int data = sc.nextInt();
		
		sc.close();
		
		int pandan = data % 2;
		
		
			
		System.out.println("data%2의 값은 " + pandan + "입니다.");
		String check;
		if (pandan == 0) {
			check = "짝수";
		} else {
			check = "홀수";
		}
		System.out.println(data+ "(은)는 " + check + " 입니다.");
	}
}
