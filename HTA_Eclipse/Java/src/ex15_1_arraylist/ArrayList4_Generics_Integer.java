package ex15_1_arraylist;

/*
 * 1. 지네릭스(Generics) JDK 1.5에서 처음 도입
 * 		다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 타입체크를 해주는 기능이다.
 * 
 * 2. 클래스 옆에 <> 꺽쇠 기호를 이요해서 만든다.
 * 	1)<> 안에 특정 자료형(Wrapper 클래스, String, 사용자 정의 클래스참조형)을 넣어준다.
 *  2) API 형식 표기
 *  	Class ArrayList<E> : E의 ArrayLIst라고 읽는다
 *  		- ArrayList : 원시 타입(raw type)
 *  		- E(타입 매개 변수) : 기호의 종류만 다를 뿐 임의의 참조형 타입을 의미한다.
 *  
 *  타입 매개 변수의 의미
 *  E : 원소 (Element)
 *  K : 키 (Key)
 *  T : 타입 (Type)
 *  V : 값 (Value)
 *  
 *   - 사용 예)
 *   List<String> list = new ArrayList<String>();
 *   ArrayList<String> list = new ArrayList<String>();
 *   ArrayList<Integer> list = new ArrayList<Integer>();
 *   ArrayList<Double> list = new ArrayList<Double>();
 *   ArrayList<MemberInput> list = new ArrayList<MemberInput>();
 */
import java.util.*;

public class ArrayList4_Generics_Integer {

	public static void main(String args[]) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		// Integer 타입 ArrayList 객체 생성

		// list 에 3개의 데이터 추가
		list.add(1); // list.add(Integer.valueOf(int)); 오토 박싱
		list.add(2);
		list.add(3);

		int length = list.size(); // list 의 데이터 갯수를 반환

		// 출력 방법 1 - 해당 객체명으로 출력하는 방법
		System.out.println("=====객체명으로 출력하기=====");
		System.out.println(list);
		System.out.println(list.toString());

		// 출력 방법 2 - get() 메서드 이용법1
		System.out.println("=====get()메서드로 출력=====");
		for (int cnt = 0; cnt < length; cnt++) {
			int num = list.get(cnt);
			System.out.println(num);
		}

		System.out.println("=====향상된 for 문=====");
		for (int num : list) {
			System.out.println(num);
		}

		// 출력 방법 4 - Iterator 인터페이스 사용 : 반복자 (요소를 순차적으로 접근하는 방식을 제어하는 경우 적합)
		System.out.println("=====Iterator 인터페이스 사용=====");
		Iterator<Integer> elements = list.iterator();
		while (elements.hasNext()) {
			System.out.println(elements.next());
		}
	}

}
