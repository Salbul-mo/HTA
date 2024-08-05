package ex04_12_conditional_op;

public class ConditionalOpExample1_max {

	public static void main(String[] v) {
		int a = 30, b = 10, max;
		//조건 연산자, 삼항 연산자.
		System.out.println(a > b ? a : b);
		
		max = a > b ? a : b;
		System.out.println("최댓값 = " + max);
		
		
	}
}
