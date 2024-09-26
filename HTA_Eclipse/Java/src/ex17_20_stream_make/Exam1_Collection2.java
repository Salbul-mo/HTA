package ex17_20_stream_make;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exam1_Collection2 {
	public static void main(String args[]) {

		/*
		 * 스트림 생성 방식 1. 컬렉션 2. 배열 3. 특정 범위의 정수 이용 4. 람다식
		 */

		List<String> list = Arrays.asList("홍길동", "hta", "자바");

		// ==============3-1 Stream 방식======================
		/*
		 * 스트림 생성 방법 - 컬렉션 Stream<T> Collection.stream() => Collection 의 자식인 List와 Set을
		 * 구현한 컬렉션 클래스들은 모두 이 메서드로 스트림을 생성할 수 있다. 해당 컬렉션을 소스(source)로 하는 스트림을 반환한다.
		 * 
		 * list.stream() 메서드는 리스트의 요소들을 스트림으로 변환한다. 스트림은 데이터를 일련의 연산으로 처리할 수 있는 추상화된
		 * 객체이다. 이 스트림은 리스트의 요소를 순차적으로 처리할 수 있게 해준다.
		 * 
		 */

		System.out.println("================3-1. Stream 방식==================");
		Stream<String> stream = list.stream(); // list의 엘리먼트를 스트림으로 변환하여 Stream<String> 객체에 대입
		stream.forEach((name) -> {

			System.out.println(name);

		});

		System.out.println("================3-2. Stream 방식==================");
		Stream<String> stream2 = list.stream();
		stream2.forEach(name -> System.out.println(name));

		System.out.println("================3-3. Stream 방식==================");
		Stream<String> stream3 = list.stream();
		stream3.forEach(System.out::println);
		// Consumer<String> 익명객체 구현의 메서드 참조, 매개변수 있고 반환이 없는 함수 인터페이스이다.
		// Stream 은 생성되고 최종 연산을 한번 하고 나면 다시 사용할 수 없다.

		// long count = stream3.count(); // stream3 이 이미 forEach 로 사용된 뒤라 다시 사용할 수 없다.
		// Exception in thread "main" java.lang.IllegalStateException: stream has
		// already been operated upon or closed

		System.out.println("==================collect(Collectors.toList())===================");
		Stream<String> stream4 = list.stream();
		// 새로운 리스트에 결과를 저장한다.
		List<String> list2 = stream4.sorted().collect(Collectors.toList());
		/*
		 * 
		 * Stream<String> java.util.stream.Stream.sorted()
		 * 
		 * 
		 * Returns a stream consisting of the elements of this stream,
		 * sorted according to natural order. 
		 * If the elements of this stream are not Comparable,
		 *  a java.lang.ClassCastException may be thrown
		 * when the terminal operation is executed.
		 * 
		 * For ordered streams, the sort is stable. For unordered streams, no stability guarantees are made.
		 * 
		 * This is a stateful intermediate operation.
		 * 
		 */
		System.out.println(list2); // 출력 [hta, 자바, 홍길동]
		// 기본 오름차순 정렬
		Stream<String> stream5 = list.stream();
		Stream<String> list3 = stream5.sorted();

		list3.forEach(System.out::println);
		// 내림차순 정렬하는 법
		List<String> sortedList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		/*
		 * 
		 * java.util.stream.Collectors
		 * 
		 * 
		 * Implementations of Collector that implement various useful
		 * reductionoperations, such as accumulating elements into collections,
		 * summarizingelements according to various criteria, etc.
		 * 
		 * The following are examples of using the predefined collectors to
		 * performcommon mutable reduction tasks:
		 * 
		 * // Accumulate names into a List List<String> list = people.stream()
		 * .map(Person::getName) .collect(Collectors.toList());
		 * 
		 * // Accumulate names into a TreeSet Set<String> set = people.stream()
		 * .map(Person::getName) .collect(Collectors.toCollection(TreeSet::new));
		 * 
		 * // Convert elements to strings and concatenate them, separated by commas
		 * String joined = things.stream() .map(Object::toString)
		 * .collect(Collectors.joining(", "));
		 * 
		 * // Compute sum of salaries of employee int total = employees.stream()
		 * .collect(Collectors.summingInt(Employee::getSalary));
		 * 
		 * // Group employees by department Map<Department, List<Employee>> byDept =
		 * employees.stream() .collect(Collectors.groupingBy(Employee::getDepartment));
		 * 
		 * // Compute sum of salaries by department Map<Department, Integer> totalByDept
		 * = employees.stream() .collect(Collectors.groupingBy(Employee::getDepartment,
		 * Collectors.summingInt(Employee::getSalary)));
		 * 
		 * // Partition students into passing and failing Map<Boolean, List<Student>>
		 * passingFailing = students.stream() .collect(Collectors.partitioningBy(s ->
		 * s.getGrade() >= PASS_THRESHOLD)); Since:
		 */
		System.out.println(sortedList);// 출력 [홍길동, 자바, hta]

	}

}
