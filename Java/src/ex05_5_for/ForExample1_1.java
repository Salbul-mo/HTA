package ex05_5_for;

public class ForExample1_1 {
	
	public static void main(String[] args) {
		
		int cnt;
		
		for (cnt = 1; cnt <= 10 ; cnt++) {
			System.out.println(cnt);
		}
		System.out.println("for문 끝");
		System.out.println(cnt);
		// cnt + 1 되어서 종료.
		for (cnt = 10; 1 <= cnt ; cnt--) {
			System.out.println(cnt);
		}
		System.out.println("for문 끝");
		System.out.println(cnt);
		// cnt - 1 되어서 종료.
		System.out.println("끝.\n====================");
		
	}
}
