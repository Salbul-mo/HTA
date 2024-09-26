package ex06_1_array;

public class ArrayTest01 {

	public static void main(String[] s) {
		int[] score = {95, 70, 80, 75, 100};
		int total = 0;
		
		for (int i = 0 ; i < score.length ; i++) {
			System.out.println("score[" + i + "] = " + score[i]);
			total += score[i];
		}
		
		System.out.println("총점 = " + total);
	}
}
