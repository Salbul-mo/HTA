package ex15_6_treeset;
import java.util.*;
public class TreeSet4_Person0 {

	public static void main(String[] args) {
		/*
		 * TreeSet은 내부적으로 객체들을 정렬하여 저장하기 위해 Comparable 인터페이스를 구현한 객체들을
		 * 필요로 한다
		 */
		// 컬렉션 생성
		TreeSet<Person0> treeSet = new TreeSet<Person0>();
		
		// 객체 생성
		treeSet.add(new Person0("홍길동",30));
		treeSet.add(new Person0("자바",26));
		treeSet.add(new Person0("스프링",26));
		treeSet.add(new Person0("홍길동",35));
		
		System.out.println(treeSet);
		//class ex15_6_treset.Person0 cannot be cast to class java.lang.Comparable
		//Comparable 인터페이스를 구현하지 않은 클래스이므로 정렬할 수 없다.
		
	}
}
