package ex04_12_conditional_op;

import java.util.Scanner;

public class Ex {

	public static void main(String[] v) {
		Scanner sc = new Scanner(System.in);
		System.out.print("3개의 정수를 입력 하세요>");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int max;
		int min;
		
		 if (a > b) {
			 max = a > c ? a : c;
		 } else {
			 max = b > c ? b : c;
		 }
		 
		 if (a < b) {
			 min = a < c ? a : c;
		 } else {
			 min = b < c ? b : c;
		 }
		 
		 System.out.println("max = " + max);
		 System.out.println(a+ ", " + b + ", " + c + " 중 큰 수는 " + max + " 입니다.");
		 System.out.println("min = " + min);
		 System.out.println(a+ ", " + b + ", " + c + " 중 작은 수는 "+ min + " 입니다.");
		
		 sc.close();
	}
}
