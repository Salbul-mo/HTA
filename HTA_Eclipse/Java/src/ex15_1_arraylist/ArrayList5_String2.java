package ex15_1_arraylist;

import java.util.ArrayList;

public class ArrayList5_String2 {
	public static void main(String args[]) {

		ArrayList<String> list = new ArrayList<String>();
		// String 타입의 ArrayList

		list.add("포도");
		list.add("딸기");
		list.add("사과");
		pArrayList(list);

		System.out.println("index (2,\"키위\") 추가");
		list.add(2, "키위");
		pArrayList(list);

		System.out.println("index (4,\"키위\") 추가");
		list.add(4, "키위");
		pArrayList(list);

		System.out.println("set(0 , \"오렌지\")로 바꿈");
		list.set(0, "오렌지");
		pArrayList(list);

		System.out.println("인덱스 1 remove(1) 삭제");
		list.remove(1);
		pArrayList(list);

		System.out.println("키위 삭제 remove(\"키위\")");
		list.remove("키위");
		pArrayList(list);
		// 앞에서부터 삭제, removeAll로 한번에 모두 삭제 가능하다.

	}

	public static void pArrayList(ArrayList<String> list) {
		// 매개 참조 변수로 쓸 때에도 <타입> 지정 해주어야 한다.
		System.out.println("==========");
		for (int cnt = 0; cnt < list.size(); cnt++) {
			String str = list.get(cnt);
			System.out.println("index=" + cnt + " 데이터=" + str);
		}
		System.out.println("==========");

	}

}
