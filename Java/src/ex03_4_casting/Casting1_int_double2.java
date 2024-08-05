package ex03_4_casting;

public class Casting1_int_double2 {

	public static void main(String[] s) {
		
		double d2 = 10.12345;
		
		// 2. 명시적 형변환
		
		// int i2 = d2; 
		// 에러 발생 - Type mismatch: cannot convert from double to int
		// 4byte 에 8byte 를 넣을 수는 없으므로 자바가 컴파일러 오류를 일으켜 경고한다.
		
		int i2 = (int) d2;
		// 강제적으로 double 을 int로 형변환한다. 책임은 개발자가 진다.
		
	}
}
