package ex15_7_generic1_4_wild;

import java.util.*;

public class WildTest {

	public static void main(String[] args) {
		// List는 인터페이스 , ArrayList 생성 후 Upcasting 이용
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		list.add("test3");

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(Integer.valueOf(3));

		ArrayList<Double> list3 = new ArrayList<Double>();
		list3.add(10.1);
		list3.add(11.2);
		list3.add(12.3);

		printData(list);
		// The method printData(Collection<Object>)
		// in the type WildTest is not applicable for the arguments
		printData(list2);
		// The method printData(Collection<Object>) in the type WildTest is not
		// applicable for the arguments

		printData(list3);
		// The method printData(Collection<Object>) in the type WildTest is not
		// applicable for the arguments
	}

	// public static void printData(Collection<Object> c) {
	public static void printData(List<?> c) { // List<?> -> List 인터페이스를 구현하는 클래스면 모두 받을 수 있다.
		/*
		 * 와일드 카드 ? 제네릭 타입을 매개값이나 리턴 타입으로 사용할 때 구체적인 타입 대신 와일드 카드를 사용할 수 있다. 
		 * 1. <?> => 타입 파라미터를 대치하는 구체적인 타입으로 모든 클래스나 인터페이스 타입이 올 수 있다.
		 * 		  => <? extends Object> 줄임 표현, Unbounded WildCard 라고 한다. -> Object 와 Object를 상속하는 클래스로만 대치할 수 있다. 
		 * 2. <? extends 상위타입> => 타입 파라미터를 대치하는 구체적인 타입으로 특정 클래스와 특정 클래스를 상속 하는 서브 클래스로 제한한다.
		 * 3. <? super 하위타입> => 타입 파라미터를 대치하는 구체적인 타입으로 특정 클래스와 그 클래스의 슈퍼 클래스로만 제한한다.
		 */
		ArrayList<?> list = (ArrayList<?>) c;
		Iterator<?> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
