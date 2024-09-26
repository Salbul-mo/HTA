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
class Student {

	public int sno; // 학번
	public String name; // 이름

	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	public String toString() {
		return "[sno= " + sno + " name= " + name + "]";
	}
}

/*
 * 파일명과 클래스명 일치시켜줘야 하는 경우
 *  1. main 메서드를 갖고 있는 경우
 *  2. 클래스의 접근 제어자가 public 인 경우
 */
public class HashMap4_equals_hash1 {

	public static void main(String args[]) {

		Map<Student, Integer> map = new HashMap<Student, Integer>();

		// new Student(1,"홍길동") 이 다른 키로 인식되어 5 저장후 다른 곳에 195가 저장된다.
		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");

		map.put(s1, 95); // s1
		map.put(s2, 195); // s2
		// s1 과 s2 는 각각 다른 객체 -> 각각 다른 hashCode()를 갖는다.
		// 즉 다른 키값이다.
		System.out.println("총 Entry 수 : " + map.size());

		Set<Student> s = map.keySet();
		Iterator<Student> it = s.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
