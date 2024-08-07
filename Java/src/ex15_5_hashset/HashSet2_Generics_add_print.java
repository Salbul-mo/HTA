package ex15_5_hashset;

/*
 * Set 인터페이스
 * 	-HashSet (상속 받는 클래스) : 내부적으로 HashMap을 이용해서 만들어졌으며
 * 	 HashSet 이란 이름은 해싱을 이용해서 구현했기 때문에 붙여진 것이다.
 *  -TreeSet 은 이진 검색 트리(binary search tree) 라는 자료구조의 형태로 데이터를 저장하는
 *   컬렉션 클래스이다. 
 *   1. 여러가지 자료형을 모두 저장할 수 있다. (기본형, 참조형) 모두
 *   2. 순서 없이 입, 출력이 된다.
 *   3. 중복된 데이터를 저장하지 못한다.
 *   ex) 로또 번호 6개를 중복 없이 생성하는 예제처럼
 */
import java.util.HashSet;
import java.util.Iterator;

public class HashSet2_Generics_add_print {

	public static void main(String[] args) {
		// HashSet 객체 생성
		HashSet<String> set = new HashSet<String>();
		// 데이터 저장
		set.add("자바");
		set.add("카푸치노");
		set.add("에스프레소");
		set.add("자바");

		// set 객체가 저장하고 있는 데이터 객체 수
		System.out.println("저장된 데이터의 수 : " + set.size());

		// set 객체가 보관하고 있는 데이터 객체 출력
		System.out.println(set);

		// iterator() : set에 있는 데이터를 모두 가져온다.
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
	}

}
