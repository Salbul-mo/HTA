package ex15_4_hashmap_treemap;
/*
 *  TreeMap
 *  이진 탐색 트리의 형태로 키와 값의 쌍으로 이루어진 데이터를 키로 정렬해서 저장한다.
 *  검색과 정렬에 적합한 컬렉션 클래스이다.
 *  
 */

import java.util.Set;
import java.util.TreeMap;

public class TreeMap_Generics {

	public static void main(String[] args) {
		// 객체 생성 방법 두 가지

		// 1 . 업캐스팅
		// Map<String, String> tm = new TreeMap<String,String>();

		// 2. 구현 클래스를 통한 객체 생성
		TreeMap<String, String> tm = new TreeMap<String, String>();

		// Key와 Value 쌍을 삽입
		// Map의 메서드는 put을 이용해 (Key, Value) 쌍으로 저장된다.
		tm.put("woman", "재미있니");
		tm.put("man", "좋은하루");
		tm.put("age", new String("10"));
		tm.put("city", "Seoul");
		tm.put("city", "Busan");

		// TreeMap에 있는 객체들을 출력

		// 출력 방법 1. 해당 객체명으로 출력
		System.out.println(tm);
		// {age=10, city=Busan, man=좋은하루, woman=재미있니}
		// HashMap과는 다르게 TreeMap은 이진 검색 트리를 사용하여 Key값을 정렬한다.

		// 출력 방법 2. Key 값만 출력
		System.out.println(tm.keySet()); // [age, city, man, woman]

		// 출력 방법 3. Value 값만 출력
		System.out.println(tm.values()); // [10, Busan, 좋은하루, 재미있니]

		// 출력 방법 4. get(key) : key에 해당하는 value를 출력 - 가장 많이 사용
		System.out.println(tm.get("woman"));// 재미있니
		System.out.println(tm.get("city"));// Busan

		System.out.println(tm.get("Woman"));// null -> 키값은 대소문자 구분한다.

		// 출력 방법 5. keySet()사용하여 키 값만 Set로 받아온 뒤 key 값으로 차례대로 출력
		System.out.println("======================");
		Set<String> keys = tm.keySet();
		for (String key : keys) {
			System.out.println(key + "=" + tm.get(key));
		}

	}
}
