package ex15_6_treeset;

public class Person0 {
	String name;
	int age;

	public Person0(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "person0 [name=" + name + ", age=" + age + "]";

	}

	public int hashCode() {
		return (name+age).hashCode();
	}
	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Person0) { // 널 체크 및 instanceof 체크
			return this.name.equals(((Person0) obj).name) && this.age == ((Person0) obj).age;
		} else
			return false;
	}

}
