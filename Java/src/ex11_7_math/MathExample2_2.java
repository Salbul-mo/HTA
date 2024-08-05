package ex11_7_math;

public class MathExample2_2 {

	public static void main(String[] args) {

		/*
		 * 0 부터 9까지의 정수 범위에 속하는 난수를 만들기 
		 * 1. 0 <= 난수 < 1  ex) 0.24234 0.5132134 0.778342342 .......
		 * 2. 0 <= 난수 * 10 < 10 1.23452345 6.34536 4.34232 ........
		 * 3. 0 <= (int)(난수*10) < 10 ===> 정수로 만들기 (int)붙여서 정수화
		 */
		//	45 ~ 60  --> 45.3425243 49.234234 59.34532465436 ........
					
		// 공식 : (정수화)((상한값-하한값+1)*난수 + 하한값)
		// (int) ((9-0+1)*난수 + 0)
		// num = (int) (Math.random() * 10);
		// System.out.println(num);

		// 1 부터 45까지 정수 범위에 속하는 난수 만들기

		int[] arr = new int[6];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((45 - 1 + 1) * Math.random() + 1);
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int a : arr)
			System.out.print(a + "\t");

	}

}
