package ex17_20_stream_make;

import java.util.stream.IntStream;

/*
 * 3. 특정 범위의 정수 이용한 스트림 만들기
 */
public class Exam3_range {

	public static void main(String args[]) {

		/*
		 * IntStream.range(int startInclusive, int endExclusive) : 
		 * 정수의 값을 startInclusive 부터 endExclusive -1 까지 1씩 증가
		 * 
		 * IntStream.rangeClosed(int startInclusive, int endInclusive) : 
		 * 정수의 값을 startInclusive 부터 endInclusive 까지 1씩 증가
		 */

		System.out.println("===========IntStream.range(1,5)===================");
		IntStream ints = IntStream.range(1, 5); // 1~ 4 (5-1)까지의 정수를 갖는 스트림을 생성합니다.
		ints.forEach(System.out::println);

		System.out.println("===========IntStream.rangeClosed(10,15)===========");
		IntStream ints2 = IntStream.rangeClosed(10, 15); // 10~15까지
		ints2.forEach(System.out::println);

		System.out.println("=========IntStream.range(1,5).count()==============");
		IntStream ints3 = IntStream.range(1, 5);
		long cnt = ints3.count(); // long 타입의 정수를 반환한다.
		/*
		 * long java.util.stream.IntStream.count()
		 * 
		 * 
		 * Returns the count of elements in this stream. 
		 * This is a special case of a reduction and is equivalent to:
		 * 
		 * return mapToLong(e -> 1L).sum();
		 * 
		 * This is a terminal operation. 
		 * Returns: the count of elements in this stream
		 */
		System.out.println(cnt);

		System.out.println("=============IntStream.range(1,5).sum()=============");
		IntStream ints4 = IntStream.range(1, 5);
		int sum = ints4.sum();
		/*
		 * 
		 * int java.util.stream.IntStream.sum()
		 * Returns the sum of elements in this stream. 
		 * This is a special case of a reduction and is equivalent to:
		 * 
		 * return reduce(0, Integer::sum);
		 * 
		 * This is a terminal operation. 
		 * Returns: the sum of elements in this stream
		 */
		System.out.println(sum);

		System.out.println("============IntStream.range(1,5).skip(3)=============");
		// skip(n) => 처음 n개의 요소를 건너뛰고, 나머지 요소들로 새로운 스트림을 반환한다.
		IntStream int_skip = IntStream.range(1, 5).skip(3); // 요소 3개를 건너뛰고 4부터 스트림요소로 사용한다.
		/*
		 * 
		 * IntStream java.util.stream.IntStream.skip(long n)
		 * 
		 * 
		 * Returns a stream consisting of the remaining elements of this stream 
		 * after discarding the first n elements of the stream.
		 * If this stream contains fewer than n elements then an empty stream will be returned.
		 * 
		 * This is a stateful intermediate operation. 
		 * Parameters: n the number of leading elements to skip
		 * Returns: the new stream 
		 * Throws:IllegalArgumentException - 
		 * if n is negative
		 */
		int_skip.forEach(System.out::println);

		/*
		 * 정수형 Predicate 함수 인터페이스
		 * 
		 * @FunctionalInterface public interface IntPredicate { boolean test(int value);
		 * }
		 */
		// filter() 메서드는 스트림의 각 요소를 조건에 따라 필터링한다. 조건이 true 인 요소만을 포함하는 새로운 스트림을 반환한다.
		System.out.println("===================IntPredicate를 이용한 filter()====================");
		IntStream int_predicated = IntStream.range(1, 5).filter(x -> x % 2 == 0);
		/*
		 * 
		 * IntStream java.util.stream.IntStream.filter(IntPredicate predicate)
		 * 
		 * 
		 * Returns a stream consisting of the elements of this stream 
		 * that match the given predicate.
		 * 
		 * This is an intermediate operation. 
		 * Parameters: predicate a non-interfering, stateless predicate to apply to each element to determine 
		 * if it should be included 
		 * Returns: the new stream
		 */
		int_predicated.forEach(System.out::println);
		System.out.println("===================IntPredicate를 이용한 filter() 2.체이닝====================");
		IntStream.range(1, 5).filter(n -> n % 2 == 0).forEach(System.out::println);
		// 한 번에 처리할 수 있다.

		System.out.println("=================filter().map()을 사용한 중간 연산으로 스트림 데이터 수정하기=========");
		/*
		 * 
		 * IntStream java.util.stream.IntStream.map(IntUnaryOperator mapper)
		 * 
		 * @FunctionalInterface
		 * public interface IntUnaryOperator { 
		 * 		int applyAsInt(int operand);
		 * 
		 * Returns a stream consisting of the results of applying the given function to the elements of this stream.
		 * 
		 * This is an intermediate operation. 
		 * 
		 * Parameters: mapper 
		 * 				a non-interfering, stateless function to apply to each element
		 * 
		 * Returns:the new stream
		 */
		// map(IntUnaryOperator mapper) 메서드는 스트림의 각 요소를 주어진 함수를 통해 변환한다. 변환한 요소로 새로운
		// 스트림을 반환한다.
		IntStream.range(1, 5).filter(x -> x % 2 == 0).map(x -> 2 * x).forEach(System.out::println);

		System.out.println("==============filter().map().sum() 사용하여 새로운 IntStream의 합 구하기=========================");
		int total = IntStream.range(1, 5).filter(x -> x % 2 == 0).map(x -> 2 * x).sum();
		System.out.println(total);

	}
}
