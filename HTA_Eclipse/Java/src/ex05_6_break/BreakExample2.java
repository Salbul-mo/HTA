package ex05_6_break;

public class BreakExample2 {

	public static void main(String[] a) {
		
		for (int row = 0; row < 3 ; row++) {
			for (int column = 0; column < 5 ; column++ ) {
				System.out.println("(" + row + ", " + column + ")");
				if ((row == 1) && (column == 2))
					break; // break 를 내포하고 있는 반복문을 빠져나가므로 
					// 안쪽 for문이 종료 되고 바깥 for 문은 계속 돈다.
			}
		}
		
		
		System.out.println("End.");
		
	}
}

