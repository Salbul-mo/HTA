package ex03_3_constant;
public class Const {

	public static void main(String[] v) {

		//상수 : 값을 한 번만 저장할 수 있는 공간
		//상수 만드는 법 : 변수타입 앞에 키워드 final만 붙여 주기만 하면 된다.
		//일반적으로 상수의 이름은 대문자로 기록. 두 단어 는 _ 로 구분한다.

		final int MAX = 500;
		System.out.println(MAX);
		
		System.out.println("========byte의 범위========");
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		// Byte.MAX_VALUE 는 상수이다.
		// Byte.MIN_VALUE 는 상수이다.
	}	
}
