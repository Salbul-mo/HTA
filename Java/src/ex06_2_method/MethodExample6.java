package ex06_2_method;

public class MethodExample6 {

	//접근제어자   객체생성없이 접근가능       반환되는 값의 자료형      메서드이름(매개변수 목록)
	public      static                 void                 main(String args[]) {
		
		int num = 50;
		// num 변수가 갖고 있는 값을 pint() 안에서 출력하려면?
		print(num); // 메서드의 괄호 안에 식별자를 넣어주면 된다.
					// 메서드를 정의한 곳에서 num을 값을 저장하기 위한 변수를 선언해 주어야 한다.
					// The method print() in the type MethodExample1 is not applicable for the arguments (int)
					// 호출하는 메서드에서 사용한 num을 인자(arguments) 라고 하며
					// 메서드 정의에서 사용된 num을 매개 변수(parameter) 라고 한다.
		
	
	}				
	
	//메서드 정의
	/*
	public static void print() {
		
		System.out.println("print() 메서드 입니다.");
		
	}
	*/
	
	public static void print(int num) { //int 라고 같은 자료형만 선언해주면 식별자는 아무거나 써도 된다.  
										//int parameter -> 매개 변수
										// 매개 변수도 캐스팅이 일어나며 규칙은 동일하다.
		System.out.println("print() 메서드 입니다.");
		System.out.println("main() 메서드에서 전달받은 데이터의 값은 " + num + "입니다.");
	}
}
