package ex17_04_runnable_interface_anon_util_function;

import java.util.function.Predicate;

/*
 * java.util.funtion 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았다.
 * 
 * 3. Predicate<T> 는 조건식을 표현하는데 사용한다.
 * 		한개의 매개변수 T, 반환타입이 boolean 이다.
 * 
 *@FunctionalInterface
 *public interface Predicate<T> {
 *		boolean test(T t);
 *}
 *
 */
public class PredicateExample {

	public static void main(String[] args) {
		
		Predicate<String> a = s -> s.length() == 0; //람다식
		// Predicate<String> 타입 변수 a 선언
		// a 의 람다식 객체 구현 Predicate (String s) { public boolean test(String s) { return s.length == 0;}}
		System.out.println(a.test("100"));
		
		
	}
}
