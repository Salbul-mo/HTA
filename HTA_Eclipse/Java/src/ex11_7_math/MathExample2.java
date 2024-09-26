package ex11_7_math;

public class MathExample2 {

	public static void main(String[] a) {
		System.out.println(Math.random()); // 0<= 난수 < 1 : double형
		System.out.println(Math.random());
		System.out.println(Math.random());

		int num;
		/*
		 * 0 부터 9까지의 정수 범위에 속하는 난수를 만들기 
		 * 1. 0 <= 난수 < 1 
		 * 2. 0 <=  난수  *10  < 10 
		 * 3. 0 <= (int)(난수*10) <10 ===> 정수로 만들기
		 */

		// 공식 : (정수화)((상한값-하한값+1)*난수 + 하한값)
		// (int) ((9-0+1)*난수 + 0)
		num = (int) (Math.random() * 10);
		System.out.println(num);

		// 1 부터 45까지 정수 범위에 속하는 난수 만들기
		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((45 - 1 + 1) * Math.random() + 1);
			System.out.print(arr[i] + "\t");
		}
		// 중복된다.

	}
}
