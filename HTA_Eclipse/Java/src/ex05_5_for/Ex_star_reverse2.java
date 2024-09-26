package ex05_5_for;

public class Ex_star_reverse2 {

	public static void main(String[] s) {
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1 ; j <= 6 - i ; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
			//i = 1 .  j = 1, 2, 3, 4, 5
			//i = 2 .  j = 1, 2, 3, 4
			//i = 3 .  j = 1, 2, 3
			/*
			 * 시작점과 최종점의 변화에서 규칙을 찾을 때
			 * 덧샘 뺄샘을 먼저 해보자.
			 */
		
		for (int h = 1; h <= 5; h++) {
			for (int v = 5 ; v >= h ; v--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}