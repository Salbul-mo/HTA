package ex17_21_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Exam2 {

	public static void main(String[] args) {
		List<Member> list = new ArrayList<>();
		list.add(new Member("홍길동", 21));
		list.add(new Member("자바", 30));
		list.add(new Member("이순신",30 ));
		
		
		//list 에 존재하는 Member 객체들의 나이 평균을 구하시오
		Stream<Member> stream = list.stream();
		OptionalDouble avg = stream.mapToInt(Member::getAge).average();
		System.out.println(avg.getAsDouble());
		
		/* OptionalDouble 에 값이 존재하는지 체크하고 사용한다. (isPresent() 메서드 사용)
		 * 
		 * IntStream intStream = stream.mapToInt(Member::getAge); 
		 * OptionalDouble optional = intStream.average();
		 * 
		 * if(optional.isPresent()) {
		 * 		Double avg = optional.getAsDouble();
		 * 		System.out.println(avg);
		 * } else {
		 * 		System.out.println("비어있어요");
		 * }
		 */
		
	}
}
/*
 * 1. list.stream() 을 통해 리스트의 스트림을 생성한다
 * 
 * 2. mapToInt(Memer::getAge) 
 * 		스트림의 각 Member 객체에 대해 getAge 메서드를 호출하여 나이를 정수(int)로 매핑한다.
 * 		이 단계에서는 Member 객체의 스트림을 IntStream 으로 변환한다.
 * 		IntStream은 Java의 스트림 API에서 기본형 int를 위한 특화된 스트림 타입이다.
 * 		IntStream 외에 LongStream, DoubleStream 등의 특화된 스트림을 제공한다.
 * 
 * 3. average() 를 호출하여 스트림의 요소들의 평균을 계산하고 OptionalDouble 로 반환한다.
 * 		이는 평균값이 없을 경우(예 : 스트림이 비어 있는 경우) 를 대비하기 위함이다.
 * 
 * 4. getAsDouble()을 통해 OptionalDouble 에서 실제 평균값을 추출한다.
 * 		만약 평균값이 존재하지 않을 경우 (예 : 스트림이 비어 있는 경우) 예외가 발생한다.
 * 
 * 
 */
