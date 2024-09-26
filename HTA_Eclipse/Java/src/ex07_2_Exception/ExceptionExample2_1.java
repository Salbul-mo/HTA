package ex07_2_Exception;

public class ExceptionExample2_1 {

	public static void main(String[] s) {
		int sum = 1 + -2;
		if (sum < 0) {
			new Exception("에러 발생"); // Exception 객체 생성. 실행 오류가 난 것은 아니다.
		}
		
		System.out.println(sum);
	}
}
