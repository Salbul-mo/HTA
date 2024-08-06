package ex15_1_arraylist;

import java.util.ArrayList;

public class ArrayTest1_contains2 {

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

		 removeList(list1, list2);

		System.out.println(list2);

		/*for (int i = 0; i < list1.size(); i++) {
			if (list1.contains(list2.get(i))) {
				list2.remove(i);
				i--;
				System.out.println("삭제 후\n " + list2);
			}
		}*/

	}

	public static void removeList(ArrayList<String> list1, ArrayList<String> list2) {
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if (list1.get(i).equals(list2.get(j))) { 
					//for(int i = 0; i < list2.size();i++) { 이게 더 간단한 for 문이다.
					// if (list1.contains(list2.get(j))) { list1이 list2의 index i의 객체를 포함하면
					// list2.remove(i); list2 의 index i 를 remove();
					// i--;  list2 의 index가 당겨졌으므로 i--;
				    //  }
					//}
					list2.remove(j);
					j--; 
					// 배열 요소가 지워지고 한칸씩 당겨지므로 j 값도 줄여야한다.
							// j = 0 [봄 봄 여름 가을 가을] -> [봄 여름 가을 가을] 삭제 후 j++
							// j = 1 이므로 당겨진 봄(index 0)을 탐색하지 않고 index 1 부터 탐색한다.

				}
			}
		}
	}
}
