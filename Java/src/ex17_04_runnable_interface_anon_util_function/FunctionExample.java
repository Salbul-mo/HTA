package ex17_04_runnable_interface_anon_util_function;

/*
 * java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았다.
 * 
 * 2. Function<T,R> 은 한개의 매개변수 T, 반환값이 R인 함수형 인터페이스
 * @FunctionalInterface
 * public interface Function<T,R> {
 * 		R apply(T t)
 */
import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {

		/*
		 * 
		 * java.util.function.Function<String, Integer>
		 * 
		 * 
		 * @FunctionalInterface
		 * 
		 * 
		 * Represents a function that accepts one argument and produces a result.
		 * 하나의 매개변수를 받고 결과값 리턴한다.
		 * 
		 * This is a functional interface whose functional method is apply(Object).
		 * 메서드 이름은 apply(Object)이다.
		 *  
		 * Type Parameters:
		 * <T> the type of the input to the function
		 * <R> the type of the result of the function
		 */
		
		Function<String, Integer> a = i -> Integer.parseInt(i); // 람다식 객체 구현
		int result = a.apply("100"); // apply(String str) 의 리턴인 <Integer> 를 대입할 int result 선언 및 대입 
		System.out.println(result);
		
		
		a = Integer::parseInt; // 메서드 참조식 표현
		result = a.apply("200");
		System.out.println(result);
		
		
		//Integer 타입을 입력 받고 int[] 타입을 출력하는 함수 인터페이스
		
		Function<Integer, int[]> f = x -> new int[x]; // 람다식 객체 구현
		int[] array = f.apply(4);
		System.out.println("생성된 배열갯수 = " + array.length);
		
		Function<Integer, int[]> f2 = int[]::new;
		int[] array2 = f2.apply(5);
		System.out.println("생성된 배열갯수 = " + array2.length);
		
		
	}
}
