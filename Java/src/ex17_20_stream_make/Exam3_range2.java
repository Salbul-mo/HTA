package ex17_20_stream_make;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Exam3_range2 {

	public static void main(String[] args) {

		System.out.println("============IntStream.range(1,1)==============");
		IntStream ints = IntStream.range(1, 1); // 비어있는 스트림
		ints.forEach(System.out::println);

		System.out.println("===============IntStream.range(1,1).average()========");
		@SuppressWarnings("unused")
		OptionalDouble avg = IntStream.range(1, 1).average();
		/*
		 * Returns an OptionalDouble describing the arithmetic mean of elements of this stream, 
		 * or an empty optional if this stream is empty. This is a special case of a reduction.
		 * 
		 * This is a terminal operation. 
		 * Returns: an OptionalDouble containing the average element of this stream,
		 * or an empty optional if the stream is empty
		 * 
		 * 
		 * java.util.OptionalDouble
		 * 
		 * @ValueBased
		 * 
		 * A container object which may or may not contain a double value.
		 * If a value is present, isPresent() returns true.
		 *  If no value is present, the object is considered empty and isPresent() returns false.
		 * 
		 * Additional methods that depend on the presence or absence of a contained value are provided,
		 * such as 
		 * orElse() (returns a default value if no value is present) 
		 * and 
		 * ifPresent() (performs an action if a value is present).
		 * 
		 * This is a value-based class;
		 * programmers should treat instances that are equal as interchangeable and 
		 * should not use instances for synchronization, or unpredictable behavior may occur.
		 * For example, in a future release,
		 * synchronization may fail. 
		 * 
		 * API Note:
		 * OptionalDouble is primarily intended for use as a method return type where 
		 * there is a clear need to represent "no result."
		 * A variable whose type is OptionalDouble should never itself be null; 
		 * it should always point to an OptionalDouble instance.
		 */
		// java.util.NoSuchElementException: No value present
		// System.out.println("Average: " + avg.getAsDouble()); 
		// 비어있는 스트림에 대해 평균값을 구하는 메서드 사용. 오류 일어난다.

		System.out.println("======================IntStream.range(1,1).average() 2=============");
		OptionalDouble avg2 = IntStream.range(1, 5).average();

		if (avg2.isPresent()) { //Double 값이 있으면 true
			System.out.println("Average: " + avg2.getAsDouble());
		} else { // 없으면 false
			System.out.println("No average available");
		}
	}
}
