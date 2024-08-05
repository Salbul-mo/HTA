package ex06_2_method;

public class Ex {

	public static void main(String[] a) {
		/*
		 * 메서드 이름 add
		 * 매개 변수 정수형 2개
		 * 기능 매개 변수 더하기
		 * 반환값 더한 값
		 * 반환 타입 int
		 * 
		 * add 호출
		 * 인자값 3,4
		 *
		 * 호출값 결과값 출력
		 */
		int i = 3, j = 4;
		System.out.println(add(i,j));
	}
	
	public static int add(int i , int j) {
		return i + j;
		
	}
}
