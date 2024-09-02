package ex17_21_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exam3 {

	public static void main(String args[]) {
		
		List<String> myList = Arrays.asList("test2.java","test.java", "test2.java", "test.txt", "test.txt", "hta");
		List<String> list = myList.stream() // 스트림 생성
											.filter(str -> str.indexOf(".") != -1) // . 있는지 확인하고 걸러내기
												.map(String::toUpperCase) // 대문자로 만들기
													.sorted() // 정렬하기
														.collect(Collectors.toList()); // 최종 결과를 리스트로
		System.out.println(list);
		System.out.println(list.size());
		
		List<String> list2 = myList.stream() // 스트림 생성
											.filter( str -> str.indexOf(".") != -1) // . 있는지 확인하고 걸러내기
												.map(String::toLowerCase) // 소문자로 만들기
													.distinct() // 중복 제거
														.sorted() // 정렬하기
															.collect(Collectors.toList()); // 최종 결과를 리스트로
		System.out.println(list2);
		System.out.println(list2.size());
		
		/*
		 * 메서드 체이닝을 이용한 표현 법
		 * 메서드 체이닝이란 객체의 메서드가 객체 자신을 반환하여 여러 메서드를 연속적으로 호출할 수 있게 하는 프로그래밍 기법이다.
		 * 이렇게 하면 코드가 간결하고 읽기 쉬워진다.
		 * Java 스트림 API 는 메서드 체이닝을 적극적으로 사용하여 데이터 처리를 직관적이고 선언적으로 표현할 수 있게 한다.
		 * 
		 */
		
		
		
	}
}
