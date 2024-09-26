package ex14_1_wrapper;

public class Wrapper2_2_String_to_int {

	public static void main(String args[]) { // run configuration
		int total = 0;

		// 방법 1
		// String -> Integer 객체
		// Integer 객체 -> int 형 값
		for (int cnt = 0; cnt < args.length; cnt++) {
			System.out.println("args[" + cnt + "]=" + args[cnt]);

			// 인자로 받은 문자열을 가지고 Integer 객체를 생성
			Integer obj = Integer.valueOf(args[cnt]);

			// Integer 객체 안에 있는 int 값을 가져온다.
			total += obj.intValue();
		}

		System.out.println("합 = " + total);

		// 방법 2
		// String -> int 값
		// WrapperType.parsePrimitiveType(String)
		total = 0;
		for (int cnt = 0; cnt < args.length; cnt++) {
			total += Integer.parseInt(args[cnt]);
		}
		System.out.println("합 = " + total);

	}
}
