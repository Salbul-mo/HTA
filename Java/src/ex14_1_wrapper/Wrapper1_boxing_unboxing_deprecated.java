package ex14_1_wrapper;

public class Wrapper1_boxing_unboxing_deprecated {

	@SuppressWarnings({ "unused", "removal" })
	public static void main(String[] args) {

		// 박싱 int -> Integer
		Integer obj = new Integer(12); // deprecated. 쓰지 마라
		Integer obj1 = Integer.valueOf(12); // 기본형 변수가 객체로 변환되었다.
		Integer obj2 = Integer.valueOf(7); // 기본형 변수가 객체로 변환되었다.

		// 언박싱 Integer -> int
		int n1 = obj1.intValue(); // Integer 객체 안의 int값을 가져온다.
		int n2 = obj2.intValue();
		int sum = n1 + n2;
		System.out.println(sum);

		// String -> Integer
		Integer n02 = Integer.valueOf("20"); // 박싱이 아니다. 문자열 객체를 정수형 객체로 변환하는것.

		int n3 = n02.intValue();
		// n3 = Integer.parseInt("20"); 문자열을 바로 정수 타입 기본형 변수로 변환.
		sum = n1 + n2 + n3;
		System.out.println(sum);

	}

}
