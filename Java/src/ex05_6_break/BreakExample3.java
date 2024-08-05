package ex05_6_break;

public class BreakExample3 {

	public static void main(String[] a) {
		
		outerLoop:
		for (int row = 0; row < 3 ; row++) {
			for (int column = 0; column < 5 ; column++ ) {
				System.out.println("(" + row + ", " + column + ")");
				if ((row == 1) && (column == 2))
					break outerLoop; 
					
			}
		}
		/*
		 * 레이블 블록
		 * 형식) 레이블 명 : {문장 블록} 또는 반복문이 포함된 블록
		 * 예)
		 * aa : {
		 * 		System.out.println("aa");
		 * }
		 * 
		 * 
		 * bb : for (int i = 0 ; i < 10 ; i++) {
		 * 		break bb;
		 * }
		 */
		
		System.out.println("End.");
		
	}
}


