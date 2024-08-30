package ex17_04_runnable_interface_anon_util_function;

import java.util.function.BiFunction;

/*
 * java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았다.
 * 
 * 5. BiFunction<T, U, R> 는 두 개의 매개변수 (T,U) , 반환타입이 R 이다.
 * 
 * @FunctionalInterface
 * public interface BiFunction<T, U, R> {
 * 
 * 		R apply(T t, U u); 
 * }
 * T U 타입 매개 2개 입력 받고 R 타입	반환
 */
public class Two_BifunctionExample {

	public static void main(String[] args) {
		
		BiFunction<String,Integer,Student> a = (name, no) -> new Student(name, no);
		Student s = a.apply("홍길동",20);
		System.out.println(s);
		
		BiFunction<String,Integer,Student> b = Student::new; 
		// 메서드 참조형, (String, Integer) 매개변수로 Student를 리턴하는 객체
		// Student(String name, int no) 생성자 호출하는 Student::new 로 매서드 참조
		Student s2 = b.apply("홍길동2",30);
		System.out.println(s2);
	}
}
