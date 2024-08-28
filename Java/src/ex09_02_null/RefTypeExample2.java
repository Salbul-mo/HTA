package ex09_02_null;

public class RefTypeExample2 {
	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		Point obj = null; // 아무 데이터도 가리키지 않는 참조값
		
		System.out.println(obj.x);
		System.out.println(obj.y);
		//컴파일은 되지만 
		
		// java.lang.NullPointerException 
		// 런 타임 에러 발생.
	}

}
