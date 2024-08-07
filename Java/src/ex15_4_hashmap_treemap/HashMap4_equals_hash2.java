package ex15_4_hashmap_treemap;

import java.util.*;

/*
 * 사용자 정의 클래스 Student를 키로 점수를 저장하는 HashMap 사용방법을 보여준다
 * 학번과 이름이 동일한 Student 를 동등 키로 간주하기 위해
 * Student 클래스에는 hashCode() 와 equals() 메서드가 재정의 해야 한다
 *  동일한 객체인지 확인하는 법 :
 *  hashCode() 의 리턴값이 다르면 다른 키로 인식된다.
 *  hashCode() 의 리턴값이 같으면 equals() 메서드의 리턴값으로 판별한다. 
 *  -> String의 경우 같은 문자열은 같은 hashCode() 를 반환하도록 오버라이딩 되어 있다.
 *  대부분 키 값의 타입은 String으로 많이 사용한다.
 *  equals() 메서드의 리턴값이 true면 같은 키로 인식하고 다르면 다른 키로 인식한다.
 *  
 */
class Student2 {

	public int sno; // 학번
	public String name; // 이름

	public Student2(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	public String toString() {
		return "[sno= " + sno + " name= " + name + "]";
	}
	
	// 학번과 이름이 같다면 동일한 값을 리턴하도록 오버라이딩한다.
	// String의 경우 문자열 내용이 같으면 같은 hashCode()를 리턴하는 점을 이용한다.
	public int hashCode() {
		return (sno + name).hashCode(); // 두 필드를 String으로 만들어서 hashCode()를 반환하게 한다.
	}
	
	// hashCode()가 같을 경우 두 키 객체를 equals() 메서드를 사용하여 비교한다.
	// 그러므로 Student2 클래스에서 equals() 메서드를 오버라이딩하여 필드의 값이 같으면 true를 리턴하도록 한다. 
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Student2) {
			return this.name.equals(((Student2)obj).name) && this.sno == ((Student2)obj).sno;
		}
		return false;
	}
	
}

/*
 * 파일명과 클래스명 일치시켜줘야 하는 경우
 *  1. main 메서드를 갖고 있는 경우
 *  2. 클래스의 접근 제어자가 public 인 경우
 */
public class HashMap4_equals_hash2 {

	public static void main(String args[]) {

		Map<Student2, Integer> map = new HashMap<Student2, Integer>();

		Student2 s1 = new Student2(1, "홍길동");
		Student2 s2 = new Student2(1, "홍길동");

		map.put(s1, 95); // s1
		map.put(s2, 195); // s2
		// s1 과 s2 는 같은 해시코드를 갖는다.
		// 같은 해시코드이므로 equals로 비교하는데 equals()도 오버라이딩 되어 있으므로 
		// 두 객체는 같은 키값이라고 인식하게 된다.
		System.out.println("총 Entry 수 : " + map.size());

		Set<Student2> s = map.keySet(); 
		//Student2 타입의 Set에 map.keySet() 메서드로 반환되는 Set대입
		Iterator<Student2> it = s.iterator();
		//Set<Student2> s 의 iterator 반환 
		while (it.hasNext()) {
			Student2 key = it.next(); // Student2 타입의 변수 에 it.next()대입
			System.out.println(key + ":" + map.get(key)); // key 출력 : key에 페어된 value 출력
			
			
			
		}

	}

}
