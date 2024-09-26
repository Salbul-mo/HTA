package ex05_5_for;

public class ForExample2 {

	public static void main(String args[]) {
		int cnt = 0;
		
		// 초기식과 증감식 생략 가능하다.
		for ( ; cnt < 10; ) {
			System.out.println(cnt);
			cnt++;
		}
		
		// 초기식과 증감식에 하나 이상의 문장이 올 수 있다. 콤마로 구분한다.
		
		for (int a = 1, b = 5; a < b ; a++, b-- ) {
			System.out.println("a = " + a + " b = " + b );
		}
		
		System.out.println("끝.");
	}	
}
