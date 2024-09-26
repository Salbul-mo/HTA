package ex14_1_wrapper;

public class Wrapper2_1_String_to_int {

	public static void main(String[] args) { // run as - run configuaration
		int total = 0;
		for (int cnt = 0; cnt < args.length; cnt++) {
			// 에러발생 (String -> int 형변환 요구)
			total = Integer.parseInt(args[cnt]) + total;
			// 문자열을 바로 기본형 정수로 변환.
		}
		System.out.println(total);
	}
}

