package ex06_1_array;

public class TwoArrayExample4 {

	public static void main(String[] a) {
		int table[][] = {
							{1,2,3,4},
							{5,6,7,8},
							{9,10,11,12}
						};
		// int[3][4] table 을 선언하고 초기화 
		
		for (int[] t : table) {
			for (int tt : t) {
				System.out.println(tt);
			}
		}
		
	}
}
