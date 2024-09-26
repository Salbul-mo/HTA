package ex07_2_Exception;

public class ExceptionExample1_2 {

	public static void main(String[] args) {
		int num1 = 3, num2 = 0;
		try {
			int result = num1 / num2;
			// Exception in thread "main" java.lang.ArithmeticException: / by zero
			System.out.println(result);
		} catch (ArithmeticException e1) {
			System.out.println("0으로 나누지 마세요~");
		}
	}
}
