package ex06_2_method;

import java.util.Scanner;

public class Ex2 {
	/*
	 * 1. input()
	 *    기능 : 정수를 입력 받는 메서드
	 *    반환형 : 입력 받은 정수형을 리턴합니다.	
	 *    
	 * 2. abs(int data)
	 *    기능 : 절대값 구하기 (양수 -> 양수 , 음수 -> 양수)
	 *    매개 변수 : 1번에서 입력 받은 값을 저장할 정수형 변수 한 개
	 * 3. main()
	 *    int intputdata = input();
	 *    int result = abs(inputdata);
	 *    
	 *    System.out.println("절대값 : " + result);
	 * 
	 * 4. 출력결과
	 */
	public static void main(String[] args) {
		
		int inputdata = input();
		int result = abs(inputdata);
		//int result = abs(input()); 이렇게 줄일 수 있다.		
		System.out.println("절대값 :" + result);
		
		
	}
	
	public static int input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요>");
		int i = sc.nextInt();
		sc.close();
		return i;
		
	}
	
	public static int abs(int data) {
		if (data < 0) {
			//data *= -1;
			data = -data;
		}
		return data;
	}
	
	
}
