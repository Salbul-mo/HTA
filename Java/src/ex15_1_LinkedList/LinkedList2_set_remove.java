package ex15_1_LinkedList;

import java.util.LinkedList;

public class LinkedList2_set_remove {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();

		list.add("머루");
		list.add("사과");
		list.add("키위");
		list.add("자두");
		list.add(2, "사과");
		pLinkedList(list);

		list.set(0, "오렌지");
		pLinkedList(list);

		list.remove(1);
		pLinkedList(list);

		list.remove("키위");
		pLinkedList(list);

	}

	public static void pLinkedList(LinkedList<String> list) {
		// 매개 참조 변수로 쓸 때에도 <타입> 지정 해주어야 한다.
		System.out.println("==========");
		for (int cnt = 0; cnt < list.size(); cnt++) {
			String str = list.get(cnt);
			System.out.println("index=" + cnt + " 데이터=" + str);
		}
		System.out.println("==========");

	}
}