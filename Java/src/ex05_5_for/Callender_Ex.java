package ex05_5_for;

public class Callender_Ex {

	public static void main(String[] args) {
		
		
		// 오른쪽 정렬
		for (int i = 1 ; i <= 31 ; i++) {
			if (i % 7 != 0) {
				System.out.printf("%5d",i);
			} else {
				System.out.printf("%5d\n",i); 
			}	
		}
		/*
		 * for (int i = 1 ; i <= 31 ; i++) {
		 * 		System.out.printf("%5d", i);
		 * 		if (i % 7 == 0) 
		 * 			System.out.println();
		 * }
		 */
		
		System.out.println();
		System.out.println("===================================");
		
		// 왼쪽 정렬 
		for (int i = 1 ; i <= 31 ; i++) {
			if (i % 7 != 0) {
				System.out.printf("%-5d",i);
			} else {
				System.out.printf("%-5d\n",i); 
			}	
		}
		
		/*
		 * for (int i = 1 ; i <= 31 ; i++) {
		 * 		System.out.printf("%-5d", i);
		 * 		if (i % 7 == 0) 
		 * 			System.out.println();
		 * }
		 */
	}
}
