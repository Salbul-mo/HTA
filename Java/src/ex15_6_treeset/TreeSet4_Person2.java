package ex15_6_treeset;
import java.util.*;
public class TreeSet4_Person2 {

	public static void main(String[] args) {
		/*
		 * TreeSet은 내부적으로 객체들을 정렬하여 저장하기 위해 Comparable 인터페이스를 구현한 객체들을
		 * 필요로 한다
		 */
		// 컬렉션 생성
		TreeSet<Person2> treeSet = new TreeSet<Person2>();
		
		// 객체 생성
		//class ex15_6_treset.Person0 cannot be cast to class java.lang.Comparable
		//Comparable 인터페이스를 구현하지 않은 클래스이므로 정렬할 수 없다.
		treeSet.add(new Person2("홍길동",30));
		treeSet.add(new Person2("자바",26));
		treeSet.add(new Person2("스프링",26));
		treeSet.add(new Person2("홍길동",30));
		
		System.out.println(treeSet);
		
		/*
		 * [person1 [name=자바, age=26], person1 [name=홍길동, age=30]]
		 * 여기서 compareTo() 는 단순히 나이를 기준으로 비교했다.
		 * 따라서 나이가 같은 객체들은 동등한 것으로 간주되어 중복된 객체로 덮어씌워진다.
		 * => 또다른 필드인 이름도 비교하는 수정이 필요하다.
		 */
	}
}
