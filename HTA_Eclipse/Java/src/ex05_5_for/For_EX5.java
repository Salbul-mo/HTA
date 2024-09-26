package ex05_5_for;

import java.util.Scanner;

public class For_EX5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("page를 입력하시오>");
		int i = sc.nextInt();
		int temp = (i-1) /10;
		
		int startpage = (temp * 10) + 1;
		System.out.println("startpage=" + startpage);
		
		sc.close();
	}
}
