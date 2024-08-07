package ex15_6_treeset;

public class Person2 implements Comparable<Person2> {
	// Comparable< 타입 > 같이 입력해주어야 한다.
	String name;
	int age;

	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "person2 [name=" + name + ", age=" + age + "]";

	}

	public int hashCode() {
		return (name + age).hashCode();
	}

	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Person2) { // 널 체크 및 instanceof 체크
			return this.name.equals(((Person2) obj).name) && this.age == ((Person2) obj).age;
		} else
			return false;
	}

	@Override
	public int compareTo(Person2 p) { 
		// 자신과 매개변수로 받은 Person1의 필드를 비교하는 메서드로 오버라이딩한다.
		if (age < p.age) { // 부등호 방향에 따라 < 오름 차순, > 내림차순  
			return -1; // 작으면 음수
		} else if (age == p.age) { 
			return name.compareTo(p.name); // 다른 필드인 name 비교하는 메서드의 결과 반환
										   // 사전적 순서로 비교하여 앞순서면 음수 같으면 0 뒷순서면 양수
		} else {
			return 1;  // 크면 양수
		}

	}
}
