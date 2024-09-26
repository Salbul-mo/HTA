package ex14_1_wrapper;

public class Wrapper7_auto_boxing {

	public static void main(String[] args) {
		// double 타입의 값을 가지고 Double 타입 매개변수를 사용하는 메서드 호출
		printDouble(123.45);
		// printDouble(Double.valuOf(123.456D)); 로 변환된다.
	}

	// 자동으로 박싱 (auto boxing)

	static void printDouble(Double obj) {
		System.out.println("obj.doubleValue() = " + obj.doubleValue());
		System.out.println("obj.toString() = " + obj.toString());

	}
}
