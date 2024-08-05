package ex04_10_rel_logic_op;

public class LogicalExample6 {

	public static void main(String[] v) {
		int a = 20 , b = 20 ;
		if(a >= 20 && ++b>= 20) { //a>=20 참이기에 ++b >=20 연산함
			System.out.println("참: " + b);
		} else {
			System.out.println("거짓: " + b);
		}
		
		/*단락 평가 (Short circuit evaluation)
		 *  1. && 연산의 경우 첫번째 피연산자를 평가해서 false 인 경우 
		 *  두번째 피연산자를 평가하지 않고 바로 false 를 반환한다.
		 *  2. || 연산의 경우 첫번째 피연산자 평가해서 true 인 경우
		 *  두번째 피연산자를 평가하지 않고 바로 true 를 반환한다.
		 */
		
		System.out.println("b = " + b);
		System.out.println("===============");
		
		
		a = 10; b = 20;
		
		if(a >= 20 && ++b>= 20) { //a>=20 거짓이기에 ++b >=20 연산안함
			System.out.println("참: " + b);
		} else {
			System.out.println("거짓: " + b);
		}
		
		System.out.println("b = " + b);
		
	}
}
