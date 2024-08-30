package ex17_21_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Exam1 {

	public static void main(String[] args) {

		List<Member> member = new ArrayList<>(); // 멤버 클래스 타입의 객체를 담을 ArrayList 생성
		member.add(new Member("홍길동", 21)); // list 에 요소 삽입
		member.add(new Member("자바", 30));
		member.add(new Member("이순신", 30));

		Stream<Member> stream = member.stream();
		/*
		 * 
		 * Stream<Member> java.util.Collection.stream()
		 * 
		 * Returns a sequential Stream with this collection as its source.
		 * 
		 * This method should be overridden when the spliterator() method 
		 * cannot return a spliterator that is IMMUTABLE, CONCURRENT, or late-binding.
		 *  (See spliterator() for details.)
		 * 
		 * Returns: a sequential Stream over the elements in this collection 
		 * ImplSpec: The default implementation creates a sequential Stream from the collection's Spliterator.
		 */
		
		stream.forEach(s -> {
			System.out.println(s);
		});

		Stream<Member> stream2 = member.stream();
		stream2.forEach(System.out::println);
		
		// 배열 만들기
		Member[] memArr = new Member[] { member.get(0), member.get(1), member.get(2) };
		
		// Member 타입 List 만들기
		List<Member> list = new ArrayList<>();
		// list 의 사이즈
		int size = list.size();
		System.out.println(size);
		// 배열을 이용해 스트림 생성하고 forEach를 이용해서 list에 일괄 추가
		Stream<Member> stream3 = Arrays.stream(memArr);
		stream3.forEach(list::add);
		// 일괄 출력
		list.forEach(System.out::println);
		// 사이즈 출력
		int size2 = list.size();
		System.out.println(size2);

	}
}
