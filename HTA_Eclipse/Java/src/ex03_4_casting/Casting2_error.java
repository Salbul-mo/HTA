package ex03_4_casting;

public class Casting2_error {

	public static void main(String[] v) {
		
		// float ft =  3.14; 자바 실수의 기본은 double 이므로 float임을 밝혀야 한다.
		//Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		//Type mismatch: cannot convert from double to float
		
		
		//float ft = 3.14f;
		// 또는
		float ft = (float) 3.14;
		System.out.println(ft);

		
	}
}
