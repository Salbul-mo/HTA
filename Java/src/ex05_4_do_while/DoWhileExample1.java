package ex05_4_do_while;

public class DoWhileExample1 {

	public static void main(String[] b) {
		int cnt = 1;
		
		do {
			System.out.println(cnt);
		} while (cnt++ < 10); 
		// 비교 하고 cnt + 1 실행
		System.out.println(cnt); // cnt = 11

		
		System.out.println("끝");
	
	
	}
}