package ex05_5_for;

public class ForExample5_1for_for0 {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1 ; j <= 5; j++) {
				System.out.println("i = " + i + ", j = " + j);
				if(j == 5 && i != 5) {
					System.out.println("========i가 변경되어요==========");
				}
			}
		}
		
		
	}
}
