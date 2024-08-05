package ex07_2_Exception;

//checked exception 을 던지는 메서드
//컴파일 에러 발생
//throws Exception을 가진 메서드 호출시 try - catch 문으로 처리
public class ExceptionExample3_2 {

	public static void main(String[] args) {
		try {
			int result = add(1, -2);   // Exception 되돌아 옴
			System.out.println(result);

		} catch (Exception e) {  //  Exception catch
			String str1 = e.getMessage();// --->"0보다 작아 에러가 발생합니다." 가져옴
			System.out.println(str1);
			System.out.println("다시 입력하세요");
		}
	}

	static int add(int a, int b) throws Exception { //메서드 호출한 곳으로 다시 던짐
		int result = a + b;
		if (result < 0)
			throw new Exception("0보다 작아 에러가 발생합니다.");
		return result;
	}
}

