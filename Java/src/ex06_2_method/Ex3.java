package ex06_2_method;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두개의 정수를 입력하시오>");
		int i = sc.nextInt();
		int j = sc.nextInt();
		int max = max(i, j);
		int min = min(i, j);
		if (max == min) {
			System.out.println("두 수는 같습니다.");
			sc.close();
			return;
		}
		System.out.println("max = " + max + "\nmin = " + min);
		sc.close();
	}

	public static int max(int a, int b) {
		if (a > b) {
			return a;
		} else if (a < b) {
			return b;
		} else {
			// System.out.println("똑같다.");
			return a;
		}
	}

	public static int min(int a, int b) {
		if (a > b) {
			return b;
		} else if (a < b) {
			return a;
		} else {
			// System.out.println("똑같다.");
			return a;
		}
	}

}
