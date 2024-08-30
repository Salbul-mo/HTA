package ex17_20_stream_make;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * 2. 배열을 이용한 스트림 만들기
 * 
 */
public class Exam2_array {

	public static void main(String[] args) {

		Stream<String> s1 = Stream.of("a", "b", "c"); // 가변 인자
		/*
		 * <String> Stream<String> java.util.stream.Stream.of(String... values)
		 * @SafeVarargs <- 배열로 가변인자를 받아 Stream으로 반환한다.
		 * Returns a sequential ordered stream whose elements are the specified values.
		 * Type Parameters:<T> the type of stream elements 
		 * Parameters:values the elements of the new stream
		 */
		s1.forEach(System.out::println);

		String[] names = new String[] { "a", "b", "c" };
		Stream<String> s2 = Stream.of(names);
		s2.forEach(System.out::println);

		Stream<String> s3 = Arrays.stream(names);
		s3.forEach(System.out::println);

		int[] ages = new int[] { 20, 35, 30 };
		IntStream s4 = IntStream.of(ages);
		s4.forEach(System.out::println);

		IntStream s5 = Arrays.stream(ages);
		s5.forEach(System.out::println);

	}
}
