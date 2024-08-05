package ex03_2_variable;

public class Variable1_int {
		
		public static void main(String[] v) {
			
			System.out.println("========정수형 변수========");
			
			//정수형 변수
			
			byte b = 10;
			// 1바이트 (작은 범위의 값을 저장하기 유용하다)
			
			short s = 100;
			// 2바이트
			
			int i = 1000;
			// 4바이트
			
			long l = 10000L;
			// 8바이트(l[소문자 엘] 또는 L 을 숫자 뒤에 붙여야 한다.)
			
			
			//문자열 + 변수의 경우 문자열 내용이 출력되고 b의 값이 출력된다.
			//여기서 + 는 더하기 개념이 아닌 문자열 연결을 의미한다.
			//+를 기준으로 문자열이 앞 또는 뒤에 존재하는 경우 모두 문자열로 취급한다.
			
			System.out.println("b=" + b); // 변수 b의 값을 출력하라는 의미이다. b=10
			System.out.println("s=" + s); // s=100
			System.out.println("i=" + i + " l=" + l); // i=1000 l=10000
			
			System.out.println("b=" + b + 1); // b=101 모두 문자열로 취급한다.
			System.out.println("s=" + s + 1); // s=1001 모두 문자열로 취급한다.
		}
}