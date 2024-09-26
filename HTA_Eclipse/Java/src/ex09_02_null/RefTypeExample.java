package ex09_02_null;

public class RefTypeExample {
	public static void main(String[] args) {
		
		Point obj;
		//The local variable obj may not have been initialized
		//초기화 되지 않은 로컬 변수
		
		System.out.println(obj.x);
		System.out.println(obj.y);
	}

}
