package ex14_1_wrapper;

public class Wrapper3_1_int_to_String {

	public static void main(String[] args) {

		int i = 10;
		// 방법 1. Integer.toString(int)사용
		String age = Integer.toString(i);

		// 방법 2. + 연산자 사용 . 문자열 뒤에 붙는 것들 모두 문자열로 취급. 빈 문자열에 기본형 변수 붙인다.
		String age2 = "" + i;

		System.out.println(age);
		System.out.println(age2);
	}
}

