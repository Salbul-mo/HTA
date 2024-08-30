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
		
		
	}
}
