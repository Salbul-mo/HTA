package ex05_1_if;

import java.util.Scanner;

public class If04_01_hakjum2_variable2 {

	public static void main(String[] v) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요>");
		
		int jumsu = sc.nextInt();
		int mok = jumsu / 10;
		String grade = "F";
		
		//if (mok == 9) {  100 점이 인식되지 않으므로 수정해야 한다.
		if (mok == 9 || mok == 10) { // 아니면 mok >= 9
			grade = "A";
		} else if (mok == 8) {
			grade = "B";
		} else if (mok == 7) {
			grade = "C";
		} else if (mok == 6) {
			grade = "D";
		} 
		
		System.out.println(grade + "학점");
		
		System.out.println("끝.");
		sc.close();
	}
}
