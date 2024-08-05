package ex04_10_rel_logic_op;

public class LogicalExample5_1 {

	public static void main(String[] v) {
		
		System.out.println(!true);
		System.out.println(!false);
		//논리 부정 연산자(!) 오른쪽 결과를 부정한다. (반대로 바꾼다)
		int a = 3, b = 4;
		
		if (a >= b) {
			System.out.println(a + ">=" + b);
		}
		
		if (!(a >= b)) {
			System.out.println(a + "<" + b);
		}
	}
}
/*
false
true
3<4
출력
*/