package ex17_04_runnable_interface_anon_util_function;

import java.util.function.Supplier;

/*
 * java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았다.
 * 
 * 4. Supplier<T> 는 매개변수는 없고 반환타입이 T 이다.
 * 
 * @FunctionalInterface
 * public interface Supplier<T> {
 * 		T get();
 * }
 */
public class SupplierExample {

	public static void main(String args[]) {
		
		Supplier<Integer> a = () -> (int)(Math.random()*45 +1);
		// Supplier<Integer> 타입인 변수 a 를 람다식으로 객체 구현한다.
		// 매개변수 없으므로 () 생략할 수 없고, Integer get() {
		//									return (int) Math.random()*45 +1; }
		System.out.println(a.get());
		
		
		// Student 객체 생성식을 람다식으로 작성한다.
		// Supplier<Student> b = () -> new Student();
		
		Supplier<Student> b = Student::new; // 메서드 참조 방식. 생성자는 타입::new 로 표현한다.
				
		Student s = b.get();
		s.setName("홍길동");
		s.setNo(11);
		System.out.println(s);
		
		
	}
	
}
