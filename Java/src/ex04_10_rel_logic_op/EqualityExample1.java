package ex04_10_rel_logic_op;

public class EqualityExample1 {

	public static void main(String[] v) {
		int num1 = 5;
		int num2 = 2 + 3;
		
		System.out.println(num1 == num2); // 같냐? true
		System.out.println(num1 != num2); // 같지않냐? false
		
		if (num1 == num2 ) { // 같으면 출력
			System.out.println("num1과 num2의 값은 동일합니다.");
			
		}
		if (num1 != num2) { // 같지 않으면 출력
			System.out.println("num1과 num2의 값은 같지 않습니다.");
		}
	}
}
