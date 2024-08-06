package ex15_1_arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayTest1_contains5 {

	public static void main(String[] args) {

		ArrayList<String> list1 = new ArrayList<String>(10);
		list1.add("봄");
		list1.add("여름");

		ArrayList<String> list2 = new ArrayList<String>(10);
		list2.add("봄");
		list2.add("봄");
		list2.add("여름");
		list2.add("가을");
		list2.add("가을");

		System.out.println("list2 = " + list2);
		
		//Iterator 를 사용하는 로직. removeAll() 도 이런 식으로 동작한다고 한다.
		Iterator<String> it = list2.iterator();
		while (it.hasNext()) {
			if (list1.contains(it.next())) {
				it.remove();
			}
		}
		System.out.println("list1 = " + list1);
		System.out.println("삭제 후 \nlist2 = " + list2);

	}
}
