package ex06_2_method;

public class MethodExample7 {

	public static void main(String args[]) {
		
		char c = '*';
				
		print(c);
	
	}
	
	public static void print(char c) { //static 을 사용해 주어야 한다.
		System.out.println("main()에서 전달받은 데이터의 값은 " + c + "입니다.");
	}
}
