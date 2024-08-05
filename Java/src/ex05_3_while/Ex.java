package ex05_3_while;

public class Ex {

	public static void main(String[] args) {
		//1 ~ 10 까지 합을 구하기
		int sum = 0;
		int i = 1;
		while (i <= 10) {
			//sum = sum + i;
			//i = i + 1;
			sum += i++;
		}
		
		System.out.println("1.    1 ~ 10까지 홀수 출력");
		
		i = 1;
		while (i <= 10) {
			System.out.println(i);
			i += 2;
		}
		
		System.out.println("2.    1 ~ 10까지 짝수 출력");
		
		i = 2;
		while (i <= 10) {
			System.out.println(i);
			i += 2;
		}
		
		System.out.println("3.    1 ~ 10까지 합");
		
		sum = 0;
		i = 1;
		
		while (i <= 10) {
			sum += i++;
		}
		System.out.println("1 ~ 10까지 합 = " + sum);
		
		System.out.println("4.    1 ~10까지 홀수의 합");
		sum = 0;
		i = 1;
		
		while (i <= 10) {
			sum += i;
			i += 2;
		}
		System.out.println("1 ~ 10까지 홀수의 합 = " + sum);
		
		System.out.println("5.    1 ~10까지 짝수의 합");
		
		sum = 0;
		i = 2;
		
		while (i <= 10) {
			sum += i;
			i += 2;
		}
		System.out.println("1 ~ 10까지 짝수의 합 = " + sum);	
	
	}
}
