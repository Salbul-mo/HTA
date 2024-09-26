package ex05_5_for;

public class Ex {

	public static void main(String[] s) {

		System.out.println("1 ~ 10 출력");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}

		System.out.println("1 ~ 10 홀수 출력");
		for (int i = 1; i <= 10; i += 2) {
			System.out.println(i);
		}

		System.out.println("1 ~ 10 짝수 출력");

		for (int i = 2; i <= 10; i += 2) {
			System.out.println(i);
		}

		int sum = 0;

		System.out.println("1 ~ 10의 합 출력");

		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println(sum);

		System.out.println("1 ~ 10 홀수의 합 출력");

		sum = 0;
		for (int i = 1; i <= 10; i += 2) {
			sum += i;
		}
		System.out.println(sum);

		System.out.println("1 ~ 10 짝수의 합 출력");

		sum = 0;
		for (int i = 2; i <= 10; i += 2) {
			sum += i;
		}
		System.out.println(sum);
	}
}
//ctrl shift f 정렬