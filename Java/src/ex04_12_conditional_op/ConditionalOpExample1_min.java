package ex04_12_conditional_op;

public class ConditionalOpExample1_min {

	public static void main(String[] v) {
		int a = 30, b = 10, min;
		//조건 연산자, 삼항 연산자.
		System.out.println(a < b ? a : b);
		
		min = a < b ? a : b;
		System.out.println("최솟값 = " + min);
		
		
	}
}
