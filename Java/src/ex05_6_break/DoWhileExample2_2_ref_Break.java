package ex05_6_break;

import java.util.Scanner;

public class DoWhileExample2_2_ref_Break {

	public static void main(String args[]) {
		String location = "";
		Scanner sc = new Scanner(System.in);
		//String q = "q";
		do {
			System.out.print("지역입력(exit=q)>");
			location = sc.next();
			if (location.equals("q")) {
				break;
			}
			System.out.println("입력하신 지역은 " + location + " 입니다.");
		} while (true);
		System.out.println("끝.");
		
		sc.close();
	}
}