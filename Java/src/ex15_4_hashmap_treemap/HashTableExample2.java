package ex15_4_hashmap_treemap;

import java.util.*;

public class HashTableExample2 {

	public static void main(String args[]) {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("사과", "Apple");
		ht.put("딸기", "StrawBerry");
		ht.put("포도", "Grapes");

		// 해시 테이블의 값을 키를 이용하여 얻는다.
		String Val = ht.get("포도");
		if (Val != null) {
			System.out.println("포도 ->" + Val);
		}

		Enumeration<String> Enum = ht.keys(); // 해시 테이블의 키 요소들에 대한 enum 객체 반환 메서드

		while (Enum.hasMoreElements()) {
			String k = Enum.nextElement(); // Generic을 사용해서 다운캐스팅 하지 않아도 된다.
			// String k = (String) Enum.nextElements();
			String v = ht.get(k); // 제네릭을 사용해서 다운 캐스팅 안해도 된다.
			// String v = (String)ht.get(k);

			System.out.println(k + " : " + v);
		}
	}
}
