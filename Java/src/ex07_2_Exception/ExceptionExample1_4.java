package ex07_2_Exception;

public class ExceptionExample1_4 {

	public static void main(String[] args) {
		int num1 = 3, num2 = 0;
		try {
			int result = num1 / num2;
			// Exception in thread "main" java.lang.ArithmeticException: / by zero
			System.out.println(result);
		} catch (ArithmeticException e1) {
			String message = e1.getMessage(); //일어난 예외 클래스에서 정보 얻기
			System.out.println(message);
		} finally {
			System.out.println("여기까지 왔어요");
		}
	}
}