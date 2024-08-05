package ex07_2_Exception;

//checked exception 을 던지는 메서드
//컴파일 에러 발생
//throws Exception을 가진 메서드 호출시 try - catch 문으로 처리
public class ExceptionExample3_1 {

	public static void main(String[] args) {
		int result = add(1,-2);
		System.out.println(result);
		
	}
	
	static int add(int a, int b) {
		int result = a + b;
		if (result < 0) {
			//throw new Exception("0보다 작아 에러가 발생합니다.");
		}
		return result;
	}
}
