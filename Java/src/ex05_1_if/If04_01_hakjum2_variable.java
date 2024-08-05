package ex05_1_if;

import java.util.Scanner;

public class If04_01_hakjum2_variable {

	public static void main(String[] v) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요>");
		
		int jumsu = sc.nextInt();
		
		String grade = "F";
		
		if (jumsu >= 90) {
			grade = "A";
		} else if (jumsu >= 80) {
			grade = "B";
		} else if (jumsu >= 70) {
			grade = "C";
		} else if (jumsu >= 60) {
			grade = "D";
		} 
		
		System.out.println(grade + "학점");
		
		System.out.println("끝.");
		sc.close();
	}
}
