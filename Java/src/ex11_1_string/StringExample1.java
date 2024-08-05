package ex11_1_string;

public class StringExample1 {

	public static void main(String args[]) {
		String str = "집에 가고 싶어요.";
		int len = str.length(); 
		//length 메서드 호출 String.length() 로 정수값을 얻을 수 있다.
		
		for (int cnt = 0; cnt < len; cnt++) {
			char ch = str.charAt(cnt); 
			//charAt 메서드 호출. (인덱스)의 문자 호출하여 char형 변수 ch에 대입
			System.out.println("index =" + cnt + "문자 = " +ch);
		}
	}
}
