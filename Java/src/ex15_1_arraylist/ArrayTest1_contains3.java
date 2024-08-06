package ex15_1_arraylist;

import java.util.ArrayList;

public class ArrayTest1_contains3 {

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

		for (int i = (list2.size() - 1); i >= 0; i--) { // 뒤에서부터 삭제
			if (list1.contains(list2.get(i))) {
				list2.remove(i);
				System.out.println("삭제 후\n " + list2);
			}
		}
		// 뒤에서부터 체크하면서 삭제해오면 배열의 index를 재배열하는 작업 없이 바로 삭제 가능하다.
	}

}
