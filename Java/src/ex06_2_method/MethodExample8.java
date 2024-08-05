package ex06_2_method;

public class MethodExample8 {

	public static void main(String args[]) {
		
		int num = 50;
		char c = '*';
				
		print(c, num);
	
	}
	
	
	public static void print(char p_c , int p_num ) { //static 을 사용해 주어야 한다.
		System.out.println("main()에서 전달받은 데이터의 값은 " + p_c + ", " + p_num  + " 입니다.");	
	}
}
