package ex06_4_method_overloading;

public class Method_overloading {

	public static void main(String[] args) {
		/*
		 * 오버로딩을 이용한 prin() 정의 및 호출
		 * 메서드 시그니처 는 메서드 이름, 매개변수 개수, 데이터 타입, 순서를 의미한다.
		 * 이름이 동일하더라도 매개 변수 개수, 데이터 타입, 순서 중
		 * 하나라도 다르면 다른 메서드로 정의하는 것을 메서드 오버로딩이라고 한다.
		 * 자바는 반환 타입으로 메서드를 구분하지는 않는다.
		 */
		
		
	}
	// 매개 변수 없는 메서드 -1
	public static void print() {
		System.out.println("print() 메서드 입니다.");
	}
	// 매개 변수 하나 갖는 메서드 -2
	public static void print(int num) {
		System.out.println("print(int num) 메서드 입니다.");
	}
	// 매개 변수 두 개 갖는 메서드 -3
	public static void print(int num, char data) {
		System.out.println("print(int num, char data) 메서드 입니다.");

	} // 위 메서드와 매개변수 순서가 다르다 - 4
	public static void print(char num, int data) {
		System.out.println("print(char data, int num) 메서드 입니다.");

	}
	
	// 3번과 동일한 메서드로 취급한다. 
	//Duplicate method print(int, char) in type Method_overloading
	/*public static String print(int num, char data) {
		System.out.println("print(int num, char data) 메서드 입니다.");
		return "overloading";
		반환 타입은 메서드 시그니처에 해당하지 않는다.
	}
	*/
}
