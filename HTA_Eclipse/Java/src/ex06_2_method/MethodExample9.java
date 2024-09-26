package ex06_2_method;

public class MethodExample9 {

	public static void main(String args[]) {

		int num = 50;
		char c = '*';

		print(c, num);
		// return; 반환되는 자료형이 void 인 경우 생략 가능하다
	}

	public static void print(char p_c, int p_num) {
		// 인스턴스를 생성하지 않는 메서드는 static 을 사용해 주어야 한다.
		System.out.println("main()에서 전달받은 데이터의 값은 " + p_c + ", " + p_num + " 입니다.");
		for (int i = 1; i <= p_num; i++) {
			System.out.print(p_c);
		}

		System.out.println("\n끝.");
		// return; 반환되는 자료형이 void 인 경우 생략 가능하다
	}

}

