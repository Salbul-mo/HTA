package ex15_4_hashmap_treemap;

import java.util.HashMap;
import java.util.Set;

/*
 * HashMap Generic 사용
 * 	Map 인터페이스 - HashMap, Hashtable( 상속 받는 클래스)
 * 		1. 여러가지 자료형 Data 를 모두 저장
 * 		2. Data 를 저장할 때 Key, Value 를 동시에 저장한다.
 * 
 * 		HashMap 과 HashSet 등에 사용되는 hashing 에 대한 설명
 * 		- 해싱이란 해시함수를 이용해서 데이터를 해시 테이블에 저장하고 검색하는 기법
 * 		- 해시 테이블이란 여러 개의 통(bucket)을 만들어 두고 키 값을 이용하여 데이터를 넣을 통 번호를 계산하는
 * 		  데이터 구조이다
 * 		- 해시 함수는 키 값을 받아 해쉬 테이블의 인덱스 키 값을 구하는 함수이다.
 * 		- 해시함수는 데이터가 저장되어 있는 곳을 알려주기 때문에 다량의 데이터 중에서도 
 * 		  원하는 데이터를 빠르게 찾을 수 있다.
 * 
 * 		- 해싱을 구현한 컬렉션 클래스로는 HashSet, HashMap, Hashtable 등이 있다.
 * 		- Object 클래스에 정의된 hashCode() 를 해시 함수로 사용한다.
 */

public class HashMap_Generics {

	public static void main(String[] args) {
		// HashMap 객체 생성 방법 두 가지

		// 1 . 업캐스팅
		// Map hm = new HashMap();

		// 2. 구현 클래스를 통한 객체 생성
		HashMap<String, String> hm = new HashMap<String, String>();

		// Key와 Value 쌍을 삽입
		// HashMap 의 put()을 이용해 (key, value) 쌍으로 자료 저장
		// Key 값이 중복된 경우 마지막 데이터가 저장된다.
		hm.put("woman", "재미있니");
		hm.put("man", "좋은하루");
		hm.put("age", new String("10"));
		hm.put("city", "Seoul");
		hm.put("city", "Busan");

		// HashMap에 있는 객체들을 출력
		// 출력 방법 1. 해당 객체명으로 출력
		System.out.println(hm);
		// {woman=재미있니 , city=Busan, man=좋은하루 , age=10}
		// 순서와 상관이 없이 출력된다.

		// 출력 방법 2. Key 값만 출력
		System.out.println(hm.keySet()); // [woman, city, man, age]

		// 출력 방법 3. Value 값만 출력
		System.out.println(hm.values());

		// 출력 방법 4. get(key) : key에 해당하는 value를 출력 - 가장 많이 사용
		System.out.println(hm.get("woman"));// 재미있니
		System.out.println(hm.get("city"));// Busan

		// 출력 방법 5.
		System.out.println("======================");
		Set<String> keys = hm.keySet();
		for (String key : keys) {
			System.out.println(key + "=" + hm.get(key));
		}

	}
}
