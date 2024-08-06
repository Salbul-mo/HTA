package ex15_1_arraylist;

import java.util.*;

/*
 * List 인터페이스 - ArrayList (상속받는 클래스)
 * 		1. 여러가지 자료형의 Data 를 모두 저장할 수 있다.
 * 		2. 입력한 순서대로 출력된다.
 * 		3. 중복된 Data 저장 가능하다.
 * 		4. 동적인 저장 구조를 이용할 수 있다.(add(), remove())
 */
public class ArrayList1_add {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String args[]) {
		// 업 캐스팅(상속해준 메서드만 사용 가능하다)
		// List list = new ArrayList();

		ArrayList list = new ArrayList();
		// 자료 추가
		// ArrayList is a raw type.
		// References to generic type ArrayList<E> should be parameterized
		// 제네릭을 이용해서 저장할 객체의 타입을 지정해 달라는 경고문이 뜬다.

		list.add("하나");
		list.add(2); // list.add(Integer.valueOf(2)); 오토 박싱
		list.add(false);
		list.add(3.42);
		list.add("넷");
		list.add("five");
		list.add('A');

		// 다양한 타입의 객체를 모두 저장할 수 있지만
		// 제네릭으로 지정되지 않아서 어떤 인덱스에 어떤 타입의 객체가 들어가 있는지 알고 있어야 사용할 수 있고
		// 사용할 때에도 명시적으로 다운 캐스팅(언박싱)하여 사용하여야 한다.

		System.out.println(list);// list의 모든 데이터 출력
		System.out.println(list.toString());
		/*
		 * Returns a string representation of this collection. The string representation
		 * consists of a list of the collection's elements in the order they are
		 * returned by its ierator, enclosed in square brackets("[]"). Adjacent
		 * elements are separated by the characters ", " (comma and space). Elements are
		 * converted to strings as by String.valueOf(Object).
		 */

		// size() - 데이터의 갯수 구하는 메서드
		System.out.println("데이터의 갯수 : " + list.size());

		// get(index) - 해당 index 의 객체를 반환
		int first = (int) list.get(1); // 정수 객체 다운 캐스팅(언박싱)
		System.out.println("list.get(1)= " + first);

		String four = (String) list.get(4); // 문자열 객체 다운 캐스팅(언박싱)
		System.out.println("list.get(4)= " + four);

		// 출력 방법 1. - 해당 객체명으로 출력하는 방법
		System.out.println("===객체명으로 출력하기===");
		System.out.println(list);
		System.out.println(list.toString());

		// 출력 방법 2 - get() 메서드 이용법
		System.out.println("===get()메서드 이용법===");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "번째 요소 " + list.get(i));
		}
		System.out.println("==============");

		for (int i = 0; i < list.size(); i++) {
			Object s = list.get(i); //get()메서드의 반환형은 Object클래스 타입이다.
			System.out.println(s);
		}

		// 출력 방법 3 - for 문 사용(간결한 코드)
		System.out.println("====향상된 for 문 사용====");
		for (Object a : list) {
			System.out.println(a);
		}
		
		// 출력 방법 4 - Iterator 인터페이스 사용 : 반복자(요소를 순차적으로 접근하는 방식을 명시적으로 제어하는 경우 적합하다)
		
		System.out.println("===Iterator 인터페이스 사용 ===");
		
		Iterator elements = list.iterator();
		// 해당 Collection 을 열거 상수로 바꿔서 인스턴스를 만든다.
		// hasNext() : 읽어올 다음 element 가 있는지 확인 StringTokenizer랑 비슷하다.
		while (elements.hasNext()) {
			System.out.println(elements.next());
		}
	}
}
