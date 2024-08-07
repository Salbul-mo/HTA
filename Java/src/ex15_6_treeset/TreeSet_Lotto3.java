package ex15_6_treeset;

import java.util.*;

public class TreeSet_Lotto3 {
	public static void main(String[] args) {
		TreeSet<Integer> ht = new TreeSet<>(Comparator.reverseOrder());
		//역순으로 정렬하라는 구분자 추가
		/*
		 * Comparator 는 Java 의 java.util 패키지에 포함된 인터페이스, 객체의 순서를 정의하기 위해 사용된다.
		 * 주로 컬렉션의 정렬을 위해 사용되며, 사용자 정의 정렬 기준을 지정할 수 있다.
		 * 메서드 int compareTo(T o);
		 * 이 메서드는 현재 객체와 전달된 객체 o를 비교하여 음수, 0, 양수를 반환환다.
		 * 반환 값은 다음과 같은 의미를 갖는다
		 * 음수 - 작다
		 * 0 - 같다
		 * 양수 - 크다
		 * 
		 */
		//TreeSet은 정렬이 된다.
		for (; ht.size() < 6;) {
			ht.add((int) (Math.random() * 45) + 1);
			// Math.random 은 double 반환이므로 (int)로 형 변환해주어야 한다.
		}

		System.out.println(ht);
		
	
	}

}
