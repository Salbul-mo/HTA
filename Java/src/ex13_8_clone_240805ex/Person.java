package ex13_8_clone_240805ex;

public class Person implements Cloneable {
	String name;
	int age;
	Address address;

	public Person(String name, int age, Address address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String toString() {
		return "person{name='" + name + "', age=" + age + ", " + this.address.toString();

	}

	public Person clone() {
		try {
			Person cloned = (Person) super.clone();
			cloned.address = new Address(this.address.street, this.address.city);
			return cloned;
		} catch (CloneNotSupportedException e) {
			System.out.println("복제할 수 없는 객체입니다.");
			return null;
		}

	}

	public boolean equals(Object obj) {
		return this.name == ((Person) obj).name && this.age == ((Person) obj).age
				&& ((Person) obj).address.equals(this.address);
	}

	
}