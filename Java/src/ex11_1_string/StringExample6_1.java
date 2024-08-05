package ex11_1_string;

/*
 * 1. substring(int beginIndex) : beginIndex 부터 문자열 끝까지 부분 문자열 리턴
 * 2. substring(int beginIndex, int endIndex) : beginIndex부터 endIndex-1까지 부분 문자열 리턴
 */
public class StringExample6_1 {

	public static void main(String[] args) {
		String str = "나를 사랑하는 자바";
		int size = str.length();
		for (int cnt = 0; cnt < size; cnt++) {
			char ch = str.charAt(cnt);
			System.out.println("index = " + cnt + " 문자 = " + ch);
		}

		System.out.println(str.substring(3));
		System.out.println(str.substring(3, 6));
	}
}
