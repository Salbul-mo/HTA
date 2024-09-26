package ex17_04_runnable_interface_anon_ramda;

/*
 * 1. 람다식은 메서드를 하나의 식으로 표현한 것이다.
 * 
 * 2. 람다식은 단지 1개의 추상 메서드로 구성된 인터페이스 구현 객체만 람다식으로 표현할 수 있다.
 * 
 * 3. 이 인터페이스를 함수형 인터페이스 (Functional Interface) 라고 한다.
 * 
 * 4. annotation 은 @functionalInterface를 붙인다.
 * => 선택 사항으로 이것을 붙이면 두 개 이상의 추상 메서드가 선언되면 컴파일 오류를 발생시킨다.
 * 
 * 5. 람다식은 함수형 인터페이스를 다음과 같이 연산식 형태로 표현한 것이다.
 * 		형식
 * 			(타입 매개변수) -> {실행문; 실행문; . . . .}
 * 
 * 		(1) (타입 매개변수)             => 람다식의 선언부
 * 			->                       => 람다식 연산자
 * 			{ 실행문; 실행문; . . . .}   => 구현부
 * 	
 * 		(2) 매개변수 타입은 실행 도중 대입하는 값에 따라 자동으로 추론할 수 있기 때문에 타입을 생략해도 된다.
 * 
 * 		(3) 매개변수가 하나 있다면 괄호를 생략할 수 있지만 매개변수가 없으면 괄호가 꼭 있어야 한다.
 * 
 * 		(4) 실행문이 하나 있다면 중괄호를 생략할 수 있다.
 * 			단, 실행문이 하나의 return문이라면 return 키워드도 생략해야 한다.
 * 		
 * 		(5) 람다식의 반환 타입은 문맥에서 추론할 수 있으므로 표현하지 않는다. 
 */

public class RamdaExample_배포 {
	
	public static void main(String args[]) {
		Negative n; // Negative 타입의 n 선언
		
		// 인터페이스 익명 구현 객체 
		n = new Negative() { //unimplemented 클릭하여 메서드 구현, 익명 클래스 구현 객체

			@Override
			public int neg(int x) { // public abstract 생략되어 있다.
				// TODO Auto-generated method stub
				return -x;
			}
		}; // 객체 n 의 neg(int x) 메서드를 구현했다.
		System.out.println(n.neg(-10)); // 객체 n의 메서드 neg()를 이용해서 출력
		
		
		// 이하 모두 동일한 람다식 표현
		
		
		// 방법 1. 매개 변수와 구현부만 남긴다
		n = (int x) -> {
			return -x;
		};
		System.out.println(n.neg(-20));
		
		
		// 방법 2. 매개변수 타입은 실행 도중 대입하는 값에 따라 자동으로 추론할 수 있기 때문에 타입을 생략해도 된다.
		n = (x) -> {
			return -x;
		};
		System.out.println(n.neg(-30));
		
		
		// 방법 3. 매개변수가 하나 있다면 괄호를 생략할 수 있지만, 매개변수가 없다면 괄호를 반드시 표기해야 한다.
		n = x -> {
			return -x;
		};
		System.out.println(n.neg(-40));
		
		
		// 방법 4. 실행문이 하나 있다면 중괄호 생략할 수 있다.
		// 단, 실행문이 하나의 return 문이라면 return 키워드도 생략해야 한다.
		// n = x -> return -x ; // 오류 발생
		n = (int x) -> -x; 
		System.out.println(n.neg(-50));
		
		// 방법 5. 람다식의 반환 타입은 문맥에서 추론할 수 있으므로 표현하지 않는다.
		n = (x) -> -x;
		System.out.println(n.neg(-60));
		
		n = x -> -x;
		System.out.println(n.neg(-70));
		
		
		
	}

}
