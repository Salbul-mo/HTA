package ex05_5_for;

import java.util.Scanner;

public class For_Ex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요>");
		int i = sc.nextInt();
		
		System.out.println("입력값  출력값");
		System.out.println("=============");
		System.out.printf("%5d%5d\n",i,i/10);
		
		sc.close();
	}
}

