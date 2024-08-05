package ex05_5_for;

public class Ex_star {

	public static void main(String[] s) {
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1 ; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
			
			//i = 1 .  j = 1, 1
			//i = 2 .  j = 1, 2, 
			//i = 3 .  j = 1, 2, 3
		}
	}
}
