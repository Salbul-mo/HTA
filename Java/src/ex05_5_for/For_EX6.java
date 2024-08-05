package ex05_5_for;

import java.util.Scanner;

public class For_EX6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("limit 를 입력하시오>");
		int limit = sc.nextInt();
		System.out.print("listCount 를 입력하시오>");
		int listCount = sc.nextInt();
		
		int temp = (listCount-1) / limit;
		
		int maxPage = temp + 1;
		System.out.println("maxpage = " + maxPage);
		
		sc.close();
	}
}
