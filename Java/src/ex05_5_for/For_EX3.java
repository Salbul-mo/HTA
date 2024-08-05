package ex05_5_for;

import java.util.Scanner;

public class For_EX3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하시오>");
		int i = sc.nextInt();
		int temp = (i-1) / 10;
		System.out.printf("%d",temp * 10);
		
		sc.close();
	}
}

