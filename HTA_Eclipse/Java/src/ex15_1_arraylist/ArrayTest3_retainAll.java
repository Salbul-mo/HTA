package ex15_1_arraylist;

import java.util.ArrayList;

public class ArrayTest3_retainAll {
	public static void main(String[] args) {
		
		ArrayList<String> list1 = new ArrayList<String>(10);
		list1.add("봄");
		list1.add("여름");

		ArrayList<String> list2 = new ArrayList<String>(10);
		list2.add("봄");
		list2.add("가을");
		list2.add("겨울");
		
		list2.retainAll(list1);
		//list2 에서 list1 과 같은 데이터만 남깁니다.
		//list2 n list1 (교집합)
		
		System.out.println("list2 = " + list2);
		System.out.println("list1 = " + list1);
		System.out.println("retainAll(list1) (교집합) 후 \nlist2 = " + list2);	}

}
