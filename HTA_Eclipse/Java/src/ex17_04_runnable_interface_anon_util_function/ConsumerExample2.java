package ex17_04_runnable_interface_anon_util_function;

import java.util.function.Consumer;

/*
 * java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 미리 함수 인터페이스로 정의해 놓았다.
 *  
 *  1. Consumer<T> 한 개의 매개변수가 있고 반환값이 없는 함수형 인터페이스
 *  
 *  @FunctionalInterface
 *  public interface Consumer<T> {
 *  	void accept(T t);
 *  } 
 */

public class ConsumerExample2 {

	public static void main(String[] args) {

		Box box = new Box();
		box.add("홍길동");
		box.add("hta");
		box.add("자바");

		box.forEach(System.out::println); 
		// Consumer<String> 객체의 accept(String str) 메서드를 System.out의 println()메서드를 참조하는 방법으로 구현하여 파라미터로 넘겨준다
		
		/*
		 * public void forEach(Consumer<? super String> action) { 
		 * 		for (String eachData : list) { 
		 * 			action.accept(eachData); 
		 * 		}
		 * }
		 */
	}
}
