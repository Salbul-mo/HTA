package ex15_1_arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList5_String {
	public static void main(String args[]) {
		
		ArrayList<String> list = new ArrayList<String>();
		//String 타입의 ArrayList
		
		list.add("포도");
		list.add("딸기");
		list.add("사과");
		int length = list.size(); // list 의 데이터 갯수를 반환

		// 출력 방법 1 - 해당 객체명으로 출력하는 방법
		System.out.println("=====객체명으로 출력하기=====");
		System.out.println(list);
		System.out.println(list.toString());

		// 출력 방법 2 - get() 메서드 이용법1
		System.out.println("=====get()메서드로 출력=====");
		for (int cnt = 0; cnt < length; cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}

		System.out.println("=====향상된 for 문======");
		for (String str : list) {
			System.out.println(str);
		}

		// 출력 방법 4 - Iterator 인터페이스 사용 : 반복자 (요소를 순차적으로 접근하는 방식을 제어하는 경우 적합)
		System.out.println("=====Iterator 인터페이스 사용=====");
		Iterator<String> elements = list.iterator();
		while (elements.hasNext()) {
			System.out.println(elements.next());
		}
	}


}
