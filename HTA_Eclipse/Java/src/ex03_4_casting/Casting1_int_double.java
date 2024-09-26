package ex03_4_casting;

public class Casting1_int_double {

	public static void main(String[] v) {
		
		int i1 = 10; // int = 4byte
		
		int j = i1; // int i1의 값 10을 int j에 대입해라.
		
		double d1 = i1; // double = 8byte. int i1의 값 10을 double d1에 대입해라.
		// 형 변환 . Casting  = 을 쓸 때는 양 옆의 타입을 맞추어 주는게 기본이다.
		// 부득이 형 변환을 하게 되는 경우에는 주의하자.
		
		//1. 자동 형변환, 묵시적 형변환, 암시적 형변환
		//자동 형변환은 변수에 값을 저장하거나 메서드의 인자값이 매개변수로 전달될 때
		//일치하지 않은 자료형인 경우 컴파일러가 자동으로 형변환을 해준다.
		
		//double d1 = (double) i1; 실수형 변수에 정수형 값을 저장할 수 있다.
		
		// 4byte 를 8byte 에 넣는 것이므로 문제 없이 저장된다.
		System.out.println("d1 데이타는 "+ d1 + " 입니다.");
		
		
	}
}
