package ex07_2_Exception;

public class ExceptionExample1_1 {

	public static void main(String[] args) {
		int num1 =3, num2 = 0;
		int result = num1 /num2;
		//Exception in thread "main" java.lang.ArithmeticException: / by zero
		System.out.println(result);
	}
}
