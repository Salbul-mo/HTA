package ex15_1_arraylist;

import java.util.ArrayList;

public class ArrayTest1_contains4 {

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

		System.out.println(list2);
		list2.removeAll(list1); // list2 - list1 : 차집합
		System.out.println("removeAll(list1) 후\n " + list2); // list2 에서 list1 과 같은 데이터 제거

	}
}
