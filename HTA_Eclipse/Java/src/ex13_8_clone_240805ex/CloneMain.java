package ex13_8_clone_240805ex;

public class CloneMain {
	public static void main(String[] args) {

		Address address1 = new Address("123 Street", "City");
		Person p1 = new Person("Alice", 30, address1);
		Person p2 = new Person("Alice", 30, address1);
		Person p3 = new Person("Bob", 25, new Address("456 Avenue", "Town"));

		// equals() 테스트
		System.out.println(p1.equals(p2)); // true
		System.out.println(p1.equals(p3)); // false

		// toString() 테스트
		System.out.println(p1.toString()); // Person{name='Alice', age=30, address=Address{street='123 Street',
											// city='City'}}

		Person p4 = p1.clone();
		System.out.println(p4.equals(p1)); // true
		System.out.println(p4.toString()); // Person{name='Alice', age=30, address=Address{street='123 Street',
											// city='City'}}
		System.out.println(p4.address == p1.address); // false
	}
}
